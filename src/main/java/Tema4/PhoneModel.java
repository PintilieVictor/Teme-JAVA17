package Tema4;

abstract class PhoneModel {
    protected String modelName;

    public PhoneModel(String modelName) {
        this.modelName = modelName;
    }

    public abstract void addContact(String phoneNumber, String firstName, String lastName);

    public abstract void sendMessage(String phoneNumber, String messageContent);

    public abstract void makeCall(String phoneNumber);

    public abstract void viewHistory();
}

interface Contact {
    String getPhoneNumber();

    String getFirstName();

    String getLastName();
}

interface Phone {
    void addContact(String phoneNumber, String firstName, String lastName);

    void sendMessage(String phoneNumber, String messageContent);

    void makeCall(String phoneNumber);

    void viewHistory();
}

