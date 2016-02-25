
class Outer1 {

    static class Inner {

        int a;

        Inner(int a) {
            this.a = a;
        }
    }
    
    int a;

    Outer1(int a) {
        this.a = a;
    }    
    
}

class Outer2 {

    class Inner {

        int a;

        Inner(int a) {
            this.a = a;
            Outer2.this.a = a+1;
        }
    }
    
    int a;
    Inner inner;

    Outer2(int a) {
        inner = new Inner(a);
    }    
    
}

public class InnerClassTest {
    
    public static void main(String args[])
    {
        Outer1.Inner i1 = new Outer1.Inner(3);
        Outer2 o = new Outer2(3);        
        
        System.out.println(i1.a);
        System.out.println(o.a);
        System.out.println(o.inner.a);
    }

}
