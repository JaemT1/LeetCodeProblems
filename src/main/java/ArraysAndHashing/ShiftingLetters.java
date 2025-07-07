package ArraysAndHashing;

public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] resultChars = s.toCharArray(); // Convertimos la cadena a un array de caracteres para modificarlos.

        long currentShift = 0; // Usamos long para currentShift para evitar desbordamientos
        // antes de aplicar el módulo, ya que shifts[i] puede ser grande.

        // Iteramos desde el final del array de shifts hacia el principio
        for (int i = n - 1; i >= 0; i--) {
            // Acumulamos el desplazamiento actual
            // Tomamos el módulo 26 para manejar el 'wrapping' del alfabeto
            currentShift = (currentShift + shifts[i]) % 26;

            // Calculamos el nuevo carácter
            // 1. Convertimos el carácter original a su posición 0-indexada ('a' es 0, 'b' es 1, etc.)
            // 2. Sumamos el desplazamiento acumulado
            // 3. Tomamos el módulo 26 para asegurarnos de que el nuevo carácter esté dentro del alfabeto (0-25)
            // 4. Sumamos 'a' de nuevo para convertir la posición 0-indexada de vuelta a un carácter ASCII
            resultChars[i] = (char) ('a' + ((s.charAt(i) - 'a' + currentShift) % 26));
        }

        // Convertimos el array de caracteres modificado de nuevo a una cadena
        return new String(resultChars);
    }

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3, 5, 9};

        String result = shiftingLetters(s, shifts);
        System.out.println("Resultado: " + result); // Debería imprimir "rpl"
    }
}
