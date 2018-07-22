package koitp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ROD_CUTTING {
/*
	시간 제한	메모리 제한	제출 횟수	정답 횟수 (비율)	정답자 수
	1.0 초	512 MB	5574	2346 (42%)	1897
	
	문제
	길이가 N인 막대기가 있다. 막대기를 길이가 자연수가 되도록 여러 조각으로 자를 수 있다. 각 길이에 대해 값어치가 있을 때, 값어치 합이 최대가 되도록 막대기를 자르자.
	예를 들어, 길이가 4인 막대기가 있고 각 길이 별 값어치가 아래와 같다고 하자.

	|  length  | 1 | 2 | 3 | 4 |
	|----------|---|---|---|---|
	|   cost   | 1 | 5 | 8 | 9 |
	이 때, 길이 2인 막대기가 두 개가 되도록 전체 막대기를 자를 경우 전체 값어치가 10이 되어 최대가 된다.

	입력
	첫 줄에 막대기의 길이 	N이 주어진다. (1≤N≤3,000)
	둘째 줄에 N개의 자연수가 공백으로 구분되어 주어지는데, i번째로 주어지는 수는 길이가 i인 막대기의 값어치를 의미한다. 이 때 주어지는 수는 1,000를 넘지 않는다.

	출력
	첫 줄에 값어치 합이 최대가 되도록 막대기를 자를 때, 값어치 합을 출력한다.

	힌트
	예제 입력
	4
	1 5 8 9
	예제 출력
	10
*/	
	
	static int N;
	static int[] D;
	static int[] cost;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		D = new int[N+1];
		cost = new int[N+1];
		
		for(int i=1; i<=N; i++){
			cost[i] = Integer.parseInt(tmp[i-1]);
		}
		
		D[0] = 0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++){
				D[i] = Math.max(D[i], D[i-j] + cost[j]);
			}
		}
		
		
		bw.write(D[N] + "");
		
		bw.flush();
		br.close();
		bw.close();
	}

}
