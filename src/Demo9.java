//////////////////////【内部类】
class Outer{
    private String outName="Stark";
    public void print(){
        Inner inner=new Inner();
        System.out.println("外部类访问内部类私有属性："+inner.inName);
    }
    class Inner{
        private String inName="John";
        public void get(){
            System.out.println("内部类访问外部类私有属性："+Outer.this.outName);   //内部类访问外部类私有属性
        }
    }
}

public class Demo9 {
    public static void main(String[] args){
        Outer outer=new Outer();
        outer.print();

        Outer.Inner oi=new Outer().new Inner();
        oi.get();
    }
}
