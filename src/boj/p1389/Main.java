package boj.p1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++)
        {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = 1;
            dist[B][A] = 1;
        }

        for(int k = 1; k <= N; k++)
        {
            for(int i = 1; i <= N; i++)
            {
                for(int j = 1; j <= N; j++)
                {
                    if(dist[i][k] == INF || dist[k][j] == INF) continue;
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j] + 1;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 1; i <= N; i++)
        {
            int sum = 0;
            for(int j = 1; j <= N; j++)
            {
                sum += dist[i][j];
            }

            if(sum < min)
            {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}