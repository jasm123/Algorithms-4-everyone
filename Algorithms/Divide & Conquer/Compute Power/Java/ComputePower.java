package HackOctoberFest;

import java.util.Scanner;

public class ComputePower {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the base: ");
		int base = in.nextInt();       //take base as input 
		System.out.println("Enter the exponent");
		int exponent = in.nextInt();   //take exponent as input 
		System.out.println(pow(base,exponent));   
		in.close();
	}
	/* Iterative Function to calculate n raised to the power p
	 * Here we divide problem of calculating n^p into subproblems of n^(p/2) and
	 * multiplying subproblems together.
	 * To do this iteratively, we do (n^2)^(p/2). For odd exponent, we multiply it with n each time. 
	 */
	public static long pow(int n, int p) {
		long result = 1;			//Initialize result
		long base=n;				//Since base will hold powers of n, we initialize it as long
		if (p == 0)          
			return 1;      		//n^0=1
		if (p == 1)
			return n;			//n^1=n
		while (p != 0) {
			if (p & 1)
				result *= base;	//If exponent is odd,multiply n with result
			p >>= 1;			//p=p/2;
			base *= base;		//Change n to n^2
		}
		return result;
	}


}
