/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdacLab;

/**
 *
 * @author hacker
 */
public class CompoundInterest {
    
    double startAmount, rate;
    int yrs;
    
    public void compoundAnnual(double startAmount, double rate, int yrs){
        
        this.startAmount = startAmount;
        this.rate = rate;
        this.yrs = yrs;
        
    }
    
    public double computeInterest(){
        
        double amount=0;
        double annualRate =1;
        for (int i = 1; i <= yrs; i++) {
            
            amount = 0;
            annualRate = annualRate * (1+rate/100);
            
            amount = amount + startAmount * annualRate;
            System.out.println("amount on year " + i + " = " + amount);
            
        }
        
        return amount;
    }
    
    public static void main(String[] args) {
        
        double depositeAmount, rate;
        int years;
        
        depositeAmount = Double.parseDouble(args[0]);
        rate = Double.parseDouble(args[1]);
        
        years = Integer.parseInt(args[2]);
        
        CompoundInterest objInterest = new CompoundInterest();
        
        objInterest.compoundAnnual(depositeAmount, rate, years);
        
        double amount = objInterest.computeInterest();
        System.out.printf("\n Total compounded amount = %.2f", amount);
    }
    
}
