package GUI;

import TemplateExpansion.TemplateExpander;
import TemplateReaderAndSaver.TemplateReader;
import jakarta.xml.bind.JAXBException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUI {
    private JTextArea Area;
    private JTextField Path;
    private JButton DownloadResultArea;
    private JButton ExampleTemplate;
    private JButton DownloadResultPath;
    private JPanel Generator;
    private JLabel AreaL;
    private JLabel PathL;
    private JTextField DownloadPathString;
    private JLabel DownloadL;
    private JButton DownloadPath;
    private String downloadPath = "src/Templates/TemplatesExpanded/ExpandedTemplate.xml";
    private String templatePath = "src/Templates/TemplatesCompressed/NestingTemplate.xml";
    private String path_r = "src/Templates/TemplatesExpanded/";
    private String path_t = "src/Templates/TemplatesCompressed/";

    public GUI() {
        Area.setText(
                "Welcome to the XML Data Generating App!\n" +
                        "\n" +
                        "Overview:\n" +
                        "This app allows you to generate XML data by providing templates and specifying data parameters.\n" +
                        "\n" +
                        "Features:\n" +
                        "\n" +
                        "1. **Show Example Template**\n" +
                        "   - Click the \"Show Example Template\" button to view a sample template.\n" +
                        "\n" +
                        "2. **Data Generation Options**\n" +
                        "   - Customize age, surname, name (female, male or not specified), and location data.\n" +
                        "   - Set quantity.\n" +
                        "   - Optionally use nesting.\n" +
                        "\n" +
                        "3. **Generate from Text Template**\n" +
                        "   - Enter your template in the provided text field.\n" +
                        "   - Click \"Download Data from Text Template\" to instantly download the expanded data.\n" +
                        "\n" +
                        "4. **Generate from File Template**\n" +
                        "   - Specify the template file's name (located in `src/Templates/TemplatesCompressed/`).\n" +
                        "   - Click \"Download Data from File Template\" to download the expanded result.\n" +
                        "\n" +
                        "5. **Customize Output File Name**\n" +
                        "   - Change the name of the expanded data file in the \"Enter Download File Name\" field.\n" +
                        "\n" +
                        "Usage Tips:\n" +
                        "- Expanded data files are stored in the project directory.\n" +
                        "- Default output filename is \"ExpandedTemplate.xml.\"\n" +
                        "\n" +
                        "Enjoy generating XML data effortlessly with our app!");
        AreaL.setText("Enter Template Text");
        PathL.setText("Enter Template Source File Name");
        DownloadL.setText("Enter Download File Name (Default ExpandedTemplate.xml)");
        Generator.setPreferredSize(new Dimension(1200, 800));
        ExampleTemplate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayExampleTemple(templatePath);
            }
        });
        DownloadResultArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateXmlFile();
                try {
                    downloadResult(downloadPath);
                } catch (JAXBException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                File fileToDelete = new File("./template.xml");
                fileToDelete.delete();
            }
        });
        DownloadPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadPath = path_r + DownloadPathString.getText();
            }
        });
        DownloadResultPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TemplateReader templateReader = null;
                templateReader = new TemplateReader(path_t + Path.getText());
                TemplateExpander templateExpander = new TemplateExpander(templateReader.getWorkers(), 0);
                File file = new File(downloadPath);
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fileWriter.write(templateExpander.expandTemplate());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    private void generateXmlFile() {
        String templeText = Area.getText();
        String filePath = "./template.xml";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(templeText);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void downloadResult(String dpath) throws JAXBException, IOException {
        TemplateReader templateReader = new TemplateReader("./template.xml");
        TemplateExpander templateExpander = new TemplateExpander(templateReader.getWorkers(), 0);
        File file = new File(dpath);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(templateExpander.expandTemplate());
        fileWriter.close();
    }
    private void displayExampleTemple(String path) {
        TemplateReader templateReader = new TemplateReader(path);
        String exampleXml = templateReader.getWorkersString();
        Area.setText(exampleXml);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("GUI");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new GUI().Generator);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}