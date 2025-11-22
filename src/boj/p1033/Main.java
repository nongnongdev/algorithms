package boj.p1033;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static class Edge
    {
        int to;
        long p, q;
        Edge(int to, long p, long q)
        {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }

    static List<Edge>[] adj;
    static long[] amount;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N];
        for(int i = 0; i < N; i++)
        {
            adj[i] = new ArrayList<>();
        }

        long lcm = 1;

        for(int i = 0; i < N - 1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, p, q));
            adj[b].add(new Edge(a, q, p));

            long g = gcd(p, q);

            lcm *= (p / g) * q;
        }

        amount = new long[N];
        visited = new boolean[N];

        amount[0] = lcm;
        dfs(0);

        long g = amount[0];
        for(int i = 1; i < N; i++)
        {
            g = gcd(g, amount[i]);
        }

        for(int i = 0; i < N; i++)
        {
            sb.append(amount[i] / g);
            if(i + 1 < N) sb.append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(int cur)
    {
        visited[cur] = true;

        for(Edge e : adj[cur])
        {
            int next = e.to;
            if(!visited[next])
            {
                amount[next] = amount[cur] * e.q / e.p;
                dfs(next);
            }
        }
    }

    static long gcd(long a, long b)
    {
        while(b != 0)
        {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
