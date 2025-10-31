package boj.p1744;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> negativePq = new PriorityQueue<>();
        PriorityQueue<Integer> postivePq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        while(N-- > 0)
        {
            int num = Integer.parseInt(br.readLine());
            if(num <= 0)
                negativePq.offer(num);
            else
                postivePq.offer(num);
        }

        int sum = 0;
        while(negativePq.size() >= 2)
        {
            int firstNum = negativePq.poll();
            int secondNum = negativePq.poll();

            sum += firstNum * secondNum;
        }

        if(!negativePq.isEmpty()) sum += negativePq.poll();

        while(postivePq.size() >= 2)
        {
            int firstNum = postivePq.poll();
            int secondNum = postivePq.poll();

            if(firstNum == 1 || secondNum == 1)
            {
                sum += firstNum + secondNum;
            }
            else
            {
                sum += firstNum * secondNum;
            }
        }

        if(!postivePq.isEmpty()) sum += postivePq.poll();

        System.out.println(sum);
    }
}