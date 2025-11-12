package boj.p2747;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        D = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            D[i] = -1;
        }

        D[0] = 0;
        D[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            D[i] = D[i - 1] + D[i - 2];
        }
        System.out.println(D[n]);
    }
}