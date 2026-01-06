package boj.p17073;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());

        int[] deg = new int[N + 1];

        for(int i = 0; i < N - 1; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            deg[a]++;
            deg[b]++;
        }

        if(N == 1)
        {
            System.out.printf("%.10f\n", (double) W);
            return;
        }

        int leafCount = 0;
        for(int i = 2; i <= N; i++)
        {
            if(deg[i] == 1) leafCount++;
        }

        double ans = (double) W / leafCount;
        System.out.printf("%.10f\n", ans);
    }
}
