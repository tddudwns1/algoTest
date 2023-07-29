package algoProj;

import java.io.*;

public class Main {
	static boolean[] prime = new boolean[10001];
	
	static void primeCheck(int num) {	//체
		
		for(int i=0; i<num; i++) {
			prime[i] = true;
			for(int j=2; j<i; j++) {
				if(i % j == 0) prime[i] = false;				
			}
		}
	}
	
	static void numCheck(int num) {		// 골드바흐 파티션
		int a = num/2;					//차이가 적은 것 부터 찾아감
		int b = num/2;
		
		while(b != 0) {
			if(a + b == num && prime[a] && prime[b]) {
				System.out.println(b + " " + a);
				return;
			}
			a++;
			b--;
		}
	}
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) max = arr[i];
		}
		
		primeCheck(max);
		for(int i=0; i<n; i++) {
			numCheck(arr[i]);
		}
	}
}