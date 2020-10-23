import javax.swing.*;
import java.util.EventObject;

public class AddressBookEvent extends EventObject {

    private DefaultListModel<BuddyInfo> buddies;
    private String name;
    public AddressBookEvent (AddressBookModel addressBookModel, DefaultListModel<BuddyInfo> list, String name) {
        super(addressBookModel);
        this.buddies = list;
        this.name = name;
    }

    public DefaultListModel<BuddyInfo> getBuddies () {
        return buddies;
    }

    public String getName () {
        return name;
    }
}
