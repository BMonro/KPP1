package org.example;

import java.util.Collections;

/*Варіант 3: Управління студентськими гуртожитками
Опис: У вас є система обліку студентів, що проживають у гуртожитках.
Кожен студент має:
•	Ім'я (String)
•	Прізвище (String)
•	Гуртожиток (String)
•	Номер кімнати (int)
•	Плату за проживання (double)
•	Вік (int)
Деякі студенти є пільговиками, і мають право на знижку на проживання.
Виконайте наступні завдання:
1.	Розділити студентів на тих, хто є пільговиками, і тих, хто не є.
2.	Згрупувати студентів за гуртожитками.
3.	Створити нову колекцію, в якій для кожної кімнати вказати кількість студентів, що там проживають.
4.	Відсортувати студентів за віком та кількістю пільг.
5.	Вивести список всіх унікальних номерів кімнат.
6.	Знайти студента, який сплачує найбільшу плату за проживання, і обробити відсутність таких студентів через Optional.

*/
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "Dorm A", 101, 500, 20, Arrays.asList("Scholarship")));
        students.add(new Student("Jane", "Smith", "Dorm B", 202, 600, 22, Arrays.asList()));
        students.add(new Student("Alice", "Johnson", "Dorm A", 101, 400, 21, Arrays.asList("Sports")));
        students.add(new Student("Bob", "Brown", "Dorm C", 303, 700, 23, Arrays.asList("Scholarship", "Sports")));
        students.add(new Student("Charlie", "Davis", "Dorm B", 204, 550, 24, Arrays.asList()));

        // Створення об'єктів StudentManager і StudentManagerStreamAPI
        StudentManager studentManager = new StudentManager();
        StudentManagerStreamAPI studentManagerStreamAPI = new StudentManagerStreamAPI();

        Map.Entry<List<Student>, List<Student>> dividedStudents = studentManager.divideStudentByBenefits(students);
        System.out.println("---- StudentManager: Divide by benefits ----");
        System.out.println("Students with benefits:");
        dividedStudents.getKey().forEach(System.out::println);
        System.out.println("Students without benefits:");
        dividedStudents.getValue().forEach(System.out::println);

        Map.Entry<List<Student>, List<Student>> dividedStudentsStreamAPI = studentManagerStreamAPI.divideStudentByBenefits(students);
        System.out.println("---- StudentManagerStreamAPI: Divide by benefits ----");
        System.out.println("Students with benefits:");
        dividedStudentsStreamAPI.getKey().forEach(System.out::println);
        System.out.println("Students without benefits:");
        dividedStudentsStreamAPI.getValue().forEach(System.out::println);

        Map<String, List<Student>> studentsByDormitory = studentManagerStreamAPI.groupStudentsByDormitory(students);
        System.out.println("\n---- StudentManagerStreamAPI: Group by dormitory ----");
        studentsByDormitory.forEach((dorm, studentList) -> {
            System.out.println(dorm + ":");
            studentList.forEach(System.out::println);
        });

        Map<String, List<Student>> studentsByDormitoryStudentManager = studentManager.groupStudentsByDormitory(students);
        System.out.println("\n---- StudentManager: Group by dormitory ----");
        studentsByDormitoryStudentManager.forEach((dorm, studentList) -> {
            System.out.println(dorm + ":");
            studentList.forEach(System.out::println);
        });

        Map<Integer, Long> studentCountInRooms = studentManagerStreamAPI.findStudentCountInDormitoryRoom(students);
        System.out.println("\n---- StudentManagerStreamAPI: Student count by room ----");
        studentCountInRooms.forEach((room, count) -> System.out.println("Room " + room + ": " + count + " student(s)"));

        Map<Integer, Integer> studentCountInRoomsManager = studentManager.findStudentCountInDormitoryRoom(students);
        System.out.println("\n---- StudentManager: Student count by room ----");
        studentCountInRoomsManager.forEach((room, count) -> System.out.println("Room " + room + ": " + count + " student(s)"));

        List<Student> sortedStudents = studentManagerStreamAPI.sortStudentByAgeAndBenefit(students);
        System.out.println("\n---- StudentManagerStreamAPI: Sorted students by age and benefits ----");
        System.out.println("Students sorted by age and benefit:");
        sortedStudents.forEach(System.out::println);

        List<Student> sortedStudentsManager = studentManager.sortStudentByAgeAndBenefit(students);
        System.out.println("\n---- StudentManager: Sorted students by age and benefits ----");
        System.out.println("Students sorted by age and benefit:");
        sortedStudents.forEach(System.out::println);

        List<Integer> uniqueRoomNumbers = studentManagerStreamAPI.writeUniqueRoomNumber(students);
        System.out.println("\n---- StudentManagerStreamAPI: Unique room numbers ----");
        uniqueRoomNumbers.forEach(System.out::println);

        List<Integer> uniqueRoomNumbersManager = studentManager.writeUniqueRoomNumber(students);
        System.out.println("\n---- StudentManager: Unique room numbers ----");
        uniqueRoomNumbersManager.forEach(System.out::println);

        Optional<Student> studentWithMaxFee = studentManagerStreamAPI.findStudentWhoPaysMost(students);
        System.out.println("\n---- StudentManagerStreamAPI: Student who pays the most ----");
        studentWithMaxFee.ifPresent(System.out::println);

        Optional<Student> studentWithMaxFeeManager = studentManager.findStudentWhoPaysMost(students);
        System.out.println("\n---- StudentManager: Student who pays the most ----");
        studentWithMaxFeeManager.ifPresent(System.out::println);
    }
}
