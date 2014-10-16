package OpenSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        boolean flag=true;
        while(true){
            HashMap <String,Integer> hm=new  HashMap<String, Integer>();
            //Tabla Hash que contiene alumno y su inscripción a un proyecto
            HashMap <String,String> id=new HashMap <String,String>();
            LinkedList<String> prj=new  LinkedList<String>();
            String last="";
            while (true) {
                    String temp=br.readLine().trim();
                    if(temp.equals("1")){
                        break;
                    }
                    if(temp.equals("0")){
                        flag=false;
                        break;
                    }
                    //Determina que lo leido es un alumno
                    if(temp.charAt(0)>='a' &&temp.charAt(0)<='z'){
                        if(!id.containsKey(temp)){
                            id.put(temp, last);
                            int tempC=hm.get(last)+1;
                            hm.put(last, tempC);
                        }else{
                            //Control realizado, dado que el alumno ya estaba inscrito anteriormente
                            String projtemp=id.get(temp);
                            if(projtemp.equals(last)||projtemp.equals("Banned")){
                                continue;
                            }
                            int projDec=hm.get(projtemp)-1;
                            hm.put(projtemp, projDec);
                            id.put(temp,"Banned");
                        }
                    }
                    //Determina que lo leido sea un proyecto
                    if(temp.charAt(0)>='A' &&temp.charAt(0)<='Z'){
                    //Se verifica y se agregan los nuevos proyectos
                        if(!hm.containsKey(temp)){
                            hm.put(temp, 0);
                            prj.add(temp);
                        }
                        last=temp;
                    }
                }
            //Salto de salida, para el ultima llamada
            if(!flag){
                break;
            }
            //Se establecen agrupan los nombres y numeros de estudiando como proyecto
            LinkedList<Projecto> list=new LinkedList<Projecto>();
            while(!prj.isEmpty()){
                String projN=prj.remove();
                int tempC=hm.get(projN);
                list.add(new Projecto(projN, tempC));
            }
            Collections.sort(list);
            while(!list.isEmpty()){
                Projecto temp=list.removeLast();
                sb.append(temp.getName()).append(" ").append(temp.getContador()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
class Projecto implements Comparable<Projecto>{
    private String nombre;
    private int contador;

    public Projecto(String n, int c) {
        this.nombre = n;
        this.contador = c;
    }

    public int getContador() {
        return contador;
    }

    public String getName() {
        return nombre;
    }
   
    @Override
    //Utilizado para cumplir el orden de impresión correcto
    public int compareTo(Projecto o) {
        if(this.contador>o.getContador()){
            return 1;
        }
        if(this.contador<o.getContador()){
            return -1;
        }else{
            if(this.nombre.compareTo(o.getName())>-1){
                return -1;
            }else{
                return 1;
            }
        }
    }
}