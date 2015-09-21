/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(s);
			double x1, y1, x2, y2;
			x1 = Double.parseDouble(st.nextToken());
			y1 = Double.parseDouble(st.nextToken());
			x2 = Double.parseDouble(st.nextToken());
			y2 = Double.parseDouble(st.nextToken());
			double x3,y3,x4,y4,xo,yo,i,j;
			xo = (x1+x2)/2;
			yo = (y1+y2)/2;
			i=x1-xo;
			j=y1-yo;
			x3=xo+j;
			y3=yo-i;
			x4=xo-j;
			y4=yo+i;
			DecimalFormat df = new DecimalFormat("0.0000000000");
			System.out.println(df.format(x3)+" "+df.format(y3)+" "+df.format(x4)+" "+df.format(y4));
		}
	}
}
