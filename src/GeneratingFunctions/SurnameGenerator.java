package GeneratingFunctions;

public class SurnameGenerator extends GeneratorFromFile {
    private static final String SURNAMES_FILE_PATH = "src/generatingFunctions/DataSources/surnames.txt";
    public static String generateSurname() {
        return generateWordFromData(SURNAMES_FILE_PATH);
    }

}