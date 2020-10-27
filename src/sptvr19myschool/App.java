/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19myschool;

import entity.Journal;
import entity.Person;
import entity.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tools.manager.JournalManager;
import tools.manager.PersonManager;
import tools.manager.SubjectManager;
import tools.savers.SaveToFile;

/**
 *
 * @author sillamae kutsekool
 */
class App {
    private Scanner scanner = new Scanner(System.in);
    
    private  List<Person> listPersons = new ArrayList<>(); 
    private  List<Subject> listSubjects = new ArrayList<>(); 
    private  List<Journal> listJournals = new ArrayList<>(); 
    
    private PersonManager personManager = new PersonManager();
    private SubjectManager subjectManager = new SubjectManager();

    public App() {
        SaveToFile saveToFile = new SaveToFile();
        this.listPersons = saveToFile.loadFromFile("listPersons");
        this.listSubjects = saveToFile.loadFromFile("listSubjects");
    }
    
    public void run(){
        System.out.println("--- Моя школа ---");
        boolean repeat = true;
        do{
            System.out.println("Задачи:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить ученика");
            System.out.println("2. Список учеников");
            System.out.println("3. Добавить учителя");
            System.out.println("4. Список учителей");
            System.out.println("5. Добавить предмет");
            System.out.println("6. Список предметов");
            System.out.println("7. Выставить оценку");
            System.out.println("8. Оценки ученика");
            System.out.println("9. Оценки по предмету");
            System.out.println("10. Изменить оценку");
            System.out.println("Выберите задачу:");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case "1":
                    Person student = personManager.createPerson("STUDENT");
                    personManager.addPersonToList(student, listPersons);
                    
                    break;
                case "2":
                    personManager.printListStudents(listPersons);
                    break;
                case "3":
                    Person teacher = personManager.createPerson("TEACHER");
                    personManager.addPersonToList(teacher, listPersons);
                    break;
                case "4":
                    personManager.printListTeachers(listPersons);
                    break;
                case "5":
                    Subject subject = subjectManager.createSubject(listPersons);
                    subjectManager.addSubjectToList(subject, listSubjects);
                    break;
                case "6":
                    subjectManager.printlistSubjects(listSubjects);
                    break;
                case "7":
                    JournalManager journalManager = new JournalManager();
                    journalManager.setMarkToUser(listSubjects, listPersons, listJournals);
                    break;
                case "8":
                    
                    break;
                case "9":
                    
                    break;
                case "10":
                    
                    break;
                default:
                    System.out.println("Нет такой задачи. Выберите из списка.");;
            }
        }while(repeat);
    }
}