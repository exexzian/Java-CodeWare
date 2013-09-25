package cdacLab;

import testCode.*;


class Pattern1{
    
    public static void main(String[] args) {
        System.out.println("loop");
        
        for(int i=5;i>=1;i--){
            for(int j=1;j<i;j++){
                System.out.print("\t");
            }
            for (int k = 1; k <=(6-i); k++) {
                System.out.print(k+ "\t\t");
                
            }
            System.out.println("");
        }
     
    }

}


