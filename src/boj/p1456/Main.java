package boj.p1456;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long Min = Long.parseLong(st.nextToken());
        long Max = Long.parseLong(st.nextToken());
        int LIMIT  = 10_000_000;
        long[] A = new long[LIMIT + 1];

        for(int i = 2; i < LIMIT; i++)
        {
            A[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(LIMIT); i++)
        {
            if(A[i] == 0) continue;

            for(int j = i + i; j <= LIMIT; j += i)
            {
                A[j] = 0;
            }
        }

        int count = 0;
        for(int i = 2; i <= LIMIT; i++)
        {
            if(A[i] != 0)
            {
                long p = A[i];
                long val = p * p;
                while(val <= Max)
                {
                    if(val >= Min) ++count;
                    if(val > Max / p) break;
                    val *= p;
                }
            }
        }

        System.out.println(count);
    }
}