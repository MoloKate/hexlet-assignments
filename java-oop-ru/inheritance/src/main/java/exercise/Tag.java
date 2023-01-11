package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    protected String name;
    protected Map<String, String> map;

    public Tag(String name, Map<String, String> map) {
        this.name = name;
        this.map = map;
    }

    public String getMapToString(Map<String, String> map) {
        StringBuilder mapToString = new StringBuilder();
        if (!map.isEmpty()) {
            map.forEach((k, v) -> mapToString.append(" " + k + "=\"" + v + "\""));
        } else return "";
        return mapToString.toString();
    }

}

// END
