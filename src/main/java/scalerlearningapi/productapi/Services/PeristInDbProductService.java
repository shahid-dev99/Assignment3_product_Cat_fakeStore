package scalerlearningapi.productapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import scalerlearningapi.productapi.Clients.fakestore.FakeStoreProductRequestDto;
import scalerlearningapi.productapi.Models.Product;
import scalerlearningapi.productapi.Repository.SqlRepository.productRepo.ProductRepository;

import java.util.List;
import java.util.Optional;
@Service
@Primary
public class PeristInDbProductService implements ProductServiceBase {
    private ProductRepository productRepository;
    @Autowired
   public void PersistInDbCategoryService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getsingleProduct(Long pid) {
        return productRepository.findById(pid);
    }

    @Override
    public Product addNewProduct(FakeStoreProductRequestDto product) {
        Product product1 = new Product();
        // set attributes of product from product DTO
        product1.setDescription(product.getDescription());
        product1.setTitle(product.getTitle());
        product1.setPrice(product.getPrice());
       // product1.setCategory(product.getCategory());
        return productRepository.save(product1);
    }

    @Override
    public Product updateProduct(Long productId, FakeStoreProductRequestDto product) {
        Product product1 = new Product();
        // set attributes of product from product DTO
        product1.setId(productId);
        product1.setDescription(product.getDescription());
        product1.setTitle(product.getTitle());
        product1.setPrice(product.getPrice());
        // product1.setCategory(product.getCategory());
        return productRepository.save(product1);
    }

    @Override
    public Product deleteProduct(Long pid) {
        Product product =  new Product();
        product.setId(pid);
        product.setDescription("This product is deleted");
         productRepository.deleteById(pid);
         return product;
    }

    @Override
    public Product changeProduct(Long PrId, FakeStoreProductRequestDto dto) {
        Product product1 = new Product();
        // set attributes of product from product DTO
        product1.setId(PrId);
        product1.setDescription(dto.getDescription());
        product1.setTitle(dto.getTitle());
        product1.setPrice(dto.getPrice());
        // product1.setCategory(product.getCategory());
        return productRepository.save(product1);
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return productRepository.findBycategory_id(id);
    }

    @Override
    public Page<Product> getProductsPage(int noOfProducts, int offset) {
        Page<Product> products = productRepository.findAll(
                PageRequest.of((offset/noOfProducts), noOfProducts, Sort.by("title").descending())
        );
        return products;
    }


}
