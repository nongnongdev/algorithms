package boj.p11657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static class Edge
    {
        int from, to, cost;
        Edge(int from, int to, int cost)
        {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long INF = Long.MAX_VALUE;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }

        if(hasNegativeCycle())
        {
            System.out.println(-1);
            return;
        }

        for(int i = 2; i <= N; i++)
        {
            if(dist[i] == INF) sb.append("-1\n");
            else sb.append(dist[i]).append('\n');
        }

        System.out.println(sb);
    }

    static boolean hasNegativeCycle()
    {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for(int i = 1; i <= N - 1; i++)
        {
            boolean updated = false;
            for(Edge e : edges)
            {
                if(dist[e.from] == INF) continue;
                if(dist[e.to] > dist[e.from] + e.cost)
                {
                    updated = true;
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }

            if(!updated) break;
        }

        for(Edge e : edges)
        {
            if(dist[e.from] == INF) continue;
            if(dist[e.to] > dist[e.from] + e.cost)
            {
                return true;
            }
        }

        return false;
    }
}