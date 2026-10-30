package org.ModelDAO;

import org.Model.Professor;

import java.util.List;

public interface ProfessorDAO {
    void addDam2(Professor professor);
    void deleteDam2(Professor professor);
    void updateDam2(Professor professor);
    List<Professor> readDam2();
}
