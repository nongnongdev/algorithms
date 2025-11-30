package boj.p1043;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        int[] know = new int[knowCnt];
        for(int i = 0; i < knowCnt; i++)
        {
            know[i] = Integer.parseInt(st.nextToken());
        }

        int[][] party = new int[M][];
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            party[i] = new int[k];
            for(int j = 0; j < k; j++)
            {
                party[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j < k; j++)
            {
                union(party[i][0], party[i][j]);
            }
        }

        boolean[] truthRoot =  new boolean[N + 1];
        for(int i = 0; i < knowCnt; i++)
        {
            truthRoot[find(know[i])] = true;
        }

        int result = 0;
        for(int i = 0; i < M; i++)
        {
            boolean canLie = true;
            for(int person : party[i])
            {
                if(truthRoot[find(person)])
                {
                    canLie = false;
                    break;
                }
            }
            if(canLie) ++result;
        }

        System.out.println(result);
    }

    static void union(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;

        parent[rootB] = rootA;
    }

    static int find(int x)
    {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}