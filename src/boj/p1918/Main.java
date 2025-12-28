package boj.p1918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++)
        {
            char curChar = s.charAt(i);

            if('A' <= curChar && curChar <= 'Z') sb.append(curChar);
            else if(curChar == '(') stack.push(curChar);
            else if(curChar == ')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    sb.append(stack.pop());
                }

                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
            }
            else
            {
                while(!stack.isEmpty() && stack.peek() != '(' && prec(stack.peek()) >= prec(curChar))
                {
                    sb.append(stack.pop());
                }
                stack.push(curChar);
            }
        }

        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int prec(char op)
    {
        if(op == '*' || op == '/') return 2;
        if(op == '+' || op == '-') return 1;
        return 0;
    }
}