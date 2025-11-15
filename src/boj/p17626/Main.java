package boj.p17626;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/*
dp[1] = 1; 1^2
dp[2] = 2; 1^2 + 1^2
dp[3] = 3; 1^2 + 1^2 + 1^2
dp[4] = 1; 2^2
dp[5] = 2; 2^2 + 1^2
dp[6] = 3; 2^2 + 1^2 + 1^2
dp[7] = 4; 2^2 + 1^2 + 1^2 + 1^2
dp[8] = 2; 2^2 + 2^2
dp[9] = 1; 3^2
dp[10] = 2; 3^2 + 1^2
dp[11] = 3; 3^2 + 1^2 + 1^2
dp[12] = 3; 2^2 + 2^2 + 2^2
dp[13] = 2; 3^2 + 2^2
dp[16] = 1; 4^2
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 4);
        dp[0] = 0;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j * j <= i; j++)
            {
                int sq = j * j;
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
