package javaexplored;


class UninitialzedVal_ConstructorChain {
    public static void main(String[] args) {
        new Derived();
        
    }
}

class Base {
    
    int a = 100;
    {
        System.out.println("init of Base = "+a);
    }
    Base() {
        System.out.println("Base constructor start : a=" + a);
        printFun();
        System.out.println("Base constructor end : a=" + a);
    }
    
    void printFun() {
        System.out.println("Class Base : : " + a);
    }
}

class Derived extends Base {
    int a = 200;
    Derived(){
        System.out.println("constructor of Derived");
    }
    
    {
        System.out.println("init of Derived = " + a );
    }
    
    @Override
    void printFun() {
        System.out.println("Class Derived : " + a);
    }
}

