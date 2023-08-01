package gitCodding;

import java.io.*;
import java.util.*;

public class MaxDiff {
	
	static int N;
	static int numArr[];
	static int result;
	static int sum_r;
	static boolean visited[];
	static int mixArr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		mixArr = new int[N];
		visited = new boolean[N];
		result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		MD(0);

		System.out.println(result);

	}
	
	
	public static void MD(int d) {
		if(d == N) {
			sum_r = 0;
			for(int i = 0; i < N - 1; i ++) {
				sum_r += Math.abs(mixArr[i] - mixArr[i+1]);
			}
			
			if(sum_r > result) {
				result = sum_r;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				mixArr[d] = numArr[i];
				MD(d+1);
				visited[i] = false;
			}
		}

	}

}
