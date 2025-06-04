package ArraysAndHashing;

public class PalindromeNumber {

    /**
    * LeetCode #9: Palindrome Number - Easy
    * Este método determina si un número entero es un palíndromo sin convertirlo a una cadena.
    * Primero se descartan los casos que nunca podrían ser palíndromos, como los números negativos
    * o aquellos que terminan en 0 pero no son 0 (por ejemplo, 10, 100, etc.).

    * Luego se invierte solo la mitad del número original. Esto se logra extrayendo el último dígito
    * del número (`x % 10`) y acumulándolo en la variable `mitad`, que representa la versión invertida
    * parcial. Se continúa este proceso hasta que `mitad` sea mayor o igual a `x`, es decir, hasta haber
    * invertido la mitad (o un poco más en el caso de longitud impar).

    * La comparación final verifica si el número original (`x`) coincide exactamente con la mitad invertida (`mitad`)
    * o con `mitad / 10` en el caso de que el número tenga una cantidad impar de dígitos (el dígito del medio se descarta).

    * Se utiliza un `while` en lugar de un `for` porque este tipo de problemas no requiere una cantidad fija de iteraciones,
    * sino una condición basada en el estado actual de las variables. El `while` comunica de forma más clara que "seguimos
    * hasta alcanzar cierta condición", lo cual lo hace más intuitivo para este caso, aunque un `for` también sería válido.

    * Esta solución es eficiente, con complejidad O(log₁₀(n)) en tiempo, ya que procesa solo la mitad de los dígitos del número.
    */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 &&  x % 10 == 0)) {
            return false;
        }

        int mitad = 0;

        while(x > mitad){
            mitad = (mitad * 10) + (x % 10);
            x = x / 10;
        }

        return x == mitad || x == mitad / 10;
    }

    public static void main(String[] args) {
        int x = 12321;
        boolean isPalindrome = isPalindrome(x);
        System.out.println(isPalindrome);
    }
}
