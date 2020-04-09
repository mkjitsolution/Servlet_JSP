package clientCode;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		

		
		System.out.println("Enter Number : ");
		String strx = sc.nextLine();
		int x = Integer.parseInt(strx);
		System.out.println(" number is "+x);
		
	
	

		System.out.println("Enter String 2: ");
		String nextLineStr = sc.nextLine();
		System.out.println(" next Str "+nextLineStr);
		
		
		
		System.out.println("Enter Number 2: ");
		String strf = sc.nextLine();
		float f = Float.parseFloat(strf);
		System.out.println(" number is "+f);
		
	
		
		
		
		
	}
}
