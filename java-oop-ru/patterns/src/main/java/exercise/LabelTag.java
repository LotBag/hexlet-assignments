package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    private String type;
    private TagInterface value;

    public LabelTag(String type, TagInterface value) {
        this.type = type;
        this.value = value;
    }

    public String render() {
        return "<label>Press Submit" + value.render() + "</label>";
    }
}
// END
