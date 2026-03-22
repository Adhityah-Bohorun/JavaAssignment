import java.awt.*;
import javax.swing.*;

public class CustomerDetails extends JDialog {

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtLicense;

    public CustomerDetails(JFrame parent, String id, String name, String phone, String license) {

        super(parent, "Customer Details", true);

        setSize(350,250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Customer Details", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD,18));

        add(title, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        txtId = new JTextField(id);
        txtName = new JTextField(name);
        txtPhone = new JTextField(phone);
        txtLicense = new JTextField(license);

        // make read-only
        txtId.setEditable(false);
        txtName.setEditable(false);
        txtPhone.setEditable(false);
        txtLicense.setEditable(false);

        formPanel.add(new JLabel("Customer ID:"));
        formPanel.add(txtId);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(txtName);

        formPanel.add(new JLabel("Phone:"));
        formPanel.add(txtPhone);

        formPanel.add(new JLabel("License No:"));
        formPanel.add(txtLicense);

        add(formPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();

        JButton btnClose = new JButton("Close");

        buttonPanel.add(btnClose);

        add(buttonPanel, BorderLayout.SOUTH);

        btnClose.addActionListener(e -> dispose());
    }
}
