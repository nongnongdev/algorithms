package boj.p2108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// 평균 (sum 후 N 나누기)
// 중앙값 N을 2로 나눈 후 + 1 번째 값
// 최빈값 Map에 담아서 MaxCount 갱신해서 그때 최빈값도 갱신
// 범위 max값, min값 담기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int medianIdx = N / 2;
        int maxCnt = 0;
        int maxCntVal = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int[] nums = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++)
        {
            int curNum = Integer.parseInt(br.readLine());

            // 평균
            sum += curNum;

            // 중앙값
            nums[i] = curNum;

            // 최빈값 빌드업
            map.put(curNum, map.getOrDefault(curNum, 0) + 1);

            // 범위 빌드업
            if(curNum > max) max = curNum;
            if(curNum < min) min = curNum;
        }

        Arrays.sort(nums);

        List<Integer> modeNums = new ArrayList<>();
        for(int num : map.keySet())
        {
            int mapNumCnt = map.get(num);
            if(mapNumCnt > maxCnt)
            {
                modeNums.clear();
                maxCnt = mapNumCnt;
                maxCntVal = num;
            }

            if(mapNumCnt == maxCnt)
            {
                modeNums.add(num);
            }
        }

        Collections.sort(modeNums);
        if(modeNums.size() > 1)
        {
            maxCntVal = modeNums.get(1);
        }

        sb.append(Math.round(sum / N)).append('\n');
        sb.append(nums[medianIdx]).append('\n');
        sb.append(maxCntVal).append('\n');
        sb.append(max - min);

        System.out.println(sb);
    }
}