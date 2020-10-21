/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19myschool;

import java.util.Scanner;

/**
 *
 * @author user
 */
class App {
    private Scanner scanner = new Scanner(System.in);
    public void run() {
        System.out.println("---Моя школа---");
        boolean repeat = true;
        do{
            System.out.println("Задачи:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить ученика");
            System.out.println("2. Список учеников");
            System.out.println("3. Добавить учителя");
            System.out.println("4. Список учителей");
            System.out.println("5. Добавить премет");
            System.out.println("6. Список предметов");
            System.out.println("7. Выставить оценку");
            System.out.println("8. Оценки ученика");
            System.out.println("9. Оценки по предмету");
            System.out.println("10. Изменить оценку");
            System.out.println("Выберите задачу: ");
            String task = scanner.nextLine();
            switch(task){
                case "0":
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
                default:
                    System.out.println("Нет такой задачи, выберите из списка");
            }
        }while(repeat);
    }
    
}
