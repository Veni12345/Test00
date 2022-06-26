/**
 * @Author : Created by lity25
 * @Date : 2021/11/2 14:23
 * @Description :
 */
class Test1 {
    public static void main(String[] args) {

        String lx = "LeXin";
        String nb = lx;
        lx = "dfsdfds";
        System.out.println(nb);
        split(12);

        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }

    public static int split(int number) {
        if (number > 1) {
            if (number % 2 != 0) {
                System.out.print(split((number + 1) / 2));
            }
            System.out.print(split(number / 2));
        }
        return number;
    }
}
