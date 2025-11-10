package boj.p2470;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
acid 산
alkali 알칼리
-99 -2 -1 4 98
브루토는 시간복잡도(N^2)이므로 투 포인터로 풀이(시간복잡도 O(N log N))
1. 용액을 담는 배열에 용액의 특성값을 담는다.
2. 용액을 담는 배열을 오름차순으로 정렬한다.
3. 왼쪽 포인터, 오른쪽 포인터를 양쪽 끝으로 잡는다.
4. 왼쪽 포인터와 오른쪽 포인터를 섞어서 0에 가장 가까운지 판단한다. 그 기준은 아래와 같다.
- 왼쪽 포인터가 오른쪽 포인터보다 작을 때 까지 반복하는 반복문을 만든다.
- 섞었을 때 0 이면 break 한다.
- 섞었는데 그 값이 음수면 오른쪽 포인터를 한 칸 왼쪽으로 이동한다.
- 섞었는데 그 값이 양수면 왼쪽 포인터를 한 칸 오른쪽으로 이동한다.
- 이전 섞은 값의 절대값보다 포인터를 이동한 뒤 섞은 값이 크면 break 한다.
5. 왼쪽 포인터값과 오른쪽 포인터 값을 출력한다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            solution[i] = num;
        }

        Arrays.sort(solution);

        int left = 0;
        int right = N - 1;
        int bestLeft = 0;
        int bestRight = N - 1;
        int minMix = Integer.MAX_VALUE;
        while(left < right)
        {
            int mix = solution[left] + solution[right];
            int absMix = Math.abs(mix);
            if(absMix < minMix)
            {
                minMix = absMix;
                bestLeft = left;
                bestRight = right;
            }

            if(mix == 0) break;
            else if(mix > 0)
            {
                --right;
            }
            else
            {
                ++left;
            }
        }

        sb.append(solution[bestLeft]).append(" ").append(solution[bestRight]);

        System.out.println(sb);
    }
}