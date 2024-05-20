public class Stringscore {
    public  static int scoreOfString(String s) {
        
        int score=0;
        for( int i=1;i<s.length();i++){
            int x=s.charAt(i)-'a';
            int y=s.charAt(i-1)-'a';
            score+=Math.abs(x-y);
        }
        
        
        return score;
    }
    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
    }
}
