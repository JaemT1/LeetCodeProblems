package ArraysAndHashing;

public class LongestCommonPrefix {
    /**
     * Versión inicial que intenta encontrar el prefijo común más largo.
     *
     * Enfoque:
     * - Empieza desde la mitad del primer string (`fin = strs[0].length() / 2`) e intenta validar si ese prefijo
     *   se repite en los demás strings.
     * - Si no se encuentra coincidencia en todos, reduce el tamaño del prefijo (decreciendo `fin`) y reinicia la validación.
     * - Utiliza `startsWith` para comparar prefijos y un contador para verificar coincidencias.
     *
     * Pros:
     * - Solución creativa que reduce progresivamente la longitud del prefijo.
     *
     * Contras:
     * - Puede fallar en casos con prefijos de longitud 1 o donde el común está justo al inicio (e.g., ["ab", "a"]).
     * - La lógica de reinicio del bucle (`i = 0`) y uso del contador puede introducir redundancias.
     * - Complejidad potencialmente mayor a O(N*M) por repetir validaciones.
     *
     * Resultado:
     * - Funciona correctamente en muchos casos básicos, pero puede romperse en límites o casos no triviales.
     */

    public static String longestCommonPrefix(String[] strs) {
        int inicio = 0;
        int fin = strs[0].length()/2;

        String subStr = strs[0].substring(inicio, fin);

        int contador = 1;

        for (int i = 1; i < strs.length; i++) {

            if (inicio == fin){
                return "";
            }

            if (strs[i].startsWith(subStr)){
                contador++;
            }

            if (i == strs.length-1 && contador != strs.length){
                contador = 1;
                i = 0;
                fin -= 1;
                subStr = strs[0].substring(inicio, fin);
            }
        }

        if (contador == strs.length){
            return subStr;
        }
        return "";
    }

    /**
     * Solución mejorada (Horizontal Scanning).
     *
     * Enfoque:
     * - Toma el primer string como prefijo base.
     * - Lo compara con cada string siguiente, y lo acorta mientras no coincida como prefijo.
     * - Usa `startsWith` y `substring` de forma eficiente para reducir el prefijo hasta encontrar el común.
     *
     * Ventajas:
     * - Limpia y fácil de entender.
     * - Siempre retorna el prefijo correcto, incluso en casos límite.
     * - No reinicia bucles ni usa contadores innecesarios.
     *
     * Complejidad:
     * - Tiempo: O(N * M), donde N = número de strings, M = longitud promedio del prefijo.
     * - Espacio: O(1), sin estructuras auxiliares.
     *
     * Resultado:
     * - Solución óptima y robusta, ideal para entornos productivos o entrevistas técnicas.
     */

    public static String longestCommonPrefixImproved(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight","flew"};
        System.out.println(longestCommonPrefixImproved(strs));

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefixImproved(strs2));
    }
}
