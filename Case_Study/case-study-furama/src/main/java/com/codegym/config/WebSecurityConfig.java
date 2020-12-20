package com.codegym.config;
import com.codegym.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/login", "/", "/logout").permitAll().and().
                authorizeRequests().antMatchers("/employee/list-employee","/contact/list-contact","contact-detail","/customer/list").access("hasRole('ROLE_ADMIN')").and().
                authorizeRequests().antMatchers("/customer/list","/customer/create","/customer/save","/customer/{id}/edit","/customer/delete","/customer/{id}/detail").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')").and().
                authorizeRequests().antMatchers().access("hasRole('ROLE_USER')")
                .anyRequest().authenticated()
                .and().cors();



//        // Các trang không yêu cầu login
//        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
//
//        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
//        // Nếu chưa login, nó sẽ redirect tới trang /login.
//        http.authorizeRequests().antMatchers("/customer/list","/customer/create","/customer/save","/customer/{id}/edit","/customer/delete","/customer/{id}/detail").access("hasRole('ROLE_USER')");
//
//        // Trang chỉ dành cho ADMIN
//        http.authorizeRequests().antMatchers("/employee/list-employee","/contact/list-contact","contact-detail","/customer/list").access("hasRole('ROLE_ADMIN')");
//
//        // Khi người dùng đã login, với vai trò XX.
//        // Nhưng truy cập vào trang yêu cầu vai trò YY,
//        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/customer/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
//                .loginProcessingUrl("/j_spring_security_check") // Submit URL
//                .loginPage("/login")//
                .defaultSuccessUrl("/")//
                .failureUrl("/login")//
//                .usernameParameter("username")//
//                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}
