import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Converter {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scan = new Scanner(new File("lista.csv"));
        ArrayList<Persona> personaArrayList = new ArrayList<Persona>();
        while(scan.hasNext()){
            String[] line = scan.nextLine().split(",");
            if(line.length>0) {
                personaArrayList.add(new Persona(line[0], Integer.parseInt(line[1].trim()), line[2]));
            }
        }
        Gson jsonFile = new Gson();
        System.out.println("Imprimiendo...");
        System.out.println(jsonFile.toJson(personaArrayList));
        PrintWriter writer = new PrintWriter("lista.json", "UTF-8");
        writer.println(jsonFile.toJson(personaArrayList));
        writer.close();
        System.out.println("Guardado en lista.json");


    }
}
