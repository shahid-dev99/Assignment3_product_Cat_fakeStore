package scalerlearningapi.productapi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempelateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate createRestTempelate(){
        return new RestTemplate();
    }
}
