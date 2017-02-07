CREATE TABLE RE_LOCALIZACAO (
    id_localizacao_pai INTEGER NOT NULL,
    id_localizacao_filha INTEGER NOT NULL,
    PRIMARY KEY (id_localizacao_pai , id_localizacao_filha)
)  ENGINE=INNODB;
CREATE TABLE RE_LOCALIZACAO_AUD (
    REV INTEGER NOT NULL,
    id_localizacao_pai INTEGER NOT NULL,
    id_localizacao_filha INTEGER NOT NULL,
    REVTYPE TINYINT,
    PRIMARY KEY (REV , id_localizacao_pai , id_localizacao_filha)
)  ENGINE=INNODB;
CREATE TABLE REVINFO (
    REV INTEGER NOT NULL AUTO_INCREMENT,
    REVTSTMP BIGINT,
    PRIMARY KEY (REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AMARGOR (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_AMRAGOR (
    id INTEGER NOT NULL,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    controleId INTEGER,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_BAR (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    latitude DECIMAL(20 , 8 ),
    longitude DECIMAL(20 , 8 ),
    cep VARCHAR(60),
    complemento VARCHAR(60),
    logradouro VARCHAR(250),
    numero VARCHAR(60),
    observacaoEndereco VARCHAR(1000),
    municipio_id INTEGER,
    localizacao_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_BAR_CERVEJA (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    bar_id INTEGER,
    cerveja_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_BAR_CERVEJA_RECEP_VOL (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    preco DECIMAL(10 , 5 ),
    bar_cerveja_id INTEGER,
    recepiente_volume_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_BAR_COMIDA (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    bar_id INTEGER,
    comida_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_CERVEJA (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    ativo CHAR(1),
    VERSAO BIGINT,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    teorAlcolico DECIMAL(5 , 2 ),
    amargor_id INTEGER,
    cervejaria_id INTEGER,
    estilo_id INTEGER,
    familia_id INTEGER,
    pais_id INTEGER,
    regiao_pais_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_CERVEJARIA (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    VERSAO BIGINT,
    REVTYPE TINYINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    tipoCervejaria VARCHAR(20),
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_CERVEJARIA_LOCALIZACAO (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    latitude DECIMAL(20 , 8 ),
    longitude DECIMAL(20 , 8 ),
    cep VARCHAR(60),
    complemento VARCHAR(60),
    logradouro VARCHAR(250),
    numero VARCHAR(60),
    observacaoEndereco VARCHAR(1000),
    cervejaria_id INTEGER,
    municipio_id INTEGER,
    localizacao_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_COMIDA (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    comida_pai_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_CONTROLE_ENTIDADE (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    entidadeId INTEGER,
    entidade VARCHAR(255),
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_ENTIDADE (
    id VARCHAR(255) NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    ordemPesquisa INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_ESTILO (
    id INTEGER NOT NULL,
    ativo CHAR(1) ,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    controleId INTEGER,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_FAMILIA (
    id INTEGER NOT NULL,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) ,
    texto VARCHAR(1000),
    controleId INTEGER,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_HARMONIZACAO (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    bar_comida_id INTEGER,
    cerveja_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_LOCALIZACAO (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    latitude DECIMAL(20 , 8 ),
    latitudeDelta DECIMAL(20 , 8 ),
    longitude DECIMAL(20 , 8 ),
    longitudeDelta DECIMAL(20 , 8 ),
    tipo_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_MUNICIPIO (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    codigoIBGE INTEGER,
    localizacao TINYBLOB,
    uf_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_PAIS (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    pais_localizacao_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_PAIS_LOCALIZACAO (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    codigoIBGE INTEGER,
    localizacao TINYBLOB,
    sigla VARCHAR(255),
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_RECEPIENTE (
    id INTEGER NOT NULL,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) ,
    texto VARCHAR(1000),
    controleId INTEGER ,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_RECEPIENTE_VOLUME (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    quantidade DECIMAL(10 , 5 ),
    recepiente_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_REGIAO_PAIS (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    pais_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_TAG (
    id INTEGER NOT NULL,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    controleId INTEGER,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_TIPO_LOCALIZACAO (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    classe VARCHAR(250),
    nome VARCHAR(250),
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_AUDITORIA_UF (
    id INTEGER NOT NULL,
    REV INTEGER NOT NULL,
    REVTYPE TINYINT,
    VERSAO BIGINT,
    ativo CHAR(1),
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    codigoIBGE INTEGER,
    localizacao TINYBLOB,
    sigla VARCHAR(255),
    pais_localizacao_id INTEGER,
    PRIMARY KEY (id , REV)
)  ENGINE=INNODB;
CREATE TABLE TB_BAR (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    latitude DECIMAL(20 , 8 ),
    longitude DECIMAL(20 , 8 ),
    cep VARCHAR(60),
    complemento VARCHAR(60),
    logradouro VARCHAR(250),
    numero VARCHAR(60),
    observacaoEndereco VARCHAR(1000),
    municipio_id INTEGER NOT NULL,
    localizacao_id INTEGER,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_BAR_CERVEJA (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    controleId INTEGER NOT NULL,
    bar_id INTEGER NOT NULL,
    cerveja_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_BAR_CERVEJA_RECEP_VOL (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    controleId INTEGER NOT NULL,
    preco DECIMAL(10 , 5 ),
    bar_cerveja_id INTEGER NOT NULL,
    recepiente_volume_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_BAR_COMIDA (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    bar_id INTEGER NOT NULL,
    comida_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_CERVEJA (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    teorAlcolico DECIMAL(5 , 2 ),
    amargor_id INTEGER NOT NULL,
    cervejaria_id INTEGER NOT NULL,
    estilo_id INTEGER NOT NULL,
    familia_id INTEGER NOT NULL,
    pais_id INTEGER NOT NULL,
    regiao_pais_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_CERVEJARIA (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    tipoCervejaria VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_CERVEJARIA_LOCALIZACAO (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    latitude DECIMAL(20 , 8 ),
    longitude DECIMAL(20 , 8 ),
    cep VARCHAR(60),
    complemento VARCHAR(60),
    logradouro VARCHAR(250),
    numero VARCHAR(60),
    observacaoEndereco VARCHAR(1000),
    cervejaria_id INTEGER NOT NULL,
    municipio_id INTEGER NOT NULL,
    localizacao_id INTEGER,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_COMIDA (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    comida_pai_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_CONTROLE_ENTIDADE (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250),
    texto VARCHAR(1000),
    entidadeId INTEGER,
    entidade VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_ENTIDADE (
    id VARCHAR(255) NOT NULL,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    ordemPesquisa INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_ESTILO (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_FAMILIA (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_HARMONIZACAO (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    bar_comida_id INTEGER NOT NULL,
    cerveja_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_LOCALIZACAO (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    latitude DECIMAL(20 , 8 ),
    latitudeDelta DECIMAL(20 , 8 ),
    longitude DECIMAL(20 , 8 ),
    longitudeDelta DECIMAL(20 , 8 ),
    tipo_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_MUNICIPIO (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    codigoIBGE INTEGER NOT NULL,
    localizacao TINYBLOB NOT NULL,
    uf_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_PAIS (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    pais_localizacao_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_PAIS_LOCALIZACAO (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    codigoIBGE INTEGER NOT NULL,
    localizacao TINYBLOB NOT NULL,
    sigla VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_RECEPIENTE (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_RECEPIENTE_VOLUME (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    quantidade DECIMAL(10 , 5 ),
    recepiente_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_REGIAO_PAIS (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    pais_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_TAG (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_TIPO_LOCALIZACAO (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    classe VARCHAR(250),
    nome VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE TB_UF (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ativo CHAR(1) NOT NULL,
    exclusao DATETIME,
    Inclusao DATETIME,
    ultimaAlteracao DATETIME,
    VERSAO BIGINT,
    nome VARCHAR(250) NOT NULL,
    texto VARCHAR(1000),
    controleId INTEGER NOT NULL,
    codigoIBGE INTEGER NOT NULL,
    localizacao TINYBLOB NOT NULL,
    sigla VARCHAR(255) NOT NULL,
    pais_localizacao_id INTEGER NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
alter table TB_AMARGOR add constraint UK_AMARGOR unique (controleId);
alter table TB_BAR add constraint UK_BAR_CONTROLE_ID unique (controleId);
alter table TB_BAR_CERVEJA add constraint UK_BAR_CERVEJA_CERV_BAR unique (cerveja_id, bar_id);
alter table TB_BAR_CERVEJA add constraint UK_BAR_CERVEJA_CONTROLE_ID unique (controleId);
alter table TB_BAR_CERVEJA_RECEP_VOL add constraint UK_BAR_CERVEJA_RECEP_VOL_BAR_CERV unique (bar_cerveja_id, recepiente_volume_id);
alter table TB_BAR_CERVEJA_RECEP_VOL add constraint UK_BAR_CERVEJA_RECEP_VOL_CONTROLE_ID unique (controleId);
alter table TB_BAR_COMIDA add constraint UK_BAR_CERVEJA_COMIDA_COMIDA_BAR unique (comida_id, bar_id);
alter table TB_BAR_COMIDA add constraint UK_BAR_CERVEJA_COMIDA_CONTROLE_ID unique (controleId);
alter table TB_CERVEJA add constraint UK_CERVEJA_CONTROLE_ID unique (controleId);
alter table TB_CERVEJARIA add constraint UK_CERVEJARIA_CONTROLE_ID unique (controleId);
alter table TB_CERVEJARIA_LOCALIZACAO add constraint UK_CERVEJARIA_LOCALIZACAO_CONTROLE_ID unique (controleId);
alter table TB_COMIDA add constraint UK_COMIDA_ID unique (controleId);
alter table TB_CONTROLE_ENTIDADE add constraint UK_CONTROLE_ENTIDADE unique (entidade, entidadeId);
alter table TB_ESTILO add constraint UK_ESTILO_CONTROLE_ID unique (controleId);
alter table TB_FAMILIA add constraint UK_FAMILIA_CONTROLE_ID unique (controleId);
alter table TB_HARMONIZACAO add constraint UK_HARMONIZACAO_CONTROLE_BAR_COMIDA_CERVEJA unique (bar_comida_id, cerveja_id);
alter table TB_HARMONIZACAO add constraint UK_HARMONIZACAO_CONTROLE_ID unique (controleId);
alter table TB_LOCALIZACAO add constraint UK_LOCALIZACAO_CONTROLE_ID unique (controleId);
alter table TB_MUNICIPIO add constraint UK_MUNICIPIO_CONTROLE_ID unique (controleId);
alter table TB_PAIS add constraint UK_PAIS_CONTROLE_ID unique (controleId);
alter table TB_PAIS add constraint UK_PAIS_PAIS_LOCALIZACAO_ID unique (pais_localizacao_id);
alter table TB_PAIS_LOCALIZACAO add constraint UK_PAIS_LOCALIZACAO_CONTROLE_ID unique (controleId);
alter table TB_RECEPIENTE add constraint UK_RECEPIENTE_CONTROLE_ID unique (controleId);
alter table TB_REGIAO_PAIS add constraint UK_REGIAO_PAIS_CONTROLE_ID unique (controleId);
alter table TB_TAG add constraint UK_TAG_CONTROLE_ID unique (controleId);
alter table TB_UF add constraint UK_UF_CONTROLE_ID unique (controleId);
alter table RE_LOCALIZACAO add constraint FK_RE_LOCALIZACAO_FILHA foreign key (id_localizacao_filha) references TB_LOCALIZACAO (id);
alter table RE_LOCALIZACAO add constraint FK_RE_LOCALIZACAO_PAI foreign key (id_localizacao_pai) references TB_LOCALIZACAO (id);
alter table RE_LOCALIZACAO_AUD add constraint FK_RE_LOCALIZACAO_AUD foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_AMRAGOR add constraint FK_AUDITORIA_AMRAGOR foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_BAR add constraint FK_AUDITORIA_BAR foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_BAR_CERVEJA add constraint FK_AUDITORIA_BAR_CERVEJA foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_BAR_CERVEJA_RECEP_VOL add constraint FK_AUDITORIA_BAR_CERVEJA_RECEP_VOL foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_BAR_COMIDA add constraint FK_AUDITORIA_BAR_COMIDA foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_CERVEJA add constraint FK_AUDITORIA_CEREVEJA foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_CERVEJARIA add constraint FK_AUDITORIA_CEREVEJARIA foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_CERVEJARIA_LOCALIZACAO add constraint FK_AUDITORIA_CEREVEJARIA_LOCALIZACAO foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_COMIDA add constraint FK_AUDITORIA_CEREVEJARIA_COMIDA foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_CONTROLE_ENTIDADE add constraint FK_AUDITORIA_CONTROLE_ENTIDADE foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_ENTIDADE add constraint FK_AUDITORIA_ENTIDADE foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_ESTILO add constraint FK_AUDITORIA_ESTILO foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_FAMILIA add constraint FK_AUDITORIA_FAMILA foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_HARMONIZACAO add constraint FK_AUDITORIA_HARMONIZACAO foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_LOCALIZACAO add constraint FK_AUDITORIA_LOCALIZACAO foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_MUNICIPIO add constraint FK_AUDITORIA_MUNICIPIO foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_PAIS add constraint FK_AUDITORIA_PAIS foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_PAIS_LOCALIZACAO add constraint FK_AUDITORIA_PAIS_LOCALIZACAO foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_RECEPIENTE add constraint FK_AUDITORIA_RECEPIENTE foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_RECEPIENTE_VOLUME add constraint FK_AUDITORIA_RECEPIENTE_VOLUME foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_REGIAO_PAIS add constraint FK_AUDITORIA_REGIAO_PAIS foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_TAG add constraint FK_AUDITORIA_TAG foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_TIPO_LOCALIZACAO add constraint FK_AUDITORIA_TIPO_LOCALIZACAO foreign key (REV) references REVINFO (REV);
alter table TB_AUDITORIA_UF add constraint FK_AUDITORIA_UF foreign key (REV) references REVINFO (REV);
alter table TB_BAR add constraint FK_BAR_MUNICIPIO foreign key (municipio_id) references TB_MUNICIPIO (id);
alter table TB_BAR add constraint FK_BAR_LOCALIZACAO foreign key (localizacao_id) references TB_LOCALIZACAO (id);
alter table TB_BAR_CERVEJA add constraint FK_BAR_CERVEJA_BAR foreign key (bar_id) references TB_BAR (id);
alter table TB_BAR_CERVEJA add constraint FK_BAR_CERVEJA_CERVEJA foreign key (cerveja_id) references TB_CERVEJA (id);
alter table TB_BAR_CERVEJA_RECEP_VOL add constraint FK_BAR_CERVEJA_RECEB_VOL_BAR_CERVEJA foreign key (bar_cerveja_id) references TB_BAR_CERVEJA (id);
alter table TB_BAR_CERVEJA_RECEP_VOL add constraint FK_BAR_CERVEJA_RECEB_RECEP_VOL foreign key (recepiente_volume_id) references TB_RECEPIENTE_VOLUME (id);
alter table TB_BAR_COMIDA add constraint FK_BAR_COMIDA_BAR foreign key (bar_id) references TB_BAR (id);
alter table TB_BAR_COMIDA add constraint FK_BAR_COMIDA_COMIDA foreign key (comida_id) references TB_COMIDA (id);
alter table TB_CERVEJA add constraint FK_CERVEJA_AMARGOR foreign key (amargor_id) references TB_AMARGOR (id);
alter table TB_CERVEJA add constraint FK_CERVEJA_CERVEJARIA foreign key (cervejaria_id) references TB_CERVEJARIA (id);
alter table TB_CERVEJA add constraint FK_CERVEJA_ESTILO foreign key (estilo_id) references TB_ESTILO (id);
alter table TB_CERVEJA add constraint FK_CERVEJA_FAMILA foreign key (familia_id) references TB_FAMILIA (id);
alter table TB_CERVEJA add constraint FK_CERVEJA_PAIS foreign key (pais_id) references TB_PAIS (id);
alter table TB_CERVEJA add constraint FK_CERVEJA_REGIAO_PAIS foreign key (regiao_pais_id) references TB_REGIAO_PAIS (id);
alter table TB_CERVEJARIA_LOCALIZACAO add constraint FK_CERVEJARIA_LOCALIZACAO_CERVEJARIA foreign key (cervejaria_id) references TB_CERVEJARIA (id);
alter table TB_CERVEJARIA_LOCALIZACAO add constraint FK_CERVEJARIA_MUNICIPIO foreign key (municipio_id) references TB_MUNICIPIO (id);
alter table TB_CERVEJARIA_LOCALIZACAO add constraint FK_CERVEJARIA_LOCALIZACAO foreign key (localizacao_id) references TB_LOCALIZACAO (id);
alter table TB_COMIDA add constraint FK_COMIDA_PAI foreign key (comida_pai_id) references TB_COMIDA (id);
alter table TB_CONTROLE_ENTIDADE add constraint FK_CONTROLE_ENTIDADE_ENTIDADE foreign key (entidade) references TB_ENTIDADE (id);
alter table TB_HARMONIZACAO add constraint FK_HARMONIZACAO_BAR_COMIDA foreign key (bar_comida_id) references TB_BAR_COMIDA (id);
alter table TB_HARMONIZACAO add constraint FK_HARMONIZACAO_CERVEJA foreign key (cerveja_id) references TB_CERVEJA (id);
alter table TB_LOCALIZACAO add constraint FK_LOCALIZACAO_TIPO foreign key (tipo_id) references TB_TIPO_LOCALIZACAO (id);
alter table TB_MUNICIPIO add constraint FK_MUNICIPIO_UF foreign key (uf_id) references TB_UF (id);
alter table TB_PAIS add constraint FK_PAIS_LOCALIZACAO foreign key (pais_localizacao_id) references TB_PAIS_LOCALIZACAO (id);
alter table TB_RECEPIENTE_VOLUME add constraint FK_RECEPIENTE_VOLUME_RECEPIENTE foreign key (recepiente_id) references TB_RECEPIENTE (id);
alter table TB_REGIAO_PAIS add constraint FK_REGIAO_PAIS_PAIS foreign key (pais_id) references TB_PAIS (id);
alter table TB_UF add constraint FK_UF_PAIS foreign key (pais_localizacao_id) references TB_PAIS_LOCALIZACAO (id);
