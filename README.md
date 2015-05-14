# Yamba

###**LAB5 CONTENT PROVIDERS - RESPUESTAS**

**Punto 1**

- DB_NAME: Este sera el fichero SQLite que contendra nuestra base de datos.
- DB_VERSION: Simplemente sera el numero de la version que le daremos al esquema creado para la base de datos.
- TABLE: Este sera el nombre de la tabla que contendra nuestra base de datos.
- DEFAULT_SORT: Ordena descendente por lo valores dados en Column.
- ID: Es un identificador de la tabla.

**Punto 2**

- El método **onCreate** se usa cuando la base de datos se crea por primera vez. Aquí es donde se define la estructura de las tablas y se cargan eventualmente los datos iniciales

- El método **onUpgrade** se usa cuando la base de datos debe ser actualizada.

**Punto 3**

import java.util.List;
Importa la clase listas contenida en el paquete java.util

import android.content.ContentValues;
Para poder definir campos, es decir los registros

import android.net.Uri;
Para referirnos a un Url Web

import com.marakana.android.yamba.clientlib.YambaClient.Status;
importamos la clase Status del API de Yamba

ContentValues values = new ContentValues();
Los valores a insertar los pasaremos como elementos de tipo ContentValues, donde almacenaremos parejas de clave-valor, donde la clave será el nombre de cada campo y el valor será el dato correspondiente a insertar en dicho campo.

for (Status status : timeline) {
values.clear();
values.put(StatusContract.Column.ID, status.getId());
values.put(StatusContract.Column.USER, status.getUser());
values.put(StatusContract.Column.MESSAGE,
status.getMessage());
values.put(StatusContract.Column.CREATED_AT, status
.getCreatedAt().getTime());

Por cada registro se crea un ContentValues y se reutiliza el mismo ya que se limpia cada vez que inicia un ciclo en el for para posteriormente llenarlo con los valores apropiados provenientes del Status

Uri uri = getContentResolver().insert(
StatusContract.CONTENT_URI, values);
if (uri != null) {
count++;
Log.d(TAG,
String.format("%s: %s", status.getUser(),
status.getMessage()));
}
}

if (count > 0) {
sendBroadcast(new Intent(
"com.marakana.android.yamba.action.NEW_STATUSES").putExtra(
"count", count));
}



###**LAB2 FRAGMENTS - RESPUESTAS**

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
###**LAB1 UI - RESPUESTAS**

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

