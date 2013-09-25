package java7basics;


class InnerInheritance {
  
    //-----------------------------------------------------------------------
   // PARENT CLASS
   class ParentClass {
     int a=20;
      public ParentClass() {
         x = new InnerClass();
      }

     InnerClass x;

      class InnerClass {
        int b = 10;
         public void speak() {
            System.out.println("I am a ParentClass.InnerClass");
         }
      }
   }

   //-----------------------------------------------------------------------
   // CHILD CLASS
   class ChildClass extends ParentClass {
      public ChildClass() {
         x = new InnerClass();
      }

      InnerClass x;

      class InnerClass extends ParentClass.InnerClass {
          @Override
         public void speak() {
            System.out.println("I am a ChildClass.InnerClass");
         }
      }
   }

   //-----------------------------------------------------------------------
   // MAIN
   public static void main(String[] args) {
      ParentClass obj = (new InnerInheritance()).new ChildClass();
      obj.x.speak();
   }

}