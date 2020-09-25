import java.util.*;
public class AddressBook {
    ArrayList<BuddyInfo> buddies;

    public AddressBook () {
        ArrayList<BuddyInfo> buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo newBuddy) {
        buddies.add(newBuddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        /*for (int i = 0; i < buddies.size(); i++) {
            if (buddies.get(i) == buddy) {
                buddies.remove(i);
            }
        }*/
        buddies.remove(buddy);
    }
}
