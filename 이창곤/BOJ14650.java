package algoProj;

import java.io.*;

class Main {
	static int N;
	static int cnt;
	
	static int addNum(int a, String num) {		//뒤에 숫자 추가해서 리턴
		return Integer.parseInt(Integer.toString(a) + num);
	}
	
	static void recur(int depth, int a) {
		if(depth == N) {
			if(a % 3 == 0) cnt++;
			return;
		}
		
		recur(depth + 1, addNum(a, "0"));
		recur(depth + 1, addNum(a, "1"));
		recur(depth + 1, addNum(a, "2"));
	}
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	cnt = 0;
    	
    	recur(1, 1);
    	recur(1, 2);
    	
    	System.out.println(cnt);
    }
}