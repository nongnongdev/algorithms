package boj.p1747;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int LIMIT = 10_000_000;
        boolean[] A = new boolean[LIMIT + 1];
        A[0] = true;
        A[1] = true;

        for(int i = 2; i <= Math.sqrt(LIMIT); i++)
        {
            for(int j = i + i; j <= LIMIT; j += i)
            {
                if(!A[j]) A[j] = true;
            }
        }

        for(int i = N; i <= Math.sqrt(LIMIT); i++)
        {
            if(A[i]) continue;

            if(isPalindrome(i))
            {
                System.out.println(i);
                break;
            }
        }

    }

    static boolean isPalindrome(int target)
    {
        char temp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;
        while(s < e)
        {
            if(temp[s] != temp[e]) return false;

            s++;
            e--;
        }

        return true;
    }
}