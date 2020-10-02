import java.util.*;
public class AddressBook {
    ArrayList<BuddyInfo> buddies;

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Tom", 20, "123 Main Street", "6130123456");
        BuddyInfo buddy2 = new BuddyInfo("Jack", 56, "5 North road", "6136543210");
        //Text added to test commit
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.addBuddy(buddy2);
        addressBook.removeBuddy(buddy2);
        addressBook.removeBuddy(buddy);
    }

    public AddressBook () {
        ArrayList<BuddyInfo> buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo newBuddy) {
        buddies.add(newBuddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }
}
