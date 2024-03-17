package TemplateTags;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Workers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Workers {
    @XmlElement(name = "Quantity")
    private Integer quantity;

    @XmlElementWrapper(name = "Person")
    @XmlElement(name = "PersonalDataGenerator")
    private List < PersonalDataGenerator > personalDataGeneratorList = new ArrayList < > ();

    @XmlElement(name = "Workers")
    private Workers nestedWorkers;

    public Integer getQuantity() {
        return this.quantity;
    }

    public List < PersonalDataGenerator > getDataGeneratorList() {
        return this.personalDataGeneratorList;
    }

    public Workers getNestedWorkers() {
        return this.nestedWorkers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Workers>\n");
        sb.append("    <Quantity>");
        sb.append((this.quantity == null) ? "null" : this.quantity);
        sb.append("</Quantity>\n");
        sb.append("    <Person>\n");
        for (PersonalDataGenerator personalDataGenerator: personalDataGeneratorList) {
            sb.append("        ").append(personalDataGenerator.toString());
        }
        sb.append("    </Person>\n");

        if (nestedWorkers != null) {
            String[] lines = nestedWorkers.toString().split(System.lineSeparator());

            StringBuilder indentedStringBuilder = new StringBuilder();
            for (String line: lines) {
                indentedStringBuilder.append("     ").append(line).append(System.lineSeparator());
            }

            sb.append(indentedStringBuilder.toString());
        }

        sb.append("</Workers>\n");
        return sb.toString();
    }
}