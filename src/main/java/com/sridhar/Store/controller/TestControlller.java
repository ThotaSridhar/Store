package com.sridhar.Store.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControlller {


    @GetMapping("/getcsrftoken")
    public ResponseEntity<?> getToken(HttpServletRequest request){
        CsrfToken csrftoken = (CsrfToken) request.getAttribute("_csrf");
        return new ResponseEntity<>(csrftoken, HttpStatusCode.valueOf(200));
    }
}
