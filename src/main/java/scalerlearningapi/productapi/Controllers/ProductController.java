package scalerlearningapi.productapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import scalerlearningapi.productapi.DTO.AddNewProductReqDto;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.DTO.SingleProductRespDto;
import scalerlearningapi.productapi.Models.Category;
import scalerlearningapi.productapi.Models.Product;
import scalerlearningapi.productapi.Services.ProductServiceBase;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getsingleProduct(@PathVariable("productId") Long pid){
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



        ResponseEntity<Product> respDto = new ResponseEntity<>(
                                            productService.getsingleProduct(pid),
                headers,
                HttpStatus.OK
        );
        return respDto;
    }
    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody AddNewProductReqDto product){
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
    public ProductRequestDto updateProduct(@PathVariable("productid") Long pid, @RequestBody ProductRequestDto dto){
//        Product product = productService.getsingleProduct(pid);
//        SingleProductRespDto respDto = new SingleProductRespDto();
//        respDto.setId(product.getId());
//        respDto.setTitle(product.getTitle());
//        respDto.setPrice(product.getPrice());
//        respDto.setCategory(product.getCategory().getName());
//        respDto.setImageUrl(product.getImageUrl());
//        respDto.setDescription(product.getDescription());
//        return respDto;
        return productService.updateProduct(pid,dto);
    }

    @DeleteMapping("/{productId}")
    public ProductRequestDto deleteProduct(@PathVariable("productId") Long pid){

        return productService.deleteProduct(pid);
    }
}
