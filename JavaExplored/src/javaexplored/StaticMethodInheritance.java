/*
 * http://stackoverflow.com/questions/14487845/compare-two-strings-that-are-lexicographically-equivalent-but-not-identical-at-t#14488004
 */
package javaexplored;

import testCode.*;
import java.util.regex.Pattern;

class Animal {

    public static void testClassMethod() {
        System.out.println("The class" + " method in Animal.");
    }

    public void testInstanceMethod() {
        System.out.println("The instance " + " method in Animal.");
    }
}

class Cat extends Animal {

    public static void testClassMethod() {
        System.out.println("The class method" + " in Cat.");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method" + " in Cat.");
    }

}

class StaticMethodInheritance {

    public static void main(String[] args) throws Exception {
        Cat myCat = new Cat();
        
        myCat.testClassMethod();
        
        Animal myAnimal = myCat;
        
        myAnimal.testClassMethod();        
        myAnimal.testInstanceMethod();
    }
}
