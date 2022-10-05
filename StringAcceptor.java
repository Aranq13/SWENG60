    boolean stringAcceptor(String input) {

        if ((input.charAt(0) < '0') | (input.charAt(0) > '9')) {
            return false;
        }

        if ((input.charAt(input.length()) < '0') | (input.charAt(input.length()) > '9')) {
            return false;
        }


        boolean prevOperator = false;
        for (int i = 1; i <= input.length(); i++) {
            char next = input.charAt(i);
            if (next == '+' || next == '-' || next == '*') {
                if (prevOperator) return false;
                else prevOperator = true;
            }
            else if ( next > '9') {
                return false;
            }


        }

        return true;

    }
