package electronicapractica10.demo;

import electronicapractica10.demo.service.SecurityService;
import electronicapractica10.demo.service.StorageProperties;
import electronicapractica10.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties(StorageProperties.class)
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =  SpringApplication.run(DemoApplication.class, args);
        SecurityService securityService = (SecurityService) applicationContext.getBean("securityService");
        securityService.crearUsuarioAdmin();
    }

    /*@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    } */
}




