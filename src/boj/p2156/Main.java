package boj.p2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] wines = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1)
        {
            System.out.println(wines[1]);
            return;
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        for(int i = 3; i <= N; i++)
        {
            // i 안 마셔 dp[i - 1]
            // i 마셔 dp[i - 2] + wines[i]
            // i랑 i - 1 마셔 dp[i - 3] + wines[i - 1] + wines[i]
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }

        System.out.println(dp[N]);
    }
}

/*
#dp의 정의
i는 현재 포도주의 순서 dp[i]는 포두주를 먹은 최대합 누적
#점화식
일단, dp는 무조건 3연속 규칙을 위배하지 않고 잘 맞췄다고 가정함
연속으로 마신 것과 두번째로 첨프한 것과 비교해서 max로 점프
dp[i] = Math.max(dp[i - 2], dp[i - 3] + A[i - 1]) + A[i];

+ i번째 잔 안 마심도 고려해야 돼서 수정
dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
*/