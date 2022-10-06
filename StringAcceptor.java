    static boolean stringAcceptor(String input) {

        int first = 0;
        if ((input.charAt(0) == '-')) {
            first++;
        }

        if ((input.charAt(first) < '0') | (input.charAt(first) > '9')) {
            return false;
        }
        first++;

        if ((input.charAt(input.length()-1) < '0') | (input.charAt(input.length()-1) > '9')) {
            return false;
        }

        boolean prevOperator = false;
        for (int i = first; i < input.length(); i++) {
            char next = input.charAt(i);
            if (next == '+' || next == '-' || next == '*') {
                if (prevOperator && next!='-') return false;
                else prevOperator = true;
            }
            else if ( next > '9' || next < '0') {
                return false;
            } else prevOperator = false;
        }

        return true;
    }
