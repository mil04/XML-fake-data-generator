package TemplateTags;

import GeneratingFunctions.*;

import javax.swing.*;

public class ExtendedPersonalDataGeneratorTag {
    private int wrongTagMessage = 0;
    public String generateTag(String action) {
        if (action == null && wrongTagMessage == 0) {
            wrongTagMessage++;
            JOptionPane.showMessageDialog(null, "Error: check your template structure " +
                    "(Tags <PersonalDataGenerator>)", "Tag <PersonalDataGenerator> error", JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
        if (action == null) {
            return "";
        }
        if (action.equals("NAME")) {
            return "<PersonalDataGenerator Action=\"NAME\">" + NameGenerator.generateName() + "</PersonalDataGenerator>\n";
        }
        if (action.equals("FEMALE_NAME")) {
            return "<PersonalDataGenerator Action=\"FEMALE_NAME\">" + NameGenerator.generateFemaleName() + "</PersonalDataGenerator>\n";
        }
        if (action.equals("MALE_NAME")) {
            return "<PersonalDataGenerator Action=\"MALE_NAME\">" + NameGenerator.generateMaleName() + "</PersonalDataGenerator>\n";
        }
        if (action.equals("SURNAME")) {
            return "<PersonalDataGenerator Action=\"SURNAME\">" + SurnameGenerator.generateSurname() + "</PersonalDataGenerator>\n";
        }
        if (action.equals("LOCATION")) {
            return "<PersonalDataGenerator Action=\"LOCATION\">" + LocationGenerator.generateLocation() + "</PersonalDataGenerator>\n";
        }
        if (action.equals("AGE")) {
            return "<PersonalDataGenerator Action=\"AGE\">" + AgeGenerator.generateAge(0, 100) + "</PersonalDataGenerator>\n";
        }
        if(action.equals("PROFESSION")){
            return "<PersonalDataGenerator Action=\"PROFESSION\">" + ProfessionGenerator.generateProfession() + "</PersonalDataGenerator>\n";
        }
        if (wrongTagMessage == 0) {
            JOptionPane.showMessageDialog(null, "Error: Unknown Action =" + action +" In expanded template Tag with such action will be omitted", "Warning: Unknown Action", JOptionPane.INFORMATION_MESSAGE);
            wrongTagMessage++;
        }
        return "";
    }
}