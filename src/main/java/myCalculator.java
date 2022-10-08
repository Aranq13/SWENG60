// imports

import java.util.*;

public class myCalculator {
    public static int parse(String input) {
        input.replaceAll("\\s+",""); // remove whitespace (if any)
        String operators[] = input.split("[0-9]+"); // find character literals 0-9, match more than one times
        String operands[]= input.split("(?<=\\d)[+*-]"); // +, - or * is followed by digit
        int eq = Integer.parseInt(operands[0]); // turn string numbers into integer
        for (int i = 1; i < operands.length; i++) { // recuris
            if(operators[i].equals("+")) {
                eq += Integer.parseInt(operands[i]); 
            } else if(operators[i].equals("-")) {
                eq += Integer.parseInt(operands[i]);
            } else {
                eq *= Integer.parseInt(operands[i]);
            }
        }
        return eq;
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
                    int answer = parse(equation);
                System.out.println("Answer: " + answer);
                }
            } catch(java.lang.Exception e) {e.printStackTrace();}
            }
        }
    
