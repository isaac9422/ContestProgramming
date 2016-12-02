/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardwood_Species;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.TreeMap;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        String s;
        boolean flag = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer c = new Integer(br.readLine());
        for(int i=1;i<=c;i++){
            if(flag){
                System.out.println("");
            }
            else{
                flag = true;
                br.readLine();
            }
            int l = 0;
            TreeMap<String,Integer> hm = new TreeMap<String,Integer>();
            while((s=br.readLine())!=null){
                if(s.equals("")){
                    break;
                }
                l++;
                if(hm.containsKey(s)){
                    int h = hm.get(s);
                    hm.put(s, h+1);
                }
                else{
                    hm.put(s, 1);
                }                
            }
            while(!hm.isEmpty()){
                DecimalFormat df = new DecimalFormat("0.0000");
                String g = hm.firstKey();
                double y = (hm.get(g).doubleValue() / l*1.0)*100.0;
                System.out.println(g+" "+ df.format(y));
                hm.remove(g);
            }
        }
    }
}