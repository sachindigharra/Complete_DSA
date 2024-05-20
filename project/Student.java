package project;

public class Student {
    public String name,uni_roll;
    public float pct;
    public Student( String name, String roll,float per){
        this.name=name;
        this.uni_roll=roll;
        this.pct=per;
    }
    public Student(){

    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUni_roll(String uni_roll) {
        this.uni_roll = uni_roll;
    }
    public void setPct(float pct) {
        this.pct = pct;
    }
    public String getName() {
        return name;
    }
    public String getUni_roll() {
        return uni_roll;
    }
    public float getPct() {
        return pct;
    }
  
}
