interface A
{
    void show();
    default void abc()
    {
        System.out.println("in abc");
    }
}
class S implements A{
    public void show()
    {
        System.out.println("in show");
    }
}
class Demo
{
    public static void main(String []args)
    {
   S obj=new S();
   obj.show();
   obj.abc();


    }
}