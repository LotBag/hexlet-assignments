package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    protected String tag;
    protected Map<String, String> value;

    public Tag(String tag, Map<String, String> value) {
        this.tag = tag;
        this.value = value;
    }
}
// END
