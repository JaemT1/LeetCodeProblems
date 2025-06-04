package ArraysAndHashing;

import java.util.HashMap;

public class TwoSum {
    /**
     * LeetCode #1: Two Sum - Easy
     * Este método resuelve el problema de encontrar dos índices en un arreglo de enteros
     * cuyos valores suman un número objetivo (target). La solución utiliza un HashMap para
     * almacenar los números ya vistos junto con sus índices lo que evita la complejidad O(n^2).
     * En cada iteración se calcula el complemento necesario para alcanzar el target y se verifica si dicho complemento
     * ya fue visto anteriormente. Si es así, se devuelve el par de índices correspondiente.
     * Esta estrategia permite reducir la complejidad temporal de O(n²) (fuerza bruta)
     * a O(n), recorriendo el arreglo solo una vez.
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> seenNumbers = new HashMap<Integer, Integer>();

        for (int i = 0; i <= nums.length - 1; i++) {
            int complemento = target - nums[i];
            if (seenNumbers.get(complemento) == null) {
                seenNumbers.put(nums[i], i);
            }else{
                result[0] = seenNumbers.get(complemento);
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        //int[] nums = {2, 7, 11, 15};
        //int[] nums = {3,2,4};
        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
