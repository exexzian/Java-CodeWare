package cdacLab;

import testCode.*;


class Pattern2{
    
    public static void main(String[] args) {
        
        final long startTime = System.nanoTime();
        
        int n=1;
        int space=5;
        char ch = 'A';
        
        
        for (int k = 1; k <=n; k++) {
            for(int j=1;j<space;j++){
                System.out.print("\t");
            }
            space--;
            
            if(n>9){
                break;
            }
            
            for(int l=1;l<=n/2;l++){
                System.out.print(ch++ + "\t");
            }
            
            for(int m = n/2+1;m<=n;m++){
                System.out.print(ch--  + "\t");
            }
            n=n+2;
            ch = 'A';
            System.out.println("");
        }
        
        final long duration = System.nanoTime() - startTime;
        System.out.println("running time - "+duration +" nano-sec");
        
    }
    

}


