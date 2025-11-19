package boj.p1328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long mod = 1000000007;
        long[][][] D = new long[101][101][101];
        D[1][1][1] = 1;
        for(int i = 2; i <= N; i++)
        {
            for(int j = 1; j <= L; j++)
            {
                for(int k = 1; k <= R; k++)
                {
                    D[i][j][k] = (D[i - 1][j][k] * (i - 2) + (D[i - 1][j][k - 1] + D[i - 1][j - 1][k])) % mod;
                }
            }
        }

        System.out.println(D[N][L][R]);
    }
}