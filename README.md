# Приложение "Контакты"

## Описание
Приложение "Контакты" представляет собой простое консольное приложение для управления списком контактов. Оно позволяет пользователям хранить, просматривать, редактировать и удалять контактные данные.

## Технологии
- Язык: Java
- Библиотека: spring-context

## Особенности
- Добавление контактов: Пользователи могут легко добавлять новые контакты, указывая имя, номер телефона, адрес электронной почты.
- Просмотр: Пользователи могут просматривать контактные данные в виде списка.
- Поиск: Приложение предоставляет возможность быстрого поиска контактов по имени, номеру телефона или адресу электронной почты.
- Удаление: Пользователи могут удалять контакт по адресу электронной почты
- Удобный интерфейс: Интуитивно понятный пользовательский интерфейс делает использование приложения простым и удобным.
- Возможность запуска приложения с разными профилями 

## Установка
1. Скачайте репозиторий: `git clone https://github.com/Bunchiek/PhoneBook.git`
2. Перейдите в файл конфигурации проекта: `src/main/resources
   /application.properties`
3. Установите необходимую конфигурацию: `init` или `user`
    * `init`- конфигурация по умолчанию, приложение при запуске 
        автоматически загрузит все контакты из файла `default-contacts.txt`. 
        Предварительно заполните файл контактами в формате `Смирнов Иван Иванович;+890999991;someEmail2@example.example`
    * `user` - приложение запуститься с пустым списком контактов 
4. Сохраненные контакты появятся в файле `Result.txt`

## Использование
1. Запустить приложение 
2. Следовать инструкциям в консоли


