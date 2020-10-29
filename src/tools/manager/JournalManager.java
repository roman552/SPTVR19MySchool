/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Journal;
import entity.Person;
import entity.Subject;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.interfaces.Saveable;
import tools.savers.SaveToFile;

/**
 *
 * @author user
 */
public class JournalManager implements Serializable{
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
    public void setMarkToUser(List<Subject> listSubjects,List<Person> listStudents, List<Journal> listJournals){
        System.out.println("--- Выставить оценку ---");
        System.out.println("Список предметов: ");
        for (int i = 0; i < listSubjects.size(); i++) {
            Subject subject = listSubjects.get(i);
            System.out.printf("%d. %s. Часов: %d Преподаватель: %s %s%n"
                    ,i+1
                    ,subject.getName()
                    ,subject.getDuration()
                    ,subject.getTeacher().getFirstname()
                    ,subject.getTeacher().getLastname()
            );
        }
        System.out.print("Выбрать предмет: ");
        int[] range = new int[]{0,listSubjects.size()};
        int numSubject=getNumInRange("Выберите номер предмета: ", range);
        Subject subject = listSubjects.get(numSubject-1);
        System.out.println("Список учеников:");
        for (int i = 0; i < listStudents.size(); i++) {
            Person person = listStudents.get(i);
            Journal journal = getOneJournal(person, subject, listJournals);
            String dateStr = "";
            if(journal.getDate() != null){
                dateStr = sdf.format(journal.getDate());
            }
            if("STUDENT".equals(person.getRole())){
                System.out.printf("%d. %s %s, оценка по предмету: %s - %d, дата: %s%n"
                        ,i+1
                        ,person.getFirstname()
                        ,person.getLastname()
                        ,subject.getName()
                        ,journal.getMark()
                        ,dateStr
                );
            }
        }
        System.out.print("Выбрать ученика: ");
        range = new int[]{0,listStudents.size()};
        int numStudent= getNumInRange("Выберите номер студента: ", range);
        Person student = listStudents.get(numStudent-1);
        range = new int[]{0,5};
        System.out.print("Оценка: ");
        int mark = getNumInRange("Выберите оценку от 1 до 5: ", range);
        Calendar c = new GregorianCalendar();
        Journal newOrUpdateJournal = getOneJournal(student, subject, listJournals);
        
        if(newOrUpdateJournal.getMark()== null){
            newOrUpdateJournal.setSubject(subject);
            newOrUpdateJournal.setStudent(student);
            newOrUpdateJournal.setMark(mark);
            newOrUpdateJournal.setDate(c.getTime());
        }else{
            int index = -1;
            for (int i = 0; i < listJournals.size(); i++) {
                Journal journ = listJournals.get(i);
                if(journ.equals(newOrUpdateJournal)){
                    index = i;
                    break;
                }
            }
            listJournals.get(index).setMark(mark);
            listJournals.get(index).setDate(c.getTime());
        }
        listJournals.add(newOrUpdateJournal);
        Saveable saveable = new SaveToFile();
        saveable.saveToFile(listJournals, "listJournals");
        
    }

    private Journal getOneJournal(Person person, Subject subject, List<Journal> listJournals) {
        for (int i = 0; i < listJournals.size(); i++) {
            Journal journal = listJournals.get(i);
            if(person.equals(journal.getStudent())
                && subject.equals(journal.getSubject())){
                return journal;
            }
        }
        return new Journal();
    }
    
    private int getNumInRange(String text, int[] range){
        int num=-1;
        do{
            String numStr = scanner.nextLine();
            try {
                num = Integer.parseInt(numStr);
                if(num > range[0] && num <= range[1]){
                    return num;
                }else{
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(text);
            }
        }while(true);
    }

    public void printMarks(List<Person> listStudents, List<Journal> listJournals) {
        System.out.println("---Оценки ученика---");
        System.out.println("Список учеников: ");
        for (int i = 0; i < listStudents.size(); i++) {
            Person person = listStudents.get(i);
            
            if("STUDENT".equals(person.getRole())){
                System.out.printf("%d. %s %s %n" 
                        ,i+1
                        ,person.getFirstname()
                        ,person.getLastname()
                );
            }
        }
        System.out.println(listJournals.size());
        System.out.println("Введите номер ученика: ");
        int numStudent = scanner.nextInt();
        Person student = listStudents.get(numStudent-1);
        for (int i = 0; i < listJournals.size(); i++) {
            Journal journal = listJournals.get(i);
            if(student.equals(journal.getStudent())){
                System.out.printf("оценка по предмету: %s - %d %n"
                    ,journal.getSubject()
                    ,journal.getMark()
                );   
            }  
        }
    }
}