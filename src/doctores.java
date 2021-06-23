import java.util.*;
import java.io.*;

public class doctores {
    static HashMap<String, String> doctores = new HashMap<>();
    //^Crea el HashMap de doctores.

    static String nombreArchivo = "db//doctores.csv";
    //^Define el nombre y ubicación del archivo.

    //El siguiente método carga el archivo a memoria, y después al HashMap, para ser utilizado por el programa.
    public static void load(){
        //Estos Arrays se crean para usarse en el try-catch para construir la agenda en el HashMap
        // desde los datos del csv.
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();

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

        } catch (IOException e){
            e.printStackTrace();
        }

        //Best practice es usar try-catch cuando se manejen archivos.
        try {
            File file = new File(nombreArchivo);
            Scanner inputStream = new Scanner(file);
            int n = 0;
            // El while guarda cada dato del archivo csv en un Array, "x" o "a", según si es par o non.
            while(inputStream.hasNext()){
                String data = inputStream.next();
                if (n % 2 == 0){
                    data = data.substring(0, data.length()-1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    x.add(data);
                    n++;
                } else {
                    a.add(data);
                    n++;
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        // Al concluir la lectura del archivo y haber formado los Arrays "x" y "a",
        // el siguiente For Loop guarda el par datos correspondientes en el HashMap.
        // De esta forma se crea el HashMap con los datos del archivo csv.
        for (int i = 0; i < x.size(); i++){
            doctores.put(x.get(i),a.get(i));
        }
    }

    public static void agregar(){
        load();
        System.out.println("==AGREGAR NUEVO DOCTOR==.");
        System.out.println("Escriba a continuación el nombre del doctor:");

        Scanner nom = new Scanner(System.in);
        String nombre = nom.nextLine();
        int pSize = doctores.size() + 1;
        String pNew = String.valueOf(pSize);
        doctores.put(pNew,nombre);

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
            for (Map.Entry<String, String> set: doctores.entrySet()){
                pw.println(set.getKey() + ", " + set.getValue());
            }
            pw.flush();
            pw.close();
        } catch (Exception E){
            System.out.println("Error");
        }
    }
}
