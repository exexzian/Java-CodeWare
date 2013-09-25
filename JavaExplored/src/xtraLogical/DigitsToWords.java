package xtraLogical;

import java.util.ArrayList;
import javax.swing.*;


public class DigitsToWords{
	public static void main(String args[]){
            
		try{
			int inputNumber=0;
			
			String ones[]={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
			String tens[]={"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
			String hundreds[]={"","","hundred","thousand","million","billion"};
			
			StringBuilder answer=new StringBuilder("");
			JOptionPane.showMessageDialog(null,"Number must be less then ONE BILLION");
			
			inputNumber=Integer.parseInt(JOptionPane.showInputDialog(null,"PLease Enter a Number: "));
			int copyNum=inputNumber;
			
			ArrayList numArray=new ArrayList();
			
			int count=0;
			int exp=0;

			while(copyNum>0){
				count=copyNum%100;
				numArray.add(count);
				copyNum=(int)copyNum/100;
				count++;
				if(exp==0)
				{
					exp=1;
					count=copyNum%10;
					numArray.add(count);
					copyNum=(int)copyNum/10;
				}

			}


			Object obarray[]=numArray.toArray();
			int[] array=new int[obarray.length];



			for(int i=0; i<obarray.length; i++)
				array[i]= ((Integer) obarray[i]).intValue();


			for(int p=array.length;p>0;p--){
				if(array[p-1]>19){
					int first=array[p-1]/10;
					int sec=array[p-1]%10;
					answer.append(tens[first]+" ");
					answer.append(ones[sec]+" ");
					answer.append(hundreds[p]+" ");
				}
				else
				{
					answer.append(ones[array[p-1]]+" ");
					if(array[1]>0)
						answer.append(hundreds[p]+" ");
				}

			}

			JOptionPane.showMessageDialog(null,answer);

		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"you entered wrond number");
		}
		
		

	}

}