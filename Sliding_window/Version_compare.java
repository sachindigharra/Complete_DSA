public class Version_compare {
    public static int compareVersion(String s1, String s2) {
        int v1=0;
        int v2=0;
        int rev1=0;
        int rev2=0;
        while(v1<s1.length() && v2<s2.length()){
            while( v1<s1.length() && s1.charAt(v1)!='.'){
                if(rev1==0 && s1.charAt(v1)=='0'){
                    v1++;
                    continue;
                }
                rev1=rev1*10;
                rev1+=(s1.charAt(v1)-'0');
                v1++;
            }
            while(v2<s2.length() && s2.charAt(v2)!='.' ){
                if(rev2==0 && s2.charAt(v2)=='0'){
                    v2++;
                    continue;
                }
                rev2=rev2*10;
                rev2+=(s2.charAt(v2)-'0');
                v2++;
            }
            //System.out.println("track");
            if(rev2==rev1){
                rev1=rev2=0;
                v1++;
                v2++;
                continue;
            }
            
            else if(rev1<rev2)return -1;
            else{
                return 1;
            }
        }
        
            rev2=rev1=0;
            while (v1<s1.length() &&v2>=s2.length()) {
                //System.out.println("tracker");
                if(s1.charAt(v1)=='.'){
                    v1++;
                    continue;
                }
                while( v1<s1.length() && s1.charAt(v1)!='.'){
                    
                    if(rev1==0 && s1.charAt(v1)=='0'){
                        v1++;
                        continue;
                    }
                    rev1=rev1*10;
                    rev1+=(s1.charAt(v1)-'0');
                    v1++;
                }
                if(rev2==rev1){
                    rev1=rev2=0;
                    v1++;
                    continue;
                }
                else if(rev1<rev2)return -1;
                else{
                    return 1;
                }
            }
            while(v2<s2.length() &&v1>=s1.length()){
                if(s2.charAt(v2)=='.'){
                    v2++;
                    continue;
                }
                while(v2<s2.length() && s2.charAt(v2)!='.' ){
                   
                    if(rev2==0 && s2.charAt(v2)=='0'){
                        v2++;
                        continue;
                    }
                    rev2=rev2*10;
                    rev2+=(s2.charAt(v2)-'0');
                    v2++;
                }
                if(rev2==rev1){
                    rev1=rev2=0;
                    v2++;
                    continue;
                }
                else if(rev1<rev2)return -1;
                else{
                    return 1;
                }
            }

        
        return 0;
    }
    public static void main(String[] args) {
        String version1 = "1.0.1", version2 = "1";
        System.out.println(compareVersion(version1, version2));
    }
}
