package scalerlearningapi.productapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import scalerlearningapi.productapi.Clients.fakestore.FakeStoreClient;
import scalerlearningapi.productapi.DTO.ProductRequestDto;

@Service
public class FakeStoreCategorySrveImpl implements CategoryServiceBase{

    private FakeStoreClient fakeStoreClient;
    @Autowired
    public void FakeStoreProductSrvImp(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }
    @Override
    public String[] getAllCategory() {
       return fakeStoreClient.getAllCategory();

    }

    @Override
    public ProductRequestDto[] getProductsInCategory(String cid) {
       return fakeStoreClient.getProductsInCategory(cid);
    }
}
