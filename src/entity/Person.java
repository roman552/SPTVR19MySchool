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
public class Person {
    private String firstName;
    private String lastName;
    private Integer phone;
    private String role;
    
    public Person() {
    }

    public Person(String firstName, String lastName, Integer phone, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.role = role;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" 
                + "firstName=" + firstName 
                + ", lastName=" + lastName 
                + ", phone=" + phone 
                + ", role=" + role 
                + '}';
    }
    
    
}

