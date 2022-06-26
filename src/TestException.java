/**
 * @Author : Created by lity25
 * @Date : 2021/10/18 15:39
 * @Description :
 */
public class TestException {
    public static void main(String[] args) {
        try {
            f();
        }catch (MyException e){
            System.out.println("异常");
            e.printStackTrace(System.out);
        }

        try {
            d();
        }catch (MyException e){
            e.printStackTrace(System.out);
        }
    }

    public static void f() throws MyException{
        System.out.println("My Exception from f()");
        throw new MyException();
    }
    public static void d() throws MyException{
        System.out.println("My Exception from d()");
        throw new MyException("哈哈");
    }
}

class MyException extends Exception{
    public MyException(){}
    public MyException(String s){super(s);}
}


