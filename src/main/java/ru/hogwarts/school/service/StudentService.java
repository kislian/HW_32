package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final HashMap<Long, Student> studentHashMap = new HashMap<Long, Student>();

    private long lastId = 0;

    //метод принимает в качестве аргумента факультет
    //его задача давать новый идентификатор добавленному  факультету
    public Student createStudent(Student student) {
        student.setId(++lastId);
        studentHashMap.put(lastId, student);
        return student;
    }

    ;

    public Student findStudent(long id) {
        return studentHashMap.get(id);
    }

    public Student editStudent(Student student) {
        studentHashMap.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return studentHashMap.remove(id);
    }

    public Collection<Student> getAllStudents() {
        return studentHashMap.values();
    }

    public List<Student> filterByAge(@RequestParam int age) {
        return studentHashMap.values()
                .stream()
                .filter(it -> it.getAge() == age)
                .collect(Collectors.toList());
    }
}