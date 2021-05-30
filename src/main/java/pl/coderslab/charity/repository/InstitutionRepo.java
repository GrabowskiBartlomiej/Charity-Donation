package pl.coderslab.charity.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InstitutionRepo extends JpaRepository<Institution, Long> {

    Institution findInstitutionById(Long id);

}
