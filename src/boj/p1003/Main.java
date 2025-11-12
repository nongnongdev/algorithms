package boj.p1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] cases = new int[T];
        int maxN = 0;
        for(int i = 0; i < T; i++)
        {
            cases[i] = Integer.parseInt(br.readLine());
            if(cases[i] > maxN) maxN = cases[i];
        }

        int[][] cnt = new int[Math.max(2, maxN + 1)][2];
        cnt[0][0] = 1;
        cnt[0][1] = 0;
        cnt[1][0] = 0;
        cnt[1][1] = 1;
        for(int i = 2; i <= maxN; i++)
        {
            cnt[i][0] = cnt[i - 1][0] + cnt[i - 2][0];
            cnt[i][1] = cnt[i - 1][1] + cnt[i - 2][1];
        }

        for(int n : cases)
        {
            sb.append(cnt[n][0]).append(' ').append(cnt[n][1]).append('\n');
        }
        System.out.println(sb);
    }
}