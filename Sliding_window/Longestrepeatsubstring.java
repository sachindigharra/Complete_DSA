

public class Longestrepeatsubstring {
    public static int maxLengthofRepeatSubString(String s, int k){
        /*
         low optimized sol time complex =O(n+n)*26
          space= o(26)

          int n=s.length();
            int r=0;
            int l=0;
            int ans=0;
            int maxfreq=0;
            int[]arr=new int[26];
           while(r<n){
                arr[s.charAt(r)-'A']++;
                maxfreq=Math.max(maxfreq,arr[s.charAt(r)-'A']);
               

                while(r-l+1-maxfreq>k){
                    // update value of maxfreq and remove or shift sidling window util 
                    difference between maxfreq and len of sliding window is not gretaer than k
                    arr[s.charAt(l)-'A']--;
                    maxfreq=0;
                    for(int i=0;i<26;i++){
                        maxfrq=Math.max(maxfreq,arr[i]);
                    }
                    l++;
                }
                if(r-l+1 -maxfreq<=k)ans=Math.max(ans,r-l+1);
                r++;
           }
        */
            int n=s.length();
            int r=0;
            int l=0;
            int ans=0;
            int maxfreq=0;
            int[]arr=new int[26];
           while(r<n){
                
                arr[s.charAt(r)-'A']++;
                // update maxfreq
                maxfreq=Math.max(maxfreq,arr[s.charAt(r)-'A']);
                // we dont care about size of slidling window until it does not cross limit
                // limit is decided by diff b\w (r-l+1) - maxfreq 
                // main role of dcrease of time complexity is we don't update maxfreq  if changeable charcter more than k 
                // we just  single or shift sliding window by one 
                if(r-l+1 -maxfreq>k){
                    arr[s.charAt(l)-'A']--;
                    l++;
                }
                if(r-l+1 -maxfreq<=k)ans=Math.max(ans,r-l+1);
                r++;
           }
          return ans;
    }
    public static void main(String[] args) {
        String s="AAABBCCD";
        int k=3;
        System.out.println(maxLengthofRepeatSubString(s, k));
    }
}
