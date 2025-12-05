package boj.p11043;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
            {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++)
        {
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if(dist[i][k] == 1 && dist[k][j] == 1) dist[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}