package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage kVS) {
        Map<String, String> originalMap = kVS.toMap();
        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            kVS.unset(entry.getKey());
            kVS.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
