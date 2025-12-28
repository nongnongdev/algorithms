package boj.p2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> stack = new ArrayDeque<>();

        String line = br.readLine();

        int tmp = 1;
        int result = 0;

        for(int i = 0; i < line.length(); i++)
        {
            char curChar = line.charAt(i);

            if(curChar == '(')
            {
                stack.push(curChar);
                tmp *= 2;
            }
            else if(curChar == '[')
            {
                stack.push(curChar);
                tmp *= 3;
            }
            else if(curChar == ')')
            {
                if(stack.isEmpty() || stack.peek() != '(')
                {
                    System.out.println(0);
                    return;
                }

                if(i > 0 && line.charAt(i - 1) == '(') result += tmp;

                stack.pop();
                tmp /= 2;
            }
            else if(curChar == ']')
            {
                if(stack.isEmpty() || stack.peek() != '[')
                {
                    System.out.println(0);
                    return;
                }

                if(i > 0 && line.charAt(i - 1) == '[') result += tmp;

                stack.pop();
                tmp /= 3;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}