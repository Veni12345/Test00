////////////////////////////【继承】
import java.util.List;
import java.util.ArrayList;
import java.util.AbstractList;

class Person{
    private long ID;
    private String name;
    public Person(long ID,String name){
        this.ID=ID;
        this.name=name;
    }

    public Person() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo(){
        return "编号："+this.getID()+" ，姓名："+this.getName();
    }
}

class Student extends Person{
    private String school;
    public Student(){}
    public Student(String school){
        super();
        this.school=school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    @Override
    public String getInfo(){
        return "编号："+super.getID()+" ，姓名："+super.getName()+" ，学校："+this.school;
    }

    //final 可以重载
    public final String print(int ID){
        return "输出ID:"+ID;
    }
    public final void print(int ID,String name){
        System.out.println("输出ID和姓名："+ID+","+name);
    }
}

/**
 * @author lity25
 */
public class Demo4 {
    public static void main(String[] args) {
        Student student=new Student();
        student.setID(1);
        student.setName("朱元璋");
        student.setSchool("明帝国");
        System.out.println(student.getInfo());

        //final
        System.out.println(student.print(1));
        student.print(2,"朱允炆");

    }
}
