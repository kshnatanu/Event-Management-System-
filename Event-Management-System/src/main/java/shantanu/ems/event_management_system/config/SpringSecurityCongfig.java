package shantanu.ems.event_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityCongfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)->csrf.disable()) // Disable CSRF protection for testing (not recommended for production)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())  // Allow all requests
                .httpBasic(Customizer.withDefaults());  // Enable basic authentication if needed
        return http.build();
    }
}
