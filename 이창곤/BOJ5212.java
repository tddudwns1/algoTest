package algoProj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static char[][] namhae;
	static int R;
	static int C;

	static boolean check50(int x, int y) {	//50년 후를 체크
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
				cnt++;
			}
			else if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(namhae[nx][ny] == '.') cnt++;
			}

		}
		if(cnt >= 3) return false;	//물에 잠기면 f
		return true;				//안잠기면 t
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		namhae = new char[R][C];
		char[][] newNamhae = new char[R][C];

		for(int i=0; i<R; i++) {
			String s = br.readLine();
			
			for(int j=0; j<C; j++) {
				char a = s.charAt(j);
				namhae[i][j] = a;
			}
		}
		//지도 축소를 위한 xy값
		int minX = C;
		int minY = R;
		int maxX = 0;
		int maxY = 0;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(namhae[i][j] == 'X') {
					if(check50(i, j) == true) {//50년 후에 물에 안 잠긴다면 지도를 위한 xy값 갱신
						maxY = Math.max(i,  maxY);
						minY = Math.min(i,  minY);
						maxX = Math.max(j,  maxX);
						minX = Math.min(j,  minX);
						newNamhae[i][j] = 'X';
					} 
					else newNamhae[i][j] = '.';
				}
				else {
					newNamhae[i][j] = '.';
				}
			}
		}
		
		for(int i=minY; i<=maxY; i++) {
			for(int j=minX; j<=maxX; j++) {
				System.out.print(newNamhae[i][j]);
			}
			System.out.println();
		}
	}
}