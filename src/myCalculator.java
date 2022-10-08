package src;

// imports

import java.util.*;

public class myCalculator {

    // return true if 2nd operator has higher or equal precendence to 1st operator
    // otherwise, returns false
    public static boolean hasPrecedence(char operator1, char operator2) {
        if (operator2 == '(' || operator2 == ')') return false;
        if ((operator1 == '*') && (operator2 == '+' || operator2 == '-')) return false;
        else return true;
    }

    public static int applyOperator(char operator, int x, int y) {
        switch(operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y; 
        }
        return 0;
    }

    public static int evaluate(String input) {
        input.replaceAll("\\s+",""); // remove whitespace (if any)
        char[] element = input.toCharArray(); // add individual char to char array
        Stack<Integer> operand = new Stack<Integer>(); // stack for operands
        Stack<Character> operator = new Stack<Character>(); // stack for operators
        for (int i = 0; i < element.length; i++) {
            if (element[i] >= '0' && element[i] <= '9') { // if number, push to operand stack
                StringBuffer elementbuf = new StringBuffer(); // modifiable strings
                while (i < element.length && element[i] >= '0' && element[i] <= '9') { // x>1 digits
                    elementbuf.append(element[i++]); // add extra digit to number
                    operand.push(Integer.parseInt(elementbuf.toString())); //push number to stack
                }
                i--; // correct offset (i points to next char, for loop decreases i)
            }
            else if (element[i] == '(') {
                operator.push(element[i]); // opening bracket pushes to op
            } else if (element[i] == ')') {  // closing bracket, solves equation in bracket
                while (operator.peek() != '(') {
                    operand.push(applyOperator(operator.pop(), operand.pop(), operand.pop()));
                } 
                operator.pop();
            } else if (element[i] == '+' || element[i] == '-' || element[i] == '*') { // current i is an operator
                // while top of operator stack has = or > precedence to current i
                // apply operator on top of top two elements in operand stack
                while (!operator.empty() && hasPrecedence(element[i], operator.peek())) { 
                    operand.push(applyOperator(operator.pop(), operand.pop(), operand.pop()));
                }
                operator.push(element[i]); // push current element to operator stack
            }
        }
        while (!operator.empty()) { // apply remaining operators to remaining values
            operand.push(applyOperator(operator.pop(), operand.pop(), operand.pop()));
        }
        return operand.pop(); // return answer on top of stack
    }


    public static void main (String[] args) {
            try (Scanner input = new Scanner(System.in)) {
                System.out.println("Welcome to The String Calculator!\nPlease type exit when ready to exit program.\n\n");
                System.out.println("Please enter your equation: ");
                while (true) {
                    String equation = input.nextLine();
                    if ("exit".equalsIgnoreCase(equation)) {
                        break;
                    }
                    int answer = evaluate(equation);
                System.out.println("Answer: " + answer);
                }
            } catch(java.lang.Exception e) {e.printStackTrace();}
            }
        }
    
