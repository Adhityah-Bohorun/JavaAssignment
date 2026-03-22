import java.awt.*;
import javax.swing.*;

public class ReturnCar extends JFrame {

    private JTextField txtBookingId;
    private JTextField txtReturnDate;
    private JTextField txtExtraCharges;
    private JCheckBox chkDamaged;
    private JTextArea txtNotes;

    public ReturnCar() {

        setTitle("Return Car & Inspection");
        setSize(450,400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Return Car & Inspection", JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        txtBookingId = new JTextField();
        txtReturnDate = new JTextField();
        txtExtraCharges = new JTextField();

        chkDamaged = new JCheckBox("Car Damaged");

        txtNotes = new JTextArea(3,20);

        panel.add(new JLabel("Booking ID:"));
        panel.add(txtBookingId);

        panel.add(new JLabel("Return Date:"));
        panel.add(txtReturnDate);

        panel.add(new JLabel("Extra Charges:"));
        panel.add(txtExtraCharges);

        panel.add(new JLabel("Damage:"));
        panel.add(chkDamaged);

        panel.add(new JLabel("Inspection Notes:"));
        panel.add(new JScrollPane(txtNotes));

        add(panel, BorderLayout.CENTER);

        JPanel bottom = new JPanel();

        JButton btnComplete = new JButton("Complete Return");
        JButton btnCancel = new JButton("Cancel");

        bottom.add(btnComplete);
        bottom.add(btnCancel);

        add(bottom, BorderLayout.SOUTH);

        btnComplete.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Car Returned Successfully!");
        });

        btnCancel.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        new ReturnCar().setVisible(true);
    }
}
