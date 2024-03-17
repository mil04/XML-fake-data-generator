package GeneratingFunctions;

public class ProfessionGenerator extends GeneratorFromFile{
    private static final String PROFESSIONS_FILE_PATH = "src/generatingFunctions/DataSources/professions.txt";
    public static String generateProfession() {
        return generateWordFromData(PROFESSIONS_FILE_PATH);
    }
}
