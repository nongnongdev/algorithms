package boj.p1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] left = new int[26];
    static int[] right = new int[26];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < 26; i++)
        {
            left[i] = -1;
            right[i] = -1;
        }

        while(N-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            int parent = p - 'A';
            if(l != '.') left[parent] = l - 'A';
            if(r != '.') right[parent] = r - 'A';
        }

        int root = 0;

        preorder(root);
        sb.append('\n');

        inorder(root);
        sb.append('\n');

        postorder(root);
        sb.append('\n');

        System.out.print(sb);
    }

    static void preorder(int node)
    {
        if(node == -1) return;

        sb.append((char)(node + 'A'));
        preorder(left[node]);
        preorder(right[node]);
    }

    static void inorder(int node)
    {
        if(node == -1) return;

        inorder(left[node]);
        sb.append((char)(node + 'A'));
        inorder(right[node]);
    }

    static void postorder(int node)
    {
        if(node == -1) return;

        postorder(left[node]);
        postorder(right[node]);
        sb.append((char)(node + 'A'));
    }
}
