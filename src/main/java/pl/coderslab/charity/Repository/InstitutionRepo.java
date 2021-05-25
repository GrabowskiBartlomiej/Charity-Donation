package pl.coderslab.charity.Repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InstitutionRepo extends JpaRepository<Institution, Long> {

    Institution findInstitutionById(Long id);

}
