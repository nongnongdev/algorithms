package boj.p11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static final long INF = Long.MAX_VALUE / 4;
    static long[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new long[n + 1][n + 1];
        for(int i = 1; i <= n; i++)
        {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        while(m-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                {
                    if(dist[i][k] == INF || dist[k][j] == INF) continue;
                    if(dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(dist[i][j] == INF) sb.append("0 ");
                else sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}