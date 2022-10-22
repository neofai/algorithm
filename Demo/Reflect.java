import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflect {
    public static void main(String[] args) {
        // function();

        // 反射调用私有方法
        try {
            Class cls = Class.forName("Person");
            Object o = cls.newInstance();
            Method m = cls.getDeclaredMethod("run");
            m.setAccessible(true);
            m.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *  反射无视泛型的安全检查
     *  通过反射向Integer的List中添加String
     */
    public static void function () {
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        Class c = myList.getClass();

        try {
            Method add = c.getMethod("add", Object.class);
            add.invoke(myList, "abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        myList.add(3);
        System.out.println(myList);
    }
}
