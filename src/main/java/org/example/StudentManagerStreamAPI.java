package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentManagerStreamAPI {

    public Map.Entry<List<Student>, List<Student>> divideStudentByBenefits(List<Student> studentList) {

        Map<Boolean, List<Student>> partitioned = studentList.stream()
                .collect(Collectors.partitioningBy(student -> !student.getBenefits().isEmpty()));

        return new AbstractMap.SimpleEntry<>(partitioned.get(true), partitioned.get(false));
    }

    public Map<String, List<Student>> groupStudentsByDormitory(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getDormitory));
    }


    public Map<Integer, Long> findStudentCountInDormitoryRoom(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getRoomNumber, Collectors.counting()));
    }


    public Map.Entry<List<Student>, List<Student>> sortStudentByAgeAndSortByBenefit(List<Student> studentList) {
        List<Student> studentListSortedByAge = studentList.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());

        List<Student> studentListSortedByBenefit = studentList.stream()
                .sorted(Comparator.comparingInt(s -> s.getBenefits().size()))
                .collect(Collectors.toList());

        return Map.entry(studentListSortedByAge, studentListSortedByBenefit);
    }


    public List<Student> sortStudentByAgeAndBenefit(List<Student> studentList) {
        return studentList.stream()
                .sorted(Comparator.comparingInt(Student::getAge)
                        .thenComparingInt(s -> s.getBenefits().size()))
                .toList();
    }

    public List<Integer> writeUniqueRoomNumber(List<Student> studentList) {
        return studentList.stream()
                .map(Student::getRoomNumber)
                .distinct()
                .collect(Collectors.toList());
    }

    public Optional<Student> findStudentWhoPaysMost(List<Student> studentList) {
        return studentList.stream()
                .max(Comparator.comparingDouble(Student::getAccommodationFee));
    }

}
