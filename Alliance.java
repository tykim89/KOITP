package koitp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 테스트케이스
7
9
0 1 3
1 1 7
0 7 6
1 3 7
0 3 7
0 4 2
0 1 3
1 1 7
1 1 1

출력
0
0
1
1
 * 
 * */
public class Alliance {

	static int n, q;	// n : 1~100,000   q : 1 ~ 200,000
	static ArrayList<Integer> node;
	static int[] parent;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = new String[3];
		n = Integer.parseInt(br.readLine());
		q = Integer.parseInt(br.readLine());
		
		node = new ArrayList<Integer>();
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++){
			parent[i] = i;
		}
		
		for(int i=1; i<=q; i++){
			input = br.readLine().split(" ");
			int ques = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			
			if(ques == 0){
				//[1], [2] 노드 동맹맺기
				if(a < b){
					doProcess(a, b);
				}else{
					doProcess(b, a);
				}
			}else{
				//[1], [2] 노드가 동맹인지? 질문에 대답 리턴
				if(a == b){
					answer = 1;
				}else{
					answer = solution(a, b);
				}

				bw.write(answer + "\n");
			}
		}
		
		bw.close();
		
	}

	public static int solution(int a, int b){
		return 0;
	}
	
	public static void doProcess(int small, int big){
		
	}
	
}
