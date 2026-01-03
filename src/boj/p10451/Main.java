package boj.p10451;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            int[] p = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++)
            {
                p[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N + 1];
            int cycles = 0;

            for(int i = 1; i <= N; i++)
            {
                if(visited[i]) continue;

                int cur = i;
                while(!visited[cur])
                {
                    visited[cur] = true;
                    cur = p[cur];
                }

                cycles++;
            }

            sb.append(cycles).append('\n');
        }

        System.out.println(sb);
    }
}
