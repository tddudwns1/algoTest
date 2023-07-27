package algoTest.차성원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    static class Node{
        long x;
        long cnt;
        public Node(long x,long cnt) {
            this.x=x;
            this.cnt=cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");
        long a = Integer.parseInt(ab[0]);
        long b = Integer.parseInt(ab[1]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 1));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(now.x>b) continue;
            if(now.x == b) {
                System.out.println(now.cnt);
                return;
            }
            queue.add(new Node(now.x * 2, now.cnt+1));
            queue.add(new Node(now.x *10 +1, now.cnt+1));
        }
        System.out.println(-1);
    }

}
