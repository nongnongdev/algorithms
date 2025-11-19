package boj.p1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        dp[0][0] = Integer.parseInt(br.readLine());
        int max = dp[0][0];
        for(int i = 1; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++)
            {
                dp[i][j] = Integer.parseInt(st.nextToken());
                if(j == 0) dp[i][j] += dp[i - 1][0];
                else if(j == i) dp[i][j] += dp[i - 1][j - 1];
                else
                {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}

/*
#dp의 정의
dp는 2차원 형태의 누적합
현재 행과 똑같은 열을 검사할 것(ex. 2행이면 2열까지)
이전 누적합(왼쪽, 오른쪽) 중 Max dp 선택
단, i가 0이면 무조건 위 j가 i면 무조건 -1 선택
max값 갱신하여 마지막에 max값 출력
*/
