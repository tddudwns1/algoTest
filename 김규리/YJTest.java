package gitCodding;

import java.io.*;
import java.util.*;

public class YJTest {
	
	static int scores[];
	static int test[];
	static int result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		scores = new int[10];
		test = new int[10];
		result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 10; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(0);
		
		System.out.println(result);
	
	}
	
	static void solution(int stack) {
		// 만약 10문제 모두 답을 지정했다면
		if(stack == 10) {
			int cnt = 0;
			// 정답값이랑 비교해서 정답인 문제 카운트
			for(int i = 0; i < 10; i++) {
				if(scores[i] == test[i]){
					cnt += 1;
				}
			}
			// 만약 정답인 문제가 5개 이상이라면
			if(cnt >= 5) {
				result += 1; // 결과값 + 1
			}
			
			return;
		}
		
		// 5지선다 고를 번호
		for(int i = 1; i < 6; i++) {
			
			// 만약 전문제와 전전문제의 답과 같다면 continue
			if(stack > 1 && i == test[stack - 1] && i == test[stack - 2]) {
				continue;
			}
			
			test[stack] = i; // stack번째 문제에 대해 i로 답 지정
			solution(stack + 1); // 재귀
			test[stack] = 0;
		}
	}
}
