package boj.p1850;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = gcd(A,B);
        while(result-- > 0)
        {
            sb.append("1");
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b)
    {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}