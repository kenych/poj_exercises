package exercises.exceptions;

public class MyEx extends Exception {

    public static void main(String[] args) {
        try {
            new MyEx().exc();
            new MyEx().exc2();
        } catch (MyEx myEx) {
            System.out.println("caught");
//        } catch (Exception e){
//            System.out.println("caught2");
//
        }
    }

    private void exc() throws MyEx {
//        throw new MyEx();
    }

    private void exc2() {
        throw new RuntimeException();
    }
}
