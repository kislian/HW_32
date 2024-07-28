package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Faculty;

import java.util.*;
//import java.util.stream.Collectors;

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

    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : facultyHashMap.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}
