import java.util.*;

public class PhoneBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact c) {
        contacts.add(c);
    }

    public void removeContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    public Contact searchContact(String name) {
        return contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void updateContact(String name, Contact newInfo) {
        Contact c = searchContact(name);
        if (c != null) {
            c.setPhoneNumber(newInfo.getPhoneNumber());
            c.setEmail(newInfo.getEmail());
        }
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("연락처가 없습니다.");
        } else {
            contacts.forEach(System.out::println);
        }
    }
}
