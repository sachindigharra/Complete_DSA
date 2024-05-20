

import java.util.Arrays;

public class Backtrackarr {
    public static void backtrackArray(int[]x ,int i){
        // Base Case
        if(i==x.length)return;
        x[i]=i+1;
        backtrackArray(x, i+1);
        // BackTracking Instruction
        x[i]=x[i]-2;

    }
    public static void main(String[] args) {
        int []x=new int[5];
        backtrackArray(x, 0);
        System.out.println(Arrays.toString(x));
    }
}
