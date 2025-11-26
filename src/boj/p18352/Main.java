package boj.p18352;

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
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] A;
    static int[] visited;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new int[N + 1];
        Arrays.fill(visited, -1);
        for(int i = 1; i <= N; i++)
        {
            A[i] = new ArrayList<>();
        }
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
        }

        bfs(X);

        for(int i = 1; i <= N; i++)
        {
            if(visited[i] == K) sb.append(i).append("\n");
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    static void bfs(int v)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(v);
        visited[v] = 0;
        while(!dq.isEmpty())
        {
            int now = dq.poll();
            for(int next : A[now])
            {
                if(visited[next] == -1)
                {
                    visited[next] = visited[now] + 1;
                    dq.offer(next);
                }
            }
        }
    }
}