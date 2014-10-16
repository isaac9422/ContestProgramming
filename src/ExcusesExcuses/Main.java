package ExcusesExcuses;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        ArrayList<String> excuses;
        String[] num, words;
        int d, p, max, i, caseNum = 0;
        while ((line = in.readLine()) != null) {
            num = line.split(" ");
            p = Integer.parseInt(num[0]);
            d = Integer.parseInt(num[1]);

            caseNum++;

            words = new String[p];
            excuses = new ArrayList<String>(d);

            max = 0;
            for (i = 0; i < p; i++) {
                words[i] = in.readLine();
                words[i] = words[i].toLowerCase();
            }

            for (i = 0; i < d; i++) {
                line = in.readLine();
                p = countIncidents(line.toLowerCase(), words);
                if (p > max) {
                    max = p;
                    excuses.clear();
                    excuses.add(line);
                } else if (p == max) {
                    excuses.add(line);
                }
            }

            System.out.println("Excuse Set #" + caseNum);
            for (i = 0; i < excuses.size(); i++) {
                System.out.println(excuses.get(i));
            }
            System.out.println();
        }
    }

    public static int countIncidents(String line, String[] words) {
        int pos, pos2, cont = 0;
        int size = line.length();
        for (int i = 0; i < words.length; i++) {
            pos = line.indexOf(words[i]);
            pos2 = words[i].length();
            while (pos >= 0) {
                if (pos > 0) {
                    if (!Character.isLetter(line.charAt(pos - 1))) {
                        if ((pos + pos2) < size) {
                            if (!Character.isLetter(line.charAt(pos + pos2))) {
                                cont++;
                            }
                        } else if ((pos + pos2) == size) {
                            cont++;
                        }
                    }
                } else if (pos == 0) {
                    if ((pos + pos2) < size) {
                        if (!Character.isLetter(line.charAt(pos + pos2))) {
                            cont++;
                        }
                    } else if ((pos + pos2) == size) {
                        cont++;
                    }
                }
                pos = line.indexOf(words[i], pos + 1);
            }
        }
        return cont;
    }
}