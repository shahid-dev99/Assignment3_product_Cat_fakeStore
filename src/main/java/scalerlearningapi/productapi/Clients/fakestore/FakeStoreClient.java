package scalerlearningapi.productapi.Clients.fakestore;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import scalerlearningapi.productapi.DTO.ProductRequestDto;
import scalerlearningapi.productapi.Models.Category;
import scalerlearningapi.productapi.Models.Product;

import javax.print.DocFlavor;
import java.util.*;

@Component
public class FakeStoreClient {
//    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;
    private Map<Long,Object> productsMap = new HashMap<>();
    public FakeStoreClient(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }

    private Product convertDtoToProduct(FakeStoreProductRequestDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImage());
        product.setDescription(dto.getDescription());

        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);
        return  product;

    }

    public List<Product> getAllProducts(){
//        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductRequestDto[]> list = restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductRequestDto[].class);

        List<Product> answer = new ArrayList<>();

        for(FakeStoreProductRequestDto dto: list.getBody()){

            answer.add(convertDtoToProduct(dto));
        }
        return answer;
    }


    public Optional<Product> getsingleProduct(Long pid){
        if(productsMap.containsKey(pid)){
            Product producttemp = (Product)productsMap.get(pid);
            return Optional.of(producttemp);
        }else {
//            RestTemplate restTemplate = restTemplateBuilder.build();
            ResponseEntity<FakeStoreProductRequestDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                    FakeStoreProductRequestDto.class,
                    pid);

            FakeStoreProductRequestDto dto = response.getBody();
            if (dto == null) {
                return Optional.empty();
            }
            productsMap.put(Optional.of(convertDtoToProduct(dto)).get().getId(), Optional.of(convertDtoToProduct(dto)).get());

            return Optional.of(convertDtoToProduct(dto));
        }
    }

    public FakeStoreProductRequestDto addNewProduct(FakeStoreProductRequestDto product){
//        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductRequestDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductRequestDto.class);


        return response.getBody();
    }


    public FakeStoreProductRequestDto  updateProduct(Long productId, FakeStoreProductRequestDto product){
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(ProductRequestDto.class);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);

        ResponseExtractor<ResponseEntity<FakeStoreProductRequestDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductRequestDto.class);

        ResponseEntity<FakeStoreProductRequestDto> response = restTemplate.execute("https://fakestoreapi.com/products/{id}", HttpMethod.PUT,
                requestCallback, responseExtractor, productId);

        return response.getBody();
    }

    public FakeStoreProductRequestDto  deleteProduct(Long pid){
//        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductRequestDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductRequestDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductRequestDto.class);
        ResponseEntity<FakeStoreProductRequestDto> response = restTemplate.execute("https://fakestoreapi.com/products/{id}", HttpMethod.DELETE,
                requestCallback, responseExtractor, pid);

        return response.getBody();
    }


    public FakeStoreProductRequestDto changeProduct(Long PrId, FakeStoreProductRequestDto dto) {

        ResponseEntity<FakeStoreProductRequestDto> response = RequestForEntity
                (    HttpMethod.PATCH,
                        "https://fakestoreapi.com/products/{Pid}",
                        dto,
                        FakeStoreProductRequestDto.class,
                        PrId);
        return response.getBody();

    }

    //Category relation service calls

    public String[] getAllCategory(){
//        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/categories",
                String[].class)  ;
        return response.getBody();
    };


    public ProductRequestDto[] getProductsInCategory(String cid){
//        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{jcat}",
                ProductRequestDto[].class,cid);
        return response.getBody();
    };

    private <T> ResponseEntity<T> RequestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
//        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
//                HttpComponentsClientHttpRequestFactory.class
//        ).build();

        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
