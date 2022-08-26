package com.example.exportExcel.controller;

import com.example.exportExcel.exporter.ExcelFileExporter;
import com.example.exportExcel.model.Customer;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DownloadExcelController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/download/customers.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");
        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(createTestData());
        IOUtils.copy(stream, response.getOutputStream());
    }

    private List<Customer> createTestData(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("Agus", "Luffy", "086183927345", "test1@gmai.com"));
        customers.add(new Customer("Budi", "Zoro", "089738647382", "test2@gmai.com"));
        customers.add(new Customer("Tarno", "Sanji", "082749364823", "test3@gmai.com"));
        customers.add(new Customer("Krisha", "Nami", "085372892019", "test4@gmai.com"));
        customers.add(new Customer("Andre", "Yamato", "083648938920", "test5@gmai.com"));
        return customers;
    }
}
