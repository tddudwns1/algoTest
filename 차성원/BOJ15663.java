package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {
	static int[] arr;
	static int n;
	static int m;
	static boolean[] visit;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		visit = new boolean[n];
		ans = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i =0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permu(0);
	}
	public static void permu(int dep) {
		if(dep==m) {
			for(int x:ans) {
				System.out.print(x+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(visit[i]) continue;
			if(ans[dep]==arr[i]) continue;
			if(dep<m-1) ans[dep+1] = 0;
			visit[i] = true;
			ans[dep] = arr[i];
			permu(dep+1);
			visit[i] = false;
		}
	}
}