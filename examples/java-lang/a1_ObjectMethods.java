package a1_java.lang;

public class a1_ObjectExample implements Cloneable {

    private String name;

    public a1_ObjectExample(String name) {
        this.name = name;
    }

    // 1) equals(Object obj): Checks object equality  
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof a1_ObjectExample)) return false;
        a1_ObjectExample other = (a1_ObjectExample) obj;
        return name != null ? name.equals(other.name) : other.name == null;
    }

    // 2) hashCode(): Returns object's hash code  
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    // 3) toString(): Returns string representation of object  
    @Override
    public String toString() {
        return "Object{name='" + name + "'}";
    }

    // 5) clone(): Creates a copy of the object  
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 6) finalize(): Called by garbage collector (deprecated since Java 9)  
    @SuppressWarnings("removal")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called: " + name);
        super.finalize();
    }

    // 7) notify(): Wakes up a waiting thread  
    public synchronized void notifyExample() {
        notify();
        System.out.println("Notify called.");
    }

    // 8) notifyAll(): Wakes up all waiting threads  
    public synchronized void notifyAllExample() {
        notifyAll();
        System.out.println("NotifyAll called.");
    }

    // 9) wait(): Suspends the thread  
    public synchronized void waitExample() throws InterruptedException {
        wait();
        System.out.println("Thread continued.");
    }

    // 10) wait(long timeout): Suspends for specified time  
    public synchronized void waitWithTimeout() throws InterruptedException {
        wait(1000);
        System.out.println("Continued after timeout.");
    }

    // 11) wait(long timeout, int nanos): Suspends with milliseconds and nanoseconds  
    public synchronized void waitWithTimeoutNanos() throws InterruptedException {
        wait(1000, 500000);
        System.out.println("Continued after nanosecond wait.");
    }

    public static void main(String[] args) {
        // 1) equals() method example  
        a1_ObjectExample obj1 = new a1_ObjectExample("Alice");
        a1_ObjectExample obj2 = new a1_ObjectExample("Alice");
        a1_ObjectExample obj3 = new a1_ObjectExample("Bob");

        System.out.println("Are obj1 and obj2 equal? " + obj1.equals(obj2));
        System.out.println("Are obj1 and obj3 equal? " + obj1.equals(obj3));

        // 2) hashCode() method example  
        System.out.println("obj1 Hash Code: " + obj1.hashCode());
        System.out.println("obj2 Hash Code: " + obj2.hashCode());

        // 3) toString() method example  
        System.out.println("obj1 String Representation: " + obj1);

        // 4) getClass() method example (cannot be overridden)  
        System.out.println("Class Name: " + obj1.getClass().getName());

        // 5) clone() method example  
        try {
            a1_ObjectExample clonedObj = (a1_ObjectExample) obj1.clone();
            System.out.println("Cloned Object: " + clonedObj);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 6) finalize() method example  
        obj1 = null;
        System.gc();
    }
}
