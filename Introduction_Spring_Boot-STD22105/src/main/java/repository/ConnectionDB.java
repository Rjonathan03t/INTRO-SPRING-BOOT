package repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionDB {
    @Value("${DB_USERNAME}")
    private String username;
    @Value("${DB_PASSWORD}")
    private String password;
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost/intro_spring_boot",
                username,
                password
        );
    }
}
