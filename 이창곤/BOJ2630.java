package javapp;

import java.util.*;
import java.io.*;

public class practice {
	static int[][] board;
	static int[] color = {0, 0};	//하얀색 파란색
	
	public static void devide(int n, int x, int y) {
		boolean flg = true;
		
		if(n == 1) {
			color[board[x][y]] += 1;
			return;
		}
		
		for(int i=x; i<n+x; i++) {		//색종이 탐색
			for(int j=y; j<n+y; j++) {
				if(board[x][y] != board[i][j]) {
					flg = false;
					break;
				}				
			}
			if(flg == false) break;
		}
		
		if(flg == true) {
			color[board[x][y]] += 1;	//첫번째 칸 색과 같은 자리 카운트 +1
			return;
		}
		else if(flg == false) {				//재귀
			devide(n/2, x, y);
			devide(n/2, x + n/2, y);
			devide(n/2, x + n/2, y + n/2);
			devide(n/2, x, y + n/2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());	//2 4 8 16 32 64 128
    	
    	board = new int[n][n];
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");    		
    		
    		for(int j=0; j<n; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}

    	devide(n, 0, 0);
    	System.out.println(color[0] + "\n" + color[1]);
    	
	}
}