package boj.p11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long mod = 10007;
        long[] D = new long[1001];
        D[1] = 1;
        D[2] = 2;
        for(int i = 3; i <= N; i++)
        {
            D[i] = (D[i - 1] + D[i - 2]) % mod;
        }

        System.out.println(D[N]);
    }
}