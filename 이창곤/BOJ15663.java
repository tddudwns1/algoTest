package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int[] arr;
	static boolean[] visit;
	static List<String> result;
	
	static void recur(int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			//String s = "";
			for(int i=0; i<M; i++) {
				//s += arr[i] + " ";		//스트링으로 만들어서 어레이리스트에 넣음 //처음에 이렇게 했는데 시간초과
				sb.append(arr[i]).append(" ");	//스트링 빌더를 사용하니까 통과 되었습니다.
			}
			if(!result.contains(sb.toString())) result.add(sb.toString()); //겹치는 수열 제거
			return;
		}
		
		for (int i = 0; i < N; i++) {
            if(!visit[i]) {			//안 들어간 수
                arr[depth] = nums[i]; 
                visit[i] = true;
                recur(depth + 1);
                visit[i] = false;
            }
        }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);		//정렬해서 사전 순으로 증가하는 순서 만들기
		result = new ArrayList<>();
		visit = new boolean[N + 1];
		
		recur(0);
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
}