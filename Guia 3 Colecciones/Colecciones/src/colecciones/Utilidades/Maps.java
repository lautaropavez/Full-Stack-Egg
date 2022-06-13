package colecciones.Utilidades;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {

        HashMap<Integer, String> nombres = new HashMap();

        nombres.put(1, "Tu vieja"); // Nos pide primero la key(llave) y un valor(value) en este caso es un String porque nosotros pusimos eso arriba
        nombres.put(Integer.MAX_VALUE, "Tu mamá");// Le podemos poner el valor que nosotros queramos siempre y cuando sea un valor hasta el max valor de Integer por lo menos, pero no podemos poner un long como llave, si es un dni o rut si se lo aguanta

        //Escribo for + (Ctrl+Space) y nos sale primero este
        for (Map.Entry<Integer, String> aux : nombres.entrySet()) { //Vamos a tener una variable auxiliar "aux", lo vamos a recorrer sobre nombres.entryset, como que lo procesa para que lo podamos correr con este for
            Integer key = aux.getKey();
            String value = aux.getValue();

            System.out.println("key: " + key + ", value: " + value);
        }

        //----------------------------------------------------------------------
        HashMap<String, String> nombres2 = new HashMap();

        nombres2.put("1", "Tu hna");
        nombres2.put(String.valueOf(Long.MAX_VALUE), "Tu tia");// Para poner el valor del long ya que no podemos hacerlo cmo numero, lo hacemos como String.

        //Escribo for + (Ctrl+Space) y nos sale primero este
        for (Map.Entry<String, String> aux : nombres2.entrySet()) { //Vamos a tener una variable auxiliar "aux", lo vamos a recorrer sobre nombres.entryset, como que lo procesa para que lo podamos correr con este for
            String key = aux.getKey();
            String value = aux.getValue();

            System.out.println("key: " + key + ", value: " + value);
        }
    }
}
