package exercise;

import java.util.*;

// BEGIN
public class App {

    public static List<Map<String, String>>findWhere(List<Map<String, String>> mapList, Map<String, String> stringMap) {
        boolean result = false;
        List<Map<String, String>> resultList = new ArrayList<>();
        for (var map : mapList) {
            for (var key : stringMap.keySet()) {
                if (map.containsValue(stringMap.get(key))){
                    result = true;
                } else {
                    result = false;
                    break;
                }
        }
            if (result) {
            resultList.add(map);
            }
        }
        System.out.println(resultList);
        return resultList;
    }
}
//END
