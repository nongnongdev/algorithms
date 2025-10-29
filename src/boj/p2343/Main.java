package boj.p2343;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] A;
    static int min = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for(int i = 0; i < N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
            right += A[i];
            left = Math.max(left, A[i]);
        }

        binarySearch(left, right);

        System.out.println(min);
    }

    static void binarySearch(int left, int right)
    {
        while(left <= right)
        {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < N; i++)
            {
                if(sum + A[i] > mid)
                {
                    ++count;
                    sum = 0;
                }
                sum = sum + A[i];
            }
            if(sum != 0) ++count;
            if(count > M)
                left = mid + 1;
            else
                right = mid - 1;
        }

        min = left;
    }
}
