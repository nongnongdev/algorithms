package boj.p1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long Min = Long.parseLong(st.nextToken());
        long Max = Long.parseLong(st.nextToken());
        boolean[] check = new boolean[(int) (Max - Min + 1)];

        for(long i = 2; i * i <= Max; i++)
        {
            long pow = i * i;
            long startIndex = Min / pow;
            if(Min % pow != 0) ++startIndex;

            for(long j = startIndex; pow * j <= Max; j++)
            {
                check[(int) ((j * pow) - Min)] = true;
            }
        }

        int count = 0;
        for(int i = 0; i <= Max - Min; i++)
        {
            if(!check[i]) ++count;
        }

        System.out.println(count);

    }
}