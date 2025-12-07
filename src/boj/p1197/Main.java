package boj.p1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static class Edge implements Comparable<Edge>
    {
        int from, to, cost;
        Edge(int from, int to, int cost)
        {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o)
        {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[E];
        parent = new int[V + 1];
        for(int i = 1; i <= V; i++)
        {
            parent[i] = i;
        }

        for(int i = 0; i < E; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }

        Arrays.sort(edges);

        int result = 0;
        int cnt = 0;

        for(Edge e : edges)
        {
            if(union(e.from, e.to))
            {
                result += e.cost;
                cnt++;

                if(cnt == V - 1) break;
            }
        }

        System.out.println(result);
    }

    static boolean union(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;

        if(rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;

        return true;
    }

    static int find(int x)
    {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}