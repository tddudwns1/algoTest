package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1058 {
    static char[][] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr=new char[n][];
        ans=new int[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine().toCharArray();
        }
        int answer=0;
        for(int i=0;i<n;i++){
            search(i,n);
        }
        for(int a:ans){
            answer=answer>a?answer:a;
        }
        System.out.println(answer);
    }
    public static void search(int v,int n){
        for(int i=v+1;i<n;i++){
            if(arr[v][i]=='Y'){
                ans[i]++;
                ans[v]++;
            }
            else{
                for(int j=0;j<n;j++){
                    if(arr[v][j]=='Y' && arr[j][i]=='Y'){
                        ans[v]++;
                        ans[i]++;
                        break;
                    }
                }
            }
        }
    }
}
