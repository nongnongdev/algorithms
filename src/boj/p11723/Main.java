package boj.p11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(M-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());

            switch(command)
            {
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);
                    break;
                case "check":
                    if(set.contains(x)) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "toggle":
                    if(!set.contains(x)) set.add(x);
                    else set.remove(x);
                    break;
                case "all":
                    for(int i = 1; i <= 20; i++)
                    {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}