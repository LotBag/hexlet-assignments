package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public synchronized void add(int number) {
        this.list.add(number);
    }

    public int get(int index) {
        return this.list.get(index);
    }

    public int getSize() {
        return this.list.size();
    }

    // END
}
