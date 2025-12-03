package boj.p1854;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

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

    static List<Node>[] graph;
    static PriorityQueue<Integer>[] dist;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        dist = new PriorityQueue[n + 1];
        for(int i = 1; i <= n; i++)
        {
            graph[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        while(m-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        dijkstra();

        for(int i = 1; i <= n; i++)
        {
            if(dist[i].size() < k) sb.append("-1\n");
            else sb.append(dist[i].peek()).append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra()
    {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.w, o2.w);
        });
        pq.offer(new Node(1, 0));
        dist[1].offer(0);

        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            int nowNode = cur.v;
            int nowWeight = cur.w;

            for(Node next : graph[nowNode])
            {
                int nextNode = next.v;
                int nextWeight = next.w + nowWeight;
                if(dist[nextNode].size() < k)
                {
                    dist[nextNode].offer(nextWeight);
                    pq.offer(new Node(nextNode, nextWeight));
                }
                else if(dist[nextNode].peek() > nextWeight)
                {
                    dist[nextNode].poll();
                    dist[nextNode].offer(nextWeight);
                    pq.offer(new Node(nextNode, nextWeight));
                }
            }
        }
    }
}