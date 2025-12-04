package boj.p1219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

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

    static final long INF = Long.MAX_VALUE / 4;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;
    static int[] earn;
    static int N;
    static int startCity, endCity;
    static boolean[] inNegCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new long[N];
        earn = new int[N];
        inNegCycle = new boolean[N];
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, cost));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            earn[i] = Integer.parseInt(st.nextToken());
        }

        bellmanFord();

        if(dist[endCity] == INF) System.out.println("gg");
        else if(canReachEndFromNegCycle()) System.out.println("Gee");
        else System.out.println(-dist[endCity]);
    }

    static void bellmanFord()
    {
        Arrays.fill(dist, INF);
        dist[startCity] = -earn[startCity];
        for(int i = 0; i < N - 1; i++)
        {
            boolean updated = false;
            for(Edge e : edges)
            {
                if(dist[e.from] == INF) continue;
                if(dist[e.to] > dist[e.from] + e.cost - earn[e.to])
                {
                    updated = true;
                    dist[e.to] = dist[e.from] + e.cost - earn[e.to];
                }
            }

            if(!updated) break;
        }

        for(Edge e : edges)
        {
            if(dist[e.from] == INF) continue;
            if(dist[e.to] > dist[e.from] + e.cost - earn[e.to])
            {
                inNegCycle[e.to] = true;
            }
        }
    }

    static boolean canReachEndFromNegCycle()
    {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++)
        {
            if(inNegCycle[i])
            {
                visited[i] = true;
                dq.offer(i);
            }
        }

        while(!dq.isEmpty())
        {
            int now = dq.poll();
            if(now == endCity) return true;
            for(Edge e : edges)
            {
                if(e.from == now && !visited[e.to])
                {
                    visited[e.to] = true;
                    dq.offer(e.to);
                }
            }
        }

        return false;
    }
}