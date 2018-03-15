package exercises.exceptions;

public class Main {

    public static MyReusableException myReusableException = new MyReusableException();

    public static void main(String[] args) {

        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void test1(){

        throw myReusableException;

    }public static void test2(){

        throw new MyReusableException();

    }

}

class MyReusableException extends RuntimeException{

}
