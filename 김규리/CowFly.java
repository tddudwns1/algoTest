package gitCodding;

import java.io.*;
import java.util.*;

public class CowFly {
	static HashSet<Integer> set = new HashSet<>();
	static int cows[];
	static boolean visited[];
	static int result;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cows = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(st2.nextToken());
		}

		combination(0, 0, 0);
		
		ArrayList<Integer> comb = new ArrayList<>(set);

		Collections.sort(comb);

		if(comb.size() == 0) {
			System.out.println(-1);
		}
		else{
			for(int i:comb) {
				System.out.print(i + " ");
			}
		}

	}
	
	static void combination(int s, int d, int result) {
		if(d == M) {
			if(prime(result) == true) {
				set.add(result);
			}
			return;
		}
		
		for(int i = s; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i+1, d+1, result + cows[i]);
				visited[i] = false;
			}
		}
	}
	
	static boolean prime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
