package exercises.collections.refugeecamp;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PrinterImplTest {

    Printer printer = new PrinterImpl();

    @Before
    public void setUp() throws Exception {
        printer.accept(new Job(1));
        printer.accept(new Job(2, 3));
        printer.accept(new Job(3, 2));
        printer.accept(new Job(4));
        printer.accept(new Job(5, 1));
        printer.accept(new Job(6));
    }

    @Test
    public void testAccept() throws Exception {
        assertThat(printer.retrieve()).isEqualTo(new Job(5, 1));
        assertThat(printer.retrieve()).isEqualTo(new Job(3, 2));
        assertThat(printer.retrieve()).isEqualTo(new Job(2, 3));

        assertThat(printer.retrieve()).isEqualTo(new Job(1));
        assertThat(printer.retrieve()).isEqualTo(new Job(4));
        assertThat(printer.retrieve()).isEqualTo(new Job(6));
    }
}
