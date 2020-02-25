package com.furniturefuture.config;

import com.furniturefuture.entity.Product;
import com.furniturefuture.entity.Role;
import com.furniturefuture.entity.User;
import com.furniturefuture.repository.RoleRepository;
import com.furniturefuture.service.ProductService;
import com.furniturefuture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ProductService productService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()

                .antMatchers("/registration").not().fullyAuthenticated()

                .antMatchers("/news").hasRole("USER")
                .antMatchers("/product/all").permitAll()
                
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/admin/product/add").hasRole("ADMIN")

                .antMatchers("/admin/registration").hasRole("SUPERADMIN")

                .antMatchers("/", "/resources/**").permitAll()

                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/login")

                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");


    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());

//        save in db basic roles for further usage
//        roleRepository.save(new Role(1L,"ROLE_USER"));
//        roleRepository.save(new Role(2L,"ROLE_ADMIN"));
//        roleRepository.save(new Role(3L,"ROLE_SUPERADMIN"));
//        roleRepository.save(new Role(4L,"ROLE_CONTENTMAKER"));
//
//        User superadmin = new User();
//        superadmin.setUsername("superadmin");
//        superadmin.setPassword("adminpassword");
//
//        userService.saveSuperAdmin(superadmin);

    }
}