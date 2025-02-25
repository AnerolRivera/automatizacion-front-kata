package com.orange.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Excel {

    private static XSSFWorkbook libro;
    private static FileInputStream file;

    public static String leerDatosExcel(String ruta, String hoja, int rowValue, int cellValue) {
        String valor = null; // Inicializa el valor como null
        try {
            file = new FileInputStream(new File(ruta));
            libro = (XSSFWorkbook) WorkbookFactory.create(file);
            Sheet sheet = libro.getSheet(hoja);
            Row row = sheet.getRow(rowValue);

            if (row != null) { // Verifica si la fila no es nula
                Cell cell = row.getCell(cellValue);
                if (cell != null) { // Verifica si la celda no es nula
                    switch (cell.getCellType()) {
                        case STRING:
                            valor = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            valor = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            valor = String.valueOf(cell.getBooleanCellValue());
                            break;
                        default:
                            valor = ""; // Puedes manejar otros tipos de celda según sea necesario
                    }
                }
            }
            libro.close();
            file.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return valor != null ? valor : ""; // Retorna un string vacío si el valor es nulo
    }
}