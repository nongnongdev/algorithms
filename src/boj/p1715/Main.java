package boj.p1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(N-- > 0)
        {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while(pq.size() >= 2)
        {
            int combination = pq.poll() + pq.poll();
            total += combination;
            pq.offer(combination);
        }


        System.out.println(total);
    }
}