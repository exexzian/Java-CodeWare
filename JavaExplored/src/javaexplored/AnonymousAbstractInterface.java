package javaexplored;


/**
 *http://viralpatel.net/blogs/inner-classes-in-java/ 
 */

abstract class AbsClass{

    public AbsClass() {
        System.out.println("hell AbsClass");
    }
    
    public void fun(){
        System.out.println("fun of abstract");
    }
    
      
}

class AnonymousAbstractInterface extends AbsClass{

    public AnonymousAbstractInterface() {
        //super();
        System.out.println("for test");
    }
    
    
    
    public static void main(String[] args) {
        
       
        AbsClass obj = new AbsClass(){
            
                                    };
        obj.fun();
        System.out.println("obj object of = " + obj.getClass());
        
        AbsClass obj2 = new AnonymousAbstractInterface();
        System.out.println("obj2 object of = "+obj2.getClass());
        
    }

   
}