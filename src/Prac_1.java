import java.util.*;
/*
 --------------------------------------------
   Java Multithreading using Threads
 --------------------------------------------

 🔹 Multithreading allows concurrent execution of two or more parts of a program.
 🔹 Java provides two ways to create threads:

   ✅ Method 1: Extending the Thread class
   ✅ Method 2: Implementing the Runnable interface

 🔹 Core Concepts:
    - run() method: Contains the code that a thread executes.
    - start() method: Starts a new thread and calls run() internally.
    - run() vs start():
        • run(): Called like a normal method (no parallelism)
        • start(): Creates a new thread (enables parallelism)
*/

// -----------------------------
// ✅ Method 1: Extending Thread
// -----------------------------
/*
class Cake extends Thread {
    public void run() {
        // Simulate cake-making process in a thread
        System.out.println("Mixing flour - " + Thread.currentThread().getId());
        System.out.println("Baking cake - " + Thread.currentThread().getId());
        System.out.println("Decorating cake - " + Thread.currentThread().getId());
    }
}

class Prac_1 {
    public static void main(String[] args) {
        int count = 4;
        for (int i = 0; i < count; i++) {
            Cake ck = new Cake();
            ck.start(); // Enables parallel execution using multiple threads
            // ck.run(); // Executes sequentially (not multithreaded)
        }
    }
}
*/

// ----------------------------------------
// ✅ Method 2: Implementing Runnable
// ----------------------------------------

class Cake implements Runnable {
    public void run() {
        // Simulate cake-making process in a thread
        System.out.println("Mixing flour - " + Thread.currentThread().getId());
        System.out.println("Baking cake - " + Thread.currentThread().getId());
        System.out.println("Decorating cake - " + Thread.currentThread().getId());
    }
}

class Prac_1 {
    public static void main(String[] args) {
        int count = 4;
        for (int i = 0; i < count; i++) {
            Cake ck = new Cake();
            Thread thread = new Thread(ck); // Wrap Runnable object in a Thread
            thread.start(); // Start the thread to run concurrently
            // ck.run(); // Executes like a normal method (sequentially)
        }
    }
}
