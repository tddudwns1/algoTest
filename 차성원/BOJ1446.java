package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ1446 {
	static List<Node>[] arr;
	static boolean[] visit;
	static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		visit = new boolean[d+1];
		arr = new ArrayList[d+1];
		answer = new int[d+1];
		
		for(int i=0;i<=d;i++) {
			arr[i] = new ArrayList<>();
			arr[i].add(new Node(1, i+1));
			answer[i] = i+1;
		}
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(b>d) continue;
			arr[a].add(new Node(c, b));
		}
		dijkstra(d);
	}
	
	public static void dijkstra(int d){
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->a.weight-b.weight);
		pq.add(new Node(0, 0));
		visit[0] = true;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.next == d) break;
			visit[now.next] = true;
			if(now.weight > answer[now.next]) continue;
			for(Node next : arr[now.next]) {
				if(visit[next.next]==true) continue;
				if(now.weight+next.weight>= answer[next.next]) continue;
				answer[next.next] = now.weight+next.weight;
				pq.add(new Node(now.weight+next.weight, next.next));
			}
		}
		System.out.println(answer[d]);
	}
}
class Node {
	int weight;
	int next;

	public Node(int weight, int next) {
		this.weight = weight;
		this.next = next;
	}
}