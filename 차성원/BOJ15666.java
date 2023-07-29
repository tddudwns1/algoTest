package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15666 {
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr =new int[n];
        answer = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0,n,m);
    }
    static void dfs(int s,int cnt,int n,int m){
        if(cnt==m){
            for(int a:answer){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }
        int num = 0;
        for(int i=s;i<n;i++){
            if(num==arr[i]) continue;
            answer[cnt] = arr[i];
            dfs(i,cnt+1,n,m);
            num=arr[i];
        }
    }
}
