package lt.codeacadamy.shop.api.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lt.codeacadamy.shop.api.entity.Role;
import lt.codeacadamy.shop.api.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;
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
                    .collect(toSet())) // ["ADMIN", "USER"]
                .signWith(Keys.hmacShaKeyFor(secretKey),SignatureAlgorithm.HS512)
                .compact();
    }

    public Authentication parseToken(String jwt) {

        Claims parsedJwtBody;
        try {
            // parse and validate JWT
            parsedJwtBody = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            return null;
        }

        String username = parsedJwtBody.getSubject();
        List<GrantedAuthority> roles = ((List<String>) parsedJwtBody.get("roles")).stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(toList());

        return new UsernamePasswordAuthenticationToken(username, null, roles);
    }
}
