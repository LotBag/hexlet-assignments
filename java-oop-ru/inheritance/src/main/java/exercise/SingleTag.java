package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{
    public SingleTag(String tag, Map<String, String> value) {
        super(tag, value);
    }

    @Override
    public  String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<").append(tag);

        for (var key : value.keySet()) {
            result.append(" ").
                    append(key).
                    append("=").
                    append("\"").
                    append(value.get(key)).
                    append("\"");
        }

        result.append(">");

        return result.toString();
    }
}
// END
