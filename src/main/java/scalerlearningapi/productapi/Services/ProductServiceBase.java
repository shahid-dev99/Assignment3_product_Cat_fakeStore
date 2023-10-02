package scalerlearningapi.productapi.Services;

import org.springframework.web.bind.annotation.*;
import scalerlearningapi.productapi.DTO.AddNewProductReqDto;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.Models.Category;
import scalerlearningapi.productapi.Models.Product;

import java.util.List;

public interface ProductServiceBase {


    public List<Product> getAllProducts();


    public Product getsingleProduct(  Long pid);

    public Product addNewProduct(AddNewProductReqDto product);


    public ProductRequestDto updateProduct( Long productId, ProductRequestDto product);

    public ProductRequestDto deleteProduct(Long pid);

}
