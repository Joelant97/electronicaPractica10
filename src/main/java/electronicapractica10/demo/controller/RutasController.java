package electronicapractica10.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller("/index")
public class RutasController {

    @Autowired
    MessageSource messageSource;
  
    @RequestMapping(value = {"/"})
    public String index(Model model, Locale locale, HttpServletRequest request) {

        return "index";
    }

}
