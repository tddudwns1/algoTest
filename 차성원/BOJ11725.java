package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ11725 {
	static List<Integer>[] g;
	static int[] answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		g=new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			g[i]=new ArrayList<>();
		}
		for(int i =1;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			g[a].add(b);
			g[b].add(a);
		}
		answer=new int[n+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		answer[1]=1;
		queue.add(1);
		while(!queue.isEmpty()) {
			int head = queue.poll();
			for(int x:g[head]) {
				if(answer[x]!=0) continue;
				queue.add(x);
				answer[x]=head;
			}
		}
		for(int i=2;i<n+1;i++)
			System.out.println(answer[i]);
	}
	
}