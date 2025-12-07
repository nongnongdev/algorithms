package boj.p20040;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
        }

        int lastTurn = 0;
        for(int i = 1; i <= m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int firstPoint = Integer.parseInt(st.nextToken());
            int secondPoint = Integer.parseInt(st.nextToken());
            if(find(firstPoint) == find(secondPoint))
            {
                lastTurn = i;
                break;
            }
            union(firstPoint, secondPoint);
        }

        System.out.println(lastTurn);
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
