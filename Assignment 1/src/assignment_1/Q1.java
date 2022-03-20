package assignment_1;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1, b=1, range, c, sum=0;
		range=1;
		
		   while( range<=20 )
		   {
		     System.out.print(a +" ");
		      sum =sum+ a;
		      c = a + b;
		      a = b;
		      b = c;
		      range++;
		   }
		   
		System.out.println("sum of 20 terms: "+ sum);

	}

}
