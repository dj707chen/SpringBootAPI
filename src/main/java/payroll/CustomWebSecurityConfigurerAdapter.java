package payroll;

// https://www.baeldung.com/spring-security-basic-authentication

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.*;
import java.io.IOException;

//@Configuration
//@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter //extends WebSecurityConfigurerAdapter
{
//
//    @Autowired
//    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("password"))
//                .authorities("USER");
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("password"))
//                .authorities("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/securityNone").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint);
//
//        http.addFilterAfter(
//                new Filter() {
//                    @Override
//                    public void doFilter(
//                            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain
//                    ) throws IOException, ServletException {
//                        System.out.println(("[doFilter] "));
//                        filterChain.doFilter(servletRequest, servletResponse);
//                    }
//                },
//                BasicAuthenticationFilter.class);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
