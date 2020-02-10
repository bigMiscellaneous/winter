package Annot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.解析注解
        //1.1获取类的字节码文件对象
        Class<Demo> d = Demo.class;
        //2.获取上边的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
                public class Annotion implements Annotion{
                    public String className(){
                        return "Annot.Person";
                    }
                    public String methodName(){
                        return "show";
                    }
                }
         */
        Annotion a = d.getAnnotation(Annotion.class);
        String className = a.className();
        String methodName = a.methodName();
//        System.out.println(className);
//        System.out.println(methodName);

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
