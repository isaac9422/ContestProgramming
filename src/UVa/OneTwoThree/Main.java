package UVa.OneTwoThree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = new Integer(br.readLine());
        for(int i=0;i<t;i++){
            s = br.readLine();
            if(s.length()>3){
                System.out.println("3");
            }
            else{
                if((s.contains("o")) && (s.contains("e"))||(s.contains("e")) && (s.contains("n"))||(s.contains("o")) && (s.contains("n"))){
                    System.out.println("1");
                }
                else{
                    System.out.println("2");
                }
            }
        }
    }
}