package boj.p1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = N - 1;
        while(M-- > 0)
        {
            sb.append(binarySearch(left, right, Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    static String binarySearch(int left, int right, int target)
    {
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(A[mid] == target)
            {
                return "1";
            }
            else if(A[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return "0";
    }
}
