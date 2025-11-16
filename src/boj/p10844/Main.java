package boj.p10844;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long mod = 1000000000;
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N + 1][11];
        for(int i = 1; i <= 9; i++)
        {
            D[1][i] = 1;
        }

        for(int i = 2; i <= N; i++)
        {
            D[i][0] = D[i - 1][1];
            D[i][9] = D[i - 1][8];
            for(int j = 1; j <= 8; j++)
            {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++)
        {
            sum = (sum + D[N][i]) % mod;
        }

        System.out.println(sum);
    }
}
