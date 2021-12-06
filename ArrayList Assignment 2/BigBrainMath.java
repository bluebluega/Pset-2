import java.util.ArrayList;

public class BigBrainMath{

    public static ArrayList<Integer> eratosthenes(int n){  
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2; i<=n; i++) list.add(i);

        for(int p=2; p<=n; p++){
            for(int i=list.size()-1; i>=0; i--){
                if(list.get(i)>p && list.get(i)%p==0){
                    list.remove(i);
                }
            }
        } 
        return list;
    }

    /**
     * Precondition: n is even and greater than 2
     */
    public static void goldbach(int n){
        int first = 0;
        int second = 0;
        ArrayList<Integer> bach = eratosthenes(n);

        for(int j=0; j<bach.size(); j++){
            for(int i=0; i<bach.size(); i++){            
                if(n-bach.get(i)==bach.get(j)){
                    first = bach.get(i);
                    second = bach.get(j);
                } 
            }   
        }  

        System.out.println(n + " = " + first + " + " + second);
    }

    public static ArrayList<Integer> add(ArrayList<Integer> one, ArrayList<Integer> two){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean carry = false;
        int first = one.size()-1;
        int second = two.size()-1;
        int sum = 0;
        int extra = 0;
        int s = 0; //difference in arraylist size

        while(first>=0 && second>=0){
            if(carry){
                sum = one.get(first) + two.get(second) + 1; 
                carry = false;
            }
            else sum = one.get(first) + two.get(second); 

            if(sum>=10){
                carry = true;
                sum%=10;
            }

            ans.add(0, sum);
            first--;
            second--;
        }

        if(one.size()==two.size() && carry){
            ans.add(0,1);
        }
        else if (one.size()>two.size()){
            s = one.size()-two.size();

            for(int i=s-1; i>=0; i--){
                if(carry){
                    extra = one.get(i)+1;
                    carry = false;
                }
                else extra = one.get(i);

                if(extra>=10){
                    carry = true;
                    extra%=10;
                }
                
                ans.add(0, extra);
            }
        }
        else {
            s = two.size()-one.size();
            for(int i=s-1; i>=0; i--){
                if(carry){
                    extra = two.get(i)+1;
                    carry = false;
                }
                else extra = two.get(i);

                if(extra>=10){
                    carry = true;
                    extra%=10;
                }
                
                ans.add(0, extra);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        //System.out.println("Without prime: " + eratosthenes(10));
        //goldbach(26);

        ArrayList<Integer> one = new ArrayList<Integer>();
        ArrayList<Integer> two = new ArrayList<Integer>();

        for(int i=0; i<5; i++){
            one.add((int)(Math.random()*10));
        }
        for(int i=0; i<7; i++){
            two.add((int)(Math.random()*10));
        }

        System.out.println(one);
        System.out.println(two);
        System.out.println(add(one, two));
    }
}