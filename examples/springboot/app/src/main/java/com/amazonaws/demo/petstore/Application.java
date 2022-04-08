package com.amazonaws.demo.petstore;

import com.amazonaws.demo.petstore.controller.PetsController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@Import({ PetsController.class })
public class Application {

    // silence console logging
    @Value("${logging.level.root:OFF}")
    String message = "";

    @RequestMapping(path = "/healthz", method = RequestMethod.GET)
    @ResponseBody
    public String healthCheck() {
        return "healthy";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}