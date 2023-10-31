package scalerlearningapi.productapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scalerlearningapi.productapi.Models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long aLong);
}
