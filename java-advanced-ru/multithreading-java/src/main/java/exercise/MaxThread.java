package exercise;

// BEGIN
public class MaxThread extends Thread {

    private int maxThread;
    private int[] maxArray;

    public void setMaxArray(int[] maxArray) {
        this.maxArray = maxArray;
    }

    public int getMaxThread() {
        return maxThread;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread MaxTread started");
        for (var number : maxArray) {
            if (maxThread == 0) {
                maxThread = number;
            } else if (number >= maxThread) {
                maxThread = number;
            }
        }
        System.out.println("INFO: Thead MaxThread finished");
    }

}
// END
