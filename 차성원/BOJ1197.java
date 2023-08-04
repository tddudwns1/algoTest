package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 {
	static List<Node>[] graph; 
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V+1];
		for(int i=0;i<V+1;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		visit = new boolean[V+1];
		prim(1);
	}
	
	public static void prim(int s) {
		PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->a.w-b.w);
		int answer = 0;
		//visit[s] = true;
		queue.add(new Node(s, 0));
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(visit[now.v]) continue;
			answer+=now.w;
			visit[now.v]=true;
			for(Node next : graph[now.v]) {
				if(visit[next.v]) continue;
				queue.add(next);
			}
		}
		System.out.println(answer);
	}
	
	static class Node{
		int v;
		int w;
		Node(int v,int w){
			this.v = v;
			this.w = w;
		}
	}
}
