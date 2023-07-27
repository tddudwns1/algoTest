package javapp;

import java.util.*;
import java.io.*;

public class practice {
	static int N;
	static int M;
	static int[] cow;
	static boolean[] prime;
	static boolean[] visit;
	static ArrayList<Integer> result = new ArrayList<>();
	
	static void primeCheck() {				//어쩌구의 체를 구현
		int num = 1;
		for(int i=0; i<N; i++) num += cow[i];	//소의 몸무게를 전부 더한 값
		
		prime = new boolean[num];			//소의 몸무게를 전부 더한 값 까지 소수를 구함
		for(int i=2; i<num; i++) {
			prime[i] = true;
			for(int j=2; j<i; j++) {
				if(i % j == 0) prime[i] = false;
				
			}
		}
	}
	
	static void cal(int depth, int m) {	//N개 중에 M개 combination
		if(m == 0) {					
			int a = 0;
			for (int i = 0; i < N; i++) {
				if(visit[i]) {
					a += cow[i];		//재귀가 M마리 일때 visit에 찍힌 소를 다 더함
				}
			}
			
			if(prime[a]) {								//M마리 소의 몸무게를 전부 더했을 때 수가 소수이고
				if(result.contains(a) == false)			//리스트에 없다면 ( 중복 제거 )
					result.add(a);						//어레이 리스트에 더함
			}
			return;
		}
		
		if(depth == N)
			return;
		
		visit[depth] = true;		//재귀
		cal(depth + 1, m - 1);		//뒤로 쭉
		
		visit[depth] = false;
		cal(depth + 1, m);			//뒷 부분 부터
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cow = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)
			cow[i] = Integer.parseInt(st.nextToken());
		
		
		visit = new boolean[N];
		primeCheck();
		cal(0, M);
		
		if(result.size() == 0) {
			System.out.println(-1);
		}
		else {
			Collections.sort(result);					//오름차순 정렬
			for(int i=0; i<result.size(); i++) {
				System.out.print(result.get(i) + " ");
			}
		}
		
	}
}