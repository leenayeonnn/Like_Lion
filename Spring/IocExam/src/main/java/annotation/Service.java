package annotation;

public class Service {
    @PrintAnnotation("!")
    public void method1(){
        System.out.println("method1");
    }
    @PrintAnnotation("@")
    public void method2(){
        System.out.println("method2");
    }
    @PrintAnnotation("#")
    public void method3(){
        System.out.println("method3");
    }
    @PrintAnnotation(value = "$", number = 10)
    public void method4(){
        System.out.println("method4");
    }

}
