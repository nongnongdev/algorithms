package boj.p2251;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static int A;
    static int B;
    static int C;
    static boolean[][] visited;
    static boolean[] possible;
    static Deque<int[]> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[A + 1][B + 1];
        possible = new boolean[C + 1];

        bfs();

        for(int c = 0; c <= C; c++)
        {
            if(possible[c]) sb.append(c).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs()
    {
        visited[0][0] = true;
        possible[C] = true;
        dq.offer(new int[]{0, 0});
        while(!dq.isEmpty())
        {
            int[] now = dq.poll();
            int a = now[0];
            int b = now[1];
            int c = C - a - b;

            move(a, b, c, 0, 1);
            move(a, b, c, 0, 2);
            move(a, b, c, 1, 0);
            move(a, b, c, 1, 2);
            move(a, b, c, 2, 0);
            move(a, b, c, 2, 1);
        }
    }

    static void move(int a, int b, int c, int fromIdx, int toIdx)
    {
        int[] cur = {a, b, c};
        int[] cap = {A, B, C};
        int from = cur[fromIdx];
        int to = cur[toIdx];
        if(from == 0) return;
        int canTake = cap[toIdx] - to;
        int pourAmount = Math.min(from, canTake);

        cur[fromIdx] -= pourAmount;
        cur[toIdx] += pourAmount;

        int na = cur[0];
        int nb = cur[1];
        int nc = cur[2];
        if(!visited[na][nb])
        {
            visited[na][nb] = true;
            dq.offer(new int[]{na, nb});
            if(na == 0) possible[nc] = true;
        }
    }
}

