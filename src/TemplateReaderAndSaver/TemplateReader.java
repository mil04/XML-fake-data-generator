package TemplateReaderAndSaver;

import TemplateTags.Workers;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

public class TemplateReader {
    private Workers workers;
    public TemplateReader(String pathToTemplate) {
        try {
            File file = new File(pathToTemplate);
            if (!file.exists()) {
                throw new FileNotFoundException("Template file not found: " + pathToTemplate);
            }
            JAXBContext jAXBContext = JAXBContext.newInstance(Workers.class);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            this.workers = (Workers) unmarshaller.unmarshal(file);
        } catch (FileNotFoundException e) {
            String errorMessage = "Error: FileNotFoundException. Check your path to the template file:\n" + pathToTemplate;
            JOptionPane.showMessageDialog(null, errorMessage, "File Not Found", JOptionPane.INFORMATION_MESSAGE);
        } catch (JAXBException e) {
            String errorMessage = "Error: JAXBException. Check the structure of your template file.";
            Throwable cause = e.getCause();
            if (cause != null) {
                errorMessage += "\nCaused by: " + cause.getMessage();
            }
            JOptionPane.showMessageDialog(null, errorMessage, "JAXBException", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            String errorMessage = "Unexpected error";
            JOptionPane.showMessageDialog(null, errorMessage, "Unexpected Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Workers getWorkers() {
        return workers;
    }
    public String getWorkersString() {
        if (this.workers == null) {
            return "";
        }
        return this.workers.toString();
    }
}