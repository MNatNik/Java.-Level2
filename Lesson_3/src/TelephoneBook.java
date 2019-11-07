import java.util.*;

public class TelephoneBook {
    private   HashMap<String,  HashSet<String>> tb;


    public TelephoneBook() {
        tb = new HashMap<>();
    }

    public void add(String surname, String phone, String email) {
        HashSet<String> book = tb.getOrDefault(surname, new HashSet<>());
        book.add(phone + " " + email);
        tb.put(surname, book);
    }

    public void get(String surname) {
        System.out.println("\nФамилия: " + surname  +  ", Телефонный номер и email: " + tb.getOrDefault(surname, new HashSet<>()));
    }
}
