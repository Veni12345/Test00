////////////////////////【接口】工厂设计模式     double ...args//...多个参数设置
interface IGraphics{
    void paint();
}

class Triangle implements IGraphics{
    @Override
    public void paint() {
        System.out.println("绘制三角形");
    }
}
class Circle implements IGraphics{
    private double radis;
    public Circle(double radis){
        this.radis=radis;
    }
    @Override
    public void paint() {
        System.out.println("绘制圆形");
    }
}
class Ractangle implements IGraphics{
    private double length;
    private double width;
    public Ractangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    @Override
    public void paint() {
        System.out.println("绘制矩形");
    }
}

class Factory{
    public static IGraphics getInstance(String className,double ...args){    //...多个参数设置
        if("triangle".equalsIgnoreCase(className)){
            return new Triangle();
        }else if("circle".equalsIgnoreCase(className)){
            return new Circle(args[0]);
        }else if("ractangle".equalsIgnoreCase(className)){
            return new Ractangle(args[0],args[1]);
        }else {
            return null;
        }
    }
}

public class Demo6 {
    public static void main(String[] args){
        IGraphics iGraphics1=Factory.getInstance("Triangle");
        iGraphics1.paint();
        IGraphics iGraphics2=Factory.getInstance("circle",10.2);
        iGraphics2.paint();
        IGraphics iGraphics3=Factory.getInstance("ractangle",1.2,5.6);
        iGraphics3.paint();

    }
}
