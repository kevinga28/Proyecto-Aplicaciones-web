
package Proyecto.Proyecto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration 
public class ProjectConfig  implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");

 }
      @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/",
                                 "/index", 
                                 "/errores/**", 
                                 "/js/**", 
                                 "/css/**", 
                                 "/assets/**")
                .permitAll()
                .requestMatchers("/index", "/product/**", "/caracteristicas/**", 
                                 "/chat/**","/pago/**",
                                 "/perfil/**","/personal/**",
                                 "/registro/**","/seguridad/**")
               .hasRole("ADMIN"))
                .formLogin((form) -> form.loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true))
                .logout(LogoutConfigurer::permitAll)
                .csrf().disable().cors();//this line is important to allow ajax request from the js
        return http.build();
    }
  @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}