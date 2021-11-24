package com.christianvilca.proyecto1.christian.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping // Acepta todas las solicitudes dentro del metodo a nivel http
    @ResponseBody // Responder un cuerpo a nivel del servicio
    public ResponseEntity<String> holaMundo() {
        return new ResponseEntity<>("Hello from controller", HttpStatus.OK);
    }

}
