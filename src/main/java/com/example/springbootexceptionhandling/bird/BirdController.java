package com.example.springbootexceptionhandling.bird;

import com.example.springbootexceptionhandling.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.springbootexceptionhandling.ServiceException;
import javax.validation.Valid;

@RestController
@RequestMapping("/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    @GetMapping(value = "/{birdId}")
    public Bird getBird(@PathVariable("birdId") String birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }
	
	@GetMapping(value = "/getme/{birdId}")
    public Bird getmeBird(@PathVariable("birdId") String birdId) throws Exception {
        throw new ServiceException("one","not foudn mand");
    }
	
	@GetMapping(value = "/compute/{birdId}")
    public Bird compute(@PathVariable("birdId") String birdId) throws EntityNotFoundException {
		try {
		long x=25/0;
		}catch(ArithmeticException e){
				throw new  ArithmeticException("Error: Don't divide a number by zero");
		}
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/params")
    public Bird getBirdRequestParam(@RequestParam("birdId") String birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/noexception/{birdId}")
    public Bird getBirdNoException(@PathVariable("birdId") String birdId) throws EntityNotFoundException {
        return birdService.getBirdNoException(birdId);
    }



    @PostMapping
    public Bird createBird(@RequestBody @Valid Bird bird){
        return birdService.createBird(bird);
    }

}
