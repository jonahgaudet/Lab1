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

    public static BuddyInfo importBuddy (String importText) {
        String[] fields = importText.split("#");
        return new BuddyInfo(fields[0], fields[1], fields[2]);
    }

    public String getName () {
        return name;
    }

    public String getInfo () {
        return name + " lives at " + address + ", with phone number " + phoneNumber;
    }

    public String toString () { return name + "#" + address + "#" + phoneNumber; }
}
