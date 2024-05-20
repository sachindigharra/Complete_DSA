public  class Bitmainuplanation{
    public static int getIthbit(int n,int i){
        int bitmask = 1<<i;
        if((n&bitmask)==0)return 0;
        return 1;
    }
    static int setIthbit(int n,int i){
        int bitmask=1<<i;
        return (n|bitmask);
    }
    static int clearIthbit(int n,int i){
        int bitmask=~(1<<i);
        return (n&bitmask);
    }
    static int upDateIthbit(int n,int i,int newbit){
        n=clearIthbit(n, i);
        int bitmask=newbit<<i;
        return (bitmask|n);
    }
    static int clearLastIthbit(int n,int i){
        int bitmask=(~0)<<i;
        return (n&bitmask);
    }
    static int clearRangeBit(int n, int i,int j){
        int a=(~0<<j+1);
        int b=(1<<i)-1;
        int bitmask=a|b;
        n=(n&bitmask);
        return n;
    }
    static boolean isPowerofTwo(int n){
        return (n&(n-1))==0;
    }
    static int Complement(int num){
        int nBits = (int)Math.floor((Math.log(num) / Math.log(2)) + 1);
        int mask = (1 << nBits) - 1;
        return ~num & mask;
    }
    static int countSetBit(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0)count++;
            n=n>>1;
        }
        return count;
    }
    static boolean hasAlternatingBits(int n) {
        
        return true;
    }
    public static void main(String[] args) {
        /*System.out.println(getIthbit(10, 2));
        System.out.println(setIthbit(10, 2));
        System.out.println(clearIthbit(10, 1));
        System.out.println(upDateIthbit(10, 2, 1));
        System.out.println(clearLastIthbit(10, 2));
        System.out.println(clearRangeBit(10, 2, 3));*/
        //System.out.println(isPowerofTwo(16));
        //System.out.println(countSetBit(10));
        System.out.println(hasAlternatingBits(3));
        System.out.println(Complement(5));
    }
}