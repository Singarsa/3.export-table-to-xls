package Service;

import Entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> getTheListStudent();
}