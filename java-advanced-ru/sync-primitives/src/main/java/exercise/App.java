package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList sList1 = new SafetyList();

        ListThread thread1 = new ListThread(sList1);
        ListThread thread2 = new ListThread(sList1);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sList1.getSize());
        // END
    }
}

