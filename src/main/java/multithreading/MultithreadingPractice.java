package multithreading;

import java.util.concurrent.*;

public class MultithreadingPractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread.currentThread().setName("MainThread"); // renaming the main thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " thread" + (Thread.currentThread().isDaemon() ? "(Daemon):" : ":") + i);
        }

        ThreadedKlass thread = new ThreadedKlass();
        thread.setName("Thread"); // renaming current thread
        thread.setPriority(1);
        thread.setDaemon(true);

        Runnable runnableKlass = () -> {
            for (int i = 1; i <= 10; i++)
                System.out.println("=== " + Thread.currentThread().getName() + " runnable" + (Thread.currentThread().isDaemon() ? "(Daemon):" : ":") + i);
        };
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