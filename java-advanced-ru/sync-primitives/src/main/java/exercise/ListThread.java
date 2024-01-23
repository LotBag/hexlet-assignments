package exercise;

// BEGIN
public class ListThread extends Thread {
    SafetyList safetyList;
    public ListThread(SafetyList sList) {
        this.safetyList = sList;
    }

    @Override
    public void run() {
        for(var i = 0; i < 1000; i++) {
            safetyList.add(i);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// END
