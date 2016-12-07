package com.jamie.cards.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WebSecurityConfiguration.class);

    @Value("${mgmt.admin.user}")
    private String mgmtAdminUser;
    @Value("${mgmt.admin.password}")
    private String mgmtAdminPassword;
    @Value("${mgmt.admin.role}")
    private String mgmtAdminRole;

    @Value("${service.user.name}")
    private String apiGatewayUser;
    @Value("${service.user.password}")
    private String apiGatewayPassword;
    @Value("${service.user.role}")
    private String apiGatewayRole;

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http
                    .authorizeRequests()
                    .antMatchers("/mgmt/**").hasRole(mgmtAdminRole)
                    .antMatchers("/v1/**").hasRole(apiGatewayRole)
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .and()
                    .csrf().disable();
        } catch (Exception e) {
            throw new WebSecurityConfigurationException(e);
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        try {
            auth
                    .inMemoryAuthentication()
                    .withUser(apiGatewayUser).password(apiGatewayPassword).roles(apiGatewayRole)
                    .and()
                    .withUser(mgmtAdminUser).password(mgmtAdminPassword).roles(mgmtAdminRole, apiGatewayRole);
        } catch (Exception e) {
            throw new WebSecurityConfigurationException(e);
        }
    }
}
