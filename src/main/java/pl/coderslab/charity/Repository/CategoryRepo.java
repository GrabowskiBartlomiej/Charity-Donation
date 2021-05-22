package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Entity.Category;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
