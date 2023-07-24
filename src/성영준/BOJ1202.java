package 성영준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ1202 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] map = new int[m][n];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			System.out.println(bfs(k, map));
		}
	}

	private static int bfs(int k, int[][] map) {
		Queue<int[]> gganBu = new LinkedList<int[]>();
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int tot = 0;

		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++)
				if (map[i][j] == 1) {
					gganBu.add(new int[] { i, j });
					map[i][j] = 0;
					while (!gganBu.isEmpty()) {
						int[] checked = gganBu.poll();
						if (--k == 0)
							return tot + 1;
						for (int d = 0; d < 4; d++) {
							int x = checked[0] + dx[d];
							int y = checked[1] + dy[d];
							if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == 1) {
								gganBu.add(new int[] { x, y });
								map[x][y] = 0;
							}
						}
					}
					tot++;
				}
		return 0;
	}
}
