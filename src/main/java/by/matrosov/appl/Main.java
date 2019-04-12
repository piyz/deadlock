package by.matrosov.appl;

public class Main {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    private static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}

                synchronized (lock2){

                }
            }
        }
    }

    private static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (lock2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}

                synchronized (lock1){

                }
            }
        }
    }
}
