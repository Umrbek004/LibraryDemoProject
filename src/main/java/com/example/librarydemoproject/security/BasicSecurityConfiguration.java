package com.example.librarydemoproject.security;

import com.example.librarydemoproject.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class BasicSecurityConfiguration {
    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//       http.authorizeHttpRequests((authorize)->authorize
//               .anyRequest()
//               .permitAll());
//       http.csrf((as)->as.disable());
//        http.authorizeHttpRequests((authorize)->authorize
//                .requestMatchers("/admin").permitAll()
//                .anyRequest()
//                .authenticated()).httpBasic(Customizer.withDefaults());
//        http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
//        HttpSecurity and = http.authorizeRequests().anyRequest().authenticated().and();
//        and.authenticationProvider(daoAuth());
//        and.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated()).authenticationProvider(daoAuth()).formLogin().permitAll();

        return http.build();
    }


    @Bean
    public DaoAuthenticationProvider daoAuth() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(encoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
