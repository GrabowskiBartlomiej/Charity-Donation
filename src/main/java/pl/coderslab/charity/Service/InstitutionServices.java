package pl.coderslab.charity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entity.Institution;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.InstitutionRepo;

@Service
public class InstitutionServices {

    private InstitutionRepo institutionRepo;

    @Autowired
    public InstitutionServices(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }


    public void addInstitution(Institution newInstitution) {
        institutionRepo.save(newInstitution);
    }


    public void removeInstitution(Long id) {
        institutionRepo.delete(institutionRepo.findInstitutionById(id));
    }

    public Institution getInstitution(Long id) {
        return institutionRepo.findInstitutionById(id);
    }

    public void updateInstitution(Institution editInstitution) {
        Institution institution = institutionRepo.findInstitutionById(editInstitution.getId());
        institution.setName(editInstitution.getName());
        institution.setDescription(editInstitution.getDescription());
        institutionRepo.save(institution);
    }

}
