package TemplateReaderAndSaver;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TemplateSaver {
    private static final String EXTENDED_TEMPLATES_PATH = "src/Templates/TemplatesExpanded";

    public static void saveTemplate(String xmlTemplateExpanded) {
        File file = new File(EXTENDED_TEMPLATES_PATH + "/expandedTemplate.xml");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(xmlTemplateExpanded);
            fileWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: IOException. Check the saving path.", "IOException", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}