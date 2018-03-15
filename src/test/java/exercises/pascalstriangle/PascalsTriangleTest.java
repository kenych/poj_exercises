package exercises.pascalstriangle;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PascalsTriangleTest {

    PascalsTriangle pascalsTriangle;

    @Before
    public void setUp() throws Exception {
    pascalsTriangle = new PascalsTriangle();
    }

    @Test
    public void testCalculateEdge()  {

        //given
        int column = 1;
        int row = 2;

        //when
        int result = pascalsTriangle.calculate(column,row);

        assertThat(result).isEqualTo(2);

    }

    @Test
    public void testCalculate()  {

        //given
        int column = 2;
        int row = 4;

        //when
        int result = pascalsTriangle.calculate(column,row);

        assertThat(result).isEqualTo(6);

    }
}
