package boj.p15657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static int N, M;

    static int[] arr;
    static int[] picked;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        picked = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtracking(0, 0);

        System.out.print(sb);
    }

    static void backtracking(int depth, int start)
    {
        if(depth == M)
        {
            for(int i = 0; i < M; i++)
            {
                sb.append(picked[i]).append(' ');
            }

            sb.append('\n');
            return;
        }

        for(int i = start; i < N; i++)
        {
            picked[depth] = arr[i];
            backtracking(depth + 1, i);
        }
    }
}