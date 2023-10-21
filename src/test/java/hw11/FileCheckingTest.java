package hw11;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import models.GlossDiv;
import models.GlossaryObject;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class FileCheckingTest {
    private final ClassLoader cl = FileCheckingTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void zipTest() throws Exception {
        try (InputStream inputStream = cl.getResourceAsStream("zip.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().contains("pdf")) {
                    PDF pdf = new PDF(zipInputStream);
                    assertEquals("Nevrona Designs", pdf.producer);
                } else if (zipEntry.getName().contains("csv")) {
                    CSVReader csv = new CSVReader(new InputStreamReader(zipInputStream));
                    List<String[]> content = csv.readAll();
                    assertEquals(4, content.size());
                    String[] firstRow = content.get(0);
                    assertArrayEquals(new String[]{"Name", "Job Title", "Address", "State", "City"}, firstRow);
                } else if (zipEntry.getName().contains("xlsx")) {
                    XLS xls = new XLS(zipInputStream);
                    assertEquals("January", xls.excel.getSheetAt(0).getRow(1).getCell(1).toString());
                } else System.out.println("wrong file format");
            }
        }
    }

    @Test
    void jsonTest() throws Exception {
        try (InputStream inputStream = cl.getResourceAsStream("glossary.json");
             Reader reader = new InputStreamReader(inputStream)) {
            GlossaryObject glossary = objectMapper.readValue(reader, GlossaryObject.class);
            GlossDiv[] glossDiv = glossary.getGlossDiv();

            assertArrayEquals(new String[]{"GML",
                    "XML"}, glossDiv[0].getGlossSeeAlso().toArray());
        }
    }
}
