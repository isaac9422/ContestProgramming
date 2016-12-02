package UnoDosTres;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s;
        for(int i=0;i<N;i++){
            s = sc.next();
            if(s.length() == 4){
                System.out.println("3");
            }
            else{
                if((s.trim().contains("u") && s.contains("n")) || (s.contains("u") && s.contains("o")) || (s.contains("o") && s.contains("n"))){
                    System.out.println("1");
                } 
                else{
                    System.out.println("2");
                }
            }
        }
    }
}