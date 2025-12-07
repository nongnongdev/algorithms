package boj.p7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static class Node
    {
        int h, r, c;
        Node(int h, int r, int c)
        {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] A = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        Deque<Node> dq = new ArrayDeque<>();
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        for(int k = 0; k < H; k++)
        {
            for(int i = 0; i < N; i++)
            {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++)
                {
                    A[k][i][j] = Integer.parseInt(st.nextToken());
                    if(A[k][i][j] == 1)
                    {
                        visited[k][i][j] = true;
                        dq.offer(new Node(k, i, j));
                    }
                }
            }
        }

        while(!dq.isEmpty())
        {
            Node now = dq.poll();
            for(int i = 0; i < 6; i++)
            {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                int nh = now.h + dz[i];
                if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(!visited[nh][nr][nc] && A[nh][nr][nc] == 0)
                {
                    visited[nh][nr][nc] = true;
                    A[nh][nr][nc] = A[now.h][now.r][now.c] + 1;
                    dq.offer(new Node(nh, nr, nc));
                }
            }
        }

        int max = 0;
        for(int k = 0; k < H; k++)
        {
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < M; j++)
                {
                    if(!visited[k][i][j] && A[k][i][j] == 0)
                    {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, A[k][i][j]);
                }
            }
        }

        System.out.println(max - 1);
    }
}