package electronicapractica10.demo.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
            auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder);
    }

    /*
     * Permite configurar las reglas de seguridad.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Marcando las reglas para permitir unicamente los usuarios

        http.authorizeRequests().antMatchers("/assets/**", "/vendor/**", "ajax", "/stylesheets/**", "/javascripts/**", "/images/**").permitAll() // permitiendo llamadas a esas urls.
                .antMatchers("/h2-console/**").permitAll().antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/index/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/usuarios/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated() // cualquier llamada debe ser validada
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin().loginPage("/login") // indicando la ruta que estaremos utilizando.

                .defaultSuccessUrl("/")
                .failureUrl("/login?error") // en caso de fallar puedo indicar otra pagina.
                .permitAll().and().logout().permitAll();

        //deshabilitando las seguridad contra los frame
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }



}
