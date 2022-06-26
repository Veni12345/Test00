import java.util.Random;

public class Demo1 {
    public static void main(String[] args){
        /*System.out.println(12/2);
        Demo2.Dog dog=new Demo2.Dog("Alix",8);

        Random random=new Random();
        int[][] arr=new int[5][5];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=random.nextInt(10);
            }
        }

        for(int[] x:arr){
            for(int y:x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
        System.out.println(arr);*/

        Thread mainTHread=Thread.currentThread();
        Thread thread=new Thread(()->{
            for (int i = 0; i < 20; i++) {
                if(i>5){
                    try {
                        mainTHread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                if(i%3==0){
//                    Thread.yield();
//                    System.out.println("线程礼让");
//                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+i+"运行");
            }
        },"线程对象");
        thread.start();
        for (int x = 0; x < 20; x++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程"+x);
        }

    }
}
