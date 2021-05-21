package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Entity.Donation;

@Repository
public interface DonationRepo extends JpaRepository<Donation, Long> {

}
