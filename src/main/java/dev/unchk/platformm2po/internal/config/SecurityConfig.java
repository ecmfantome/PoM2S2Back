package dev.unchk.platformm2po.internal.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebFluxSecurity
@AllArgsConstructor
@EnableReactiveMethodSecurity
public class SecurityConfig {
    private final FirebaseJwtDecoder jwtDecoder;

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .oauth2ResourceServer(OA2RS -> OA2RS.jwt(jwt -> jwt.jwtDecoder(jwtDecoder)))
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/actuator/**", "api/v1/user/sign_in").permitAll()
                        .pathMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .anyExchange().authenticated()
                )
                .cors(corsSpec -> corsSpec.configurationSource(corsConfigurationSource()))
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Configuration des origines autorisées
        configuration.addAllowedOrigin("*"); // Autorise toutes les origines (ou remplacez "*" par des URLs spécifiques)
        configuration.addAllowedMethod(HttpMethod.GET); // Autorise les requêtes GET
        configuration.addAllowedMethod(HttpMethod.POST); // Autorise les requêtes POST
        configuration.addAllowedHeader("*"); // Autorise tous les en-têtes
        configuration.setAllowCredentials(true); // Autorise les cookies

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Applique la configuration CORS à toutes les URL
        return source;
    }

}
