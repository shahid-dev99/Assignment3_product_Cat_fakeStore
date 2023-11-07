package scalerlearningapi.productapi.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import scalerlearningapi.productapi.Models.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    void deleteById(Long aLong);


//    List<Product> findAllByCategory_Id(Long id);
//    @Query("select p from Product p where category_id = :id")
//   public findByCategory_id(Long id);
    public List<Product>findBycategory_id(Long id);


}
