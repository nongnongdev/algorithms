package boj.p1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static int[] dist = new int[100_001];
    static boolean[] visited = new boolean[100_001];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(dist[K]);
    }

    static void bfs()
    {
        visited[N] = true;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        while(!dq.isEmpty())
        {
            int now = dq.poll();

            for(int i = 0; i < 3; i++)
            {
                int next = now;
                if(i == 0)
                {
                    next -= 1;
                }

                if(i == 1)
                {
                    next += 1;
                }

                if(i == 2)
                {
                    next *= 2;
                }

                if(next < 0 || next > 100_000) continue;

                if(!visited[next])
                {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    dq.offer(next);
                }
            }
        }
    }
}