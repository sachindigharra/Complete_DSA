public class Slidehavethreechar {
    public static int numberOfSubstrings(String s) {
        if(s.length()<3)return 0;
        int n=s.length();
        int[]lastSeen = {-1,-1,-1};
        int count=0;
        for(int i=0;i<n;i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                int minIdx= Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                count+=(minIdx+1);
            }

        }

        return count;
    }
    public static void main(String[] args) {
       String s="abcabc";
       System.out.println(numberOfSubstrings(s)); 
    }
}
