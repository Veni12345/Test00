//////////////////////类关联

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        Person person1 = new Person("Arya", 151234);
        Dog dog1 = new Dog("Dog1", 5);
        Dog dog2 = new Dog("Dog2", 6);
        Dog dog3 = new Dog("Dog3", 7);
        person1.setDogs(new Dog[]{dog1,dog2});
        System.out.println(person1.toString());
        dog1.setPerson(person1);
        dog2.setPerson(person1);
        dog1.getPerson();
        System.out.println(dog1.toString());

    }

    public static class Dog{
        private String name;
        private int age;
        public Person person;

        public Dog(String name,int age){
            this.name=name;
            this.age=age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person getPerson() {
            System.out.println(this.name+"(狗狗名字)："+"主人姓名："+person.getName()+" ,电话号码："+person.getPhoneNum());
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        @Override
        public String toString() {
            return "Demo2.Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Person {
        private String name;
        private long phoneNum;
        public Dog[] dogs;

        public Person(String name,long phoneNum){
            this.name=name;
            this.phoneNum=phoneNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(long phoneNum) {
            this.phoneNum = phoneNum;
        }

        public Dog[] getDogs() {
            return dogs;
        }

        public void setDogs(Dog[] dogs) {
            this.dogs = dogs;
        }

        @Override
        public String toString() {
            return "Demo2.Person{" +
                    "name='" + name + '\'' +
                    ", phoneNum=" + phoneNum +
                    ", dogs=" + Arrays.toString(dogs) +
                    '}';
        }

    }
}
