package GeneratingFunctions;

import java.util.Random;

public class NameGenerator extends GeneratorFromFile {
    private static final String FEMALE_NAMES_FILE_PATH = "src/generatingFunctions/DataSources/femaleNames.txt";
    private static final String MALE_NAMES_FILE_PATH = "src/generatingFunctions/DataSources/maleNames.txt";
    public static String generateFemaleName() {
        return generateWordFromData(FEMALE_NAMES_FILE_PATH);
    }

    public static String generateMaleName() {
        return generateWordFromData(MALE_NAMES_FILE_PATH);
    }

    public static String generateName() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return generateFemaleName();
        } else {
            return generateMaleName();
        }
    }

}