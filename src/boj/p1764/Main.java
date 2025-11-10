package boj.p1764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> heard = new HashSet<>();
        while(N-- > 0)
        {
            heard.add(br.readLine());
        }

        List<String> both = new ArrayList<>();
        while(M-- > 0)
        {
            String name = br.readLine();
            if(heard.contains(name)) both.add(name);
        }

        Collections.sort(both);

        sb.append(both.size()).append('\n');
        for(String name : both)
        {
            sb.append(name).append('\n');
        }

        System.out.println(sb);
    }
}