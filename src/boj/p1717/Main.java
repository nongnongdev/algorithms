package boj.p1717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++)
        {
            parent[i] = i;
        }
        while(m-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(command == 0) union(a, b);
            if(command == 1)
            {
                if(find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
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
