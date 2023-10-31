package scalerlearningapi.productapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scalerlearningapi.productapi.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
