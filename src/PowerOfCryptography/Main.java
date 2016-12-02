package PowerOfCryptography;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* package whatever; // don't place package name! */

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null){
			double n = Double.parseDouble(s);
			s = br.readLine();
			Double b1 = new Double(s);
			b1 = Math.pow(b1, (1/n));
                        Double r = Math.ceil(b1);
			System.out.println(r.intValue());
		}
	}
}
