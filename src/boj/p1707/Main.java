package boj.p1707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static List<Integer>[] A;
    static int[] color;
    static boolean isPass;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A = new ArrayList[V + 1];
            color = new int[V + 1];
            Arrays.fill(color, -1);
            for(int i = 1; i <= V; i++)
            {
                A[i] = new ArrayList<>();
            }
            while(E-- > 0)
            {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(s);
            }

            isPass = true;
            for(int i = 1; i <= V; i++)
            {
                if(!isPass) break;
                if(color[i] == -1)
                {
                    bfs(i);
                }
            }

            if(isPass) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    static void bfs(int v)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(v);
        color[v] = 0;
        while(!dq.isEmpty())
        {
            int now = dq.poll();
            for(int next : A[now])
            {
                if(color[now] == color[next])
                {
                    isPass = false;
                    return;
                }

                if(color[next] == -1)
                {
                    color[next] = 1 - color[now];
                    dq.offer(next);
                }
            }
        }
    }
}