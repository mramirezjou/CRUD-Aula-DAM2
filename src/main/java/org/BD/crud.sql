CREATE TABLE Professors (
       id_profesor NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
       nom VARCHAR2(30),
       cognoms VARCHAR2(30)
);

CREATE TABLE ModulsProfessionals (
       id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
       nom VARCHAR2(30),
       id_professor NUMBER,
       CONSTRAINT fk_professor
       FOREIGN KEY (id_professor)
       REFERENCES Professors(id_profesor)
);