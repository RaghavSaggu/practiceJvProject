package multithreading;

import java.util.concurrent.*;

public class MultithreadingPractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MultithreadingPractice obj = new MultithreadingPractice();
        obj.letSeeThreadSafeExample();
    }

    public void letSeeThreadSafeExample() throws InterruptedException {
        Counter counter = new Counter();
        Counter counterThreadSafe = new Counter();
        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                counterThreadSafe.threadSafeIncrement();
            }
        };
        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                counterThreadSafe.threadSafeIncrement();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join(); // wait till t1 joins main method
        t2.join(); // wait till t2 joins main method

        System.out.println("Counter after completion for all threads with normal method " + counter.getCounter());
        System.out.println("Counter after completion for all threads with threadSafe method " + counterThreadSafe.getCounter());
    }

    public void letSeeWorkingOfMainThread() {
        Thread.currentThread().setName("MainThread"); // renaming the main thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " thread" + (Thread.currentThread().isDaemon() ? "(Daemon):" : ":") + i);
        }
    }

    public void runThreadRunnableAndCallable() throws ExecutionException, InterruptedException {
        ThreadedKlass thread = new ThreadedKlass();
        thread.setName("VirtualThread"); // renaming current thread
        thread.setPriority(1);
        thread.setDaemon(true);

        Runnable runnableKlass = new RunnableKlass();
        Thread threadForRunnable = new Thread(runnableKlass);
        threadForRunnable.setName("Runnable"); // renaming current thread
        threadForRunnable.setPriority(9);
        threadForRunnable.setDaemon(true);

        int numberToGetFactorial = 5;
        CallableKlass callableKlass = new CallableKlass(numberToGetFactorial);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        thread.start();
        threadForRunnable.start();
        Future<Long> result = executorService.submit(callableKlass);
        executorService.submit(runnableKlass);

        executorService.shutdown();

        System.out.println("factorial of " + numberToGetFactorial + " is: " + result.get());
//        threadForRunnable.start(); // can not start again same thread

    }
}

class Counter {
    private long counter;

    public void increment() {
        counter++;
    }

    public synchronized void threadSafeIncrement() { // we can make methods threadSafe with synchronized keyword
        counter++;
    }

    public long getCounter() {
        return counter;
    }
}

class RunnableKlass implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++)
            System.out.println("=== " + Thread.currentThread().getName() + " runnable" + (Thread.currentThread().isDaemon() ? "(Daemon):" : ":") + i);
    }
}

class CallableKlass implements Callable<Long> {
    int num;

    public CallableKlass(int num) {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        try {
            long factorial = 1;
            for (int i = num; i > 1; i--) {
                System.out.println("=== " + Thread.currentThread().getName() + " Callable" + (Thread.currentThread().isDaemon() ? "(Daemon):" : ":") + i);
                factorial = factorial * i;
                try {
                    ThreadedKlass.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return factorial;
        } catch (Exception e) {
            throw e;
        }
    }
}

class ThreadedKlass extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("============= " + Thread.currentThread().getName() + " thread" + (Thread.currentThread().isDaemon() ? "(Daemon):" : ":") + i);
        }
    }

    @Override
    public synchronized void start() {
        System.out.println("it is never advised to override start");
        super.start();
    }
}