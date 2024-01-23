package scalerlearningapi.productapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class MyCustomSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                                .requestMatchers("/productsget")
//                                .hasAuthority("ADMIN")
////                        .requestMatchers("/messages/**").access(hasScope("message:read"))
//                        .anyRequest().authenticated()
//                                .anyRequest().permitAll()
//
//                ).oauth2ResourceServer((oath2)-> oath2.jwt(Customizer.withDefaults()))
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwt -> jwt
//                                .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter())
//                        )
//                );
//        return http.build();

        http
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/productsget").permitAll()
//                                .requestMatchers("/productsget").hasAuthority("ADMIN")
//                                .requestMatchers("/topics/course/**").authenticated()
                                .anyRequest().permitAll() //only allow a person who has logged in to be able to access any URL
//                                .anyRequest().permitAll() // allow anyone to access any url without needing login
                )
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter())
                        )
                ).csrf().disable()
                .cors().disable();
        return http.build();
    }
}
