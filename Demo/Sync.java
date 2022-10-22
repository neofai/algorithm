public class Sync {
    public String name;

    public Sync(String name) {
        this.name = name;
    }

    public static synchronized void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
