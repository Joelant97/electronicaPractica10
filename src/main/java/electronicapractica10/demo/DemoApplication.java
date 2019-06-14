package electronicapractica10.demo;

import electronicapractica10.demo.service.ServiciosUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.beans.BeansException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        System.out.println("Bean names: " + Arrays.toString(applicationContext.getBeanNamesForType(ServiciosUsuario.class)));

        ServiciosUsuario usuarioServices;
        try {
            usuarioServices = (ServiciosUsuario) applicationContext.getBean("serviciosUsuario");
            usuarioServices.crearAdmin();

        } catch (BeansException e) {
            e.printStackTrace();
        }


    }


}




