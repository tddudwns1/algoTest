package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4948 {
    static boolean[] arr = new boolean[123456*2+1];
    public static void main(String[] args) throws IOException {
        isPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int x = Integer.parseInt(br.readLine());
            if(x==0) break;
            int cnt=0;
            for(int i = x+1;i<=x*2;i++){
                if(!arr[i]) cnt++;
            }
            System.out.println(cnt);
        }

    }
    public static void isPrime(){
        arr[0] = arr[1] = true;
        for(int i = 2;i<Math.sqrt(arr.length);i++){
            if(arr[i]) continue;
            for(int j = i*i;j< arr.length;j+=i){
                arr[j]=true;
            }
        }
    }
}
