package boj.p1300;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static long N;
    static long K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        K = Long.parseLong(br.readLine());

        System.out.println(binarySearch(1, K));
    }
    static long binarySearch(long left, long right)
    {
        while(left <= right)
        {
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 1; i <= N; i++)
            {
                cnt += Math.min(mid / i, N);
            }

            if(cnt >= K)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}
