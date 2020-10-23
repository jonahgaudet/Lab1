import javax.swing.*;
import java.util.*;

public class AddressBookModel extends DefaultListModel{
    private DefaultListModel<BuddyInfo> buddies;
    private String name;
    private ArrayList<AddressBookView> views;

    public AddressBookModel (String name) {
        this.buddies = new DefaultListModel<>();
        this.name = name;
        views = new ArrayList<AddressBookView>();
    }

    public void clear () {
        buddies.clear();
        updateViews();
    }

    public void addAddressBookView (AddressBookView newView) {
        views.add(newView);
    }

    public void removeAddressBookView (AddressBookView oldView) {
        views.remove(oldView);
    }

    public void updateViews () {
        for (AddressBookView view : views) {
            view.handleAddressBookUpdate(new AddressBookEvent(this, buddies, name));
        }
    }

    public void addBuddy(BuddyInfo newBuddy) {
        buddies.addElement(newBuddy);
        updateViews();
    }

    public void removeAt (int index) {
        buddies.remove(index);
        updateViews();
    }

    public DefaultListModel<BuddyInfo> getBuddies () {
        return buddies;
    }

    public void changeName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void getInfo () {
        System.out.println(name);
        for (int i = 0; i < buddies.size() ; i++) {
            System.out.println(buddies.get(i).name);
        }
    }
}
