import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;


public class y3k {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(s,"\\ ");
			Calendar c = Calendar.getInstance();
			int a = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(d == 0 ||  m == 0 || y == 0){
				break;
			}
			m--;
			c.set(y, m, d);
			c.add(Calendar.DAY_OF_YEAR, a);
			System.out.println(c.get(Calendar.DATE)+ " "+ (c.get(Calendar.MONTH) + 1) + " "+c.get(Calendar.YEAR));
			
		}
	}

}
