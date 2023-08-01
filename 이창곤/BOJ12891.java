package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());	// 입력받는 문자열 길이 최대 1,000,000
		int m = Integer.parseInt(st.nextToken());	// 만들 비밀번호 길이
		
		String s = br.readLine();
		int[] acgt = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());	// 비밀번호 가능 조건
		}
		
		int result = 0;
		int[] dnaCnt = {0, 0, 0, 0};
		
		for(int i=0; i < m; i++) {					// 처음엔 비밀번호의 길이만큼 체크합니다.
			if(s.charAt(i) == 'A') dnaCnt[0] ++;
			else if(s.charAt(i) == 'C') dnaCnt[1] ++;
			else if(s.charAt(i) == 'G') dnaCnt[2] ++;
			else if(s.charAt(i) == 'T') dnaCnt[3] ++;
		}
		
		if(dnaCnt[0] >= acgt[0] && dnaCnt[1] >= acgt[1] && dnaCnt[2] >= acgt[2] && dnaCnt[3] >= acgt[3]) {			
				result++;							// 비밀번호로 사용 가능하다면 결과 카운트
		}
		
		int f = 0;
		int b = m;
		while(b < n) {								// 슬라이딩 윈도우를 사용해서 끝까지 체크합니다.
			if(s.charAt(f) == 'A') dnaCnt[0] --;
			else if(s.charAt(f) == 'C') dnaCnt[1] --;
			else if(s.charAt(f) == 'G') dnaCnt[2] --;
			else if(s.charAt(f) == 'T') dnaCnt[3] --;
			
			if(s.charAt(b) == 'A') dnaCnt[0] ++;
			else if(s.charAt(b) == 'C') dnaCnt[1] ++;
			else if(s.charAt(b) == 'G') dnaCnt[2] ++;
			else if(s.charAt(b) == 'T') dnaCnt[3] ++;
			
			if(dnaCnt[0] >= acgt[0] && dnaCnt[1] >= acgt[1] && dnaCnt[2] >= acgt[2] && dnaCnt[3] >= acgt[3]) {			
				result++;
			}
			b ++;
			f ++;
		}
		System.out.println(result);
	}
}