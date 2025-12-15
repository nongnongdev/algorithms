package boj.p1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int removeNode;
    static int leafNodeCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;

        for(int i = 0; i < N; i++)
        {
            int node = Integer.parseInt(st.nextToken());

            if(node == -1)
            {
                root = i;
            }
            else
            {
                graph[node].add(i);
                graph[i].add(node);
            }
        }

        removeNode = Integer.parseInt(br.readLine());

        if(removeNode == root)
        {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(leafNodeCnt);
    }

    static void dfs(int node)
    {
        visited[node] = true;
        int cNode = 0;
        for(int next : graph[node])
        {
            if(!visited[next] && next != removeNode)
            {
                cNode++;
                dfs(next);
            }
        }

        if(cNode == 0) ++leafNodeCnt;
    }
}