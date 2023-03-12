package zadatak;

import java.io.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Molimo unesite broj kilometara kao decimalni broj: ");

        double kilometri = Double.parseDouble(scanner.nextLine());

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Molimo unijeti konverzijski faktor za milje: ");

        double konverzijskiFaktor = Double.parseDouble(scanner1.nextLine());

        int milje = (int) (kilometri / konverzijskiFaktor);

       if (kilometri <= 0 || konverzijskiFaktor <= 0) {
           System.out.println("Broj ne smije biti 0 ili manji od 0!");
       }

       File file = new File("konverzijski_faktor.txt");

       try {
           FileWriter writer = new FileWriter(file, true);
           writer.write(String.valueOf(konverzijskiFaktor));

           writer.close();

       } catch (IOException e) {
           System.out.println("Dogodila se pogreška kod unosa podataka.");
           e.printStackTrace();
       }

        try {
            FileReader reader = new FileReader(file);

            char[] buffer = new char[3];
            reader.read(buffer);

            reader.close();

            String content = new String(buffer);

            if (content.equals(String.valueOf(konverzijskiFaktor))) {
                System.out.println("Iz Datoteke: konverzijskiFaktor = " + content);
            }

        } catch (IOException e) {
            System.out.println("Dogodila se pogreška kod povlačenja podataka.");
            e.printStackTrace();
        }


        System.out.println("Uneseno je " + kilometri + " kilometara, što je " + milje + " milja.");
    }

}
