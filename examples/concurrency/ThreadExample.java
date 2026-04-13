public class ThreadExample {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Working... " + i);
            }
        });

        worker.start();
    }
}
