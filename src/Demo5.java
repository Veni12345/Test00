////////////////////////【接口】
interface IUSB{
    public boolean check();
    public void work();
    default void unUse(){     //interface中的不同接口
        System.out.println("UNUSE");
    }
}

class Keyboard implements IUSB {
    @Override
    public boolean check() {
        return true;
    }

    @Override
    public void work() {
        System.out.println("开始打字");
    }
}

class Print implements IUSB{
    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void work() {
        System.out.println("开始打印照片");
    }
}

class Computer{
    public void test(IUSB iusb){
        if(iusb.check()){
            iusb.work();
        }else {
            System.out.println("硬件设备出现问题");
        }
    }
}

public class Demo5 {
    public static void main(String[] args){
        Computer computer=new Computer();
        computer.test(new Keyboard());
        computer.test(new Print());

        //调用interface中的不同接口
        IUSB iusb1=new Keyboard();
        iusb1.unUse();

    }
}
