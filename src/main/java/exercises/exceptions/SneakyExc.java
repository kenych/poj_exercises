package exercises.exceptions;

import lombok.SneakyThrows;

public class SneakyExc {
    public static void main(String[] args) {
        new SneakyExc().sneakyCall();
    }


    @SneakyThrows
    public void sneakyCall(){
        throw new Exception("hehey");
    }
}
