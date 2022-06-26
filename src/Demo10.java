///////////////////////////【Enum】
enum Sex{
    MALE("男"),FEMALE("女");
    private String title;
    private Sex(String title){
        this.title=title;
    }
    public String toString(){
        return this.title;
    }
}
class Person1{
    private String name;
    private int age;
    private Sex sex;
    public Person1(String name,int age,Sex sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    public String toString(){
        return "姓名："+this.name+" ，年龄："+this.age+" ，性别："+this.sex;
    }
}

public class Demo10 {
    public static void main(String[] args){
        Person1 person1=new Person1("Jobs",56,Sex.MALE);
        System.out.println(person1);
    }
}
