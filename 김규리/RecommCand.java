package gitCodding;

import java.io.*;
import java.util.*;

public class RecommCand {

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    int S = Integer.parseInt(br.readLine());
	    
	    int recomm[] = new int[S];
	    List<Integer> students = new ArrayList<Integer>();

	    int cnt[] = new int[S + 1];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    for(int i = 0; i < S; i++) {
	        recomm[i] = Integer.parseInt(st.nextToken());            
	    }
	    
	    for(int i:recomm) {
	    	// 아직 한번도 추천을 받지 않았다면
	        if(cnt[i] == 0) {
	        	// 후보자 명단이 사진틀 개수보다 작다면
	        	if(students.size() < N) {
	        		students.add(i);
	        		cnt[i] += 1; // 추천 + 1
	        	}
	        	// 사진틀 개수가 다 찼다면
	        	else {
	        		int s = 0;
	        		int s_v = 100; 
	        		int s_idx = 0;
	        		
	        		for(int j = 0; j < students.size(); j++) {
	        			// j번째 학생의 추천값이 s_v보다 작다면
	        			if(s_v > cnt[students.get(j)]) {
	        				s_v = cnt[students.get(j)]; // s_v값 갱신
	        				s = students.get(j);
	        				s_idx = j; // 해당 학생의 인덱스 값
	        			}
	        		}
	        			
        			cnt[s] = 0;
        			students.remove(s_idx); // 추천이 제일 작은 학생 삭제
        			students.add(i); // 학생 i 추가
        			cnt[i] += 1;
	        	}
	        }
	        // 이미 추천을 받은 학생이라면
	        else {
	        	cnt[i] += 1;
	        }
	        
	    } 
	    
	    Collections.sort(students);
	    
	    for (int i = 0; i < students.size(); i++) {
			System.out.print(students.get(i)+" ");
		}
	}
}