package Contact_Information_Saver;

public class Contact implements Comparable<Contact>{
    private String name;
    private String phone_number;

    public Contact(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }
}
