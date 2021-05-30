package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.util.List;

@Repository
public interface DonationRepo extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    int allBags();

    @Query("SELECT d FROM Donation d WHERE d.user.id = :id")
    List<Donation> myDonations(Long id);

    Donation findDonationById(Long id);
}