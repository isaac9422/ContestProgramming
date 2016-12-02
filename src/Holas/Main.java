package Holas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 1;
        String s;
        while(sc.hasNext()){
            s = sc.nextLine();
            if(s.equals("#")){
                break;
            }
            else{
                if(s.equalsIgnoreCase("hola")){
                    System.out.println("Palabra "+c+": ESPANOL");
                }
                else if(s.equalsIgnoreCase("hello")){
                    System.out.println("Palabra "+c+": INGLES");
                }
                else if(s.equalsIgnoreCase("ciao")){
                    System.out.println("Palabra "+c+": ITALIANO");
                }
                else if(s.equalsIgnoreCase("bonjour")){
                    System.out.println("Palabra "+c+": FRANCES");
                }
                else if(s.equalsIgnoreCase("hallo")){
                    System.out.println("Palabra "+c+": ALEMAN");
                }
                else if(s.equalsIgnoreCase("zdravstvujte")){
                    System.out.println("Palabra "+c+": RUSO");
                }
                else{
                    System.out.println("Palabra "+c+": DESCONOCIDO");
                }
                c++;
            }
        }
    }
}