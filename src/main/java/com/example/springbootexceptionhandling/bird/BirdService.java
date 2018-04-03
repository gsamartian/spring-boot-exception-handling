package com.example.springbootexceptionhandling.bird;

import com.example.springbootexceptionhandling.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    public Bird getBirdNoException(String birdId) throws EntityNotFoundException {
        return null;//birdRepository.findByScientificName(birdId);
    }

    public Bird getBird(String birdId) throws EntityNotFoundException {
        Bird bird = null;//birdRepository.findByScientificName(birdId);
        if(bird == null){
            throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
        }
        return bird;
    }

    public Bird createBird(Bird bird) {
        return birdRepository.save(bird);
    }
}
