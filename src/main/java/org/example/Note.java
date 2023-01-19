package org.example;

public class Note {
    String name;
    float number;
    public Note(String name, float number){
        this.name = name;
        this.number = number;
    }

    public float getNote() {
        return number;
    }
    public String getName() {
        return name;
    }
}
