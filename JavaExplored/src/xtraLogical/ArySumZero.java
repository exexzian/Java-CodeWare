package xtraLogical;

import testCode.*;


 

 class ArySumZero  {
    int a=10;
    
    public static void printAll(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 
            
    public ArySumZero() {
        System.out.println("in const");
    }
    
    public static void main(String[] args) {
       
        int a[] = {-1,2,1,3,-3,-2,4,-5,5};
       ArySumZero.printAll(a);
          
    }

}


