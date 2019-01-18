package com.daniellogerstedt.d2.healthtrackerbackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exerciseId;
    private String title;
    private int quantity;
    private String description;
    private long timestamp;

    public Exercise () {}

    public Exercise (String title, int quantity, String description) {
        this.title = title;
        this.quantity = quantity;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
    }

    public long getExerciseId () {return this.exerciseId;}
    public String getTitle () {return this.title;}
    public int getQuantity () {return this.quantity;}
    public String getDescription () {return this.description;}
    public long getTimestamp () {return this.timestamp;}

    public void setExerciseId (long id) {this.exerciseId = id;}
    public void setTitle (String title) {this.title = title;}
    public void setQuantity (int quantity) {this.quantity =  quantity;}
    public void setDescription (String description) {this.description = description;}
    public void setTimestamp (long timestamp) {this.timestamp = timestamp;}

    public String toString() {
        return "Exercise Name: " + this.title + "\nExercise Description " + this.description + "\nNumber Completed: " + this.quantity;
    }

}
