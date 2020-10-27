/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Person;
import entity.Subject;
import java.util.List;
import java.util.Scanner;
import tools.savers.SaveToFile;

/**
 *
 * @author sillamae kutsekool
 */
public class SubjectManager {
    private Scanner scanner = new Scanner(System.in);
    public Subject createSubject(List<Person> listPersons) {
        System.out.println("--- Добавление предмета ---");
        System.out.print("Имя предмета: ");
        String name = scanner.nextLine();
        System.out.print("Количество часов: ");
        int duration;
        do{
            String durationStr = scanner.nextLine();
            try {
                duration = Integer.parseInt(durationStr);
                break;
            } catch (Exception e) {
                System.out.println("Введите количество часов (только цифры):");
            }
            
        }while(true);
        PersonManager personManager = new PersonManager();
        int numTeacher;
        do{
            personManager.printListTeachers(listPersons);
            System.out.println("Введите номер учителя: ");
            String numTeacherStr = scanner.nextLine();
            try {
               numTeacher = Integer.parseInt(numTeacherStr);
               break;
            } catch (Exception e) {
                System.out.println("Введите число из списка.");
            }
        }while(true);
        Subject subject = new Subject(name, duration, listPersons.get(numTeacher-1));
        return subject;
    }

    public void addSubjectToList(Subject subject, List<Subject> listSubjects) {
        listSubjects.add(subject);   
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listSubjects, "listSubjects");
    }

    public void printlistSubjects(List<Subject> listSubjects) {
        System.out.println("--- Список предметов ---");
        for (int i = 0; i < listSubjects.size(); i++) {
            Subject subject = listSubjects.get(i);
            System.out.printf("%d.  %s. %s часов. Перподаватель: %s %s%n"
                    ,i+1
                    ,subject.getName()
                    ,subject.getDuration()
                    ,subject.getTeacher().getFirstname()
                    ,subject.getTeacher().getLastname()
            );
        }
    }
    
}