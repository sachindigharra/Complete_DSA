import java.util.*;
public class Dickorder {
    public static int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length<2)return deck;
        if(deck.length==2){
            if(deck[0]<deck[1])return deck;
            else{
                int temp =deck[0];
                deck[0]=deck[1];
                deck[1]=temp;
                return deck;
            }
        }
        Arrays.sort(deck);
        int mid=(deck.length-1)/2;
        int l=mid;
        int r=deck.length-1;
        List<Integer>ls=new ArrayList<>();
        if(deck.length%2!=0){
            System.out.println(deck[l]);
            ls.add(deck[l]);
            l--;
            while(r>=mid+1 && l>=0){
                if(ls.indexOf(deck[r])>0)r--;
                if(ls.indexOf(deck[r])<0)ls.add(deck[r]);
                System.out.println(deck[r]);
                
                ls.add(deck[l]);
                System.out.println(deck[l]);
                l--;
                if((r-2)<mid+1)r++;
                else{
                    r=r-2;
                }
                
            }

        }
        else{
            while(r>=mid+1 && l>=0){
                if(ls.indexOf(deck[r])>0)r--;
                if(ls.indexOf(deck[r])<0)ls.add(deck[r]);
                System.out.println(deck[r]);
                
                ls.add(deck[l]);
                System.out.println(deck[l]);
                l--;
                if((r-2)<mid+1)r++;
                else{
                    r=r-2;
                }
                
            }

        }
        l=0;
        for(int i=deck.length-1;i>=0;i--){
            System.out.print(ls.get(i)+" ");
            deck[l++]=ls.get(i);
        }
       return deck;
    }
    public static void main(String[] args) {
        int[]deck={1,2,3,4};
        deck=deckRevealedIncreasing(deck);
        for(int it:deck){
            System.out.print(it);
        }
        System.out.println();
    }
    
}
