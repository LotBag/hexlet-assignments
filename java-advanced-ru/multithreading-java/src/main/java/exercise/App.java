package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numArray) {
        MinThread threadMin = new MinThread();
        threadMin.setMinArray(numArray);

        MaxThread threadMax = new MaxThread();
        threadMax.setMaxArray(numArray);

        threadMin.start();
        threadMax.start();

        var result = new HashMap<String, Integer>();

        try {
            threadMax.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            threadMin.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        result.put("min", threadMin.getMinThread());
        result.put("max", threadMax.getMaxThread());


        return result;
    }
    // END
}
