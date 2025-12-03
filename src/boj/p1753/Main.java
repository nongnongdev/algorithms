package boj.p1753;

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
        int v, w;
        Node(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        for(int i = 1; i <= V; i++)
        {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        while(E-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(start);

        for(int i = 1; i <= V; i++)
        {
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra(int start)
    {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.w, o2.w);
        });
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            int nowNode = cur.v;
            int nowWeight = cur.w;

            if(nowWeight > dist[nowNode]) continue;

            for(Node next : graph[nowNode])
            {
                int nextNode = next.v;
                int nextWeight = next.w + nowWeight;
                if(nextWeight < dist[nextNode])
                {
                    dist[nextNode] = nextWeight;
                    pq.offer(new Node(nextNode, nextWeight));
                }
            }
        }
    }
}
