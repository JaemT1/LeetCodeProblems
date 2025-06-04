package ArraysAndHashing;

import java.util.HashMap;

public class RomanToInteger {

    /**
     *LeetCode #13: Roman to Integer - Easy
     *Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000

     * Este método convierte un número romano representado como una cadena en su valor entero.
     * Se utiliza un HashMap para asociar cada símbolo romano con su valor correspondiente.
     * Luego se recorre la cadena de izquierda a derecha y se aplica la siguiente lógica:

     * - Si el valor del símbolo actual es menor que el del siguiente, se trata de un caso de
     *   "sustracción" (como IV = 4 o CM = 900), por lo que el valor actual se resta.
     * - Si no, el valor se suma al resultado acumulado.

     * Esta estrategia evita tener que codificar manualmente todos los casos especiales de sustracción,
     * haciendo el código más limpio, general y fácil de mantener.

     * Además, se usa un bucle `for` con un `if` simple, lo cual mejora la legibilidad frente a una
     * larga cadena de `if/else`. La complejidad temporal es O(n), siendo n la longitud de la cadena,
     * y la solución es eficiente incluso para los casos más largos permitidos por la restricción (15 caracteres).
     */
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        int resultado = 0;

        for (int i = 0; i < s.length(); i++) {
            int valorActual = romanNumbers.get(s.charAt(i));

            // Si hay un siguiente símbolo y su valor es mayor, es un caso de resta
            if (i + 1 < s.length() && valorActual < romanNumbers.get(s.charAt(i + 1))) {
                resultado -= valorActual;
            } else {
                resultado += valorActual;
            }
        }

        return resultado;
        
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int resultado = romanToInt(s);
        System.out.println(resultado);
    }
}
