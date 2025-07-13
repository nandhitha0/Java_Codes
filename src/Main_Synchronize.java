//Summary: Thread Synchronization
//Race Condition:When multiple threads modify a shared variable without proper synchronization, leading to inconsistent results.
//Synchronized:A keyword that ensures only one thread at a time can access a method or block.
//Critical Section:The part of the code (like CakeCount++) that must be executed by only one thread at a time to avoid data corruption.
//Thread.join():	Makes the main thread wait until the worker threads (t1, t2) finish execution.
//Shared Resource:The object CakeCounter is shared by both threads to ensure both update the same count.

// Represents a counter that tracks how many cakes are made
class CakeCounter {
    int CakeCount = 0;  // Shared variable (critical section)

    // 🔒 Synchronized method ensures only one thread accesses increment() at a time
    public synchronized void increment() {
        CakeCount++;  // Critical operation that needs protection from race conditions
    }
}

// Represents a worker team that increases the cake count
class Team implements Runnable {
    CakeCounter counter;

    // Constructor receives the shared CakeCounter object
    Team(CakeCounter counter) {
        this.counter = counter;
    }

    // 👷 Each thread runs this method
    public void run() {
        // Simulate 1000 cake-making actions per team
        for (int i = 0; i < 1000; i++) {
            counter.increment();  // Shared counter being updated
        }
    }
}

public class Main_Synchronize {
    public static void main(String[] args) {
        // 🎯 Shared resource (only one CakeCounter object shared between threads)
        CakeCounter ck = new CakeCounter();

        // 🔧 Create two threads (teams) that share the same counter
        Thread t1 = new Thread(new Team(ck));
        Thread t2 = new Thread(new Team(ck));

        // ▶️ Start both threads
        t1.start();
        t2.start();

        // ⏳ Wait for both threads to finish using join()
        try {
            t1.join();  // Main thread waits for t1 to complete
            t2.join();  // Main thread waits for t2 to complete
        } catch (Exception e) {
            // Handle exceptions if thread joining fails
            System.out.println("Thread interrupted");
        }

        // ✅ Final result should be 2000 (1000 from each thread)
        System.out.println("Total Cakes Made: " + ck.CakeCount);
    }
}
