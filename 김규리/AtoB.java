package gitCodding;

import java.io.*;
import java.util.*;

public class AtoB {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 1;
		
		while(true) {
			if(B%10 == 1) {
				B = B / 10;
				cnt += 1;
			}

			else if(B%2 == 0) {
				B = B / 2;
				cnt += 1;
			}
			else {
				System.out.println(-1);
				break;
			}
			
			if(B == A) {
				System.out.println(cnt);
				break;
			}
			
			if(B < A) {
				System.out.println(-1);
				break;
			}
		}
	}
}
