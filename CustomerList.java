import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerList extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public CustomerList() {

        setTitle("Customer Management");
        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Customer List", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD,20));

        add(title, BorderLayout.NORTH);

        // Table columns
        String[] columns = {"ID","Name","Phone","License"};

        model = new DefaultTableModel(columns,0);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Sample Data
        model.addRow(new Object[]{"1","John Smith","58512345","LIC101"});
        model.addRow(new Object[]{"2","Sarah Brown","57987654","LIC102"});

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);

        add(buttonPanel, BorderLayout.SOUTH);

        // ADD BUTTON
        btnAdd.addActionListener(e -> {

            CustomerForm form = new CustomerForm(this);
            form.setVisible(true);

        });

        // EDIT BUTTON
        btnEdit.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(this,"Select a customer first");
                return;
            }

            String id = model.getValueAt(row,0).toString();
            String name = model.getValueAt(row,1).toString();
            String phone = model.getValueAt(row,2).toString();
            String license = model.getValueAt(row,3).toString();

            CustomerForm form = new CustomerForm(this,id,name,phone,license,row);
            form.setVisible(true);

        });

        // DELETE BUTTON
        btnDelete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(this,"Select a customer first");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Delete this customer?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );

            if(confirm == JOptionPane.YES_OPTION){
                model.removeRow(row);
            }

        });

    }

    // METHOD USED BY FORM TO ADD DATA
    public void addCustomer(String id, String name, String phone, String license){

        model.addRow(new Object[]{id,name,phone,license});

    }

    // METHOD USED BY FORM TO UPDATE DATA
    public void updateCustomer(int row,String id,String name,String phone,String license){

        model.setValueAt(id,row,0);
        model.setValueAt(name,row,1);
        model.setValueAt(phone,row,2);
        model.setValueAt(license,row,3);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new CustomerList().setVisible(true);
        });

    }
}
