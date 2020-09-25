public class BuddyInfo {
    String name, phoneNumber, address;
    int age;

    public BuddyInfo (String name) {
        this.name = name;
    }

    public BuddyInfo (String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName () {
        return name;
    }
}
