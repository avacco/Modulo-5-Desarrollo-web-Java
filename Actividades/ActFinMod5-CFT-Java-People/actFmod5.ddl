
CREATE TABLE asignatura (
    id_asignatura   SERIAL NOT NULL,
    nombre          VARCHAR(50)
);

ALTER TABLE asignatura ADD CONSTRAINT asignatura_pk PRIMARY KEY ( id_asignatura );

CREATE TABLE calificacion (
    numeroevaluacion           INTEGER NOT NULL,
    nota                       REAL NOT NULL,
    id_estudiante              INTEGER NOT NULL,
    id_asignatura              INTEGER NOT NULL
);

ALTER TABLE calificacion ADD CONSTRAINT calificacion_pk PRIMARY KEY ( nota );

CREATE TABLE estudiante (
    id_estudiante     SERIAL NOT NULL,
    rut               VARCHAR(50),
    dv                CHAR(1),
    nombre1           VARCHAR(50),
    nombre2           VARCHAR(50),
    apellidomaterno   VARCHAR(50),
    apellidopaterno   VARCHAR(50),
    genero            VARCHAR(50),
    fono              VARCHAR(50),
    curso             VARCHAR(50)
);

ALTER TABLE estudiante ADD CONSTRAINT estudiante_pk PRIMARY KEY ( id_estudiante );

ALTER TABLE calificacion
    ADD CONSTRAINT calificacion_asignatura_fk FOREIGN KEY ( id_asignatura )
        REFERENCES asignatura ( id_asignatura );

ALTER TABLE calificacion
    ADD CONSTRAINT calificacion_estudiante_fk FOREIGN KEY ( id_estudiante )
        REFERENCES estudiante ( id_estudiante );

