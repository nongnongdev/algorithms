package boj.p7662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0)
        {
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

            Map<Integer, Integer> countMap = new HashMap<>();

            int k = Integer.parseInt(br.readLine());
            while(k-- > 0)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if("I".equals(command))
                {
                    minPq.offer(num);
                    maxPq.offer(num);
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                }
                else if("D".equals(command))
                {
                    if(num == 1)
                    {
                        while(!maxPq.isEmpty() && countMap.get(maxPq.peek()) == 0)
                        {
                            maxPq.poll();
                        }

                        if(!maxPq.isEmpty())
                        {
                            int maxNum = maxPq.poll();

                            countMap.put(maxNum, countMap.get(maxNum) -1);
                        }
                    }
                    else if(num == -1)
                    {
                        while(!minPq.isEmpty() && countMap.get(minPq.peek()) == 0)
                        {
                            minPq.poll();
                        }

                        if(!minPq.isEmpty())
                        {
                            int minNum = minPq.poll();

                            countMap.put(minNum, countMap.get(minNum) -1);
                        }
                    }
                }
            }

            while(!maxPq.isEmpty() && countMap.get(maxPq.peek()) == 0)
            {
                maxPq.poll();
            }

            while(!minPq.isEmpty() && countMap.get(minPq.peek()) == 0)
            {
                minPq.poll();
            }

            if(minPq.isEmpty() || maxPq.isEmpty())
            {
                sb.append("EMPTY\n");
                continue;
            }

            sb.append(maxPq.poll()).append(' ').append(minPq.poll()).append('\n');

        }

        System.out.println(sb);
    }
}