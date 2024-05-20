public class Studentandsanwiches {
    public static int countStudents(int[] students, int[] sandwiches) {
        int ones=0;
        int zeros=0;
       for(int i=0;i<students.length;i++){
            if(students[i]==1)ones++;
            else zeros++;
       }
       for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==1 && ones>0)ones--;
            else if(sandwiches[i]==0 && zeros>0)zeros--;
            else{
                return ones+zeros;
            }
       }
       return 0;
    }
    public static void main(String[] args) {
        int[]students={1,1,1,0,0,1};
        int[] sandwiches={1,0,0,0,1,1};
        System.out.println(countStudents(students, sandwiches));
    }
}
