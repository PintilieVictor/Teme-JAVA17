package Tema4;

import java.util.ArrayList;
import java.util.List;

class Phonefunctions extends PhoneModel {
    private List<Contact> contacts;
    private List<String> callHistory;

    public Phonefunctions(String modelName) {
        super(modelName);
        contacts = new ArrayList<>();
        callHistory = new ArrayList<>();
    }

    public void addContact(String phoneNumber, String firstName, String lastName) {
        Contact contact = new PhoneContact(phoneNumber, firstName, lastName);
        contacts.add(contact);
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        System.out.println("Sending message to " + phoneNumber + ": " + messageContent);
    }

    public void makeCall(String phoneNumber) {
        System.out.println("Making a call to " + phoneNumber);
        callHistory.add(phoneNumber);
    }

    public void viewHistory() {
        System.out.println("Call History:");
        for (String phoneNumber : callHistory) {
            System.out.println("Phone Number: " + phoneNumber);
        }
    }
}






