public class Numberofone {
    static int count=0;
    // public static int countPrimes(int n) {
    //     if(n<=1) return count;
    //    boolean flag = false;
    //     for(int i=2;i<=n/2;i++){  
    //         if(n%i==0){
    //             flag=true;
    //             break;
    //         }
    //     }
    //     if(!flag)count++;
    //     return countPrimes(n-1)+count;

    // }
   
    public  static int countDigitOne(int n) {
        if(n<1)return count;
        int temp=n;
        while(temp > 0)
        {
          if(temp % 10 == 1)
              count+=1;

          temp=temp/10;
        }
        return countDigitOne(n-1);
    }
    public static void main(String[] args) {
        //System.out.println(countDigitOne(13));
        //System.out.println(countDigitOne(0));
        System.out.println(countDigitOne(13));
    }
    
}
