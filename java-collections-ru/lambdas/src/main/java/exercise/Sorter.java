package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
                .filter(man -> man.get("gender").equals("male"))
                .sorted(Comparator.comparing(date -> date.get("birthday")))
                .map(man -> man.get("name"))
                .collect(Collectors.toList());
    }
}
// END
