public class Maxarrange {
    public static String maximumOddBinaryNumber(String s) {
        if(s.length()<2) return s;
        StringBuilder sb = new StringBuilder();
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            String ch=""+s.charAt(i);
            if(ch.equals("1")){
                if(!flag){
                    flag=true;
                    continue;
                }
                else{
                    sb.insert(0,ch);
                }
            }
            else{
                sb.append(ch);
            }
        }
        sb.append("1");
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="0101";
        System.out.println(maximumOddBinaryNumber(s));
    }
}
