import java.util.*;

public class Tokenbag{
    
    public static  int bagOfTokensScore(int[] tokens, int power) {
        
                Arrays.sort(tokens);
                int score = 0;
                int res = 0;
                int si = 0, ei = tokens.length - 1;
        
                while (si <= ei) {
                    if (power >= tokens[si]) {
                        power -= tokens[si];
                        score++;
                        si++;
                        res = Math.max(res, score);
                    } else if (score > 0) {
                        power += tokens[ei];
                        score--;
                        ei--;
                    } else {
                        break;
                    }
                }
        
                return res;
            }

    public static void main(String[] args) {
        int power=200;
        int[]tokens={100,200,300,400};
        System.out.println(bagOfTokensScore(tokens, power));
    }
}