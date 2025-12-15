package boj.p14425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node
    {
        Node[] child = new Node[26];
        boolean isEnd;
    }

    static Node root = new Node();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(N-- > 0)
        {
            String s = br.readLine();
            insert(s);
        }

        int count = 0;
        while(M-- > 0)
        {
            String s = br.readLine();
            if(search(s)) ++count;
        }

        System.out.println(count);
    }

    static void insert(String s)
    {
        Node cur = root;
        for(int i = 0; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            if(cur.child[idx] == null) cur.child[idx] = new Node();

            cur = cur.child[idx];
        }
        cur.isEnd = true;
    }

    static boolean search(String s)
    {
        Node cur = root;
        for(int i = 0; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            if(cur.child[idx] == null) return false;

            cur = cur.child[idx];
        }

        return cur.isEnd;
    }
}