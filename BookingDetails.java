import java.awt.*;
import javax.swing.*;

public class BookingDetails extends JFrame {

    public BookingDetails(String bookingId, String customer, String car,
                          String startDate, String endDate, String totalCost) {

        setTitle("Booking Details");
        setSize(400,300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(7,2,10,10));
        ((JComponent)getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(15,15,15,15));

        add(new JLabel("Booking ID:"));
        add(new JLabel(bookingId));

        add(new JLabel("Customer:"));
        add(new JLabel(customer));

        add(new JLabel("Car:"));
        add(new JLabel(car));

        add(new JLabel("Start Date:"));
        add(new JLabel(startDate));

        add(new JLabel("End Date:"));
        add(new JLabel(endDate));

        add(new JLabel("Total Cost:"));
        add(new JLabel(totalCost));

        JButton btnClose = new JButton("Close");
        add(new JLabel());
        add(btnClose);

        btnClose.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        new BookingDetails(
                "B001","John Smith","Toyota Vitz",
                "2026-04-01","2026-04-05","5000"
        ).setVisible(true);
    }
}
