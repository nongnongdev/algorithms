package boj.p2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] A = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            A[i] = new ArrayList<>();
        }

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            indegree[e]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++)
        {
            if(indegree[i] == 0)
            {
                dq.offer(i);
            }
        }

        while(!dq.isEmpty())
        {
            int now = dq.poll();
            sb.append(now).append(' ');
            for(int next : A[now])
            {
                indegree[next]--;
                if(indegree[next] == 0)
                {
                    dq.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}

