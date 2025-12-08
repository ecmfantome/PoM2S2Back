package dev.unchk.platformm2po;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;
import java.sql.Connection;

@EnableJpaAuditing
@SpringBootApplication
public class PlatformM2PoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformM2PoApplication.class, args);

    }

    @Bean
    public CommandLineRunner testConnection(DataSource dataSource) {
        return args -> {
            System.out.println("Test de connexion BD...");
            try (Connection conn = dataSource.getConnection()) {
                System.out.println("Connexion réussie !");
                System.out.println("URL: " + conn.getMetaData().getURL());
                System.out.println("*************PlatformM2Po Application Started on  : 9090 ************* ");
            } catch (Exception e) {
                System.out.println("ERREUR CONNEXION: " + e.getMessage());
            }
        };
    }
}
