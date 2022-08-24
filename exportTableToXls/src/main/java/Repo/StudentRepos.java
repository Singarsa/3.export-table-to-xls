package Repo;

import Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepos extends JpaRepository <Student, Long > {

}
