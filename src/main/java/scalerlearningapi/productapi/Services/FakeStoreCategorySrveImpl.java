package scalerlearningapi.productapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import scalerlearningapi.productapi.DTO.ProductRequestDto;

@Service
public class FakeStoreCategorySrveImpl implements CategoryServiceBase{
    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public void FakeStoreProductSrvImp(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public String[] getAllCategory() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/categories",
                                    String[].class)  ;
        return response.getBody();

    }

    @Override
    public ProductRequestDto[] getProductsInCategory(String cid) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{jcat}",
                    ProductRequestDto[].class,cid);
        return response.getBody();
    }
}
