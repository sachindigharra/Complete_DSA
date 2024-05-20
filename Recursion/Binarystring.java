public class Binarystring {
    // FACEBOOK Interviews Question;
    public static void printBinString(int n,int lastpos,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinString(n-1,0,str+"0");
        if(lastpos==0){
            printBinString(n-1,1,str+"1");
        }
        
    }
    public static void main(String[] args) {
        printBinString(3, 0, "");
    }
}
