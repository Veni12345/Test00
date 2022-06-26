
class MyThread extends Thread {
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.title + "运行.i = " + i);
        }
    }
}

class MyThread1 implements Runnable {
    private int ticket = 500;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (this.ticket > 0) {
                System.out.println("买票，ticket = " + this.ticket--);
            }
        }
    }
}

/**
 * @Author : Created by lity25
 * @Date : 2021/12/21 11:11
 * @Description :
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        new MyThread("线程A").start();
//        new MyThread("线程B").start();
//        new MyThread("线程C").start();

        for (int i = 0; i < 10; i++) {
            String title = "线程对象 " + i;
            /*Runnable runnable = () -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(title + "运行，j = " + j);
                }
            };
            new Thread(runnable).start();*/
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(title + "运行，j = " + j);
                }
            }).start();
        }

        /*MyThread1 myThread1 = new MyThread1();
        new Thread(myThread1).start();
        new Thread(myThread1).start();
        new Thread(myThread1).start();*/

    }

}
