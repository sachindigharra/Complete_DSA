public class Binaryaltbit {
    static boolean isAltbit(int n){
        // this solution has a higher time complexity
        /*String s = Integer.toBinaryString(n);
        char prev = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            char ch=s.charAt(i);
            if(ch == prev) {
                return false;
            } 
            prev = ch;
        }*/
        int prev=n%2;
            n=n/2;
        while (n > 0) {
            int bin=n%2;
            if(bin==prev)return false;
            prev=bin;
            n=n/2;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int n=3;
        System.out.println(isAltbit(n));
        
    }
}
