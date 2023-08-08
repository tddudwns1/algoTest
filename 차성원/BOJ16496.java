package algoTest.차성원;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


class BOJ16496 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o2, String o1) {
                int i2 = -1;
                int i1 = -1;
                int flag=1;
                if(o1.length()>o2.length()) {
                	String tmp = o1;
                	o1 = o2;
                	o2 = tmp;
                	flag=-1;
                }
                while (true) {
                    i1++;
                    i2++;
                    if (i1 < o1.length() && i2 < o2.length()) {
                        if (o1.charAt(i1) == o2.charAt(i2)) {
                            continue;
                        }
                        return (o1.charAt(i1) - o2.charAt(i2))*flag;
                    } else {
                        i1%=o1.length();
                        while (i2<o2.length() && o1.charAt(i1) == o2.charAt(i2)) {
                            i2++;
                            i1++;
                            i1%=o1.length();
                        }
                        if(i2>=o2.length()) {
                            return (o1.charAt(i1)-o2.charAt(i2-1))*flag;
                        }
                        return (o1.charAt(i1)- o2.charAt(i2))*flag;
                    }
                }
            }
        });

        StringBuilder sBuilder = new StringBuilder();
        boolean zero = true;
        for (String x : arr) {
            sBuilder.append(x);
            if(!x.equals("0")) zero = false;
        }
        if (zero) {
            System.out.println(0);
        } else {
            System.out.println(sBuilder);
        }
    }
}