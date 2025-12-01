package boj.p1516;

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
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] A = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
        {
            A[i] = new ArrayList<>();
        }
        int[] build = new int[N + 1];
        int[] dp = new int[N + 1];
        int[] indegree = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            build[i] = Integer.parseInt(st.nextToken());
            while(true)
            {
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1) break;
                A[pre].add(i);
                ++indegree[i];
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++)
        {
            if(indegree[i] == 0)
            {
                dp[i] = build[i];
                dq.offer(i);
            }
        }

        while(!dq.isEmpty())
        {
            int cur = dq.poll();
            for(int next : A[cur])
            {
                dp[next] = Math.max(dp[next], dp[cur] + build[next]);
                --indegree[next];
                if(indegree[next] == 0) dq.offer(next);
            }
        }

        for(int i = 1; i <= N; i++)
        {
            sb.append(dp[i]).append('\n');
        }

        System.out.println(sb);
    }
}