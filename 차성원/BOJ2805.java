package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer=0;
        int l=0;
        int r= Arrays.stream(arr).max().getAsInt();
        while(l<=r){
            int mid = (l+r)/2;
            long tmp=0;
            for(int h : arr){
                if (h>mid){
                    tmp+= h-mid;
                }
            }
            if(tmp<m){
                r=mid-1;
            } else if (tmp>m) {
                answer=mid;
                l=mid+1;
            }else{
                answer=mid;
                break;
            }
        }
        System.out.println(answer);
    }
}
