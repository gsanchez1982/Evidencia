import java.util.*;
import java.io.*;

public class citas {
    static ArrayList<String[]> doctors = new ArrayList<>();
    //^Crea el ArrayList de doctores.

    static String nombreArchivo = "db//doctores.csv";
    //^Define el nombre y ubicación del archivo.

    //El siguiente método carga el archivo a memoria, y después al HashMap, para ser utilizado por el programa.
    public static void load() {
        //Estos Arrays se crean para usarse en el try-catch para construir la agenda en el HashMap
        // desde los datos del csv.
        ArrayList<String> udid = new ArrayList<>();
        ArrayList<String> nomDoc = new ArrayList<>();
        ArrayList<String> esp = new ArrayList<>();

        //El siguiente código establece la comunicación entre el programa y el archivo csv:
        //En caso de que el archivo no exista, el try-catch crea un nuevo archivo de base de datos.

        try {
            File file = new File(nombreArchivo);
            if (file.exists() == false) {
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println();
                pw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Best practice es usar try-catch cuando se manejen archivos.
        try {
            File file = new File(nombreArchivo);
            Scanner inputStream = new Scanner(file);
            int n = 0;
            n = 2;
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                if (n == 2) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    udid.add(data);
                    n = n - 1;
                }
                if (n == 1) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    nomDoc.add(data);
                    n = n - 1;
                }
                if (n == 0) {

                    esp.add(data);
                    n = 2;
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < udid.size(); i++){
            String nuevoDoc[] = {udid.get(i), nomDoc.get(i), esp.get(i)};
            doctors.add(nuevoDoc);
        }
    }



    public static void agregar(){
        load();
        System.out.println("==AGREGAR NUEVO DOCTOR==.");
        System.out.println("Escriba a continuación el nombre del doctor:");
        Scanner nom = new Scanner(System.in);
        String nomDoc = nom.nextLine();

        System.out.println("Escriba a continuación la especialidad del doctor:");
        Scanner es = new Scanner(System.in);
        String esp = es.nextLine();

        int pSize = doctors.size() + 1;
        String udid = String.valueOf(pSize);

        String nuevoDoc[] = {udid, nomDoc, esp};
        doctors.add(nuevoDoc);

        save();
        System.out.println("Se agregó el doctor exitosamente. Volviendo al menú principal.");
        menuPrincipal.opciones();

    }

    //El siguiente método guardará los cambios realizados en la agenda, en el archivo.
    public static void save(){
        try {
            FileWriter aw = new FileWriter(nombreArchivo, false);
            BufferedWriter bw = new BufferedWriter(aw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i = 0; i < doctors.size(); i++){
                String[] newLine = doctors.get(i);
                String v1 = newLine[0];
                String v2 = newLine[1];
                String v3 = newLine[2];
                pw.println(v1 + ", " + v2 + ", " + v3);

            }
            pw.flush();
            pw.close();
        } catch (Exception E){
            System.out.println("Error");
        }
    }
}
