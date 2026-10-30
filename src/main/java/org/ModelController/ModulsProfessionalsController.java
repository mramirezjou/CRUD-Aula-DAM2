package org.ModelController;

import org.Model.Professor;
import org.ModelDAO.ProfessorDAO;
import org.ModelDAOImpl.ProfessorDAOImpl;

public class ProfesorsController {

    private ProfessorDAO professorDAO = new ProfessorDAOImpl();

    public void altaProfessor(Professor professor) {
        professorDAO.addDam2(professor);
    }
}
