package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                scanner.nextLine();
            }else {
                System.out.println("Ошибка ввода попробуйте снова!");
                scanner.nextLine();
                continue;
            }
            switch (num){
                case 1-> printContact(contactList);
                case 2->addContact(contactList, scanner, context);
                case 3->deleteContactByEmail(contactList, scanner);
                case 4->saveToFile(contactList);
                case 5-> isRunning=false;
                default -> {
                    return;
                }
            }

        }

    }

    private static void saveToFile(List<Contact> contactList) {
        List<String> list = contactList.stream()
                .map(s->s.getFullName()+ ";" + s.getPhoneNumber()+";"+s.getEmail())
                .toList();
        String FILE_NAME = "src/fileToCreate.txt";
        File file = new File(FILE_NAME);
        Path filePath = Paths.get(file.toURI());
        try {
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String str : list) {
            try {
                Files.writeString(filePath, str + System.lineSeparator(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void deleteContactByEmail(List<Contact> contactList, Scanner scanner) {
        System.out.println("Введите адресс электронной почты контакта для удаления");
        String input = scanner.nextLine();
        Contact toDelete = null;
        for(Contact contact : contactList){
            if(contact.getEmail().equals(input)){
                toDelete = contact;
            }
        }
        if(toDelete==null){
            System.out.println("Контакт не найден");
        }else {
            contactList.remove(toDelete);
        }
    }

    private static void printContact(List<Contact> contactList) {
        contactList.forEach(s-> System.out.println(s.getFullName().toString() + " | " + s.getPhoneNumber().toString() + " | " + s.getEmail().toString()));
    }

    private static void addContact(List<Contact> contactList, Scanner scanner, ApplicationContext context) {
        System.out.println("Введите новый контакт в формате «Ф. И. О;номер телефона;адрес электронной почты»");
        String input = scanner.nextLine();
        String[] strings = input.split(";");
        if(strings.length != 3){
            System.out.println("Ошибка ввода попробуйте снова!");
        } else {
            Contact contact = context.getBean(Contact.class);
            contact.setFullName(strings[0].trim());
            contact.setPhoneNumber(strings[1].trim());
            contact.setEmail(strings[2].trim());
            contactList.add(contact);
        }
    }
}