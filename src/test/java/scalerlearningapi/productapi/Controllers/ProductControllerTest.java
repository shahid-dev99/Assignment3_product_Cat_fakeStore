package scalerlearningapi.productapi.Controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import scalerlearningapi.productapi.Models.Product;
import scalerlearningapi.productapi.Services.PeristInDbProductService;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

 import static org.junit.jupiter.api.Assertions.*;
 import static org.mockito.Mockito.*;
@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private PeristInDbProductService peristInDbProductService;
    @Test
    void getAllProducts() {
        List<Product> productMocks = new ArrayList<>();
        Product pMock = new Product();
        pMock.setPrice(3.00);
        productMocks.add(pMock);
        when(peristInDbProductService.getAllProducts()).thenReturn(productMocks);
        List<Product> products = productController.getAllProducts();
//        assert products.get(0).getPrice()== 3.00;
        assertEquals(4.00, products.get(0).getPrice());
        assertThat(products.get(0).getPrice()).
                isEqualTo(4.00).
                isGreaterThan(5.00);
    }
}