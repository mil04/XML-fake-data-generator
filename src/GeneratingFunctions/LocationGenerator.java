package GeneratingFunctions;

public class LocationGenerator extends GeneratorFromFile {
    private static final String LOCATIONS_FILE_PATH = "src/generatingFunctions/DataSources/locations.txt";
    public static String generateLocation() {
        return generateWordFromData(LOCATIONS_FILE_PATH);
    }
}
