package boj.p10799;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();

        int lineCnt = 0;

        char prevChar = '(';
        for(int i = 0; i < line.length(); i++)
        {
            char curChar = line.charAt(i);

            if('(' == curChar)
            {
                stack.push(curChar);
            }
            else if(')' == curChar)
            {
                if('(' == prevChar)
                {
                    stack.pop();
                    lineCnt += stack.size();
                }

                if(')' == prevChar)
                {
                    stack.pop();
                    lineCnt += 1;
                }
            }

            prevChar = curChar;
        }

        System.out.println(lineCnt);
    }
}