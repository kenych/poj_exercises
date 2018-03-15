package exercises.parenthesesbalancing;

public class ParenthesesBalancingImperative implements ParenthesesBalancing {

    @Override
    public boolean validate(String str) {

        int open = 0, close = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '(')
                ++open;
            else if (ch == ')')
                ++close;

            if (close > open) return false;

            if (i == str.length() - 1)
                if (open != close) return false;
        }

        return true;
    }


}