package scalerlearningapi.productapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import scalerlearningapi.productapi.Controllers.ProductController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//@WebMvcTest(ProductController.class)
public class FunctionalTest {
//    @Autowired
    private MockMvc mockMvc;
//    @Test
    void getAllProducts() throws  Exception{
        mockMvc.perform( get("/productsget")).
                andExpect(status().is(200));
    }
}
