package javaexplored;

class CallingMain {
    
    static String a[] = { "2", "3" };
    
    static {
        System.out.println("calling main from static block");
        CallingMain.main(a);
        System.out.println("calling main from JVM entry point");
    }
    
    public static void main(String[] args) {
    
        System.out.println("in main");
    }

}