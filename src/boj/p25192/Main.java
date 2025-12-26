package boj.p25192;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        int emoticonCnt = 0;
        for(int i = 0; i < N; i++)
        {
            String log = br.readLine();
            if("ENTER".equals(log))
            {
                set = new HashSet<>();
            }
            else
            {
                if(!set.contains(log))
                {
                    emoticonCnt++;
                    set.add(log);
                }
            }
        }

        System.out.println(emoticonCnt);
    }
}