package org.vrtkarim.authenticationwithapikey.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/first")
    ResponseEntity<String>  first(){
        return new ResponseEntity<>("authenticated", HttpStatus.ACCEPTED);
    }
}
