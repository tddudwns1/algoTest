package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static boolean[] visit;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i =0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
        }
        visit=new boolean[n];
        int ans=0;
        for(int i =0;i<n;i++) {
            if(visit[i]) continue;
            bfs(i);
            ans++;
        }
        System.out.println(ans);
    }
    public static void bfs(int v) {
        visit[v]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next:graph[now]) {
                if(visit[next]) continue;
                queue.add(next);
                visit[next] = true;
            }
        }
    }
}
