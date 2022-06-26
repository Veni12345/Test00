//////////////////////////【单例模式】
class Singleton{
    private Singleton(){}
    private static final Singleton INSTANCE=new Singleton();
    public static Singleton getInstance(){
        return INSTANCE;
    }
    public void print(){
        System.out.println("单例模式 饿汉式 输出");
    }
}

class Singleton2{
    private Singleton2(){}
    private static final Singleton2 INSTANCE=null;
    public static Singleton2 getInstance(){
        if(INSTANCE==null){         //第一次使用 实例化对象
            return new Singleton2();
        }
        return INSTANCE;
    }
    public void print(){
        System.out.println("单例模式 懒汉式 输出");
    }
}

public class Demo7 {
    public static void main(String[] args){
        Singleton singleton=Singleton.getInstance();
        singleton.print();

        Singleton2 singleton2=Singleton2.getInstance();
        singleton2.print();
    }

}
