package com.rene.chart2023analyse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    JdbcUserDetailsManager makePrincipals() {
        var admin = new JdbcUserDetailsManager(dataSource);

        admin.setUsersByUsernameQuery("""
                select emailAdres as username, paswoord as password, true as enabled
                from accounts
                where emailAdres = ?
                """);
        admin.setAuthoritiesByUsernameQuery("""
                select emailAdres,authority
                from accounts
                where emailAdres = ?
                """);
        return admin;
    }
    @Bean
    SecurityFilterChain geefRechten(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(requests
                -> requests.requestMatchers("/css/**", "/js/**", "/", "/index.html", "/principal",
                        "/tracks/filterByPlatform/**", "/tracks", "/tracks/solo", "/tracks/filterByYear", "/accessDenied.html").permitAll()
                .anyRequest().authenticated()
        );
        http.exceptionHandling(ex -> ex.accessDeniedPage("/accessDenied.html"));
        return http.build();
    }
}
