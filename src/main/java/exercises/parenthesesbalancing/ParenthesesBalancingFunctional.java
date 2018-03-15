package exercises.parenthesesbalancing;

public class ParenthesesBalancingFunctional implements ParenthesesBalancing {

    @Override
    public boolean validate(String s) {
        return validate(s, 0, 0);
    }

    private boolean validate(String str, int open, int close) {
        return (close = str.charAt(0) == ')' ? ++close : close) > (open = str.charAt(0) == '(' ? ++open : open) ?
                false :
                str.length() == 1 ?
                        open == close :
                        validate(str.substring(1), open, close);
    }
}
