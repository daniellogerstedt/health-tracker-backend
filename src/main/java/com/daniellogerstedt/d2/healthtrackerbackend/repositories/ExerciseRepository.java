package com.daniellogerstedt.d2.healthtrackerbackend.repositories;

import com.daniellogerstedt.d2.healthtrackerbackend.entities.Exercise;
import org.springframework.data.repository.CrudRepository;


public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
