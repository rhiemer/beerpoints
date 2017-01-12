    create table REVINFO (
        REV integer not null auto_increment,
        REVTSTMP bigint,
        primary key (REV)
    ) ENGINE=InnoDB
	;

    create table TB_AUDITORIA_BAR (
        id integer not null,
        REV integer not null,
        REVTYPE tinyint,
        latitude decimal(20,8),
        longitude decimal(20,8),
		Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) ,
        nome varchar(250),
        texto varchar(1000),
        primary key (id, REV)
    ) ENGINE=InnoDB;
	

    create table TB_AUDITORIA_BAR_CERVEJA (
        id integer not null,
        REV integer not null,
        REVTYPE tinyint,
        preco decimal(10,5),
        bar_id integer,
        cerveja_id integer,
		Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1),
        nome varchar(250),
        texto varchar(1000),
        primary key (id, REV)
    ) ENGINE=InnoDB;

    create table TB_AUDITORIA_CERVEJA (
        id integer not null,
        REV integer not null,
        REVTYPE tinyint,
        precoMedio decimal(10,5),
        teorAlcolico decimal(5,2),
        estilo_id integer,
        fabricante_id integer,
        pais_id integer,
		Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1),
        nome varchar(250),
        texto varchar(1000),
        primary key (id, REV)
    ) ENGINE=InnoDB;

    create table TB_AUDITORIA_ESTILO (
        id integer not null,
        REV integer not null,
        REVTYPE tinyint,
		Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) ,
        nome varchar(250),
        texto varchar(1000),
        primary key (id, REV)
    ) ENGINE=InnoDB;
	

    create table TB_AUDITORIA_FABRICANTE (
        id integer not null,
        REV integer not null,
        REVTYPE tinyint,
        tipoFabricante varchar(20),
		Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) ,
        nome varchar(250),
        texto varchar(1000),
        primary key (id, REV)
    ) ENGINE=InnoDB;

    create table TB_AUDITORIA_PAIS (
        id integer not null,
        REV integer not null,
        REVTYPE tinyint,
		Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1),
        nome varchar(250),
        texto varchar(1000),
        primary key (id, REV)
    ) ENGINE=InnoDB;
	

    create table TB_BAR (
        id integer not null auto_increment,
        Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) not null,
        nome varchar(250) not null,
        texto varchar(1000),
        latitude decimal(20,8),
        longitude decimal(20,8),
        primary key (id)
    ) ENGINE=InnoDB
	;

    create table TB_BAR_CERVEJA (
        id integer not null auto_increment,
        Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) not null,
        preco decimal(10,5),
        bar_id integer not null,
        cerveja_id integer not null,
        primary key (id)
    ) ENGINE=InnoDB
	;

    create table TB_CERVEJA (
        id integer not null auto_increment,
        Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) not null,
        nome varchar(250) not null,
        texto varchar(1000),
        precoMedio decimal(10,5),
        teorAlcolico decimal(5,2),
        estilo_id integer not null,
        fabricante_id integer not null,
        pais_id integer not null,
        primary key (id)
    ) ENGINE=InnoDB
	;

    create table TB_ESTILO (
        id integer not null auto_increment,
        Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) not null,
        nome varchar(250) not null,
        texto varchar(1000),
        primary key (id)
    ) ENGINE=InnoDB
	;

    create table TB_FABRICANTE (
        id integer not null auto_increment,
        Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) not null,
        nome varchar(250) not null,
        texto varchar(1000),
        tipoFabricante varchar(20) not null,
        primary key (id)
    ) ENGINE=InnoDB	
	;

    create table TB_PAIS (
        id integer not null auto_increment,
        Inclusao datetime,
        ultimaAlteracao datetime,
        exclusao datetime,
        VERSAO bigint,
        ativo char(1) not null,
        nome varchar(250) not null,
        texto varchar(1000),
        primary key (id)
    ) ENGINE=InnoDB
	;

    alter table TB_AUDITORIA_BAR 
        add constraint FK_AUDITORIA_BAR_REVINFO
        foreign key (REV) 
        references REVINFO (REV);

    alter table TB_AUDITORIA_BAR_CERVEJA 
        add constraint FK_AUDIT_BAR_CERVEJA_REVINFO 
        foreign key (REV) 
        references REVINFO (REV);

    alter table TB_AUDITORIA_CERVEJA 
        add constraint FK_AUDITORIA_CERVEJA_REVINFO
        foreign key (REV) 
        references REVINFO (REV);

    alter table TB_AUDITORIA_ESTILO 
        add constraint FK_AUDITORIA_ESTILO_REVINFO 
        foreign key (REV) 
        references REVINFO (REV);

    alter table TB_AUDITORIA_FABRICANTE 
        add constraint FK_AUDIT_FABRICANTE_REVINFO 
        foreign key (REV) 
        references REVINFO (REV);

    alter table TB_AUDITORIA_PAIS 
        add constraint FK_AUDITORIA_PAIS_REVINFO 
        foreign key (REV) 
        references REVINFO (REV);

    alter table TB_BAR_CERVEJA 
        add constraint FK_BAR_CERVEJA_BAR
        foreign key (bar_id) 
        references TB_BAR (id);

    alter table TB_BAR_CERVEJA 
        add constraint FK_BAR_CERVEJA_CERVEJA 
        foreign key (cerveja_id) 
        references TB_CERVEJA (id);

    alter table TB_CERVEJA 
        add constraint FK_CERVEJA_ESTILO
        foreign key (estilo_id) 
        references TB_ESTILO (id);    
	
    alter table TB_CERVEJA 
        add constraint FK_CERVEJA_FABRICANTE 
        foreign key (fabricante_id) 
        references TB_FABRICANTE (id);

    alter table TB_CERVEJA 
        add constraint FK_CERVEJA_PAIS
        foreign key (pais_id) 
        references TB_PAIS (id);
