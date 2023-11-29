package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int n) {
        list.sort(Home::compareTo);
        List<String> result = new ArrayList<>();

        if (list.size() < n) {
            return result;
        }
        for (var i = 0; i < n; i++) {
            result.add(list.get(i).toString());
        }
        return result;
    }
}
// END
