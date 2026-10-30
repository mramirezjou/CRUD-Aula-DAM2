CREATE TABLE Professors (
                            id_profesor INT AUTO_INCREMENT PRIMARY KEY,
                            nom VARCHAR(30),
                            cognoms VARCHAR(30)
);

CREATE TABLE ModulsProfessionals (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     nom VARCHAR(30),
                                     id_professor INT,
                                     CONSTRAINT fk_professor
                                         FOREIGN KEY (id_professor)
                                             REFERENCES Professors(id_profesor)
);