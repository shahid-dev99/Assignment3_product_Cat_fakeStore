package scalerlearningapi.productapi.Services;

import org.apache.catalina.connector.Response;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import scalerlearningapi.productapi.DTO.AddNewProductReqDto;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.DTO.RatingDto;
import scalerlearningapi.productapi.Models.Category;
import scalerlearningapi.productapi.Models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductSrvImp implements ProductServiceBase{
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductSrvImp(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder =restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
    RestTemplate restTemplate = restTemplateBuilder.build();
    ResponseEntity<ProductRequestDto[]> list = restTemplate.getForEntity("https://fakestoreapi.com/products",
                                ProductRequestDto[].class);

    List<Product> answer = new ArrayList<>();

    for(ProductRequestDto dto: list.getBody()){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImage());
        product.setDescription(dto.getDescription());

        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);
        answer.add(product);
    }
    return answer;




    }

    @Override
    public Product getsingleProduct(Long pid) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                                                            ProductRequestDto.class,
        pid);

        ProductRequestDto dto = response.getBody();
        Product product =new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImage());
        product.setDescription(dto.getDescription());

        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);

//        RatingDto ratingDto = new RatingDto();
//        ratingDto.setRate(dto.getRating().getRate());
//        ratingDto.setCount(dto.getRating().getCount());
//        product.setRating(ratingDto);


        return product;
    }

    @Override
    public Product addNewProduct(AddNewProductReqDto productIn) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDto> response = restTemplate.postForEntity(
                                    "https://fakestoreapi.com/products",
                                        productIn,
                                        ProductRequestDto.class);

        ProductRequestDto dto = response.getBody();
        Product product =new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImage());
        product.setDescription(dto.getDescription());

        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);

//        RatingDto ratingDto = new RatingDto();
//        ratingDto.setRate(dto.getRating().getRate());
//        ratingDto.setCount(dto.getRating().getCount());
//        product.setRating(ratingDto);


        return product;
    }

    @Override
    public ProductRequestDto updateProduct(Long pid,ProductRequestDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(ProductRequestDto.class);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);

        ResponseExtractor<ResponseEntity<ProductRequestDto>> responseExtractor =
                restTemplate.responseEntityExtractor(ProductRequestDto.class);

        ResponseEntity<ProductRequestDto> response = restTemplate.execute("https://fakestoreapi.com/products/{id}", HttpMethod.PUT,
                requestCallback, responseExtractor, pid);

        return response.getBody();
    }

    @Override
    public ProductRequestDto deleteProduct(Long pid) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(ProductRequestDto.class);
        ResponseExtractor<ResponseEntity<ProductRequestDto>> responseExtractor =
                restTemplate.responseEntityExtractor(ProductRequestDto.class);
        ResponseEntity<ProductRequestDto> response = restTemplate.execute("https://fakestoreapi.com/products/{id}", HttpMethod.DELETE,
                requestCallback, responseExtractor, pid);

        return response.getBody();
    }
}
