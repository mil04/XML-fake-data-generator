package GeneratingFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorFromFile {
    protected static String generateWordFromData(String dataPath) {
        List < String > words = new ArrayList < > ();
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words.get((int)(Math.random() * words.size()));
    }
}
