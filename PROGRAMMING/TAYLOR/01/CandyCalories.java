import java.util.*;
import java.io.*;

class triple implements Comparable<triple>{
    public String str;
    public int cnt, val;
    public triple(String s, int c, int v) {
        str = s;
        cnt = c;
        val = v;
    }
    public int compareTo(triple other) {
        return Integer.compare(this.val, other.val);
    }
}

public class CandyCalories {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("CandyCalories.in"));
        int n = sc.nextInt();
        sc.nextLine();
        TreeSet<triple> l = new TreeSet<triple>();
        while (n-- > 0) {
            String s = sc.next();
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            l.add(new triple(s, i1, i2));
        }
        //TreeSet already sorted
        int cnt = 0;
        int sm = 0;
        for (triple i : l) {
            if (sm < 1500 && sm + i.val < 1500) {
                int tmp = Math.min(i.cnt, (1499 - sm) / i.val);
                sm += tmp * i.val;
                cnt += tmp;
            }
        }
        System.out.println(cnt);
    }
}