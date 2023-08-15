import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//priorityqueue를 선언 Collections.reverseOrder()로 최대힙을 구성
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		while(N-->0) {	//N번 반복 잡기술. 
			int num= Integer.parseInt(br.readLine());
			if(num == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(q.poll());
				}
			}
			else {
				q.add(num);
			}
		}
		
	}
}