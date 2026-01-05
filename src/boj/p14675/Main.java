package boj.p14675;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] deg = new int[N + 1];

        for(int i = 0; i < N - 1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            deg[u]++;
            deg[v]++;
        }

        int q = Integer.parseInt(br.readLine());
        while(q-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 1) sb.append(deg[k] >= 2 ? "yes\n" : "no\n");
            else sb.append("yes\n");
        }

        System.out.println(sb);
    }
}
