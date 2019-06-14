package electronicapractica10.demo;


import electronicapractica10.demo.service.ServiciosUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.beans.BeansException;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);


//        ServiciosUsuario usuarioServices;
//        try {
//            usuarioServices = (ServiciosUsuario) applicationContext.getBean("usuarioServices");
//            usuarioServices.crearAdmin();
//
//        } catch (BeansException e) {
//            e.printStackTrace();
//        }


    }


}




