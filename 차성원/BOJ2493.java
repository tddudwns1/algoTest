package algoTest.차성원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BOJ2493 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int[] arr = new int[n];
		StringBuilder sBuilder=new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[0]<x) {
					stack.pop();
					
				}else {
					sBuilder.append(stack.peek()[1]).append(" ");
					break;
				}
			}
			if(stack.isEmpty())
				sBuilder.append("0 ");
			stack.push(new int[] {x,i+1});
		}
		System.out.println(sBuilder);
	}
}
