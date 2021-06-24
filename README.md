==INSTALACION Y CONFIGURACION==

Ya no me alcanzó el tiempo para desarrollar esta parte.

==USO DEL PROGRAMA==

El programa requiere de la creación de una base de datos en formato csv de usuarios y contraseñas en el archivo login.csv, mismo que solo debe ser accesible para el administrador del programa, y no para los usuarios. 

Main da la bienvenida al programa y carga la clase login, el metodo inicio(), donde se solicita al usuario su id de usuario, y su contraseña.
Si la id de usuario no existe, el programa termina y se le solicita al usuario que contacte a soporte técnico para agregarlo a la base de datos.
Si la contraseña es incorrecta, se le da la opción al usuario de volverlo a intentar o salir del programa.
No se le da la opción al usuario de crear un userid y constraseña, pues esto estaba fuera del alcance del proyecto, y no estaba incluido en las instrucciones.

Una vez que el usuario y la contraseña son validados, se carga la clase menuPrincipal, con el metodo opciones(), es un switch donde el usuario decide si quiere agregar un doctor, agregar un paciente, crear una cita, regresar a login, o salir del programa.

Si el usuario quisiera agregar un doctor, se carga el metodo agregar() de la clase doctores. Se carga o se crea una base de datos csv de doctores, basado en un ArrayList, donde se almacena un UDID, nombre de doctor, y especialidad. Se le pide al usuario que ingrese el nombre del nuevo doctor, y su especialidad, y luego se agregan al ArrayList, para posteriormente guardarse en una sobreescritura del archivo csv.

Similarmente, si el usuario quisiera agregar un paciente, se carga el metodo agregar() de la clase pacientes. Se carga o se crea una base de datos csv de pacientes, basado en un HashMap, donde se almacena un UDID, y el nombre del paciente,. Se le pide al usuario que ingrese el nombre del nuevo paciente, y luego se agregan al HashMap, para posteriormente guardarse en una sobreescritura del archivo csv.

Finalmente, si el usuario quisiera agregar una cita, se invoca el metodo agregar() de la clase citas. Se carga a HashMap la base de datos de pacientes, y el UDID y nombre de los doctores, ignorando su especialidad. Además, se carga o se crea una base de datos csv con las citas. Se pide al usuario ingresar el nombre del paciente. Si el paciente no existe, se le dirige a pacientes.agregar(). Luego, se le pide al usuario ingresar el nombre del doctor, si el doctor no existe, se le dirge a doctores.agregar(). Finalmente, se le solicita al usuario la fecha, hora, y motivo de la cita. Todos estos datos son agregardos a un ArrayList de String[] (Arreglo de arreglos), mismos que se exportan a la base de datos csv.

Al finalizar cada una de las actividades, se regresa al menu prinicipal, donde el usuario tiene la opción de cerrar sesión, o salir del programa.

==Créditos==

Este trabajo es original del alumno Guillermo Sánchez Estrada.

Universidad TecMilenio, Carrera Ingeniero en Computación Administrativa.

Matricula 2911468

==Licencia==

Este software se distribuye bajo la licencia GNU GPL, licencia general pública, versión 3. 

La GNU GPL es una licencia libre, de "copyleft" para software y otro tipo de obras.
- Cualquiera tiene permiso de copiar, distribuir, y modificar este software.
- Debes incluir esta licencia y notificación de copyright en cada una y todas las distribuciones.
- Puedes usar este software de manera privada.
- Puedes usar este software para propósitos comerciales.
- Si te atreves a construir tu negocio únicamente sobre este código, corres el riesgo de abrir el código fuente de toda tu base de código.
- Si lo modificas, debes indicar los cambios que has hecho al código.
- Cualquier modificación a este código deben ser distribuidas bajo la misma licencia, GPLv3.
- Este software se provee sin garantía.
- El autor o licenciado de este software no será considerado responsable de cualquier daño infligido por este software.
