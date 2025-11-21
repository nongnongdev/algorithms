package boj.p1904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2]  % 15746;
        }

        System.out.println(dp[N]);
    }
}

/*
N
#N=1
1
1개

#N=2
00 11
2개

#N=3
100 001 111
3개

#N=4
0011, 0000, 1001, 1100, 1111
5개

#N=5
00001, 00100, 10000, 00111, 11001, 10011, 11100, 11111
8개

#N=6
000000, 000011, 001100, 110000, 001111, 110011, 111100, 111111
100001, 001001
10개
13?

#N=7
0000001, 0000100, 0010000, 1000000, 0000111, 0011100, 110000, 0011111, 1100111, 1111100, 1111111
11개
21?

*/
