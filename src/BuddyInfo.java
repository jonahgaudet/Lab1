public class BuddyInfo {
    String name, phoneNumber, address;

    public BuddyInfo (String name) {
        this.name = name;
    }

    public BuddyInfo (String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName () {
        return name;
    }

    public String toString () {
        return name + " lives at " + address + ", with phone number " + phoneNumber;
    }
}
