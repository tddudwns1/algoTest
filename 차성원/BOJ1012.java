package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
	static boolean[][] board;
	static int m;
	static int n;
	static int k;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0) //테스트 케이스
		{      //입력
			String[] mnk = br.readLine().split(" ");
			m = Integer.parseInt(mnk[0]);
			n = Integer.parseInt(mnk[1]);
			k = Integer.parseInt(mnk[2]);
			board = new boolean[n][m];
			for(int i=0;i<k;i++) {
				String[] xy = br.readLine().split(" ");
				board[Integer.parseInt(xy[1])][Integer.parseInt(xy[0])] = true;
			}

			int answer=0; //답
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(board[i][j]==true) {
						dfs(i,j);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}
	public static void dfs(int x,int y) {
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
			if(board[nx][ny]==false) continue;
			board[nx][ny] = false;
			dfs(nx, ny);
		}
	}
}
