import javax.swing.*;
import java.awt.*;

public class AddressBookFrame extends JFrame implements AddressBookView {

    private JLabel bookTitle;
    private JList buddyList;

    public AddressBookFrame () {

        super("Address Book");

        AddressBookModel abm = new AddressBookModel("Address Book");
        abm.addAddressBookView(this);
        buddyList = new JList(abm.getBuddies());
        buddyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        AddressBookController abc = new AddressBookController(abm, buddyList);

        bookTitle = new JLabel(abm.getName());
        bookTitle.setHorizontalAlignment(JLabel.CENTER);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(bookTitle, BorderLayout.PAGE_START);
        mainPanel.add(buddyList, BorderLayout.CENTER);
        add(mainPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu addressBookMenu = new JMenu("Address Book");

        JMenuItem createAddressBook = new JMenuItem("Create New Address Book");
        createAddressBook.addActionListener(abc);
        createAddressBook.setActionCommand("new");

        JMenuItem addBuddyInfo = new JMenuItem("Add Buddy Info");
        addBuddyInfo.addActionListener(abc);
        addBuddyInfo.setActionCommand("addBuddy");

        JMenuItem removeBuddyInfo = new JMenuItem("Remove Buddy Info");
        removeBuddyInfo.addActionListener(abc);
        removeBuddyInfo.setActionCommand("removeBuddy");

        addressBookMenu.add(createAddressBook);
        addressBookMenu.add(addBuddyInfo);
        addressBookMenu.add(removeBuddyInfo);

        menuBar.add(addressBookMenu);

        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void handleAddressBookUpdate(AddressBookEvent addressBookModel) {
        buddyList.clearSelection();
        bookTitle.setText("Empty Name");
        if (!addressBookModel.getName().equals(""))
            bookTitle.setText(addressBookModel.getName());

        buddyList.setModel(addressBookModel.getBuddies());
    }

    public static void main(String[] args) {
        AddressBookFrame myTest = new AddressBookFrame();
    }
}
