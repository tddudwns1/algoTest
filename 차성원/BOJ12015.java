package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> stack = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.add(tmp);
                continue;
            }
            if(stack.get(stack.size()-1)<tmp) {
                stack.add(tmp);
                continue;
            }
            int l = 0;
            int r = stack.size() - 1;
            int mid=0;
            while (l < r) {
                mid = (l+r)/2;
                if(stack.get(mid)<tmp)
                    l=mid+1;
                else
                    r=mid;
            }
            stack.set(l,tmp);
        }
        System.out.println(stack.size());
    }
}