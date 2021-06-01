package lt.codeacadamy.shop.api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lt.codeacadamy.shop.api.entity.Role;
import lt.codeacadamy.shop.api.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

import static java.util.stream.Collectors.toSet;

@Service
public class JwtService {

    private final long tokenValidityInMillis;
    private final byte[] secretKey;

    public JwtService(
            @Value("#{${security.jwt.validity-mins} * 60000}") long tokenValidityInMillis,
            @Value("${security.jwt.secret-key}") byte[] secretKey) {
        this.tokenValidityInMillis = tokenValidityInMillis;
        this.secretKey = secretKey;
    }

    public String createToken(User user) {

        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setIssuer("eshop-api")
                .setAudience("eshop-ui")
                .setSubject(user.getUsername())
                .setExpiration(new Date(now.getTime() + tokenValidityInMillis))
                .setIssuedAt(now)
                .claim("roles", user.getRoles().stream()
                    .map(Role::getName)
                    .collect(toSet()))
                .signWith(Keys.hmacShaKeyFor(secretKey),SignatureAlgorithm.HS512)
                .compact();
    }
}
