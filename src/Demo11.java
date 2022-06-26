///////////////////【Lambda】【assert】
import java.lang.RuntimeException;
interface IMessage{
    public void send();
}

interface IMath{
    public int add(int t1,int t2);
}

public class Demo11 {
    public static void main(String[] args){
        int x=10;
        assert x == 100 :"x为100";
        System.out.println(x);

        IMessage iMessage=()->{
            System.out.println("发送消息：嘤嘤嘤 ");
        };
        iMessage.send();

        IMath iMath=(t1,t2)->{
            return t1+t2;
        };
        IMath iMath1=(t1,t2)->t1+t2;
        System.out.println(iMath.add(45,56));
        System.out.println(iMath1.add(45,56));

    }
}
