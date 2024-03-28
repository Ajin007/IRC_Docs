import java.util.*;
class item
{
    public String name;
    public double price;
}
class Cart
{
    private ArrayList<item>a = new ArrayList<>();
    public void addItem(item obj)
    {
        a.add(obj);
    }
    public void removeItem(String str)
    {
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).name.equals(str))
            {
                a.remove(i);
            }
        }
    }
    public void calculateTotalPrice()
    {
        double tot = 0;
        for(int i=0;i<a.size();i++)
        {
            tot+=a.get(i).price;
        }
        System.out.print("Total Price after removing items: $"+tot);
    }
    public void print()
    {
        System.out.print(a.get(1).price);
    }
}
public class C1 {
    public static void main(String ar[])
    {
        Scanner o = new Scanner(System.in);
        int n = o.nextInt();
        o.nextLine();
        Cart obj2 = new Cart();
        for(int i = 0;i<n;i++)
        {
            String str = o.nextLine();
            double db = o.nextDouble();
            o.nextLine();
            item obj1 = new item();
            obj1.name = str;
            obj1.price = db;
            obj2.addItem(obj1);
        }
        int num = o.nextInt();
        o.nextLine();
        for(int i=0;i<num;i++)
        {
            String t = o.nextLine();
            obj2.removeItem(t);
        }
        obj2.calculateTotalPrice();
        o.close();
    }
}