package boj.p1256;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final long LIMIT = 1_000_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int total = N + M;

        long[][] comb = new long[total + 1][total + 1];
        for(int n = 0; n <= total; n++)
        {
            comb[n][0] = comb[n][n] = 1;
            for (int r = 1; r < n; r++)
            {
                long v = comb[n - 1][r - 1] + comb[n - 1][r];
                comb[n][r] = Math.min(LIMIT, v);
            }
        }

        if (comb[total][N] < K)
        {
            System.out.println(-1);
            return;
        }

        int n = N, m = M;
        while(n > 0 && m > 0)
        {
            long countA = comb[(n - 1) + m][n - 1];

            if (K <= countA)
            {
                sb.append('a');
                n--;
            }
            else
            {
                sb.append('z');
                K -= countA;
                m--;
            }
        }

        while(n-- > 0) sb.append('a');
        while(m-- > 0) sb.append('z');

        System.out.println(sb);
    }
}