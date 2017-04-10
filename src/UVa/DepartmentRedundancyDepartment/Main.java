package UVa.DepartmentRedundancyDepartment;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s=new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");
        LinkedList<Long> str=new LinkedList<Long>();
        while(s.hasNext()){
            str.add(s.nextLong());
        }
        TreeMap<Long,Integer> tm=new TreeMap<Long, Integer>();
        LinkedList<Long> ls=new LinkedList<Long>();
        for(int i=0;i<str.size();i++){
            long temp=str.get(i);
            if(tm.containsKey(temp)){
                int ind=tm.get(temp)+1;
                tm.remove(temp);
                tm.put(temp, ind);
            }else{
                tm.put(temp, 1);
                ls.add(temp);
            }
        }
        for(int i=0;i<ls.size();i++){
            long number=ls.get(i);
            sb.append(number).append(" ").append(tm.get(number)).append("\n");
        }
        System.out.print(sb);
    }
}