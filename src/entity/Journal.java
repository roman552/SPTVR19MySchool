/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;



/**
 *
 * @author user
 */
public class Journal {
    private String student;
    private String subject;
    private Integer mark;
    private String date;
    
    public Journal(){
    }

    public Journal(String person, String subject, Integer mark, String date) {
        this.student = person;
        this.subject = subject;
        this.mark = mark;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String dateStr = sdf.format(date);
        return "Journal{" 
                + "student=" + student
                +" " + student
                + ", subject=" + subject
                + ", mark=" + mark 
                + ", date=" + dateStr 
                + '}';
    }
    
    
}
