package com.belajar.springExcelExport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.springExcelExport.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
