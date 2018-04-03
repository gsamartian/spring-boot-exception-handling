package com.example.springbootexceptionhandling;


//import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class MyCustomErrorController implements ErrorController {
  
    private static final String PATH = "/error";
     
    @RequestMapping(value=PATH)
    public ResponseEntity<Object> error() {
		 ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage("Resource Not found");
        return buildResponseEntity(apiError);
        //return "Error heaven";
    }
 
    @Override
    public String getErrorPath() {
        return PATH;
    }
	
	 private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}