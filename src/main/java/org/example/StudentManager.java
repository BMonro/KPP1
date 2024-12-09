package org.example;
/*Виконайте наступні завдання:
        1.	Розділити студентів на тих, хто є пільговиками, і тих, хто не є.
        2.	Згрупувати студентів за гуртожитками.
        3.	Створити нову колекцію, в якій для кожної кімнати вказати кількість студентів, що там проживають.
        4.	Відсортувати студентів за віком та кількістю пільг.
        5.	Вивести список всіх унікальних номерів кімнат.
        6.	Знайти студента, який сплачує найбільшу плату за проживання, і обробити відсутність таких студентів через Optional.
*/

import java.util.*;

public class StudentManager {

    public Map.Entry<List<Student>, List<Student>> divideStudentByBenefits(List<Student> studentList) {
        List<Student> studentListWithBenefits = new ArrayList<>();
        List<Student> studentListWithoutBenefits = new ArrayList<>();

        for (Student student : studentList) {
            if (!student.getBenefits().isEmpty()) {
                studentListWithBenefits.add(student);
            } else {
                studentListWithoutBenefits.add(student);
            }
        }

        return Map.entry(studentListWithBenefits, studentListWithoutBenefits);
    }

    public Map<String, List<Student>> groupStudentsByDormitory(List<Student> studentList) {

        Set<String> dormitorySet = new HashSet<>();
        Map<String, List<Student>> studentsByDormitory = new HashMap<>();

        for (Student student : studentList) {
            dormitorySet.add(student.getDormitory());
        }

        for (String dormitory : dormitorySet) {
            List<Student> studentsInDormitory = new ArrayList<>();
            for (Student student : studentList) {
                if (dormitory.equals(student.getDormitory())) {
                    studentsInDormitory.add(student);
                }
                ;
            }
            studentsByDormitory.put(dormitory, studentsInDormitory);
        }
        return studentsByDormitory;
    }

    public Map<Integer, Integer> findStudentCountInDormitoryRoom(List<Student> studentList) {

        Set<Integer> roomSet = new HashSet<>();
        Map<Integer, Integer> studentCountByRoom = new HashMap<>();

        for (Student student : studentList) {
            roomSet.add(student.getRoomNumber());
        }

        for (Integer room : roomSet) {
            int size = 0;
            for (Student student : studentList) {
                if (room.equals(student.getRoomNumber())) {
                    size++;
                }
            }
            studentCountByRoom.put(room, size);
        }
        return studentCountByRoom;
    }

    public Map.Entry<List<Student>, List<Student>> sortStudentByAgeAndSortByBenefit(List<Student> studentList) {
        List<Student> studentListSortedByAge = new ArrayList<>(studentList);
        List<Student> studentListSortedByBenefit = new ArrayList<>(studentList);

        studentListSortedByAge.sort(Comparator.comparingInt(s -> s.getAge()));
        studentListSortedByBenefit.sort(Comparator.comparingInt(s -> s.getBenefits().size()));

        return Map.entry(studentListSortedByAge,studentListSortedByBenefit);
    }

    public List<Student> sortStudentByAgeAndBenefit(List<Student> studentList){
        studentList.sort(Comparator.comparingInt(s -> s.getAge()));
        studentList.sort(Comparator.comparingInt(s -> s.getBenefits().size()));

        return studentList;
    }


    public List<Integer> writeUniqueRoomNumber (List<Student> studentList){
        Set<Integer> uniqueRoomNumbers = new HashSet<>();

        for (Student student : studentList) {
            uniqueRoomNumbers.add(student.getRoomNumber());
        }
        return new ArrayList<>(uniqueRoomNumbers);
    }


    public Optional<Student> findStudentWhoPaysMost (List<Student> studentList){
        double maxValue = 0;
        for(Student student : studentList){
            if(student.getAccommodationFee() > maxValue){
                maxValue = student.getAccommodationFee();
            }
        }

        for(Student student : studentList){
            if(maxValue == student.getAccommodationFee()){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
}
