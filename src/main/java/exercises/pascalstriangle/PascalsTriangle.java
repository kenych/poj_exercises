package exercises.pascalstriangle;

import static com.google.common.base.Preconditions.checkArgument;

public class PascalsTriangle {

    public int calculate(int column, int row) {
        checkArgument(column <= row, "In triangle columns can not exceed rows");
        return calc(column, row);
    }

    private int calc(int column, int row) {
        return (row <= 1 || column <= 0 || column == row) ? 1 :
                calc(column - 1, row - 1) + calc(column, row - 1);
    }
}
