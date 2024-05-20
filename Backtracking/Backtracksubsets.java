public class Backtracksubsets {
    static int count=0;
    public static void findSubSets(String s,String ans,int i){
        if(i==s.length()){
            count++;
            if(ans.length()==0)System.out.println("null");
            System.out.println(ans);
            return;
        }
        //letter choice yes
        findSubSets(s, ans+s.charAt(i),i+1 );
        //Letter choice No
        findSubSets(s ,ans,i+1 );
    }
 public static void main(String[] args) {
    String s="abc";
   findSubSets(s, "", count);
   System.out.println(count);
 }    
}
