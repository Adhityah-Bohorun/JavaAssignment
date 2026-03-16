import java.awt.*;
import javax.swing.*;

public class CustomerForm extends JDialog {

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtLicense;

    private CustomerList parent;
    private int row = -1;

    public CustomerForm(CustomerList parent){

        this.parent = parent;

        setTitle("Add Customer");
        setSize(300,250);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5,2,10,10));

        initComponents();

    }

    // EDIT CONSTRUCTOR
    public CustomerForm(CustomerList parent,String id,String name,String phone,String license,int row){

        this(parent);

        setTitle("Edit Customer");

        txtId.setText(id);
        txtName.setText(name);
        txtPhone.setText(phone);
        txtLicense.setText(license);

        this.row = row;

    }

    private void initComponents(){

        txtId = new JTextField();
        txtName = new JTextField();
        txtPhone = new JTextField();
        txtLicense = new JTextField();

        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");

        add(new JLabel("ID"));
        add(txtId);

        add(new JLabel("Name"));
        add(txtName);

        add(new JLabel("Phone"));
        add(txtPhone);

        add(new JLabel("License"));
        add(txtLicense);

        add(btnSave);
        add(btnCancel);

        btnSave.addActionListener(e -> saveCustomer());

        btnCancel.addActionListener(e -> dispose());

    }

    private void saveCustomer(){

        String id = txtId.getText();
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String license = txtLicense.getText();

        if(id.isEmpty() || name.isEmpty()){
            JOptionPane.showMessageDialog(this,"Fill all fields");
            return;
        }

        if(row == -1){

            parent.addCustomer(id,name,phone,license);

        } else {

            parent.updateCustomer(row,id,name,phone,license);

        }

        dispose();

    }
}
