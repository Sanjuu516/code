class GoodMorning extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("Good Morning");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Hello extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("Hello");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Welcome extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("Welcome");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadsExample {
    public static void main(String[] args) {
        new GoodMorning().start();
        new Hello().start();
        new Welcome().start();
    }
}
''''''''''''''''''''''''''''''''''''''''''''''''''''
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the MyRunnable class
        MyRunnable runnable = new MyRunnable();

        // Pass the Runnable instance to a Thread object
        Thread thread = new Thread(runnable);

        // Start the thread
        thread.start();
    }
}

''''''''''''''''''''''''''''''''''''''''''''''''''''

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 Running");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 Running");
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}

''''''''''''''''''''''''''''''''''''''''''''''''''''''

class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadSync {
    public static void main(String[] args) {
        Table table = new Table();

        Thread t1 = new Thread(() -> table.printTable(5));
        Thread t2 = new Thread(() -> table.printTable(10));

        t1.start();
        t2.start();
    }
}

''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

import java.io.*;
public class ByteOrientedCopy {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("source.txt");
             FileOutputStream fos = new FileOutputStream("destination.txt")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully using Byte-Oriented I/O.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

import java.io.*;
public class CharacterOrientedCopy {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("source.txt");
             FileWriter fw = new FileWriter("destination.txt")) {

            int charData;
            while ((charData = fr.read()) != -1) {
                fw.write(charData);
            }
            System.out.println("File copied successfully using Character-Oriented I/O.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






