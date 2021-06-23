import java.io.*;
import java.util.*;

//Esta clase tiene un solo método: opciones().
//El método opciones() es el menú interactivo del usuario para interactuar con las funciones del programa.

public class logIn {
    static HashMap<String, String> credentials = new HashMap<>();
    //^Crea el HashMap de credenciales.

    static String nombreArchivo = "db//login.csv";
    //^Define el nombre y ubicación del archivo.

    //El siguiente método carga el archivo a memoria, y después al HashMap, para ser utilizado por el programa.
    public static void load(){
        //Estos Arrays se crean para usarse en el try-catch para construir la agenda en el HashMap
        // desde los datos del csv.
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();

        //El siguiente código establece la comunicación entre el programa y el archivo csv:
        //En caso de que el archivo no exista, el try-catch crea un nuevo archivo de base de datos.
        File file = new File(nombreArchivo);
        if (!file.exists()){
            try {
            file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
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
            credentials.put(x.get(i),a.get(i));
        }
    }

    public static void inicio(){
        load();
        System.out.println("Por favor, inicie sesión.");
        System.out.println("Escriba a continuación su nombre de usuario y presione Enter:");

        Scanner uid = new Scanner(System.in);
        String userId = uid.nextLine();

        System.out.println("Ahora, escriba a continuación su contraseña y presione Enter:");

        Scanner pwd = new Scanner(System.in);
        String passwd = pwd.nextLine();

        if (credentials.containsKey(userId)){
            System.out.println("Tu usuario existe");
        } else {
            System.out.println("Tu usuario no existe");
        }

        if (credentials.get(userId) == passwd){
            System.out.println("Tu contraseña es correcta");
        } else {
            System.out.println("Tu contraseña es incorrecta");
        }

    }
}