import java.util.*;
public class Knapsack {
    class Pair
    {
        int weight;
        int value;
        Pair(int weight, int value)
        {
            this.weight = weight;
            this.value = value;
        }
        
    }
    public static double maximumValue(Pair[] items, int n, int w) {
        //ObjectWise Used
        // Write your code here.
        // ITEMS contains {weight, value} pairs.
        double val=0;
        double[][] mat=new double[n][2];
        for(int i=0;i<n;i++){
            mat[i][0]=i;
            mat[i][1]=items[i].value/(double)items[i].weight;
        }
        Arrays.sort(mat,Comparator.comparingDouble(o ->o[1]));
        for(int i=n-1;i>=0;i--){
            if(w>=items[(int)mat[i][0]].weight){
                w=w-items[(int)mat[i][0]].weight;
                val+=items[(int)mat[i][0]].value;
            }
            else{
                val=val+(w*mat[i][1]);
                break;
            }
        }
        return val;
}
    public static int maxValueinKnapsack(int[] weight,int[] value,int W){
        int len=value.length;
        int cap=W;
        int finalval=0;
        double [][]ratio=new double[len][2];
        for(int i=0;i<len;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o ->o[1]));
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(cap>=weight[idx]){
                finalval+=value[idx];
                cap-=weight[idx];
            }
            else{
                finalval+=(ratio[i][1]*cap);
                cap=0;
                break;
            }
        }
        return finalval;
    }
    public static void main(String[] args) {
        int[] weught={10,20,30};
        int[] value={60,100,120};
        System.out.println(maxValueinKnapsack(weught, value, 50));
        System.out.println();
    }
}
