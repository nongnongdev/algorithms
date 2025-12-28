package boj.p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {

    static class Subject
    {
        int start, end;
        Subject(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Subject> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.start == o2.start) return Integer.compare(o1.end, o2.end);
            return Integer.compare(o1.start, o2.start);
        });

        for(int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Subject(start, end));
        }

        PriorityQueue<Integer> endPq = new PriorityQueue<>();

        while(!pq.isEmpty())
        {
            Subject cur = pq.poll();

            if(!endPq.isEmpty() && endPq.peek() <= cur.start)
            {
                endPq.poll();
            }

            endPq.offer(cur.end);
        }

        System.out.println(endPq.size());
    }
}