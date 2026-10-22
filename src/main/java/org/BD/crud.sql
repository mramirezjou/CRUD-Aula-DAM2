CREATE TABLE Professors (
      id_profesor NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
      nom VARCHAR2(30),
      cognoms VARCHAR2(30)
);
create table Moduls(
    id_modul NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nom varchar2(30)
)
CREATE TABLE ModulsProfessionals (
     id_modul     NUMBER,
     id_professor NUMBER,
     CONSTRAINT pk_mod_prof PRIMARY KEY (id_modul, id_professor),
     CONSTRAINT fk_moduls_comp FOREIGN KEY (id_modul)
        REFERENCES Moduls(id_modul),
     CONSTRAINT fk_prof_comp FOREIGN KEY (id_professor)
         REFERENCES Professors(id_profesor)
);
