import java.util.*;

public class Main {

    public static void main(String[] arg) {

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        text = text.toLowerCase(); //Переводим все в нижний регистр
        text = text.replaceAll("[^a-zA-Z]", ""); //Убираем все символы за исключением алфавита
        ///**/System.out.println(text);

        char[] strToArray = text.toCharArray(); // Преобразуем текст в массив символов (char)

        //Map для хранения "Символа-Количество раз встретился"
        Map<Character, Integer> words = new HashMap<>();

        // Вывод массива на экран
        for (int i = 0; i < strToArray.length; i++) {
            if (words.containsKey(strToArray[i])) {
                int a = words.get(strToArray[i]);
                a++;
                words.put(strToArray[i], a);
            } else {
                words.put(strToArray[i], 1);
            }
        }

        Collection<Integer> values = words.values();

        int max = getMax(values);
        int min = getMin(values);

        List<Character> maxInjects = new ArrayList<>();
        List<Character> minInjects = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : words.entrySet()) {
            if (entry.getValue() == max) {
                maxInjects.add(entry.getKey());
            } else if (entry.getValue() == min) {
                minInjects.add(entry.getKey());
            }
        }

        System.out.println("Максимальное количество: " + maxInjects);
        System.out.println("Минимальное количество: " + minInjects);
    }

    private static int getMin(Collection<Integer> values) {
        List<Integer> integers = new ArrayList<>(values);
        int min = integers.get(0);
        for (Integer number : integers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }


    private static int getMax(Collection<Integer> values) {
        List<Integer> integers = new ArrayList<>(values);
        int max = integers.get(0);
        for (Integer number : integers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}