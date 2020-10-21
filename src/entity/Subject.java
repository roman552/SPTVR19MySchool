/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author user
 */
public class Subject {
    private String name;
    private String duration;
    private String teacher;
    
    public Subject(){
    }

    public Subject(String name, String duration, String teacher) {
        this.name = name;
        this.duration = duration;
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Subject{" 
                + "name=" + name 
                + ", duration=" + duration 
                + ", teacher=" + teacher
                + " " + teacher
                + '}';
    }
    
    
}
