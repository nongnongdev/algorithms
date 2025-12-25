package boj.p10529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static String[] add;
    static String resultWord;

    static int N, M;

    static int[][] addCol;
    static int[] resCol;
    static boolean[] appear = new boolean[26];
    static boolean[] leading = new boolean[26];
    static int[] map = new int[26];
    static int maxLen;
    static int usedMask = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = N - 1;

        add = new String[M];

        maxLen = 0;
        for(int i = 0; i < M; i++)
        {
            add[i] = br.readLine();

            maxLen = Math.max(maxLen, add[i].length());

            markAppear(add[i]);

            int first = charToIdx(add[i].charAt(0));
            leading[first] = true;
        }

        resultWord = br.readLine();

        maxLen = Math.max(maxLen, resultWord.length());

        markAppear(resultWord);

        leading[charToIdx(resultWord.charAt(0))] = true;

        int distinct  = 0;
        for(boolean v : appear) if(v) ++distinct ;

        if(distinct > 10)
        {
            System.out.println(0);
            return;
        }

        addCol = new int[M][maxLen];
        for(int i = 0; i < M; i++) Arrays.fill(addCol[i], -1);

        resCol = new int[maxLen];
        Arrays.fill(resCol, -1);

        for(int i = 0; i < M; i++)
        {
            String s = add[i];
            for(int pos = 0; pos < s.length(); pos++)
            {
                addCol[i][pos] = letterFromRight(s, pos);
            }
        }

        for(int pos = 0; pos < resultWord.length(); pos++)
        {
            resCol[pos] = letterFromRight(resultWord, pos);
        }

        Arrays.fill(map, -1);

        long answer = dfs(0, 0, 0, 0);

        System.out.print(answer);
    }

    static int charToIdx(char ch)
    {
        return ch - 'A';
    }

    static void markAppear(String s)
    {
        for(int i = 0; i < s.length(); i++) appear[charToIdx(s.charAt(i))] = true;
    }

    static int letterFromRight(String s, int pos)
    {
        int idx = s.length() -1 - pos;
        if(idx < 0) return -1;
        return charToIdx(s.charAt(idx));
    }

    static long dfs(int pos, int idx, int carry, int sum)
    {
        if(pos == maxLen) return carry == 0 ? 1L : 0L;

        if(idx < M)
        {
            int letter = addCol[idx][pos];
            if(letter == -1) return dfs(pos, idx + 1, carry, sum);

            if(map[letter] != -1) return dfs(pos, idx + 1, carry, sum + map[letter]);

            long ways = 0;
            for(int digit = 0; digit < 10; digit++)
            {
                if((usedMask & (1 << digit)) != 0) continue;
                if(digit == 0 && leading[letter]) continue;

                map[letter] = digit;
                usedMask |= (1 << digit);

                ways += dfs(pos, idx + 1, carry, sum + digit);

                usedMask &= ~(1 << digit);
                map[letter] = -1;
            }

            return ways;
        }
        else
        {
            int total = sum + carry;
            int need = total % 10;
            int nextCarry = total / 10;

            int letterResult = resCol[pos];

            if(letterResult == -1)
            {
                if(need != 0 || nextCarry != 0) return 0;
                return dfs(pos + 1, 0, 0, 0);
            }

            if(map[letterResult] != -1)
            {
                if(map[letterResult] != need) return 0;
                return dfs(pos + 1, 0, nextCarry, 0);
            }

            if((usedMask & (1 << need)) != 0) return 0;
            if(need == 0 && leading[letterResult]) return 0;

            map[letterResult] = need;
            usedMask |= (1 << need);

            long baseWays = dfs(pos + 1, 0, nextCarry, 0);

            usedMask &= ~(1 << need);
            map[letterResult] = -1;

            return baseWays;
        }
    }
}