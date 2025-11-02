package boj.p1929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] A = new boolean[N + 1];
        A[0] = true;
        A[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++)
        {
            for(int j = i + i; j <= N; j = j + i)
            {
                A[j] = true;
            }
        }

        for(int i = M; i <= N; i++)
        {
            if(!A[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}