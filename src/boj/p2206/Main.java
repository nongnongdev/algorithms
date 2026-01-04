package boj.p2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    static int N, M;
    static int[][] A;
    static int[][][] dist;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Way
    {
        int row, col;
        boolean usedChance;
        Way(int row, int col, boolean usedChance)
        {
            this.row = row;
            this.col = col;
            this.usedChance = usedChance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        dist = new int[N][M][2];

        for(int i = 0; i < N; i++)
        {
            String line = br.readLine();
            for(int j = 0; j < M; j++)
            {
                A[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        bfs(0, 0);

        int a = dist[N - 1][M - 1][0];
        int b = dist[N - 1][M - 1][1];

        int answer;
        if(a == 0 && b == 0) answer = -1;
        else if(a == 0) answer = b;
        else if(b == 0) answer = a;
        else answer = Math.min(a, b);

        System.out.println(answer);
    }

    static void bfs(int row, int col)
    {
        Deque<Way> dq = new ArrayDeque<>();
        dq.offer(new Way(row, col, false));
        dist[0][0][0] = 1;

        while(!dq.isEmpty())
        {
            Way now = dq.poll();
            int b = now.usedChance ? 1 : 0;

            for(int i = 0; i < 4; i++)
            {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if(A[nr][nc] == 0 && dist[nr][nc][b] == 0)
                {
                    dist[nr][nc][b] = dist[now.row][now.col][b] + 1;
                    dq.offer(new Way(nr, nc, now.usedChance));
                }

                if(A[nr][nc] == 1 && b == 0 && dist[nr][nc][1] == 0)
                {
                    dist[nr][nc][1] = dist[now.row][now.col][0] + 1;
                    dq.offer(new Way(nr, nc, true));
                }
            }
        }
    }
}