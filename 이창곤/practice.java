package javapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice {
	static int[] dx = {-1, 1, 0, 0};	//상 하 우 좌
	static int[] dy = {0, 0, 1, -1};
	
	static int[][] board;
	static boolean[][] visit;
	static int N;
	static int M;
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		//int[] xy = {x, y};
		q.add(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			
			x = xy[0];
			y = xy[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if(visit[nx][ny] == false && board[nx][ny] == 1) {						
						visit[nx][ny] = true;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		
		for(int tc=0; tc<t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());		// 배추밭 가로길이
			N = Integer.parseInt(st.nextToken());		// 배추밥 세로길이
			int K = Integer.parseInt(st.nextToken());		// 배추 개수

			board = new int[M][N];
			visit = new boolean[M][N];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[x][y] = 1;
			}
			
			int cnt = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j] == 1 && visit[i][j] == false) {	//방문한적 없는 배추
						bfs(i, j);
						cnt ++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
}
