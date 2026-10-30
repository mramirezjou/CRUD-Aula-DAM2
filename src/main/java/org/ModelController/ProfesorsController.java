package org.ModelController;

import org.Model.Professor;
import org.ModelDAO.ProfessorDAO;
import org.ModelDAOImpl.ProfessorDAOImpl;

import java.util.List;

public class ProfesorsController {

    private ProfessorDAO professorDAO = new ProfessorDAOImpl();

    public void altaProfessor(Professor professor) {
        professorDAO.addDam2(professor);
    }
    public void deleteDam2(Professor professor){
        professorDAO.deleteDam2(professor);
    }
    public void updateDam2(Professor professor){
        professorDAO.updateDam2(professor);
    }
    public List<Professor> readDam2(){
        professorDAO.readDam2();
        return professorDAO.readDam2();
    }
}
