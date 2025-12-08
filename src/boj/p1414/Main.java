package boj.p1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static class Edge
    {
        int u, v, w;
        Edge(int u, int v, int w)
        {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static List<Edge> edges = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i = 0; i < N; i++)
        {
            parent[i] = i;
        }
        int total = 0;
        for(int i = 0; i < N; i++)
        {
            String line = br.readLine();
            for(int j = 0; j < N; j++)
            {
                char curChar = line.charAt(j);
                int curNum = 0;
                if('0' == curChar) continue;
                if(Character.isLowerCase(curChar)) curNum = curChar - 'a' + 1;
                if(Character.isUpperCase(curChar)) curNum = curChar - 'A' + 27;

                total += curNum;
                edges.add(new Edge(i, j, curNum));
            }
        }

        Collections.sort(edges, (e1, e2) -> Integer.compare(e1.w, e2.w));

        int count = 0;
        int result = 0;
        for(Edge e : edges)
        {
            if(union(e.u, e.v))
            {
                result += e.w;
                ++count;

                if(count == N - 1) break;
            }
        }

        System.out.println(count == N - 1 ? total - result : -1);
    }

    static boolean union(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b) return false;

        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    static int find(int x)
    {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
