package koitp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AssemblyLineScheduling {

	static int N, s1, s2, e1, e2;
	static int[][] S;
	static int[][] T;
	static int[][] D;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		s1 = Integer.parseInt(tmp[1]);
		s2 = Integer.parseInt(tmp[2]);
		e1 = Integer.parseInt(tmp[3]);
		e2 = Integer.parseInt(tmp[4]);
		
		S = new int[3][N+1];
		T = new int[3][N];
		D = new int[3][N+1];
		answer = 0;
		
		tmp = br.readLine().split(" ");
		for(int i=0; i<N; i++){
			S[1][i+1] = Integer.parseInt(tmp[i]);
		}
		
		tmp = br.readLine().split(" ");
		for(int i=0; i<N; i++){
			S[2][i+1] = Integer.parseInt(tmp[i]);
		}
		
		tmp = br.readLine().split(" ");
		for(int i=0; i<N-1; i++){
			T[1][i+1] = Integer.parseInt(tmp[i]);
		}
		
		tmp = br.readLine().split(" ");
		for(int i=0; i<N-1; i++){
			T[2][i+1] = Integer.parseInt(tmp[i]);
		}
		
		
		D[1][1] = s1 + S[1][1];
		D[2][1] = s2 + S[2][1];
		
		for(int j=2; j<=N; j++){
			for(int i=1; i<=2; i++){
				D[i][j] = Math.min(D[i][j-1], D[3-i][j-1] + T[3-i][j-1]) + S[i][j];
			}
		}
		
		answer = Math.min(D[1][N] + e1, D[2][N] + e2);
		
		bw.write(answer + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
