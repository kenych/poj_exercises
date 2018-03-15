package exercises.parenthesesbalancing;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class ParenthesesBalancingFunctionalTest {

    ParenthesesBalancing parenthesesBalancingFunc;
    ParenthesesBalancing parenthesesBalancingImp;

    @Before
    public void setUp() throws Exception {
        parenthesesBalancingFunc = new ParenthesesBalancingFunctional();
        parenthesesBalancingImp = new ParenthesesBalancingImperative();
    }

    @Test
    public void trueWhenEquals() {

        //given
        String s = "((1+2)*(3-7)+3+5())";

        //when
        boolean resultFun = parenthesesBalancingFunc.validate(s);
        boolean resultImp = parenthesesBalancingImp.validate(s);

        //then
        assertThat(resultFun).isTrue();
        assertThat(resultImp).isTrue();

    }

    @Test
    public void falseWhenNonEquals() {

        //given
        String s = "((1+2)*(3-7)+3+5()";

        //when
        boolean resultFun = parenthesesBalancingFunc.validate(s);
        boolean resultImp = parenthesesBalancingImp.validate(s);

        //then
        assertThat(resultFun).isFalse();
        assertThat(resultImp).isFalse();

    }

    @Test
    public void falseWhenStartWithWrongEquals() {

        //given
        String s = ")(";

        //when
        boolean resultFun = parenthesesBalancingFunc.validate(s);
        boolean resultImp = parenthesesBalancingImp.validate(s);

        //then
        assertThat(resultFun).isFalse();
        assertThat(resultImp).isFalse();

    }

    @Test
    public void falseWhenSingle() {

        //given
        String s = "(";

        //when
        boolean resultFun = parenthesesBalancingFunc.validate(s);
        boolean resultImp = parenthesesBalancingImp.validate(s);

        //then
        assertThat(resultFun).isFalse();
        assertThat(resultImp).isFalse();

    }


}
