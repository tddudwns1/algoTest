package gitCodding;

import java.io.*;
import java.util.*;

public class Goldbach {
	//static List<Integer> prime;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		visited = new boolean[10001];
		pri(10000);
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int a = n / 2;
			int b = n / 2;
			
			while(true) {
				if(visited[a] == false && visited[b] == false && a + b == n) {
					System.out.println(a + " " + b);
					break;
				}
				
				a--;
				b++;
			}
		}
	}

	public static void pri(int n) {
		visited[0] = true;
		visited[1] = true;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (visited[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				visited[j] = true;
			}
		}
	}
}
