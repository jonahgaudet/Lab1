import javax.swing.*;
import java.util.*;

public class AddressBookControl {
    DefaultListModel<BuddyInfo> buddies;
    String name;

    public AddressBookControl (String name) {
        this.buddies = new DefaultListModel<>();
        this.name = name;
    }

    public void testAddressBook () {
        BuddyInfo buddy = new BuddyInfo("Tom", "123 Main Street", "6130123456");
        BuddyInfo buddy2 = new BuddyInfo("Jack","5 North road", "6136543210");
        this.addBuddy(buddy);
        this.addBuddy(buddy2);
    }
    public void addBuddy(BuddyInfo newBuddy) {
        buddies.addElement(newBuddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.removeElement(buddy);
    }

    public DefaultListModel<BuddyInfo> getBuddies () {
        return buddies;
    }

    public boolean isEmpty () {
        return buddies.isEmpty();
    }

    public String toString () {
        return name;
    }

    public String getInfo () {
        String s = toString();
        for (int i = 0; i < buddies.getSize() ; i++) {
            BuddyInfo b = buddies.elementAt(i);
            s += "\n" + b.getName();
        }

        return s;
    }
}
