package boj.p7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> dq = new ArrayDeque<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
            {
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] == 1)
                {
                    visited[i][j] = true;
                    dq.offer(new int[]{i, j});
                }
            }
        }

        while(!dq.isEmpty())
        {
            int[] now = dq.poll();
            for(int i = 0; i < 4; i++)
            {
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(A[nr][nc] == -1) continue;
                if(!visited[nr][nc] && A[nr][nc] == 0)
                {
                    visited[nr][nc] = true;
                    A[nr][nc] = A[now[0]][now[1]] + 1;
                    dq.offer(new int[]{nr, nc});
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if(A[i][j] == 0)
                {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, A[i][j] - 1);
            }
        }

        System.out.println(max);
    }
}
