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
	public static Archive<?> gerarDeployment() {

		// adiciona bibliotecas do empacotamento
		Collection<String> deps = new ArrayList<>();
		deps.add("br.com.rhiemer:rhiemer-api-test-integration");
		deps.add("br.com.rhiemer:rhiemer-api-rest-client");
		deps.add("br.com.rhiemer.beerpoints:beerpoints-domain");

		// busca as
		File[] libs = Maven.configureResolver().workOffline().withMavenCentralRepo(true).withClassPathResolution(true)
				.loadPomFromFile("pom.xml").resolve(deps).withTransitivity().asFile();

		List<File> filesList = new ArrayList<>(Arrays.asList(libs));
		File fileDomain = null;
		for (File file : filesList) {
			if (file.getName().indexOf("beerpoints-domain-") > -1) {
				filesList.remove(file);
				fileDomain = file;
				break;
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

		// gera um war com as classes do projeto web
		WebArchive war = ShrinkWrap.create(WebArchive.class, "beerpoints-servicos-war.war")
				.addPackages(true, getRecursivePackagesWeb())
				.addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
				// se não ter um web.xml separado dos projetos o arquillian não
				// encontra
				.setWebXML("META-INF/web.xml");

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

		return new String[] { "br.com.rhiemer.beerpoints.rest" };

	}

}
