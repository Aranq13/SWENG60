import java.util.*;

public class myCalculator {

    // return true if 2nd operator has higher or equal precedence to 1st operator
    // otherwise, returns false
    public static int precedence(char o) {
        switch (o) {
            case '+':
            case '-':
                return 1;
            case '*':
                return 2;
            case '(':
            case ')':
                return 3;
        }
        return -1;
    }

    public static boolean stringAcceptor(String input) {
        if (input == null || input.length() == 0) return false;
        int first = 0;
        if ((input.charAt(0) == '-')) {
            first++;
        }
        if ((input.charAt(first) < '0') | (input.charAt(first) > '9')) {
            return false;
        }
        first++;
        if ((input.charAt(input.length() - 1) < '0') | (input.charAt(input.length() - 1) > '9')) {
            return false;
        }
        boolean prevOperator = false;
        for (int i = first; i < input.length(); i++) {
            char next = input.charAt(i);
            if (next == '+' || next == '-' || next == '*') {
                if (prevOperator && next != '-') return false;
                else prevOperator = true;
            } else if (next > '9' || next < '0') {
                return false;
            } else prevOperator = false;
        }

        return true;
    }

    // negative numbers e.g -30 + 3, bugged as + is being popped first
    public static int applyOperator(Stack<Integer> operand, Stack<Character> operators) {
        int x, y;
        // if(operators.size() >= 2) {
        char operator = operators.pop();
        switch (operator) {
            case '+':
                x = operand.pop();
                y = operand.pop();
                return x + y;
            case '-':
                if (operand.size() == 1) {
                    x = operand.pop();
                    return -x;
                } else
                    y = operand.pop();
                x = operand.pop();
                return x - y;
            case '*':
                x = operand.pop();
                y = operand.pop();
                return x * y;
        }
        return 0;
    }

    public static boolean isOperator(char o) {
        return (o == '+' || o == '-' || o == '*');
    }

    public static int evaluate(String input) {
        boolean isNegative = input.charAt(0) == '-';
        boolean prevOperator = true;
        input = input.replaceAll("\\s+", ""); // remove whitespace (if any)
        Stack<Integer> operand = new Stack<>(); // stack for operands
        Stack<Character> operator = new Stack<>(); // stack for operators
        for (int i = 0; i < input.length(); i++) {
            char k = input.charAt(i); // element position
            if (Character.isDigit(k)) { // if operand...
                int number = 0;
                while (Character.isDigit(k)) {
                    number = number * 10 + (k - '0'); // convert to integer
                    i++;
                    if (i < input.length()) { // if more than one digit in number
                        k = input.charAt(i);
                    } else {
                        break;
                    }
                }
                i--;
                if (isNegative) {
                    number = -number;
                    isNegative = false;
                }
                operand.push(number);    // push numbers onto operand stack
                prevOperator = false;
            } else if (k == '(') {    // push opening bracket to operator stack
                operator.push(k);
                prevOperator = true;
            } else if (k == ')') {    // closing bracket solves equation
                while (operator.peek() != '(') {
                    int answer = applyOperator(operand, operator);
                    operand.push(answer);
                }
                operator.pop();
            } else if (isOperator(k)) {    // if current k is an operator

                if ((i == 0 | prevOperator) & k == '-') {
                    isNegative = true;
                }
                if (!prevOperator) {
                    if (i != 0 && operand.size() != 1) {
                        while ((operand.size() >= 2 && precedence(k) <= precedence(operator.peek())) || i + 1 == input.length()) { // if precedence is higher...
                            int out = applyOperator(operand, operator);
                            operand.push(out);

                        }
                    }
                    operator.push(k);
                    prevOperator = true;
                }
            }
        }
        while (!operator.isEmpty() && !operand.isEmpty() && operand.size() >= 2) { // apply remaining operators to remaining numbers
            int out = 0;
            for (int i = 0; i < operand.size(); i++) {
                out = operand.push(applyOperator(operand, operator));
            }
            if (operator.size() != 0)
                out = applyOperator(operand, operator);
            operand.push(out);
        }

        return operand.pop();    // return answer on top of stack
    }


    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Welcome to The String Calculator!\nPlease type exit when ready to exit program.\n\n");
            System.out.println("Please enter your equation: ");
            while (true) {
                String equation = input.nextLine();
                if ("exit".equalsIgnoreCase(equation)) {
                    break;
                }
                if (!stringAcceptor(equation)) {
                    System.out.println("Please enter a valid equation");
                } else {
                    int answer = evaluate(equation);
                    System.out.println("Answer: " + answer);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}