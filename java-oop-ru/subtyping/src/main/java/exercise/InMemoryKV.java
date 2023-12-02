package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private Map<String, String> storage;

    @Override
    public void set(String key, String value) {
        this.storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        String value = storage.get(key);
        if (value == null) {
            return defaultValue;
        } else {
            return value;
        }
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> storageCopy = new HashMap<>(this.storage);
        return storageCopy;
    }

    InMemoryKV() {
        this.storage = new HashMap<>();
    }

    InMemoryKV(Map<String, String> map) {
        this.storage = new HashMap<>(map);
    }

}
// END
