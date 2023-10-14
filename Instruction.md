# Инструкция по запуску авто-тестов.

## Требуемые приложения для запуска.
- IDEA
- GIT
- NodeJS
- Docker
- Google Chrome браузер.

## Шаги для запуска
1. Создать Gradle проект в нужной вам папке
2. С помощью команды git init создать локальный репозиторий.
3. С помощью команды git clone клонировать удаленный репозиторий https://github.com/VeraAbramitskaya/QA_Diploma.
4. Запустить Docker Desktop.
5. Запустить контейнеры docker:
* Для работы с базой данных mysql выполнить команду:
  docker-compose -f docker-compose-mysql.yml up -d
  После прогона тестов остановить контейнеры:
  docker-compose -f docker-compose-mysql.yml down
* Для работы с базой данных postgres выполнить команду:
  docker-compose -f docker-compose-postgres.yml up -d
  После прогона тестов остановить контейнеры:
  docker-compose -f docker-compose-postgres.yml down
6. Запустить SUT:
* Для работы с базой данных mysql выполнить команду:
  java -jar artifacts/aqa-shop.jar
  После прогона тестов остановить контейнеры:
* Для работы с базой данных postgres выполнить команду:
  java -jar artifacts/aqa-shop.jar --spring.profiles.active=post
  После прогона тестов остановить контейнеры:
7. Проверить работоспособность SUT http://localhost:8080/
8. Запустить тесты:
    * Для работы с базой данных mysql с помощью команды
      ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
    * Для работы с базой данных postgres с помощью команды
      ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
9. После прогона тестов терминале IntelliJ IDEA остановить SUT
   CTRL+C


## Документация
- План тестирования https://github.com/VeraAbramitskaya/QA_Diploma/blob/main/Plan.md
- Проделанная работа
- Отчет