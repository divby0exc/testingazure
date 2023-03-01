package com.divby0exc.routingpool.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;

import static java.lang.String.format;

public class SecurityFilter {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http.cors().and().csrf().disable();

        // Set session management to stateless
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Set unauthorized requests exception handler
        http.exceptionHandling(
                (exceptions) ->
                        exceptions
                                .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                                .accessDeniedHandler(new BearerTokenAccessDeniedHandler()));

        // Set permissions on endpoints
        http.authorizeHttpRequests()
                // Swagger endpoints must be publicly accessible
                .requestMatchers("/")
                .permitAll()
                .requestMatchers(format("%s/**", restApiDocPath))
                .permitAll()
                .requestMatchers(format("%s/**", swaggerPath))
                .permitAll()
                // Our public endpoints
                .requestMatchers("/api/public/**")
                .permitAll()
                .requestMatchers(HttpMethod.GET, "/api/author/**")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/api/author/search")
                .permitAll()
                .requestMatchers(HttpMethod.GET, "/api/book/**")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/api/book/search")
                .permitAll()
                // Our private endpoints
                .anyRequest()
                .authenticated()
                // Set up oauth2 resource server
                .and()
                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        return http.build();
    }
}
