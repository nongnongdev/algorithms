package boj.p2487;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) p[i] = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        long ans = 1;

        for(int i = 1; i <= N; i++)
        {
            if(visited[i]) continue;

            int cur = i;
            int len = 0;
            while(!visited[cur])
            {
                visited[cur] = true;
                cur = p[cur];
                len++;
            }

            ans = lcm(ans, len);
        }

        System.out.println(ans);
    }

    static long gcd(long a, long b)
    {
        while(b != 0)
        {
            long t = a % b;
            a = b;
            b = t;
        }

        return a;
    }

    static long lcm(long a, long b)
    {
        return a / gcd(a, b) * b;
    }
}
