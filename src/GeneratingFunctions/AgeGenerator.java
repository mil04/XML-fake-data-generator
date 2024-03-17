package GeneratingFunctions;

import java.util.Random;

public class AgeGenerator {
    public static int generateAge(int min, int max) {
        if (min < 0 || max < 0 || min > max) {
            Exception e = new Exception("Invalid age range");
            e.printStackTrace();
            return -1;
        }
        return new Random().nextInt(max - min + 1) + min;
    }
}
