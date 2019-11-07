import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList(
                "Груша", "Яблоко", "Апельсин", "Лимон", "Ананас",
                "Виноград", "Клубника", "Лимон", "Гранат", "Смородина",
                "Крыжовник", "Черника", "Крыжовник", "Лимон", "Лимон",
                "Лимон", "Ананас", "Черника", "Лимон", "Гранат"
        );
        System.out.println("Исходный массив:");
        System.out.println(arr.toString() + "\n" );

        Set<String> set = new HashSet<String>(arr);
        System.out.println("Список уникальных слов, из которых состоит массив (дубликаты не считаем):");
        System.out.println(set.toString() + "\n" );

        System.out.println("В первоначальном массиве каждое слово встречается, раз:");
        for (String key : set) {
                System.out.println(key + ": " + Collections.frequency(arr, key));

        }


        TelephoneBook book = new TelephoneBook();
        book.add("Иванова", "+79780000000", "ivanova1@test.ru" );
        book.add("Петров", "+797800000001", "petrov1@test.ru");
        book.add("Петрова", "+79780000002", "petrova@test.ru");
        book.add("Сидоров", "+79780000003", "sidorov@test.ru");
        book.add("Иванова", "+79780000004", "ivanova2@test.ru");
        book.add("Петров", "+79780000005", "petrov2@test.ru");

        book.get("Иванова");
        book.get("Петров");
        book.get("Сидоров");
    }
}
