import java.awt.*;
import javax.swing.*;

public class CreateBooking extends JFrame {

    private JComboBox<String> cmbCustomer;
    private JComboBox<String> cmbCar;

    private JTextField txtStartDate;
    private JTextField txtEndDate;
    private JTextField txtDailyRate;
    private JTextField txtTotalCost;

    private JButton btnCalculate;
    private JButton btnCreate;
    private JButton btnCancel;

    public CreateBooking() {

        setTitle("Create Booking / Rental");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Create Booking", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Customer Dropdown
        cmbCustomer = new JComboBox<>();
        cmbCustomer.addItem("Select Customer");
        cmbCustomer.addItem("C001 - John Smith");
        cmbCustomer.addItem("C002 - Sarah Brown");

        // Car Dropdown
        cmbCar = new JComboBox<>();
        cmbCar.addItem("Select Car");
        cmbCar.addItem("CAR01 - Toyota Vitz");
        cmbCar.addItem("CAR02 - Honda Civic");

        // Fields
        txtStartDate = new JTextField();
        txtEndDate = new JTextField();
        txtDailyRate = new JTextField();
        txtTotalCost = new JTextField();

        txtTotalCost.setEditable(false);

        // Add to panel
        panel.add(new JLabel("Customer:"));
        panel.add(cmbCustomer);

        panel.add(new JLabel("Car:"));
        panel.add(cmbCar);

        panel.add(new JLabel("Start Date (YYYY-MM-DD):"));
        panel.add(txtStartDate);

        panel.add(new JLabel("End Date (YYYY-MM-DD):"));
        panel.add(txtEndDate);

        panel.add(new JLabel("Daily Rate:"));
        panel.add(txtDailyRate);

        panel.add(new JLabel("Total Cost:"));
        panel.add(txtTotalCost);

        // Calculate Button
        btnCalculate = new JButton("Calculate Cost");
        panel.add(btnCalculate);

        add(panel, BorderLayout.CENTER);

        // Bottom buttons
        JPanel bottomPanel = new JPanel();

        btnCreate = new JButton("Create Booking");
        btnCancel = new JButton("Cancel");

        bottomPanel.add(btnCreate);
        bottomPanel.add(btnCancel);

        add(bottomPanel, BorderLayout.SOUTH);

        // EVENTS

        // Calculate total cost
        btnCalculate.addActionListener(e -> calculateCost());

        // Create booking
        btnCreate.addActionListener(e -> createBooking());

        // Cancel
        btnCancel.addActionListener(e -> clearForm());
    }

    private void calculateCost() {

        try {
            String start = txtStartDate.getText();
            String end = txtEndDate.getText();
            double rate = Double.parseDouble(txtDailyRate.getText());

            // Simple fake calculation (you can improve later)
            int days = 3; // placeholder (replace with real date diff later)

            double total = days * rate;

            txtTotalCost.setText(String.valueOf(total));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Invalid input!");
        }
    }

    private void createBooking() {

        if(cmbCustomer.getSelectedIndex() == 0 ||
           cmbCar.getSelectedIndex() == 0 ||
           txtStartDate.getText().isEmpty() ||
           txtEndDate.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,"Please fill all fields!");
            return;
        }

        JOptionPane.showMessageDialog(this,"Booking Created Successfully!");

        clearForm();
    }

    private void clearForm() {

        cmbCustomer.setSelectedIndex(0);
        cmbCar.setSelectedIndex(0);
        txtStartDate.setText("");
        txtEndDate.setText("");
        txtDailyRate.setText("");
        txtTotalCost.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new CreateBooking().setVisible(true);
        });
    }
}
