package org.example;

import org.example.config.DefaultAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);


        ContactsUser contactsUser = context.getBean(ContactsUser.class);

        System.out.println(contactsUser.getContacts());



//        context.getBean(Contact.class);
//
//        ContactsInit contactsInit = context.getBean(ContactsInit.class);
//
//        System.out.println("Добро пожаловать в контакты");
//        Scanner scanner = new Scanner(System.in);
//        boolean isRunning = true;
//
//        while (isRunning){
//            System.out.println("""
//                    Выберите необходимое действие:
//                    1. Вывести все имеющиеся контакты
//                    2. Добавлять новый контакт в список контактов
//                    3. Удалять контакт по email
//                    4. Сохранять имеющиеся контакты в файл в формате
//                    5. Выход
//                    """);
//            int num = 0;
//            if(scanner.hasNextInt()){
//                num = scanner.nextInt();
//                System.out.println("Спасибо! Вы ввели число " + num);
//                scanner.nextLine();
//            }else {
//                System.out.println("Ошибка ввода попробуйте снова!");
//                scanner.nextLine();
//                continue;
//            }
//            switch (num){
//                case 1-> printContact(contactsInit);
//                case 2->addContact(contactsInit, scanner, context);
//                case 3->deleteContactByEmail(contactsInit, scanner);
//                case 4->saveToFile(contactsInit);
//                case 5-> isRunning=false;
//                default -> {
//                    return;
//                }
//            }
//
//        }

    }

//    private static void saveToFile(ContactsInit contactsInit)  {
//        List<String> list = contactsInit.getContacts().stream()
//                .map(s->s.getFullName()+ ";" + s.getPhoneNumber()+";"+s.getEmail())
//                .toList();
//
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter("output.txt");
//            for(String str: list) {
//                writer.write(str + System.lineSeparator());
//            }
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void deleteContactByEmail(ContactsInit contactsInit, Scanner scanner) {
//        System.out.println("Введите адресс электронной почты контакта для удаления");
//        String input = scanner.nextLine();
//        Contact toDelete = null;
//        for(Contact contact : contactsInit.getContacts()){
//            if(contact.getEmail().equals(input)){
//                toDelete = contact;
//            }
//        }
//        if(toDelete==null){
//            System.out.println("Контакт не найден");
//        }else {
//            contactsInit.getContacts().remove(toDelete);
//        }
//
//    }
//
//    private static void printContact(ContactsInit contactsInit) {
//        contactsInit.getContacts().forEach(s-> System.out.println(s.getFullName() + " | " + s.getPhoneNumber() + " | " + s.getEmail()));
//    }
//
//    private static void addContact(ContactsInit contactsInit, Scanner scanner, ApplicationContext context) {
//        System.out.println("Введите новый контакт в формате «Ф. И. О;номер телефона;адрес электронной почты»");
//        String input = scanner.nextLine();
//        String[] strings = input.split(";");
//        if(strings.length != 3){
//            System.out.println("Ошибка ввода попробуйте снова!");
//        } else {
//            Contact contact = context.getBean(Contact.class);
//            contact.setFullName(strings[0].trim());
//            contact.setPhoneNumber(strings[1].trim());
//            contact.setEmail(strings[2].trim());
//            contactsInit.getContacts().add(contact);
//        }
//    }
}