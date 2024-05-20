public class Palindromic_substring{
    static int count=0;
    public static int countSubstrings(String s) {
        if (s.length()==0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            check(s, i, i); 
            check(s, i, i + 1);
        }
        return count;
    }
    private static void check(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
    public static void main(String[] args) {
        String s="aaa";
        System.out.println(countSubstrings(s));
    }
}