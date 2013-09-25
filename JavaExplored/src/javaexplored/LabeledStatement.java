package javaexplored;

/**
 * http://stackoverflow.com/questions/3821827/loop-in-java-code-what-is-this-why-does-it-compile-and-generally-wtf
 * http://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html
 * http://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.7
 *
 */
class LabeledStatement {
    public static void main(String[] args) {
        
        //outer loop labeled as outer
        outer:
        for (int i = 0; i < 10; i++) {
            //inner loop labeled as inner
            inner:
            for (int j = 0; j < 10; j++) {
                if((j==2)&&(i==4)){
                    System.out.println("break outer i =  "+i + " j = "+j);
                    break outer;
                }
                if(i==3){
                    System.out.println("break inner i =  "+i + " j = "+j);
                    break inner;
                }
                
            }
        }
        
    }
}

