/***
package com.divby0exc.routingpool.config;

import com.divby0exc.routingpool.failedjwt.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;




@Component
public class JwtTokenFilter extends OncePerRequestFilter {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Logger logger;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        // Get jwt token and validate
        var token = verifyAndDecode(header.substring(7).trim());
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        // Get user identity and set it on the spring security context
        User user = userRepository.findByEmail(token.getClaim("username").asString()).get(0);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private DecodedJWT verifyAndDecode(String token) throws UnauthorizedError {
        try {
            Algorithm algorithm = Algorithm.RSA256(cryptic.getPubKey(), cryptic.getPrivKey());
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer(issuer)
                    .withClaim("unique", jwtUnique)
                    // reusable verifier instance
                    .build();
            return verifier.verify(token);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return null;
    }
}
*/
