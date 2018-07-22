package koitp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ROD_CUTTING {
/*
	�ð� ����	�޸� ����	���� Ƚ��	���� Ƚ�� (����)	������ ��
	1.0 ��	512 MB	5574	2346 (42%)	1897
	
	����
	���̰� N�� ����Ⱑ �ִ�. ����⸦ ���̰� �ڿ����� �ǵ��� ���� �������� �ڸ� �� �ִ�. �� ���̿� ���� ����ġ�� ���� ��, ����ġ ���� �ִ밡 �ǵ��� ����⸦ �ڸ���.
	���� ���, ���̰� 4�� ����Ⱑ �ְ� �� ���� �� ����ġ�� �Ʒ��� ���ٰ� ����.

	|  length  | 1 | 2 | 3 | 4 |
	|----------|---|---|---|---|
	|   cost   | 1 | 5 | 8 | 9 |
	�� ��, ���� 2�� ����Ⱑ �� ���� �ǵ��� ��ü ����⸦ �ڸ� ��� ��ü ����ġ�� 10�� �Ǿ� �ִ밡 �ȴ�.

	�Է�
	ù �ٿ� ������� ���� 	N�� �־�����. (1��N��3,000)
	��° �ٿ� N���� �ڿ����� �������� ���еǾ� �־����µ�, i��°�� �־����� ���� ���̰� i�� ������� ����ġ�� �ǹ��Ѵ�. �� �� �־����� ���� 1,000�� ���� �ʴ´�.

	���
	ù �ٿ� ����ġ ���� �ִ밡 �ǵ��� ����⸦ �ڸ� ��, ����ġ ���� ����Ѵ�.

	��Ʈ
	���� �Է�
	4
	1 5 8 9
	���� ���
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
