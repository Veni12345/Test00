/**
 * @Author : Created by lity25
 * @Date : 2021/12/30 11:14
 * @Description :
 */
public class Test2 {
    public static void main(String[] args) {
        boolean aa = false;
        System.out.println(aa);
        Cat c1 = new Cat("王磊");
        Cat c2 = new Cat("王磊");
        System.out.println(c1.equals(c2)); // false

        String s1 = new String("老王");
        String s2 = new String("老王");
        System.out.println(s1.equals(s2)); // true


    }
}

class Cat {
    public Cat(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




