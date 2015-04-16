# Yamba

###**LABORATORIO 2 - RESPUESTAS**

**Punto 6**

View view = inflater.inflate(R.layout.fragment_status, container, false);
Se utiliza para añadir la vista fragment_status al diseño del fragmento. 
Solo nos interesa inflar el contenedor que esta en el primer parametro (fragments_status).

**Punto 7**

a) Explicar:

- onResume(): El fragmento permite la interacción con el usuario.
- onStar(): Hace que el fragmento sea visible al usuario.
- onStop(): El usuario deja de utilizar el fragmento y por ende, ya no es visible.


b) Un Fragment siempre esta en un Activity, no pueden existir independientes. 
Lo que significa que si el ciclo de vida de la actividad termina, el o los fragmentos que esten en esa actividad también serán terminados.

**Punto 8**

Explicar:

- FragmentManager fragmentManager = getFragmentManager();

R/: Llama a un fragment dentro de una actividad.

- FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 

R/: Es un API que permite realizar transacciones entre fragments.

- FragmentTransaction.add(android.R.id.content, fragment,  fragment.getClass().getSimpleName()); 

R/: Es para agregar un fragmento al estado de la actividad.

- FragmentTransaction.commit(); 

R/: Se debe llamar el método commit para que los cambios se lleven a cabo en cada ejecución. 



.
###**LABORATORIO 1 - RESPUESTAS**

**Punto 2**

a)
android:layout_height="wrap_content"
esta propiedad le indica al componente que tome la altura acorde a su contenido


android:layout_height="match_parent"
esta propiedad le indica al componente que tome la altura de su componente padre, es decir el que le contiene


android:hint="@string/hint_status"
con esta propiedad pondremos un texto por defecto para un campo de texto mientras este se encuentre vacio, es decir, el usuario podra visualizarlo mientra no escriba nada 


android:inputType="textMultiLine"
esta propiedad permite el ingreso de varias lineas texto 


b) wrap_content asignara para el componente solo el espacio en pantalla requerido por su contenido, mientras que match_parent usara todo el espacio que tiene el componente padre 


c) Nos permite identificar un componente para hacer uso de el en la clase que despligue el fichero xml de layouts


**Punto 3**

a) android:text="string/Tweet"
Primero le hace falta el arroba para indicar el string y segundo la variable que se llama no existe, ya que 
su nombre es "button_tweet", y se referencia con este no con su contenido

android:text="@button_tweet/string"
En este caso se invirtio el verdadero orden, se identifica por el string y luego se llama la variable


**Punto 4**

a) @Override es una anotacion que significa que estas sobre escribiendo un metodo de la clase padre, ya sea para mejorar el metodo o para que se acople a tu clase hija


b) setContentView señala que hay una clase estática llamada R.layout y, que dentro de esa clase hay una constante entera que apunta a una vista definida por un fichero de recursos layout XML con los componentes que se visualizaran en la actividad y debe estar en el directorio ./res/layout


**Punto 5**

a) El método **findViewById()** enlaza las variables con los objetos definidos en el archivo XML. Recibe como parámetro una ruta que parte de la referencia a la clase R.

b) Al quitar el **(EditText)**, no compila el proyecto y saca un error "error: incompatible types: View cannot be converted to EditText" lo que significa que la vista no puede convertir el texto.


**Punto 7**

a) Los logging son registros de actividades del sistema. En Android existe la clase android.util.Log que proporciona ese servicio. Se clasifica por su nivel de criticidad.

b) LogCat permite la visualización de los mensajes de log. Ofrece varias funcionalidades para la visualización y búsqueda de determinados mensajes.

c) 3 tipos de Log 
- log.e(TAG, message) muestra los mensajes a nivel de Error
- log.w(TAG, message) muestra los mensajes a nivel de Warning
- log.i(TAG, message) muestra los mensajes a nivel de Informacion

d)


**Punto 8**

a) La diferencia entre un simple-thread y un multithread, es que el simple-thread son programas que realizan una sola tarea, denominados de flujo único. En cambio los multithread realizan más de una tarea, denominados de flujo multiple.

b) Una tarea asíncrona son cálculos que se ejecutan en un hilo secundario y cuyo resultado queremos que se publique en el hilo del interfaz de usuario.

Se crea de la siguiente manera (donde Parametros, Progreso y Resultado serán reemplazados por nombres de clases según los tipos de datos con los que trabaje la tarea):

class Laboratorio extends AsyncTask<Parametros, Progreso, Resultado> {
       @Override protected void onPreExecute() {
              …     
       }
       @Override protected Resultado doInBackground(Parametros... par) {
             …     
       }
       @Override protected void onProgressUpdate(Progreso... prog) {
       …     
       }
       @Override protected void onPostExecute(Resultado result) {
          …    
       }
}

El método **doInBackground()** es el que realiza la tarea asignada. Dicho método se ejecuta en el hilo del interfaz de usuario y lo hace en un hilo nuevo creado para ese propósito. 

c) El método **onPostExecute()** muestra la tarea en la interfaz de usuario.

