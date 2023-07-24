package gitCodding;

import java.io.*;
import java.util.*;

public class OrganicCabbage {
	
	static int graphs[][];
	static boolean visited[][];
	static int M;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			graphs = new int[M][N];
			visited = new boolean[M][N];
			
			for(int j = 0; j < K; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				
				int X = Integer.parseInt(st2.nextToken());
				int Y = Integer.parseInt(st2.nextToken());
				
				graphs[X][Y] = 1;
			}
			
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < N; k++) {
					if(graphs[j][k] == 1) {
						BFS(j, k);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		
		int dx[] = {0, 0, -1, 1};
		int dy[] = {1, -1, 0, 0};
		
		q.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int g_x = node.x;
			int g_y = node.y;
			
			for(int i = 0; i < dx.length; i++) {
				
				int nx = g_x + dx[i];
				int ny = g_y + dy[i];
				
				if(nx >= 0 && nx < M && ny >= 0 && ny < N) {				
					if(graphs[nx][ny] == 1) {
						graphs[nx][ny] = 0;
						q.offer(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}
