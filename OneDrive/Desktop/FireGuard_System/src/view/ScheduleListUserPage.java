import Dao.DashboardDAO;
import Dao.InventoryDAO;
import Dao.InventoryDAOImpl;
import Dao.User;
import Dao.UserDAO;
import Dao.UserDAOImpl;
import controller.DashboardController;
import dao.OperationDAO;
import dao.OperationDAOImpl;
import dao.ScheduleDAO;
import dao.ScheduleDAOImpl;
import controller.InventoryController;
import controller.OperationController;
import controller.ScheduleController;
import controller.StaffController;
import dao.StaffDAO;
import dao.StaffDAOImpl;
import model.Schedule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ScheduleListUserPage {
    private JFrame frame;
    private ScheduleController controller;
    private JTable scheduleTable;

    public ScheduleListUserPage(ScheduleController controller) {
        this.controller = controller;

        SwingUtilities.invokeLater(() -> {
            // Create a JFrame (window)
        frame = new JFrame("FireGuard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/Logo.png"));
        frame.setIconImage(logo.getImage());

            // Image Panel on the left
            String imagePath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuard_System\\src\\images\\SystemLogo.png";
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();
            int newWidth = 210;
            int newHeight = 170;
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon);

            // Dashboard button with text and image
            String dashboardIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuard_System\\src\\images\\download (5).png";
            ImageIcon dashboardIcon = new ImageIcon(new ImageIcon(dashboardIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton dashboardButton = new JButton("Dashboard", dashboardIcon);
            configureButton(dashboardButton);
            dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 DashboardDAO dashboardDAO = new DashboardDAOImpl();
                DashboardController dashboardController = new DashboardController(dashboardDAO);
                User User = null;
                DashboardPage dashboardPage = new DashboardPage(User);
                dashboardPage.setVisible(true);
                frame.dispose();
            }
        });

            // Schedule button with text and a different image
            String scheduleIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuard_System\\src\\images\\download (1).png";
            ImageIcon scheduleIcon = new ImageIcon(new ImageIcon(scheduleIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton scheduleButton = new JButton("Schedule", scheduleIcon);
            configureButton(scheduleButton);

            // Staff button with text and image
            String staffIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuard_System\\src\\images\\download.png";
            ImageIcon staffIcon = new ImageIcon(new ImageIcon(staffIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton staffButton = new JButton("Staff", staffIcon);
            configureButton(staffButton);
            staffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StaffDAO staffDAO = new StaffDAOImpl();
                    StaffController staffController = new StaffController(staffDAO);
                    StaffListUserPage staffListUserPage = new StaffListUserPage(staffController);
                    staffListUserPage.setVisible(true);
                    frame.dispose(); 
                }
            });

            // Operation button with text and image
            String operationIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuard_System\\src\\images\\download (6).png";
            ImageIcon operationIcon = new ImageIcon(new ImageIcon(operationIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton operationButton = new JButton("Operation", operationIcon);
            configureButton(operationButton);
            operationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationDAO operationDAO = new OperationDAOImpl();  
                    OperationController operationController = new OperationController(operationDAO);  
                    OperationPage operationPage = new OperationPage(operationController);
                    operationPage.setVisible(true);
                    frame.dispose();
                }
            });

            // Inventory button with text and image
            String inventoryIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuard_System\\src\\images\\download (2).png";
            ImageIcon inventoryIcon = new ImageIcon(new ImageIcon(inventoryIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton inventoryButton = new JButton("Inventory", inventoryIcon);
            configureButton(inventoryButton);
            inventoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InventoryDAO inventoryDAO = new InventoryDAOImpl();  
                    InventoryController inventoryController = new InventoryController(inventoryDAO);  
                    InventoryPage inventoryPage = new InventoryPage(inventoryController);
                    inventoryPage.setVisible(true);
                    frame.dispose();
                }
            });

            // Report button with text and image
            String reportIconPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\FireGuard_System\\src\\images\\download (7).png";
            ImageIcon reportIcon = new ImageIcon(new ImageIcon(reportIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton reportButton = new JButton("Reports", reportIcon);
            configureButton(reportButton);
            reportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OperationDAO operationDAO = new OperationDAOImpl();  
                    OperationController operationController = new OperationController(operationDAO);  
                    ReportPage reportPage = new ReportPage(operationController);
                    reportPage.setVisible(true);
                    frame.dispose();
                }
            });

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

            // Content Panel in the center with BorderLayout for proper component placement
            JPanel contentPanel = new JPanel(new GridBagLayout());
            contentPanel.setBackground(Color.WHITE);
//            contentPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFDEC8"), 1));

            // Create the panel with the specified size
            JPanel tablePanel = new JPanel(new BorderLayout());
            tablePanel.setPreferredSize(new Dimension(1070, 670));
            tablePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFDEC8"), 15));
            tablePanel.setBackground(Color.decode("#FFDEC8"));
                
            JLabel titleLabel = new JLabel("Schedule", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
            tablePanel.add(titleLabel, BorderLayout.NORTH);
            
            // Table model with column names
            String[] columnNames = {"Name", "Rank", "Phone Number","Email", "Date", "Shift"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            scheduleTable = new JTable(tableModel);
            scheduleTable.setBackground(Color.decode("#FFD3AD"));
            JScrollPane scrollPane = new JScrollPane(scheduleTable);
            tablePanel.add(scrollPane, BorderLayout.CENTER); // Add the scroll pane to the table panel

            updateScheduleTable();

            // Add table panel to the content panel with GridBagLayout constraints
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            contentPanel.add(tablePanel, gbc);

            // Add panels to the frame
            frame.add(imagePanel, BorderLayout.WEST);
            frame.add(controlPanel, BorderLayout.NORTH);
            frame.add(contentPanel, BorderLayout.CENTER); // Add content panel to the frame

            // Set frame size and make it visible
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }

    public void updateScheduleTable() {
        List<Schedule> scheduleList = controller.getAllSchedules();
        DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
        model.setRowCount(0); // Clear existing rows
        for (Schedule item : scheduleList) {
            model.addRow(new Object[]{
                    item.getName(),
                    item.getRank(),
                    item.getPhone_number(),
                    item.getEmail(),
                    item.getDate(),
                    item.getShift()
            });
        }
    }

    // Method configure button styling
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
        frame.setVisible(isVisible);
    }

    public static void main(String[] args) {
        ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
        ScheduleController controller = new ScheduleController(scheduleDAO);
        new ScheduleListUserPage(controller);
    }
}
