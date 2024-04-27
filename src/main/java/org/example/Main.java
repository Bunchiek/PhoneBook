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

        System.out.println("Добро пожаловать в контакты");

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning){
            System.out.println("""
                    Выберите необходимое действие:
                    1. Вывести все имеющиеся контакты
                    2. Добавить новый контакт в список контактов
                    3. Удалить контакт по email
                    4. Сохранить имеющиеся контакты в файл
                    5. Выход
                    """);
            int num = 0;
            if(scanner.hasNextInt()){
                num = scanner.nextInt();
                System.out.println("Спасибо! Вы ввели число " + num);
                scanner.nextLine();
            }else {
                System.out.println("Ошибка ввода попробуйте снова!");
                scanner.nextLine();
                continue;
            }
            switch (num){
                case 1-> printContact(contactsUser);
                case 2->addContact(contactsUser, scanner, context);
                case 3->deleteContactByEmail(contactsUser, scanner);
                case 4->saveToFile(contactsUser);
                case 5-> isRunning=false;
                default -> {
                    return;
                }
            }

        }

    }

    private static void saveToFile(ContactsUser contactsUser)  {
        List<String> list = contactsUser.getContacts().stream()
                .map(s->s.getFullName()+ ";" + s.getPhoneNumber()+";"+s.getEmail())
                .toList();

        FileWriter writer = null;
        try {
            writer = new FileWriter("src/main/resources/result.txt");
            for(String str: list) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteContactByEmail(ContactsUser contactsUser, Scanner scanner) {
        System.out.println("Введите адрес электронной почты контакта для удаления");
        String input = scanner.nextLine();
        Contact toDelete = null;
        for(Contact contact : contactsUser.getContacts()){
            if(contact.getEmail().equals(input)){
                toDelete = contact;
            }
        }
        if(toDelete==null){
            System.out.println("Контакт не найден");
        }else {
            contactsUser.getContacts().remove(toDelete);
        }

    }

    private static void printContact(ContactsUser contactsUser) {
        contactsUser.getContacts().forEach(s-> System.out.println(s.getFullName() + " | " + s.getPhoneNumber() + " | " + s.getEmail()));
    }

    private static void addContact(ContactsUser contactsUser, Scanner scanner, ApplicationContext context) {
        System.out.println("Введите новый контакт в формате «Ф. И. О;номер телефона;адрес электронной почты»");
        String input = scanner.nextLine();
        String[] strings = input.split(";");
        if(strings.length != 3){
            System.out.println("Ошибка ввода попробуйте снова!");
        } else {
            Contact contact = new Contact(strings[0].trim(),strings[1].trim(),strings[2].trim());
            contactsUser.getContacts().add(contact);
        }
    }
}