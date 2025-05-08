package christopher.flores.tranferencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Fitxer {
    private String nom;
    private byte[] contingut;
    
    public Fitxer(String nom) {
        this.nom = nom;
    }

    public byte[] getContigut() {
        File file = new File(nom);
        
        try{
            if (file.exists() && file.isFile()) {
                Path path = file.toPath();
                contingut = Files.readAllBytes(path);
            } 
        } catch (IOException ioe) {
            System.out.println("Error llegint el fitxer del client: " + file);
        }
        return contingut;
    }
}
