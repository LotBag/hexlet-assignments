package exercise;

import java.util.*;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        var tmp = new TreeMap<String, String>();
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                tmp.put(key, "added");
            }
        }
        
        for (String key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                tmp.put(key, "deleted");
            }
        }
        
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if ((map1.get(key).equals(map2.get(key))) || (map1.get(key) == map2.get(key))) {
                    tmp.put(key, "unchanged");
                } else {
                    tmp.put(key, "changed");
                }
            }
        }
        
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (String key : tmp.keySet()) {
            result.put(key, tmp.get(key));
        }

        return result;
    }
}
//END
