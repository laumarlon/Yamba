# Yamba

Preguntas


2)

a)
android:layout_height="wrap_content"
esta propiedad le indica al componente que tome la altura acorde a su contenido


android:layout_height="match_parent"
esta propiedad le indica al componente que tome la altura de su componente padre, es decir el que le contiene


android:hint="@string/hint_status"
con esta propiedad pondremos un texto por defecto para un campo de texto mientras este se encuentre vacio, es decir, el usuario podra visualizarlo mientra no escriba nada 


android:inputType="textMultiLine"
esta propiedad permite el ingreso de varias lineas texto 


b)wrap_content asignara para el componente solo el espacio en pantalla requerido por su contenido, mientras que match_parent usara todo el espacio que tiene el componente padre 


c)nos permite identificar un componente para hacer uso de el en la clase que despligue el fichero xml de layouts

3)

a)android:text="string/Tweet"
Primero le hace falta el arroba para indicar el string y segundo la variable que se llama no existe, ya que 
su nombre es "button_tweet", y se referencia con este no con su contenido

android:text="@button_tweet/string"
En este caso se invirtio el verdadero orden, se identifica por el string y luego se llama la variable

4)

a)@Override es una anotacion que significa que estas sobre escribiendo un metodo de la clase padre, ya sea para mejorar el metodo o para que se acople a tu clase hija


b)setContentView señala que hay una clase estática llamada R.layout y, que dentro de esa clase hay una constante entera que apunta a una vista definida por un fichero de recursos layout XML con los componentes que se visualizaran en la actividad y debe estar en el directorio ./res/layout
