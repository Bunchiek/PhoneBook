package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(Contact.class);

        List<Contact> contactList = new ArrayList<>();

        System.out.println("Добро пожаловать в контакты");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning){
            System.out.println("""
                    Выберите необходимое действие:
                    1. Вывести все имеющиеся контакты
                    2. Добавлять новый контакт в список контактов
                    3. Удалять контакт по email
                    4. Сохранять имеющиеся контакты в файл в формате
                    5. Выход
                    """);
            int num = 0;
            if(scanner.hasNextInt()){
                num = scanner.nextInt();
                System.out.println("Спасибо! Вы ввели число " + num);
            }else {
                System.out.println("Ошибка ввода попробуйте снова!");
                continue;
            }
            switch (num){
                case 1-> printContact(contactList);
                case 2->addContact(contactList, scanner, context);
                case 3->deleteContactByEmail(contactList);
                case 4->saveToFile(contactList);
                case 5-> isRunning=false;
                default -> {
                    return;
                }
            }

        }

    }

    private static void saveToFile(List<Contact> contactList) {
    }

    private static void deleteContactByEmail(List<Contact> contactList) {
    }

    private static void printContact(List<Contact> contactList) {
        contactList.forEach(s-> System.out.println(s.getFullName() + " | " + s.getPhoneNumber() + " | " + s.getEmail()));
    }

    private static void addContact(List<Contact> contactList, Scanner scanner, ApplicationContext context) {
        System.out.println("Введите новый контакт в формате «Ф. И. О;номер телефона;адрес электронной почты»");
        String input = scanner.next();
        String[] strings = input.split(";");
        Contact contact = context.getBean(Contact.class);
        contact.setFullName(new FullName().setFullName(strings[0]));
        contact.setPhoneNumber(new PhoneNumber().setNumber(strings[1]));
        contact.setEmail(new Email().setEmail(strings[2]));
        contactList.add(contact);
    }

}