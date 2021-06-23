import java.io.*;
import java.util.*;

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


        if (credentials.containsKey(userId)){

            //Si el usuario existe, se solicita la contraseña del usuario:
            System.out.println("Ahora, escriba a continuación su contraseña y presione Enter:");
            Scanner pwd = new Scanner(System.in);
            String passwd = pwd.nextLine();

            System.out.println(credentials.get(userId));

            //El siguiente if comprueba si la contraseña es correcta.
            //Si lo es, lleva al usuario al menu principal.
            //Si no lo es, se le lleva al menú de credenciales incorrectas.

            if (credentials.get(userId).equals(passwd)){
                menuPrincipal.opciones();
            } else {
                System.out.println("Tu contraseña es incorrecta");
                incorrecto();

            }
        } else {
            //Si el usuario no existe, se le avisa al usuario, y se le lleva al menú de credenciales incorrectas.
            System.out.println("Tu usuario no existe.");
            incorrecto();
        }
        }


    // Menú de credenciales incorrectas:
    // Se le pregunta al usuario si quiere volver a intentarlo, o salir del programa.
    public static void incorrecto() {
        System.out.println("¿Deseas volver a intentarlo, o salir del programa?");
        System.out.println("[1] -- Volver a intentarlo.");
        System.out.println("[2] -- Salir del programa.");

        Scanner seleccion = new Scanner(System.in);
        String y = seleccion.nextLine();

        switch (y) {
            case "1":
                inicio();
            case "2":
                System.out.println("El programa ha terminado exitosamente. ¡Hasta luego!");
                System.exit(0);
            default:
                System.out.println("Esa no es una opción válida. Favor de intentar de nuevo.");
                incorrecto();

        }
    }
}