package com.example.exportExcel.exporter;

import com.example.exportExcel.model.Customer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileExporter {
    public static ByteArrayInputStream contactListToExcelFile(List<Customer> customers) {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Customers");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Untuk header
            Cell cell = row.createCell(0);
            cell.setCellValue("First Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Last Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Mobile");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Email");
            cell.setCellStyle(headerCellStyle);

            // Membuat baris data untuk tiap customer
            for(int i = 0; i < customers.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(customers.get(i).getFirstName());
                dataRow.createCell(1).setCellValue(customers.get(i).getLastName());
                dataRow.createCell(2).setCellValue(customers.get(i).getMobileNumber());
                dataRow.createCell(3).setCellValue(customers.get(i).getEmail());
            }

            // Membuat ukuran kolom auto
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
