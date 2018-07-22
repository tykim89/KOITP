package koitp;

import java.io.*;
import java.util.*;

public class Alliance_TimeOut {

	static int n, q;	// n : 1~100,000   q : 1~200,000
	static ArrayList<ArrayList<Integer>> rel;
	static ArrayDeque<Integer> Q;
	static int[] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = new String[3];
		n = Integer.parseInt(br.readLine());
		q = Integer.parseInt(br.readLine());
		
		rel = new ArrayList<ArrayList<Integer>>();
		Q = new ArrayDeque<Integer>();
		visited = new int[n+1];
				
		for(int i=0; i<=n+1; i++){
			rel.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=q; i++){
			input = br.readLine().split(" ");
			int ques = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			
			if(ques == 0){
				//[1], [2] 노드 동맹맺기
				rel.get(a).add(b);
				rel.get(b).add(a);
			}else{
				//[1], [2] 노드가 동맹인지? 질문에 대답 리턴
				if(a == b){
					answer = 1;
				}else{
					answer = dfs(a, b);
				}

				bw.write(answer + "\n");
			}
		}
		
		bw.close();
	}
	
	public static int dfs(int start, int target){
		int result = 0;
		boolean flag;
		
		Arrays.fill(visited, 0);
		Q.clear();
		Q.add(start);
		while(!Q.isEmpty()){
			int node = Q.poll();
			visited[node] = 1;
			flag = false;
			
			for(int tmp : rel.get(node)){
				if(tmp == target){
					flag = true;
					result = 1;
					break;
				}
				
				if(visited[tmp] == 0 && flag == false){
					Q.add(tmp);
				}
			}
			
			if(flag == true) break;
		}
		
		return result;
	}
	
	
}
