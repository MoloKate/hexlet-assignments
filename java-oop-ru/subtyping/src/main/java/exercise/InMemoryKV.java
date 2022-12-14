package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {

  private Map<String, String> database= new HashMap<>();;

  InMemoryKV(Map<String, String> data) {
      this.database.putAll(data);
  }
  @Override
    public void set(String key, String value) {
      database.put(key, value);
  }

  @Override
    public void unset (String key) {
      database.remove(key);
  }

  @Override
    public String get(String key, String defaultValue) {
      return database.getOrDefault(key, defaultValue);
  }

  @Override
    public Map<String, String> toMap() {
      return new HashMap<>(database);
  }


}


// END
