import java.util.*;

//Esta clase tiene un solo método: opciones().
//El método opciones() es el menú interactivo del usuario para interactuar con las funciones del programa.

public class menuPrincipal {
    public static void opciones(){
        System.out.println("Seleccione del siguiente menú la opción deseada:");
        System.out.println("[1] -- Agregar un Doctor");
        System.out.println("[2] -- Agregar un Paciente");
        System.out.println("[3] -- Crear una nueva cita");
        System.out.println("[4] -- Cambiar de usuario");
        System.out.println("[5] -- Salir del Programa");
        System.out.println("");
        System.out.println("Escriba el número de su opción a continuación:");

        Scanner opcion = new Scanner(System.in);
        String x = opcion.nextLine();

        switch(x) {
            case "1":
                doctores.agregar();
            case "2":
                pacientes.agregar();
            case "3":
                citas.agregar();
            case "4":
                logIn.inicio();
            case "5":
                System.out.println("El programa ha terminado exitosamente. ¡Hasta luego!");
                System.exit(0);
            default:
                System.out.println("Esa no es una opción válida. Favor de intentar de nuevo.");
                opciones();
        }
    }
}
