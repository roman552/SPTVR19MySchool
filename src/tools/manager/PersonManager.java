/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import tools.savers.SaveToFile;
import entity.Person;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class PersonManager {
    private Scanner scanner = new Scanner(System.in);
    public Person createPerson(String role) {
        System.out.println("---Добавление ученика---");
        System.out.println("Имя ученика: ");
        String firstname = scanner.nextLine();
        System.out.println("Фамилия ученика: ");
        String lastname = scanner.nextLine();
        System.out.println("Телефон: ");
        String phone = scanner.nextLine();
        Person person = new Person(firstname, lastname, phone, role);
        return person;
    }

    public void addPersonToList(Person student, List<Person> listPersons) {
        listPersons.add(student);
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listPersons, "listPersons");
    }

    public void printListStudents(List<Person> listPersons) {
        System.out.println("---Список учеников---");
        for (int i = 0; i < listPersons.size(); i++) {
            Person person = listPersons.get(i);
            if("STUDENT".equals(person.getRole())){
                System.out.printf("%d. %s %s%n"
                        ,i+1
                        ,person.getFirstName()
                        ,person.getLastName()
                        
                );
            }
        }
    }
    public void printListTeachers(List<Person> listPersons) {
        System.out.println("---Список учителей---");
        for (int i = 0; i < listPersons.size(); i++) {
            Person person = listPersons.get(i);
            if("TEACHER".equals(person.getRole())){
                System.out.printf("%d. %s %s%n"
                        ,i+1
                        ,person.getFirstName()
                        ,person.getLastName()
                        
                );
            }
        }
    }
}
