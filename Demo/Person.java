public class Person {
    public void eat() {
        System.out.println("吃-公共方法");
    }
    public void eat(String thing) {
        System.out.println("吃啥呢？" + thing + "！- 公共方法");
    }

    private void run() {
        System.out.println("走-私有方法");
    }

    private void run(String place) {
        System.out.println("走哪去?" + place + "-私有方法");
    }
}

