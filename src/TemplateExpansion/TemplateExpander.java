package TemplateExpansion;

import TemplateTags.ExtendedPersonalDataGeneratorTag;
import TemplateTags.Workers;

import javax.swing.*;

public class TemplateExpander {
    private Workers workers;
    private int nestingLevel;
    public TemplateExpander(Workers workers, int nestingLevel) {
        this.workers = workers;
        this.nestingLevel = nestingLevel;
    }

    public String expandTemplate() {
        if (this.workers == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if (this.nestingLevel == 0) {
            sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
        }
        String indent = "    ".repeat(this.nestingLevel);
        sb.append(indent).append("<WorkersExpanded>\n");
        int numberOfWorkers = 0;
        if (this.workers.getQuantity() != null) {
            numberOfWorkers = this.workers.getQuantity();
        }
        if(numberOfWorkers <=0) {
            JOptionPane.showMessageDialog(null, "The Quantity is <=0. The program will generate an expanded template using Quantity = 0", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            numberOfWorkers = 0;
        }
        if(numberOfWorkers>30000){
            JOptionPane.showMessageDialog(null, "The Quantity is >30000. It will take some time for the program to generate.", "Information!", JOptionPane.INFORMATION_MESSAGE);
            numberOfWorkers = 30000;
        }
        ExtendedPersonalDataGeneratorTag extendedPersonalDataGeneratorTag = new ExtendedPersonalDataGeneratorTag();
        while (numberOfWorkers > 0) {
            sb.append(indent).append("    <Person>\n");
            for (int j = 0; j < this.workers.getDataGeneratorList().size(); j++) {
                String Action = this.workers.getDataGeneratorList().get(j).getAction();
                sb.append(indent).append("        ").append(extendedPersonalDataGeneratorTag.generateTag(Action));
            }
            sb.append(indent).append("    </Person>\n");
            numberOfWorkers--;
        }
        if (this.workers.getNestedWorkers() != null) {
            TemplateExpander templateExpanderNested = new TemplateExpander(this.workers.getNestedWorkers(), this.nestingLevel + 1);
            sb.append(templateExpanderNested.expandTemplate());
        }
        sb.append(indent).append("</WorkersExpanded>\n");
        return sb.toString();
    }
}