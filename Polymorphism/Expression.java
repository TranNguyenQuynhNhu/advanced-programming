package Polymorphism;

import java.util.*;

abstract class Token {}

class NumberToken extends Token {
    long value;

    public NumberToken(long value) {
        this.value = value;
    }
}

class OpToken extends Token {
    char op;

    public OpToken(char op) {
        this.op = op;
    }

    public int precedence() {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public boolean isOperator() {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }
}

public class Expression {
    public static List<Token> infixToPostfix(String s) {
        List<Token> output = new ArrayList<>();
        Stack<OpToken> ops = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                output.add(new NumberToken(num));
                continue;
            }
            if (c == '(') {
                ops.push(new OpToken(c));
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek().op != '(') {
                    output.add(ops.pop());
                }
                ops.pop();
            } else {
                OpToken cur = new OpToken(c);
                while (!ops.isEmpty() && ops.peek().isOperator() && ops.peek().precedence() >= cur.precedence()) {
                    output.add(ops.pop());
                }
                ops.push(cur);
            }
            i++;
        }
        while (!ops.isEmpty()) {
            output.add(ops.pop());
        }
        return output;
    }
    public static long evalPostfix(List<Token> postfix) {
        Stack<Long> st = new Stack<>();
        for (Token t : postfix) {
            if (t instanceof NumberToken) {
                st.push(((NumberToken) t).value);
            } else {
                char op = ((OpToken) t).op;
                long b = st.pop();
                long a = st.pop();
                if (op == '+') st.push(a + b);
                else if (op == '-') st.push(a - b);
                else if (op == '*') st.push(a * b);
                else if (op == '/') st.push(a / b);
            }
        }
        return st.pop();
    }
    public static long evaluate(String expr) {
        List<Token> postfix = infixToPostfix(expr);
        return evalPostfix(postfix);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expr = sc.nextLine();

        System.out.println(evaluate(expr));
    }
}
