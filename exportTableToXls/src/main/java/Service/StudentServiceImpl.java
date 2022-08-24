package Service;

import Entity.Student;
import Repo.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepos studentRepo;

    @Override
    public void addStudent (Student student){
        studentRepo.save(student);
    }

    @Override
    public List<Student> getTheListStudent(){
        return studentRepo.findAll();
    }
}
