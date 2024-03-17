package TemplateTags;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDataGenerator {
    @XmlAttribute(name = "Action")
    private String action;
    public String getAction() {
        return this.action;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<PersonalDataGenerator Action='");
        sb.append((this.action == null) ? "null" : this.action);
        sb.append("'/>\n");
        return sb.toString();
    }
}