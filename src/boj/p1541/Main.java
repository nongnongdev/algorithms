package boj.p1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] expressions = br.readLine().split("-");
        int result = 0;
        for(int i = 0; i < expressions.length; i++)
        {
            String exp = expressions[i];
            int sum = 0;
            for(String numStr : exp.split("[+]"))
            {
                sum += Integer.parseInt(numStr);
            }

            if(i == 0) result += sum;
            else result -= sum;
        }

        System.out.println(result);
    }
}