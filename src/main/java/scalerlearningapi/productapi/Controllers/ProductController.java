package scalerlearningapi.productapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import scalerlearningapi.productapi.Clients.fakestore.FakeStoreProductRequestDto;
import scalerlearningapi.productapi.DTO.*;
import scalerlearningapi.productapi.Exceptions.NotFoundException;
import scalerlearningapi.productapi.Models.Product;
import scalerlearningapi.productapi.Services.ProductServiceBase;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    //dependency injection
    private ProductServiceBase productService;

    public ProductController(ProductServiceBase productSrv){
        this.productService = productSrv;
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
//    @ExceptionHandler(NotFoundException.class)
//    ResponseEntity<ErrorResponseDto> handleNotFoundException(Exception exception){
//        ErrorResponseDto dto = new ErrorResponseDto();
//        dto.setErrorMessage(exception.getMessage());
//        return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
//    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getsingleProduct(@PathVariable("productId") Long pid) throws NotFoundException{
       // Product product = productService.getsingleProduct(pid);
//        ResponseEntity<SingleProductRespDto> respDto = new ResponseEntity<SingleProductRespDto>();
//        respDto.setId(product.getId());
//        respDto.setTitle(product.getTitle());
//        respDto.setPrice(product.getPrice());
//        respDto.setCategory(product.getCategory().getName());
//        respDto.setImageUrl(product.getImageUrl());
//        respDto.setDescription(product.getDescription());
//        respDto.setRating(product.getRating());
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token","Noaccess3994e");


        Optional<Product> product =  productService.getsingleProduct(pid);
        if(product.isEmpty()){
            throw new NotFoundException("Product not found with id: "+ pid);
        }
        ResponseEntity<Product> respDto = new ResponseEntity<>(
                                            product.get(),
                headers,
                HttpStatus.OK
        );
        return respDto;
    }
    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody FakeStoreProductRequestDto product){
//        Product inp = new Product();
//        inp.setTitle(product.getTitle());
//        inp.setDescription(product.getDescription());
//        inp.setPrice(product.getPrice());
//        Category category = new Category();
//        category.setName(product.getCategory());
//        inp.setCategory(category);
//        inp.setImageUrl(product.getImage());
        Product newProduct = productService.addNewProduct(product);
       ResponseEntity<Product> response = new ResponseEntity<>(newProduct,
                                                                HttpStatus.OK);
       return response;
    }

    @PutMapping("/{productid}")
    public Product updateProduct(@PathVariable("productid") Long pid, @RequestBody FakeStoreProductRequestDto dto){
        return productService.updateProduct(pid,dto);
    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable("productId") Long pid){

        return productService.deleteProduct(pid);
    }

    @PatchMapping("/{productid}")
    public Product ChangeProduct(@PathVariable("productid") Long pid, @RequestBody FakeStoreProductRequestDto dto){

        return productService.changeProduct(pid,dto);
    }

}
