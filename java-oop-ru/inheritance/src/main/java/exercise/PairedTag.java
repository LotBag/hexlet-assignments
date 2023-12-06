package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    public String body;
    public List<Tag> child;

    public PairedTag(String tag, Map<String, String> value,  String body, List<Tag> child) {
        super(tag, value);
        this.body = body;
        this.child = child;
    }

    @Override
    public String toString() {
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


        for (Tag tag:child) {
            result.append(tag.toString());
        }
        result.append(body).append("</").append(tag).append(">");

        return result.toString();
    }
}
// END
