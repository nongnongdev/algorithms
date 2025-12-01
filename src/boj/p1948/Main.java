package boj.p1948;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static class Node
    {
        int place, time;
        Node(int place, int time)
        {
            this.place = place;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Node>[] A = new ArrayList[n + 1];
        List<Node>[] revA = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++)
        {
            A[i] = new ArrayList<>();
            revA[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        while(m-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[u].add(new Node(v, w));
            ++indegree[v];
            revA[v].add(new Node(u, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(startCity);
        while(!dq.isEmpty())
        {
            int cur = dq.poll();
            for(Node next : A[cur])
            {
                int v = next.place;
                int w = next.time;

                dist[v] = Math.max(dist[v], dist[cur] + w);

                --indegree[v];
                if(indegree[v] == 0)
                {
                    dq.offer(v);
                }
            }
        }
        sb.append(dist[endCity]).append('\n');

        dq = new ArrayDeque<>();
        dq.offer(endCity);
        visited[endCity] = true;
        int roadCount = 0;
        while(!dq.isEmpty())
        {
            int cur = dq.poll();
            for(Node prev : revA[cur])
            {
                int u = prev.place;
                int w = prev.time;
                if(dist[cur] == dist[u] + w)
                {
                    ++roadCount;
                    if(!visited[u])
                    {
                        visited[u] = true;
                        dq.offer(u);
                    }
                }
            }
        }
        sb.append(roadCount);

        System.out.println(sb);
    }
}


