package icons;
import java.util.*;
import java.lang.*;
public class May04 
{
    public static void main(String args[])
    {
        int n=36;
        List <Integer> factors=new ArrayList();
       
        for(int i=1;i*i<=36;i++)
        {
            if(n%i==0)
            {
                factors.add(i);
                if(n/i!=i)
                    factors.add(n/i);
                //System.out.println(i+" "+n/i);
            }
        }
        /*Collections.sort(factors);
        System.out.println(factors);
        distributemoney();
        removematchString();
        moveNeg();*/
        Quadraprocess();
    }
    public static void distributemoney()
    {
        int amo=10;
        int distamo=0;
        int per=0;
        int i=1;
        while(true)
        {
           distamo=distamo+1;
           if(distamo>=amo) break;
           per=per+1;
           i=i+1;
        }
        System.out.println(per);
    }
    public static void removematchString()
    {
        String string="abcde";
        String[] strings={"abcd","bcde","abde","aabb","accb"};
        List <String> li=new ArrayList<>();
        Collections.addAll(li,strings);
        int matches=0;
        int n=string.length();
        for(int i=0;i<n;i++)
        {
            StringBuilder sb=new StringBuilder(string);
            String s=sb.delete(i, i+1).toString();
            if(li.contains(s))
                matches++;
        }
        System.out.println(matches); 
    }
    public static void moveNeg()
    {
        int arr[]={-5,7,-4,9,10,-3,12};
        int right=arr.length-1;
        int left=0;
        fun(arr);
        while(left<right)
        {
            if(arr[left]<0)
            {
                if(arr[right]>0)
                {
                    int temp=arr[left];
                    arr[left]=arr[right];
                    arr[right]=temp;
                    left++;
                    right--;
                }
                else
                {
                    right--;
                }
            }
            else
            {
                left++;
            }
                
        }
        System.out.println(Arrays.toString(arr));
        
    }
    public static void fun(int[] arr)
    {
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        for(int i:arr)
        {
            if(i<0)
                neg.add(i);
            else
                pos.add(i);
        }
        pos.addAll(neg);
        System.out.println(pos);
    }
    public static void Quadraprocess()
    {
        int[] p={8,12};
        Integer[] t={4,6,2,3,7,5,5,1};
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,t);
        int max=0;
        Collections.sort(list,Collections.reverseOrder());
        int j=1;
        int i=0;
        while(i<list.size())
        {
            if(i/4==j-1)
            {
                max=Math.max(max, p[j-1]+list.get(i));
            }
            else
            {
                i=4*j-1;
                j++;
            }
            i++;
        }
        System.out.println(max);
    }
}
