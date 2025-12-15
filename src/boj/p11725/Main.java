package boj.p11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N - 1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        bfs(1);

        for(int i = 2; i <= N; i++)
        {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int root)
    {
        visited[root] = true;
        parent[root] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty())
        {
            int now = dq.poll();
            for(int next : graph[now])
            {
                if(!visited[next])
                {
                    visited[next] = true;
                    parent[next] = now;
                    dq.offer(next);
                }
            }
        }
    }
}

