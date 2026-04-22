package a1_java.lang;

import java.util.*;

public class b14_ThreadExample {

    public static void main(String[] args) {
        try {
            // Method 1: Thread() - Creating a new Thread object without parameters  
            Thread defaultThread = new Thread() {
                @Override
                public void run() {
                    System.out.println("1. Default Thread is running");
                }
            };
            defaultThread.start(); // Method 5: start() - Starts the thread  

            // Method 2: Thread(Runnable target) - Creating a Thread with a Runnable  
            Runnable runnableTask = () -> {
                System.out.println("2. Runnable Thread is executing");
                try {
                    // Method 10: sleep() - Pausing the thread  
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // Method 11: interrupt() - Handling thread interruption  
                    System.out.println("Thread was interrupted");
                }
            };
            Thread runnableThread = new Thread(runnableTask);
            runnableThread.start();

            // Method 3: Thread(String name) - Creating a named Thread  
            Thread namedThread = new Thread() {
                @Override
                public void run() {
                    // Method 13: setName() - Changing thread name  
                    setName("CustomNameThread");
                    // Method 14: getName() - Getting thread name  
                    System.out.println("3. Thread name: " + getName());
                }
            };
            namedThread.start();

            // Method 4: Thread(Runnable target, String name)  
            Thread combinedThread = new Thread(runnableTask, "CombinedThread");
            combinedThread.start();

            // Method 7: currentThread() - Getting current thread  
            Thread currentThread = Thread.currentThread();
            System.out.println("7. Current Thread: " + currentThread.getName());

            // Method 8 & 9: join() methods - Waiting for thread completion  
            try {
                runnableThread.join(1000); // Wait up to 1 second  
                System.out.println("8-9. Thread joined successfully");
            } catch (InterruptedException e) {
                System.out.println("Join operation interrupted");
            }

            // Method 12: isAlive() - Checking thread status  
            System.out.println("12. Runnable Thread is alive: " + runnableThread.isAlive());

            // Method 15 & 16: getPriority() and setPriority()  
            System.out.println("15. Default Thread Priority: " + defaultThread.getPriority());
            defaultThread.setPriority(Thread.MAX_PRIORITY);
            System.out.println("16. Updated Thread Priority: " + defaultThread.getPriority());

            // Method 17: yield() - Suggesting thread scheduler to switch threads  
            Thread yieldThread = new Thread(() -> {
                System.out.println("17. Yield Thread is running");
                Thread.yield(); // Suggests thread scheduler to switch threads  
            });
            yieldThread.start();

            // Method 18: isInterrupted() - Checking interruption status  
            Thread interruptedThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("18. Checking interruption status");
                }
            });
            interruptedThread.start();
            interruptedThread.interrupt(); // Interrupt the thread  

            // Method 19: interrupted() - Static method to check interruption  
            Thread.interrupted(); // Clears interrupted status  

            // Method 20: activeCount() - Get number of active threads  
            System.out.println("20. Active Thread Count: " + Thread.activeCount());

            // Method 21: getAllStackTraces() - Get stack traces of all threads  
            Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
            System.out.println("21. Total Thread Stack Traces: " + stackTraces.size());

            // Method 22: enumerate() - Place existing threads in an array  
            Thread[] threadArray = new Thread[Thread.activeCount()];
            int threadCount = Thread.enumerate(threadArray);
            System.out.println("22. Threads in Array: " + Arrays.toString(threadArray));
            System.out.println("    Number of Threads Enumerated: " + threadCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
