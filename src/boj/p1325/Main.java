package boj.p1325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static int[] dist;
    static boolean[] visited;
    static List<Integer>[] A;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++)
        {
            A[i] = new ArrayList<>();
        }

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            A[s].add(e);
        }


        for(int i = 1; i <= N; i++)
        {
            Arrays.fill(visited, false);
            bfs(i);
        }

        for(int i = 1; i <= N; i++)
        {
            if(dist[i] == max) sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs(int v)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(v);
        ++dist[v];
        visited[v] = true;
        while(!dq.isEmpty())
        {
            int now = dq.poll();
            for(int next : A[now])
            {
                if(!visited[next])
                {
                    ++dist[v];
                    visited[next] = true;
                    dq.offer(next);
                }
            }
        }
        max = Math.max(max, dist[v]);
    }
}