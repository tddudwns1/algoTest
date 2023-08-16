package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dh = {0, 0, -1 ,1, -1, 1, -1, 1}; // 대각선까지
	static int[] dw = {-1, 1, 0, 0, 1, 1, -1, -1};

	static int w;
	static int h;
	static int[][] arr;
	static boolean[][] visit;
	
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		visit[x][y] = true;
		q.offer(new Node(x, y));

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 8; i++) {
				int nh = node.x + dh[i];
				int nw = node.y + dw[i];

				if (nh >= 0 && nh < h && nw >= 0 && nw < w && arr[nh][nw] == 1 && !visit[nh][nw]) {
					visit[nh][nw] = true;
					q.offer(new Node(nh, nw));
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		w = 1;
		h = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				return;

			int cnt = 0;

			arr = new int[h][w];
			visit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}

	}
}