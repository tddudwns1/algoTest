package javapp;

import java.util.*;
import java.io.*;

public class Main {
	static int[] answer = new int[10];
	static int[] yj = new int[10];
	static int total = 0;
	
	public static void dfs(int depth) {
		if(depth == 10) {
			int cnt = 0;
			for(int i=0; i<10; i++) {
				if(yj[i] == answer[i]) {
					cnt++;
				}
				if(cnt >= 5) {				//5문제 맞았으면 토탈++
				total ++;
				return;
				}
			}		
			return;
		}
		
		for(int i=1; i<=5; i++) {		//1번~5번						//같은 답을 세번 연속 찍으면 안되기 때문에
			if(depth > 1) {											//두 문제 이상 풀었을 때
				if(yj[depth - 2] == i && yj[depth - 1] == i ) {		//앞에 두 문제와 같으면 컨티뉴
					continue;
				}
			}
			yj[depth] = i;
			dfs(depth + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<10; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(total);
	}
}









