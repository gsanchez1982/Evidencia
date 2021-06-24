import java.util.*;
import java.io.*;

public class citas {
<<<<<<< Updated upstream
    static ArrayList<String[]> doctors = new ArrayList<>();
    //^Crea el ArrayList de doctores.

    static String nombreArchivo = "db//doctores.csv";
    //^Define el nombre y ubicación del archivo.

    public static void load() {

        ArrayList<String> udid = new ArrayList<>();
        ArrayList<String> nomDoc = new ArrayList<>();
        ArrayList<String> esp = new ArrayList<>();

=======
    static HashMap<String, String> pacientes = new HashMap<>();
    static HashMap<String, String> doctors = new HashMap<>();
    static ArrayList<String[]> citas = new ArrayList<>();


    static String nombreArchivo = "db//citas.csv";
    //^Define el nombre y ubicación del archivo.


    public static void load() {
        ArrayList<String> udid = new ArrayList<>();
        ArrayList<String> fechaCita = new ArrayList<>();
        ArrayList<String> horaCita = new ArrayList<>();
        ArrayList<String> motivoCita = new ArrayList<>();
        ArrayList<String> docId = new ArrayList<>();
        ArrayList<String> pacienteId = new ArrayList<>();

        //El siguiente código establece la comunicación entre el programa y el archivo csv:
        //En caso de que el archivo no exista, el try-catch crea un nuevo archivo de base de datos.
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
            n = 2;
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                if (n == 2) {
=======
            n = 5;
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                if (n == 5) {
>>>>>>> Stashed changes
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    udid.add(data);
                    n = n - 1;
                }
<<<<<<< Updated upstream
                if (n == 1) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    nomDoc.add(data);
                    n = n - 1;
                }
                if (n == 0) {

                    esp.add(data);
                    n = 2;
=======
                if (n == 4) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    fechaCita.add(data);
                    n = n - 1;
                }
                if (n == 3) {
                    data = data.substring(0, data.length() - 1);
                    horaCita.add(data);
                    n = n - 1;
                }
                if (n == 2) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    motivoCita.add(data);
                    n = n - 1;
                }
                if (n == 1) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    docId.add(data);
                    n = n - 1;
                }
                if (n == 0) {
                    pacienteId.add(data);
                    n = 5;
>>>>>>> Stashed changes
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < udid.size(); i++){
<<<<<<< Updated upstream
            String nuevoDoc[] = {udid.get(i), nomDoc.get(i), esp.get(i)};
            doctors.add(nuevoDoc);
        }
    }

=======
            String nuevaCita[] = {udid.get(i), fechaCita.get(i), horaCita.get(i), motivoCita.get(i), docId.get(i), pacienteId.get(i)};
            citas.add(nuevaCita);
        }
    }

    public static void cargarPacientes(){
        String archivoPacientes = "db//pacientes.csv";
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();


            File file = new File(archivoPacientes);
            if (file.exists() == false) {
                System.out.println("No existen pacientes. Favor de crear un paciente antes de continuar");
                menuPrincipal.opciones();
            }

        //Best practice es usar try-catch cuando se manejen archivos.
        try {
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
            pacientes.put(x.get(i),a.get(i));
        }
    }

    public static void cargarDocs() {
        String archivoDocs = "db//doctores.csv";
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();



            File file = new File(archivoDocs);
            if (file.exists() == false) {
                System.out.println("No existen doctores. Favor de crear un doctor antes de continuar");
                menuPrincipal.opciones();}


        //Best practice es usar try-catch cuando se manejen archivos.
        try {
            Scanner inputStream = new Scanner(file);
            int n = 0;
            n = 2;
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                if (n == 2) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    x.add(data);
                    n = n - 1;
                }
                if (n == 1) {
                    data = data.substring(0, data.length() - 1);
                    //^Esto se agrega para remover la coma que separa los datos.
                    a.add(data);
                    n = n - 1;
                }
                if (n == 0) {
                    data = data.substring(0, data.length() - 1);
                    n = 2;
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < x.size(); i++){
            doctors.put(x.get(i),a.get(i));
        }
    }
>>>>>>> Stashed changes


    public static void agregar(){
        load();
<<<<<<< Updated upstream
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
=======
        cargarDocs();
        cargarPacientes();

        System.out.println("==AGREGAR NUEVA CITA==");

        System.out.println("Escriba el nombre del paciente que solicita la cita:");
        Scanner p = new Scanner(System.in);
        String nomPac = p.nextLine();
        if (pacientes.containsValue(nomPac) == false){
            System.out.println("Ese paciente no existe en la base de datos.");
            System.out.println("Es necesario agregar el paciente antes de proceder con la cita.");
            System.out.println("Regresando al menú principal...");
            menuPrincipal.opciones();
        }

        System.out.println("Escriba el doctor con el que tendrá la cita:");
        Scanner doc = new Scanner(System.in);
        String nomDoc = doc.nextLine();
        if (doctors.containsValue(nomDoc) == false){
            System.out.println("Ese doctor no existe en la base de datos.");
            System.out.println("Es necesario agregar el doctor antes de proceder con la cita.");
            System.out.println("Regresando al menú principal...");
            menuPrincipal.opciones();
        }

        System.out.println("Escriba a continuación la fecha de la cita:");
        Scanner d = new Scanner(System.in);
        String appDate = d.nextLine();

        System.out.println("Escriba a continuación la hora de la cita:");
        Scanner h = new Scanner(System.in);
        String appTime = h.nextLine();

        System.out.println("Escriba a continuación el motivo de la cita:");
        Scanner mot = new Scanner(System.in);
        String motive = mot.nextLine();

        int pSize = citas.size() + 1;
        String udid = String.valueOf(pSize);

        String nuevaCita[] = {udid, appDate, appTime, motive, nomDoc, nomPac};
        citas.add(nuevaCita);

        save();
        System.out.println("Se agregó la cita. Volviendo al menú principal.");
>>>>>>> Stashed changes
        menuPrincipal.opciones();

    }

<<<<<<< Updated upstream
    //El siguiente método guardará los cambios realizados en la agenda, en el archivo.
=======
>>>>>>> Stashed changes
    public static void save(){
        try {
            FileWriter aw = new FileWriter(nombreArchivo, false);
            BufferedWriter bw = new BufferedWriter(aw);
            PrintWriter pw = new PrintWriter(bw);
<<<<<<< Updated upstream
            for (int i = 0; i < doctors.size(); i++){
                String[] newLine = doctors.get(i);
                String v1 = newLine[0];
                String v2 = newLine[1];
                String v3 = newLine[2];
                pw.println(v1 + ", " + v2 + ", " + v3);
=======
            for (int i = 0; i < citas.size(); i++){
                String[] newLine = citas.get(i);
                String id = newLine[0];
                String f = newLine[1];
                String h = newLine[2];
                String m = newLine[3];
                String d = newLine[4];
                String p = newLine[5];
                pw.println(id + ", " + f + ", " + h + ", " + m + ", " + d + ", " + p);
>>>>>>> Stashed changes

            }
            pw.flush();
            pw.close();
        } catch (Exception E){
            System.out.println("Error");
        }
    }
}
