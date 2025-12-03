package boj.p16928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static int[] board = new int[101];
    static int[] ladder = new int[101];
    static int[] snake = new int[101];
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        while(N-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x] = y;
        }

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake[u] = v;
        }

        bfs();

        System.out.println(board[100]);
    }

    static void bfs()
    {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        visited[1] = true;

        while(!dq.isEmpty())
        {
            int now = dq.poll();

            for(int i = 1; i <= 6; i++)
            {
                int next = now + i;

                if(next > 100) continue;

                if(ladder[next] != 0) next = ladder[next];
                else if(snake[next] != 0) next = snake[next];

                if(!visited[next])
                {
                    visited[next] = true;
                    board[next] = board[now] + 1;
                    dq.offer(next);
                }
            }
        }
    }
}