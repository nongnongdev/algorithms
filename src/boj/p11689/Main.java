package boj.p11689;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        while(N-- > 0)
        {
            set.add(br.readLine());
        }

        for(String s : set)
        {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}