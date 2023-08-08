package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//priorityqueue를 선언 
		Queue<Integer> q = new PriorityQueue<>();
		//comparator 클래스를 오버라이드 해 우선순위를 정해 줄 수 있지만
		//기본 값이 최소이기 때문에 이 경우엔 생략가능
		//생략하니까 더 빨랐습니다
		
		
		while(N-->0) {	//N번 반복 멋지게 쓰는 잡기술. 이유는 모르지만 for문 쓴거보다 빠르네요
			int num= Integer.parseInt(br.readLine());
			if(num == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(q.poll());
				}
			}
			else {
				q.add(num);
			}
		}
		
	}
}