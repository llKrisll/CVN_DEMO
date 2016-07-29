package com.synapsis.cvn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@ComponentScan(basePackages = { "com.synapsis.cvn.security"})
//@ComponentScan(basePackageClasses = MyUserDetailsService.class)
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;


    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/security/login*", "/security/logout*", "/signin/**", "/signup/**",
                        "/user/registration*", "/security/regitrationConfirm*", "/security/expiredAccount*", "/security/registration*",
                        "/security/badUser*", "/user/resendRegistrationToken*" ,"/security/forgetPassword*", "/user/resetPassword*",
                        "/user/changePassword*", "/security/emailError*", "/resources/**","/old/user/registration*","/security/successRegister*").permitAll()
                .antMatchers("/vendors/**","/images/.**","/css/**","/js/**").permitAll()
                .antMatchers("/security/invalidSession*").anonymous()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/security/login")
                .defaultSuccessUrl("/security/homepage.html")
                .failureUrl("/security/login?error=true")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
            .permitAll()
                .and()
            .sessionManagement()
                .invalidSessionUrl("/security/invalidSession.html")
                .sessionFixation().none()
            .and()
            .logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/security/logout.html?logSucc=true")
                .deleteCookies("JSESSIONID")
                .permitAll();
     // @formatter:on
    }

    // beans

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}