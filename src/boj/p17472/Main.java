package boj.p17472;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int isLandCount;
    static final int INF = 1_000_000;
    static int[] parent;

    static class Edge
    {
        int u, v, w;
        Edge(int u, int v, int w)
        {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isLandCount = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if(map[i][j] == 1 && !visited[i][j])
                {
                    isLandCount++;
                    bfsLabel(i, j, isLandCount);
                }
            }
        }

        if(isLandCount <= 1)
        {
            System.out.println(0);
            return;
        }

        int[][] dist = new int[isLandCount + 1][isLandCount + 1];
        for(int i = 1; i <= isLandCount; i++)
        {
            Arrays.fill(dist[i], INF);
        }

        for(int x = 0; x < N; x++)
        {
            for(int y = 0; y < M; y++)
            {
                if(map[x][y] == 0) continue;

                int from = map[x][y];
                for(int d = 0; d < 4; d++)
                {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int len = 0;

                    while(true)
                    {
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                        if(map[nx][ny] == from) break;

                        if(map[nx][ny] == 0)
                        {
                            len++;
                            nx += dx[d];
                            ny += dy[d];
                        }
                        else
                        {
                            if(len >= 2)
                            {
                                int to = map[nx][ny];
                                if(dist[from][to] > len)
                                {
                                    dist[from][to] = len;
                                    dist[to][from] = len;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        List<Edge> edges = new ArrayList<>();
        for(int i = 1; i <= isLandCount; i++)
        {
            for(int j = i + 1; j <= isLandCount; j++)
            {
                if(dist[i][j] != INF) edges.add(new Edge(i, j, dist[i][j]));
            }
        }

        if(edges.isEmpty())
        {
            System.out.println(-1);
            return;
        }

        Collections.sort(edges, (e1, e2) -> e1.w - e2.w);

        parent = new int[isLandCount + 1];
        for(int i = 1; i <= isLandCount; i++) parent[i] = i;

        int used = 0;
        int answer = 0;

        for(Edge e : edges)
        {
            if(union(e.u, e.v))
            {
                answer += e.w;
                used++;
                if(used == isLandCount - 1) break;
            }
        }

        if(used != isLandCount - 1) System.out.println(-1);
        else System.out.println(answer);
    }

    static void bfsLabel(int sx, int sy, int id)
    {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        map[sx][sy] = id;

        while(!dq.isEmpty())
        {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 4; d++)
            {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(!visited[nx][ny] && map[nx][ny] == 1)
                {
                    visited[nx][ny] = true;
                    map[nx][ny] = id;
                    dq.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static int find(int x)
    {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parent[b] = a;
        return true;
    }
}