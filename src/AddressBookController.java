import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddressBookController implements ActionListener {

    private AddressBookModel addressBookModel;
    private JList buddyList;

    public AddressBookController (AddressBookModel abm, JList buddyList) {
        this.addressBookModel = abm;
        this.buddyList = buddyList;
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand() == null)
            return;
        String command = e.getActionCommand().split(" ")[0];

        switch (command){
            case "new" ->{
                String name = (String)JOptionPane.showInputDialog(
                        null,
                        "Name of the Address Book",
                        "Name Input",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "");

                addressBookModel.changeName(name);
                addressBookModel.clear();
            }
            case "addBuddy" ->{
                if (addressBookModel == null) {
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
                    addressBookModel.addBuddy(new BuddyInfo(name.getText(), address.getText(), phone.getText()));
                } else {
                    System.out.println("Buddy creation failed");
                }
            }
            case "removeBuddy" ->{
                if (buddyList.getModel().getSize() == 0)
                    return;
                try {
                    addressBookModel.removeAt(buddyList.getSelectedIndex());
                }
                catch (Exception exception) {
                    return;
                }
            }
        }
    }
}