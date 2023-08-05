package algoProj;


import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //후보 수
        int M = Integer.parseInt(br.readLine()); //총 추천 수

        int[] student = new int[101]; //최대 100명

        List<Integer> nomi = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) { 
            int a = Integer.parseInt(st.nextToken());
            student[a]++;        	//투표 받은 학생 +1


            if(!nomi.contains(a) && nomi.size() < N) {    //후보가 안찼고 후보에 없을 때
                nomi.add(a);
            }
            else if(!nomi.contains(a) && nomi.size() >= N) { //후보가 다 찼을 때
                int min = Integer.MAX_VALUE;

                for(int j : nomi) {		//후보 중에 표가 가장 적은 표를 찾아서
                	min = Math.min(student[j], min);
                    
                }

                for(int j=0; j<nomi.size(); j++) {
                    if(student[nomi.get(j)] == min) {
                        student[nomi.get(j)] = 0; 
                        nomi.remove(j);			//가장 적은 표를 가진 사람 중 앞선 사람을 제거
                        nomi.add(a);
                        break;
                    }
                }
            }


        }
        Collections.sort(nomi);
        for(int s : nomi) {
            System.out.print(s + " ");
        }
    }
}