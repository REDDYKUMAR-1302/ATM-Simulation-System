
package bank.management.systems;
import java.util.*;
interface Show
{
    public void show();
}
interface Funct
{
    void fun(int i);
}

class Color 
{
    public static void main(String args[])
    {
        /*
        int a[]=new int[]{1,3,4,2,7,1,1,2};
        Map <Integer,Integer> fe=new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            if(fe.containsKey(a[i]))
            {
                fe.put(a[i],fe.get(a[i])+1);
            }
            else
            {
                fe.put(a[i],1);
            }
        }
        System.out.println(fe);
        Show obj=new Show()
        {
            public void show()
            {
                System.out.println("show");
            }
        };
        Funct o=(i)->System.out.println("Interfaces and lamda expression"+ " "+ i);
        obj.show();
        System.out.println(obj instanceof Show);
        System.out.println( o instanceof Show);
        o.fun(5);
        System.out.println(~1);*/
        display("ReddyKumar",2345);
        display(2345,"ReddyKumar Valligatla");
        Myclass <String> cl=new Myclass<>("Reddy","kumar");
        
        cl.display1();
    }
    public static <T> void display(T input,T input2)
    {
        System.out.println(input+" "+input2);
    }
}
class Myclass <T>
{
    T x;
    T y;
    Myclass(T x,T y)
    {
        this.x=x;
        this.y=y;
    }
     public  void display1()
    {
        System.out.println(x+" "+y);
    }
}