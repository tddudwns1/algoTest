package algoProj;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] a;
    static boolean[] visit;				//Boolean으로 쓰지 마세요 ㅠㅠ
    static int N;
    static int max = 0;

    static void dfs(int depth) {
        if(depth == N) {
            int total = 0;
            for(int i=1; i<N; i++) {
                total += Math.abs(a[i-1] - a[i]);
            }
            if(total > max) max = total;

            return;
        }

        for(int i=0; i<N; i++) {
            if(visit[i]) continue;		//visit이 false일 때 수행
            
            a[depth] = arr[i];
            visit[i] = true;
            
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine());

        arr = new int[N];
        visit = new boolean[N];
        a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0);
        System.out.println(max);
    }
}