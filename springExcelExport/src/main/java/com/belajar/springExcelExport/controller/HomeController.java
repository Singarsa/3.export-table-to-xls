package com.belajar.springExcelExport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belajar.springExcelExport.excel.UserExcelExporter;
import com.belajar.springExcelExport.model.Student;
import com.belajar.springExcelExport.repository.StudentRepository;

@Controller
@RequestMapping("/web")
public class HomeController {
	@RequestMapping("/home")
	public String homePage() {
		return "HomePage";
	}

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Student_info.xlsx";

		response.setHeader(headerKey, headervalue);
		List<Student> listStudent = studentRepo.findAll();
		UserExcelExporter exp = new UserExcelExporter(listStudent);
		exp.export(response);

	}

}
