package scalerlearningapi.productapi.Services;

import scalerlearningapi.productapi.Clients.fakestore.FakeStoreProductRequestDto;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceBase {


    public List<Product> getAllProducts();


    public Optional<Product> getsingleProduct(Long pid);

    public Product addNewProduct(FakeStoreProductRequestDto product);


    public Product updateProduct( Long productId, FakeStoreProductRequestDto product);

    public Product deleteProduct(Long pid);
    public Product changeProduct(Long PrId,FakeStoreProductRequestDto dto);
    public List<Product> getProductsByCategoryId(Long id);

}
