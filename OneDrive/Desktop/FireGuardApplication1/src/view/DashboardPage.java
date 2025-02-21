import Dao.User;
import Dao.InventoryDAO; 
import Dao.InventoryDAOImpl;
import Dao.UserDAO;
import Dao.UserDAOImpl;
import controller.InventoryController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DashboardPage {
    public DashboardPage(User user) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame (window)
            JFrame frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Image Panel on the left
            String imagePath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\SytemLogo.png";
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();
            int newWidth = 203;
            int newHeight = 185;
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon);

            // Dashboard button with text and image
            String dashboardIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\download (5).png";
            ImageIcon dashboardIcon = new ImageIcon(new ImageIcon(dashboardIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton dashboardButton = new JButton("Dashboard", dashboardIcon);
            configureButton(dashboardButton);

            // Schedule button with text and a different image
            String scheduleIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\download (1).png";
            ImageIcon scheduleIcon = new ImageIcon(new ImageIcon(scheduleIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton scheduleButton = new JButton("Schedule", scheduleIcon);
            configureButton(scheduleButton);

            // Staff button with text and image
            String staffIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\download.png";
            ImageIcon staffIcon = new ImageIcon(new ImageIcon(staffIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton staffButton = new JButton("Staff", staffIcon);
            configureButton(staffButton);

            // Operation button with text and image
            String operationIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\download (6).png";
            ImageIcon operationIcon = new ImageIcon(new ImageIcon(operationIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton operationButton = new JButton("Operation", operationIcon);
            configureButton(operationButton);

            // Inventory button with text and image
            String inventoryIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\download (2).png";
            ImageIcon inventoryIcon = new ImageIcon(new ImageIcon(inventoryIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton inventoryButton = new JButton("Inventory", inventoryIcon);
            configureButton(inventoryButton);
            inventoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                InventoryDAO inventoryDAO = new InventoryDAOImpl();
                InventoryController inventoryController = new InventoryController(inventoryDAO); // Instantiate RegisterController with UserDAO
                InventoryPage inventoryPage = new InventoryPage(inventoryController); // Pass RegisterController to RegisterPage
                inventoryPage.setVisible(true);
                frame.dispose();
            }
        });
            // Report button with text and image
            String reportIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\download (7).png";
            ImageIcon reportIcon = new ImageIcon(new ImageIcon(reportIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton reportButton = new JButton("Reports", reportIcon);
            configureButton(reportButton);

            // Create a panel with BoxLayout to stack image and buttons vertically
            JPanel stackPanel = new JPanel();
            stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));
            stackPanel.setBackground(Color.decode("#FFDEC8"));
            stackPanel.add(imageLabel);
            stackPanel.add(createVerticalSpacing(20));
            stackPanel.add(dashboardButton);
            stackPanel.add(createVerticalSpacing(20));
            stackPanel.add(scheduleButton);
            stackPanel.add(createVerticalSpacing(20));
            stackPanel.add(staffButton);
            stackPanel.add(createVerticalSpacing(20));
            stackPanel.add(operationButton);
            stackPanel.add(createVerticalSpacing(20));
            stackPanel.add(inventoryButton);
            stackPanel.add(createVerticalSpacing(20));
            stackPanel.add(reportButton);

            // Image panel with BorderLayout
            JPanel imagePanel = new JPanel(new BorderLayout());
            imagePanel.setBackground(Color.decode("#FFDEC8"));
            imagePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFDEC8"), 1));
            imagePanel.add(stackPanel, BorderLayout.NORTH);

            // Control Panel at the top
            JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            controlPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

            // Content Panel in the center with null layout for absolute positioning
            JPanel contentPanel = new JPanel(null);  // Using null layout for absolute positioning
            contentPanel.setBackground(Color.WHITE);
            contentPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFDEC8"), 1));

            // Load and resize the map image
            String mapIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuardApplication1\\src\\images\\Map.png";
            ImageIcon mapOriginalIcon = new ImageIcon(mapIconPath);
            Image mapOriginalImage = mapOriginalIcon.getImage();
            int mapWidth = 501;  // Set desired width
            int mapHeight = 331;  // Set desired height
            Image mapResizedImage = mapOriginalImage.getScaledInstance(mapWidth, mapHeight, Image.SCALE_SMOOTH);
            ImageIcon mapResizedIcon = new ImageIcon(mapResizedImage);
            JLabel mapLabel = new JLabel(mapResizedIcon);
            mapLabel.setBounds(700, 400, mapWidth, mapHeight); // Set bounds for absolute positioning

            // Add mapLabel to contentPanel
            contentPanel.add(mapLabel);

            // Add panels to the frame
            frame.add(imagePanel, BorderLayout.WEST);
            frame.add(controlPanel, BorderLayout.NORTH);
            frame.add(contentPanel, BorderLayout.CENTER);

            // Set frame size and make it visible
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }
    

    // Method to configure button styling
    private static void configureButton(JButton button) {
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setIconTextGap(20);
        button.setPreferredSize(new Dimension(200, 50));
        button.setFocusPainted(false);
        button.setBackground(Color.decode("#FFDEC8"));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    // Method to create vertical spacing
    private static Component createVerticalSpacing(int height) {
        return Box.createRigidArea(new Dimension(0, height));
    }

    public void setVisible(boolean isVisible) {
        // This method makes the dashboard visible.
    }

}
