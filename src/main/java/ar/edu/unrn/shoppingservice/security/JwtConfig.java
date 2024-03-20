package ar.edu.unrn.shoppingservice.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
public class JwtConfig {

    @Value("${jwt.secret_key}")
    private String secretKey;

    @Value("${jwt.token-prefix}")
    private String tokenPrefix;

    @Value("${jwt.header}")
    private String header;

    public JwtConfig() {
    }

}