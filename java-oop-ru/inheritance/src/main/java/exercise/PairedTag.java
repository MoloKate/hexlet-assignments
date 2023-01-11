package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> map, String body, List<Tag> children) {
        super(name, map);
        this.body = body;
        this.children = children;
    }

    public String getChildrenToString() {
        StringBuilder childToString = new StringBuilder();
        if (!children.isEmpty()) {
            children.forEach(c -> childToString.append(c.toString()));
        } else return "";
        return childToString.toString();
    }

    @Override
    public String toString() {
        StringBuilder finalTag = new StringBuilder();
        finalTag.append("<" + name + getMapToString(map) + ">")
                .append(getChildrenToString())
                .append(body)
                .append("</" + name + ">");
        return finalTag.toString();
    }
}

// END
