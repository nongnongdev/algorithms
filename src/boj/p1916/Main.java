package boj.p1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    static class Node
    {
        int v, cost;
        Node(int v, int cost)
        {
            this.v = v;
            this.cost = cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[startCity].add(new Node(endCity, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity);

        System.out.println(dist[endCity]);
    }

    static void dijkstra(int startCity)
    {
        Arrays.fill(dist, INF);
        dist[startCity] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.cost, o2.cost);
        });
        pq.offer(new Node(startCity, 0));
        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            int nowNode = cur.v;
            int nowCost = cur.cost;

            if(nowCost > dist[nowNode]) continue;

            for(Node next : graph[nowNode])
            {
                int nextNode = next.v;
                int nextCost = next.cost + nowCost;
                if(nextCost < dist[nextNode])
                {
                    dist[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }
    }
}

