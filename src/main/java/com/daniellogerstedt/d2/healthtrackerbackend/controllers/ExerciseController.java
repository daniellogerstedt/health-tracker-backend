package com.daniellogerstedt.d2.healthtrackerbackend.controllers;

import com.daniellogerstedt.d2.healthtrackerbackend.entities.Exercise;
import com.daniellogerstedt.d2.healthtrackerbackend.repositories.ExerciseRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepo;

    @GetMapping("/exercises")
    public Iterable<Exercise> getExercises () {
        return exerciseRepo.findAll();
    }

    @GetMapping("/exercises/${id}")
    public Exercise getExercise (@PathVariable long id) {
        Optional exerciseOptional = exerciseRepo.findById(id);
        if (exerciseOptional.isPresent()) return (Exercise) exerciseOptional.get();
        else return null;
    }

    @PostMapping("/exercises/many")
    public void postExercises (@RequestParam String exercisesJson) {
        Gson gson = new Gson();
        Exercise[] exercises = gson.fromJson(exercisesJson, Exercise[].class);
        for (Exercise exercise : exercises) {
            exerciseRepo.save(exercise);
        }
    }

    @PostMapping("/exercises")
    public void postExercise (@RequestParam String exerciseJson) {
        Gson gson = new Gson();
        Exercise exercise = gson.fromJson(exerciseJson, Exercise.class);
        exerciseRepo.save(exercise);

    }
}
