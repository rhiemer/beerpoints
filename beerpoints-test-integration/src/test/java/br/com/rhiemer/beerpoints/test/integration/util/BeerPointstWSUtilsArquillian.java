package br.com.rhiemer.beerpoints.test.integration.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import br.com.rhiemer.api.test.integration.helper.HelperArquillian;

/**
 * Classe com deploy para testes dos serviços rests
 * 
 * @author rodrigo.hiemer
 * 
 */
public class BeerPointstWSUtilsArquillian {

	/**
	 * Gera um EAR com as configurações necessárias que será utilizado nos
	 * testes dos serviços REST ou EJBs
	 * 
	 * @param classeTest
	 *            Classe do teste que onde está gerando o deploy
	 * 
	 * 
	 * @return EAR gerado para os testes
	 */

	public static Archive<?> gerarDeployment(Class<?>... classes) {

		// adiciona bibliotecas do empacotamento
		Collection<String> deps = new ArrayList<>();
		deps.add("br.com.rhiemer:rhiemer-api-rest-client");
		deps.add("br.com.rhiemer:rhiemer-api-rest-resources");
		deps.add("br.com.rhiemer:rhiemer-api-test-integration-dbunit");
		deps.add("br.com.rhiemer.beerpoints:beerpoints-domain");

		// busca as
		File[] libs = Maven.configureResolver().workOffline().withMavenCentralRepo(true).withClassPathResolution(true)
				.loadPomFromFile("pom.xml").resolve(deps).withTransitivity().asFile();

		List<File> filesList = new ArrayList<>(Arrays.asList(libs));
		List<File> filesListWeb = new ArrayList<>();
		File fileDomain = null;
		for (int i = filesList.size()-1; i >= 0; i--) {
			File file = filesList.get(i);
			if (fileDomain == null && file.getName().indexOf("beerpoints-domain-") > -1) {
				filesList.remove(file);
				fileDomain = file;	
				continue;
			}
			if (file.getName().indexOf("rhiemer-api-rest-resources-") > -1) {
				filesList.remove(file);
				filesListWeb.add(file);				
				continue;
			}
		}
		

		libs = filesList.toArray(new File[] {});

		// gera o projeto ejb
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "beerpoints-service.jar")
				// gera um beans.xml limpo
				.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
				// injeta persistence service
				.addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
				.addAsResource("META-INF/orm.xml")
				// injeta arquivo de resorces do projeto
				.addAsResource("environment.properties")
				// adiciona todos os pacotes necessários ao projeto
				.addPackages(true, getRecursivePackagesJar());

		if (classes != null)
			for (Class<?> classe : classes)
				jar.addClass(classe);

		// gera um war com as classes do projeto web
		WebArchive war = ShrinkWrap.create(WebArchive.class, "beerpoints-servicos-war.war")
				.addPackages(true, getRecursivePackagesWeb())
				.addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))				
				.addAsLibraries(filesListWeb.toArray(new File[] {}))
				// se não ter um web.xml separado dos projetos o arquillian não
				// encontra
				.setWebXML("META-INF/web.xml");

		HelperArquillian.addResourcesFiles(war, new File("src/test/resources/datasets"));

		// empacota com ear o jar e o war acima
		EnterpriseArchive ear = ShrinkWrap
				.create(EnterpriseArchive.class,
						String.format("BeerPointsTest%s.ear", Calendar.getInstance().getTimeInMillis()))
				.addAsLibraries(libs)
				// contexto web apontando para test afim de não conflitar com
				// o contexto da aplicação
				.setApplicationXML("META-INF/application.xml").addAsModule(jar).addAsModule(war);
		if (fileDomain != null) {
			ear.addAsLibrary(fileDomain, "beerpoints-domain.jar");
		}

		// exporta o deploy gerado para verificações
		// exportDeploy(ear);

		return ear;
	}

	static void exportDeploy(EnterpriseArchive deploy) {
		deploy.as(ZipExporter.class).exportTo(new File("C:\\desenvolvimento\\java\\deploy-teste\\" + deploy.getName()),
				true);
	}

	private static String[] getRecursivePackagesJar() {

		return new String[] { "br.com.rhiemer.beerpoints.service" };

	}

	private static String[] getRecursivePackagesWeb() {

		return new String[] { "br.com.rhiemer.beerpoints.rest", "br.com.rhiemer.beerpoints.test.integration.rest" };

	}

}
