package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {
        for (Map.Entry<String, String> map : keyValueStorage.toMap().entrySet()) {
            keyValueStorage.unset(map.getKey());
            keyValueStorage.set(map.getValue(), map.getKey());
        }
    }

}

// END
