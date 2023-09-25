package org.example;

import java.util.*;

public class PhoneBook {
    private final HashMap<String, List<String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = book.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        book.put(name, phoneNumbers);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(book.entrySet());
        sortedContacts.sort((a, b) -> b.getValue().size() - a.getValue().size());

        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + String.join(", ", phoneNumbers));
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Иванов", "333-33-33");
        phoneBook.addContact("Петров", "223-22-22");
        phoneBook.addContact("Сидоров", "444-33-44");
        phoneBook.addContact("Иванов", "222-22-22");
        phoneBook.addContact("Иванов", "548-33-33");
        phoneBook.addContact("Федотов", "777-33-33");
        phoneBook.addContact("Сидоров", "878-12-16");
        phoneBook.addContact("Демьянов", "567-89-12");

        phoneBook.printPhoneBook();
    }
}
