package boj.p12852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 1];
        int[] prev = new int[N + 1];

        D[1] = 0;
        prev[1] = 0;

        for(int i = 2; i <= N; i++)
        {
            D[i] = D[i - 1] + 1;
            prev[i] = i - 1;
            if(i % 2 == 0 && D[i] > D[i / 2] + 1)
            {
                D[i] = D[i / 2] + 1;
                prev[i] = i / 2;
            }
            if(i % 3 == 0 && D[i] > D[i / 3] + 1)
            {
                D[i] = D[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        sb.append(D[N]).append('\n');

        int cur = N;
        while(cur != 0)
        {
            sb.append(cur).append(' ');
            cur = prev[cur];
        }

        System.out.println(sb);
    }
}