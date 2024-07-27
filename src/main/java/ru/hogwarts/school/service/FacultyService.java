package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> facultyHashMap = new HashMap<Long, Faculty>();
    private long lastId = 0;

    //метод принимает в качестве аргумента факультет
    //его задача давать новый идентификатор добавленному  факультету
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        facultyHashMap.put(lastId, faculty);
        return faculty;
    }

    ;

    public Faculty findFaculty(long id) {
        return facultyHashMap.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        facultyHashMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return facultyHashMap.remove(id);
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyHashMap.values();
    }

    public List<Faculty> filterByColor(@RequestParam String color) {
        return facultyHashMap.values()
                .stream()
                .filter(it -> it.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
