package gitCodding;

import java.io.*;
import java.util.*;

public class ColorPaper {
	
	static int graphs[][];
	static int N;
	static int w;
	static int b;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graphs = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				graphs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0, N);
		
		System.out.println(w);
		System.out.println(b);
	}
	
	public static boolean ColorCheck(int x, int y, int size) {
				// 해당 좌표에서 사이즈 크기 만큼 좌표값 비교
				// 해당 좌표값과 같지 않다면 더 작은 사각형으로 나눠야
				// 되므로 false return
				for(int i = x; i < x + size; i++) {
					for(int j = y; j < y + size; j++) {
						if(graphs[i][j] != graphs[x][y]) {
							return false;
						}
					}
				}
				return true;
	}
	
	public static void DFS(int x, int y, int size) {
		
		if(ColorCheck(x, y, size) == true) {
			// 만약 해당 좌표값이 0일 경우, 
			// 흰색 + 1
			if(graphs[x][y] == 0) {
				w += 1;
			}
			// 만약 해당 좌표값이 1일 경우, 
			// 파란색 + 1 
			if(graphs[x][y] == 1) {
				b += 1;
			}
			return;
		}
		
		// 만약 해당 size 정사각형 모양으로 나눠지지 않을 경우
		// size를 줄임 (길이를 1/2로 줄이기)
		int nsize = size / 2;
		
		DFS(x, y, nsize); // 2사분면
		DFS(x + nsize, y, nsize); // 1사분면
		DFS(x, y + nsize, nsize); // 3사분면
		DFS(x + nsize, y + nsize, nsize); // 4사분면
	}
}
