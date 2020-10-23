import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddressBookView extends JFrame implements ActionListener {

    public JPanel mainPanel;

    public JLabel addressBookName;
    public AddressBookControl addressBook;
    public JList buddyList;

    public AddressBookView () {

        addressBook = new AddressBookControl("Address Book");
        buddyList = new JList(addressBook.getBuddies());
        buddyList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        addressBookName = new JLabel("Book Name: " + addressBook.name);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(addressBookName, BorderLayout.PAGE_START);
        mainPanel.add(buddyList, BorderLayout.CENTER);
        add(mainPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu addressBookMenu = new JMenu("Address Book");

        JMenuItem createAddressBook = new JMenuItem("Create New Address Book");
        createAddressBook.addActionListener(this);
        createAddressBook.setActionCommand("new");

        JMenuItem addBuddyInfo = new JMenuItem("Add Buddy Info");
        addBuddyInfo.addActionListener(this);
        addBuddyInfo.setActionCommand("addBuddy");

        JMenuItem removeBuddyInfo = new JMenuItem("Remove Buddy Info");
        removeBuddyInfo.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JMenuItem){
            String actionCommand = e.getActionCommand();
            switch (actionCommand){
                case "new" ->{
                    String name = (String)JOptionPane.showInputDialog(
                            this,
                            "Name of the Address Book",
                            "Name Input",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            "");
                    addressBookName.setText("Book name: " + name);
                    addressBook = new AddressBookControl(name);
                    mainPanel.remove(buddyList);
                    buddyList = new JList(addressBook.getBuddies());
                    buddyList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    mainPanel.add(buddyList, BorderLayout.CENTER);
                }
                case "addBuddy" ->{
                    if (addressBook == null) {
                        System.out.println("Have not created an address book yet");
                        return;
                    }
                    JTextField name = new JTextField();
                    JTextField address = new JTextField();
                    JTextField phone = new JTextField();
                    Object[] message = {
                            "Name:", name,
                            "Address:", address,
                            "Phone:", phone
                    };

                    int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        BuddyInfo buddy = new BuddyInfo(name.getText(), address.getText(), phone.getText());
                        addressBook.buddies.addElement(buddy);
                    } else {
                        System.out.println("Buddy creation failed");
                    }
                }
                case "removeBuddy" ->{
                    if (buddyList == null)
                        return;
                    int[] selected = buddyList.getSelectedIndices();
                    if (selected.length == 0)
                        return;
                    Arrays.sort(selected);
                    for(int i = selected.length - 1; i >= 0; i--){
                        addressBook.getBuddies().removeElementAt(selected[i]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AddressBookView myTest = new AddressBookView();
    }

}
