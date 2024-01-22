package exercise;

// BEGIN
public class MinThread extends Thread {

    private int minThread;
    private int[] minArray;

    public void setMinArray(int[] minArray) {
        this.minArray = minArray;
    }

    public int getMinThread() {
        return minThread;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread minTread started");
        for (var number : minArray) {
            if (minThread == 0) {
                minThread = number;
            } else if (number <= minThread) {
                minThread = number;
            }
        }
        System.out.println("INFO: Thead minThread finished");
    }

}
// END
