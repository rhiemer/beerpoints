    INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Cerveja','S',sysdate(),sysdate(),1,count(1) + 1 from beerpoints.tb_entidade;        
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Pais','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'RegiaoPais','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Cervejaria','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Familia','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Estilo','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Tag','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Recepiente','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'RecepienteVolume','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Bar','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'BarCerveja','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'BarCervejaRecepienteVolume','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Comida','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'BarComida','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Harmonizacao','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Localizacao','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'PaisLocalizacao','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'UF','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'Municipio','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
	INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'TipoLocalizacao','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
    INSERT INTO beerpoints.tb_entidade(id,ativo,Inclusao,ultimaAlteracao,VERSAO,ordemPesquisa) select 'CervejariaLocalizacao','S',sysdate(),sysdate(),1, count(1) + 1 from beerpoints.tb_entidade;
    commit;
    