package scalerlearningapi.productapi.Services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import scalerlearningapi.productapi.Clients.fakestore.FakeStoreClient;
import scalerlearningapi.productapi.Clients.fakestore.FakeStoreProductRequestDto;
import scalerlearningapi.productapi.Models.Category;
import scalerlearningapi.productapi.Models.Product;
import scalerlearningapi.productapi.Repository.SqlRepository.productRepo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
public class FakeStoreProductSrvImp implements ProductServiceBase{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;
    private ProductRepository productRepository;

    public FakeStoreProductSrvImp(RestTemplateBuilder restTemplateBuilder,
                                  FakeStoreClient fakeStoreClient,
                                  ProductRepository productRep){
        this.restTemplateBuilder =restTemplateBuilder;
        this.fakeStoreClient =fakeStoreClient;
        this.productRepository = productRep;
    }
    private Product convertDtoToProduct2(FakeStoreProductRequestDto dto){
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

    @Override
    public List<Product> getAllProducts() {

    return fakeStoreClient.getAllProducts();


    }

    @Override
    public Optional<Product> getsingleProduct(Long pid) {

        return fakeStoreClient.getsingleProduct(pid);
    }

    @Override
    public Product addNewProduct(FakeStoreProductRequestDto productIn) {
       FakeStoreProductRequestDto dto = fakeStoreClient.addNewProduct(productIn);
      Product product =  new Product();
      product.setTitle(dto.getTitle());
      product.setDescription(dto.getDescription());

      Product newProduct = productRepository.save(product);
//       return convertDtoToProduct2(dto);
       return newProduct;
    }

    @Override
    public Product updateProduct(Long pid,FakeStoreProductRequestDto product) {
        return convertDtoToProduct2(fakeStoreClient.updateProduct(pid,product));
    }

    @Override
    public Product deleteProduct(Long pid) {
       return convertDtoToProduct2(fakeStoreClient.deleteProduct(pid));
    }

    @Override
    public Product changeProduct(Long PrId, FakeStoreProductRequestDto dto) {


        return convertDtoToProduct2(fakeStoreClient.changeProduct(PrId,dto));

    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return null;
    }

    @Override
    public Page<Product> getProductsPage(int noOfProducts, int offset) {
        return null;
    }


}
