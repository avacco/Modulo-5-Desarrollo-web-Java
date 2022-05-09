
CREATE TABLE cliente (
    id_cliente   SERIAL NOT NULL,
    nombre       VARCHAR(50),
    telefono     VARCHAR(50),
    direccion    VARCHAR(50)
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id_cliente );

CREATE TABLE electrodomestico (
    id_electrodomestico   SERIAL NOT NULL,
    nombre                VARCHAR(50),
    falla                 VARCHAR(50),
    id_cliente            INTEGER NOT NULL
);

ALTER TABLE electrodomestico ADD CONSTRAINT electrodomestico_pk PRIMARY KEY ( id_electrodomestico );

CREATE TABLE ordendetrabajo (
    id_odt                    SERIAL NOT NULL,
    estado                    VARCHAR(50),
    fechasolicitud            DATE,
    fechaactualizacionorden   DATE,
    id_electrodomestico       INTEGER NOT NULL
);

ALTER TABLE ordendetrabajo ADD CONSTRAINT ordendetrabajo_pk PRIMARY KEY ( id_odt );

ALTER TABLE ordendetrabajo
    ADD CONSTRAINT electrodomestico_fk FOREIGN KEY ( id_electrodomestico )
        REFERENCES electrodomestico ( id_electrodomestico );

ALTER TABLE electrodomestico
    ADD CONSTRAINT electrodomestico_cliente_fk FOREIGN KEY ( id_cliente )
        REFERENCES cliente ( id_cliente );
