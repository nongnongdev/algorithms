package boj.p1976;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++)
            {
                if(Integer.parseInt(st.nextToken()) == 1)
                {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for(int i = 1; i < M; i++)
        {
            int end = Integer.parseInt(st.nextToken());
            if(find(start) != find(end))
            {
                System.out.println("NO");
                return;
            }
            start = end;
        }

        System.out.println("YES");
    }

    static void union(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;

        if(a < b) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }

    static int find(int x)
    {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}