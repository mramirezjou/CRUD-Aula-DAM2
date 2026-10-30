package org.ModelController;

import org.Model.ModulsProfessionals;
import org.ModelDAO.ModulsProfessionalsDAO;
import org.ModelDAOImpl.ModulsProfessionalsDAOImpl;

public class ModulsProfessionalsController {

    private final ModulsProfessionalsDAO modulsProfessionalsDAO = new ModulsProfessionalsDAOImpl();

    public void altaModul(ModulsProfessionals modulsProfessionals) {
        modulsProfessionalsDAO.addDam2(modulsProfessionals);
    }
    public void baixaModul(ModulsProfessionals modulsProfessionals) {
        modulsProfessionalsDAO.deleteDam2(modulsProfessionals);
    }
    public void actualitzaModul(ModulsProfessionals modulsProfessionals) {
        modulsProfessionalsDAO.updateDam2(modulsProfessionals);
    }
    public void llegirModul(ModulsProfessionals modulsProfessionals) {
        modulsProfessionalsDAO.readDam2(modulsProfessionals);
    }
}
