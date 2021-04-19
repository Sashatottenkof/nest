## Общие сведения

java 8

REST API выполнено на Spring Boot

формат JSON

## Установка

1)Скачать гит в рабочую папку

2)Открыть файл с помощью IDE

3)Локально запустить PostgreSQL и создать базу данных 

DB: NestAssignment

username:postgres

password:napoleon

либо поменять настройки для Базы данных в application.properties для своей DB
![application properties](https://github.com/Sashatottenkof/nest/blob/master/src/main/resources/static/images/application.properties.png)

## Запуск

При запуске таблицы в BD будут созданы автоматически



# Endpoints
Для гнезда:

POST
http://localhost:8080/nest/add -добавить новое гнездо

пример:
{
"name": "Новое Гнездо",
"address":"Москва"
}

GET
http://localhost:8080/nest/all - показать все гнёзда

DELETE
http://localhost:8080/nest/{idNest} - удалить гнездо

GET
http://localhost:8080/nest/{idNest} - показать конкретное гнездо


PUT
http://localhost:8080/nest/{idNest} - редактировать гнездо

пример:
{
"name": "Старок Гнездо",
"address":"Москва"
}

GET
http://localhost:8080/nest//allBirds/{idNest} - показать птиц в гнезде


Для птицы:

POST
http://localhost:8080/bird/add/{nestId} -добавить новую птицу 

пример:
{
"name": "Воробей",
"colour":"серый",
"canFly":"true"
}


GET
http://localhost:8080/bird/all - показать всех птиц

GET
http://localhost:8080/bird/{birdId} - показать конкретную птицу

PUT
http://localhost:8080/bird/113 - редактировать птицу

DELETE
http://localhost:8080/bird/{birdId} - удалить птицу
