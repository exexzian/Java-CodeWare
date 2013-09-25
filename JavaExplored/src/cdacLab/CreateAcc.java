/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdacLab;

class Account
{
 	String name,accno,acctype;
 	double bal;
        
	void display()
 	{
  		System.out.println("Balance :    \t\t "+bal);
 	}
	void deposit(double dep)
 	{
 		 bal=bal+dep;
  		System.out.println("Balance Deposited:     \t"+dep);
	 }
 	void init(double b,String nm,String no,String type)
 	{
  		bal=b;
  		name=nm;
  		accno=no;
  		acctype=type;
  		System.out.println("ACCOUNT CREATED\n");
		System.out.println("Account Holder:     \t"+name);
		System.out.println("Account Number:    \t"+accno);
		System.out.println("Account Type:   \t"+acctype);
 	}
}

class Curracct extends Account
{
 	static double min=2000.00,chrg=150.0;
        
 	void withdraw(double amt)
 	{
 		bal=bal-amt;
  		System.out.println("Balance Withdrawn :  \t"+amt);
  		if(bal<min)
  		{
  			bal=bal-chrg;
   			System.out.println("\nService charge is imposed :    \t"+chrg);
  		}	
 	}
}

class Saveacct extends Account
{	
 	void withdraw(double amt)
 	{
  		if(bal<amt)
   			System.out.println("\nInsufficient Balance");	
  		else
  		{
   			bal=bal-amt;
   			System.out.println("Balance Withdrawn :    \t"+ amt);
  		}	
 	}
 	void interestdep()
 	{
  		double interest  = ( 5*bal)/100;
  		bal=bal+interest;
  		System.out.println("Interest Deposited :   \t" + interest);
 	}
}

class CreateAcc
{
 	public static void main(String []args)
 	{
  		Account a=new Account();
  		Saveacct s=new Saveacct();	
  		Curracct c=new Curracct();
  		
		System.out.println();
  		a.init(4000.00,"ABC","123456","Saving");
  		a.display();
  		a.deposit(550.00);
  		a.display();		

  		System.out.println();
  		s.init(92000.0,"XYZ","345678","Saving");
  		s.display();	
  		s.interestdep();
  		s.deposit(2000.00);	
  		s.withdraw(800000);
  		s.display();	

 		System.out.println();
  		c.init(50000.00,"PQR","567892","Current");
  		c.display();
  		c.deposit(3000.00);
  		c.withdraw(52000.00);				
  		c.display();	
 	}
}
