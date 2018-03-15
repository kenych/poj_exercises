package exercises;

import org.junit.Ignore;
import org.junit.Test;

public class TestIgnore {

    @Test
    @Ignore
    public void ignored(){
        System.out.println("you should not see this message");
    }


}
