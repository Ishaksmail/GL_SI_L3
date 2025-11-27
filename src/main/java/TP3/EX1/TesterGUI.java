package TP3.EX1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import TP3.EX1.base.Customer;
import TP3.EX1.base.Order;
import TP3.EX1.base.OrderStatus;
import TP3.EX1.base.Product;

public class TesterGUI extends JFrame {

    private DefaultListModel<Product> productsModel = new DefaultListModel<>();
    private DefaultListModel<Product> cartModel = new DefaultListModel<>();

    private JList<Product> productsList;
    private JList<Product> cartList;

    private JTextField tfUsername, tfPassword, tfName, tfAddress, tfEmail, tfPhone;
    private JLabel lblTotal;
    private JTextArea taOrderDetails;
    private JComboBox<OrderStatus> cbStatus;

    private Order currentOrder;

    public TesterGUI() {
        setTitle("E-Commerce System GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        initProducts(); // productsModel filled
        initUI();
    }

    private void initProducts() {
        // منتجات تجريبية — يمكنك استبدالها أو تحميلها من مكان آخر
        productsModel.addElement(new Product("Laptop", 799.99, 1));
        productsModel.addElement(new Product("Mouse", 19.99, 1));
        productsModel.addElement(new Product("Keyboard", 49.99, 1));
        productsModel.addElement(new Product("Headphones", 89.99, 1));
        productsModel.addElement(new Product("USB Cable", 5.99, 1));
    }

    private void initUI() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(root);

        // center left: منتجات + سلة
        JPanel center = new JPanel(new GridLayout(1, 2, 10, 10));
        root.add(center, BorderLayout.CENTER);

        // لوحة المنتجات
        JPanel productsPanel = new JPanel(new BorderLayout(5, 5));
        productsPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        productsList = new JList<>(productsModel);
        productsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productsList.setCellRenderer(new ProductCellRenderer());
        productsPanel.add(new JScrollPane(productsList), BorderLayout.CENTER);

        JButton btnAddToCart = new JButton("Add to Cart ->");
        btnAddToCart.addActionListener(this::onAddToCart);
        productsPanel.add(btnAddToCart, BorderLayout.SOUTH);

        // لوحة السلة
        JPanel cartPanel = new JPanel(new BorderLayout(5, 5));
        cartPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        cartList = new JList<>(cartModel);
        cartList.setCellRenderer(new ProductCellRenderer());
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);

        JPanel cartButtons = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton btnRemove = new JButton("<- Remove");
        btnRemove.addActionListener(this::onRemoveFromCart);
        JButton btnClear = new JButton("Clear Cart");
        btnClear.addActionListener(e -> cartModel.clear());
        cartButtons.add(btnRemove);
        cartButtons.add(btnClear);
        cartPanel.add(cartButtons, BorderLayout.SOUTH);

        center.add(productsPanel);
        center.add(cartPanel);

        // right panel: بيانات العميل وطلب
        JPanel right = new JPanel(new BorderLayout(5, 5));
        right.setPreferredSize(new Dimension(340, 0));
        root.add(right, BorderLayout.EAST);

        // customer form
        JPanel customerForm = new JPanel();
        customerForm.setLayout(new GridBagLayout());
        customerForm.setBorder(BorderFactory.createTitledBorder("Customer"));
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.anchor = GridBagConstraints.WEST;
        g.insets = new Insets(3, 3, 3, 3);

        customerForm.add(new JLabel("Username:"), g);
        g.gridx = 1;
        tfUsername = new JTextField(15);
        customerForm.add(tfUsername, g);
        g.gridx = 0;
        g.gridy++;
        customerForm.add(new JLabel("Password:"), g);
        g.gridx = 1;
        tfPassword = new JTextField(15);
        customerForm.add(tfPassword, g);
        g.gridx = 0;
        g.gridy++;
        customerForm.add(new JLabel("Name:"), g);
        g.gridx = 1;
        tfName = new JTextField(15);
        customerForm.add(tfName, g);
        g.gridx = 0;
        g.gridy++;
        customerForm.add(new JLabel("Address:"), g);
        g.gridx = 1;
        tfAddress = new JTextField(15);
        customerForm.add(tfAddress, g);
        g.gridx = 0;
        g.gridy++;
        customerForm.add(new JLabel("Email:"), g);
        g.gridx = 1;
        tfEmail = new JTextField(15);
        customerForm.add(tfEmail, g);
        g.gridx = 0;
        g.gridy++;
        customerForm.add(new JLabel("Phone:"), g);
        g.gridx = 1;
        tfPhone = new JTextField(15);
        customerForm.add(tfPhone, g);

        right.add(customerForm, BorderLayout.NORTH);

        // order controls
        JPanel orderControls = new JPanel(new GridLayout(6, 1, 5, 5));
        orderControls.setBorder(new EmptyBorder(8, 0, 0, 0));
        JButton btnCreateOrder = new JButton("Create Order");
        btnCreateOrder.addActionListener(this::onCreateOrder);
        JLabel lblStatus = new JLabel("Order Status:");
        cbStatus = new JComboBox<>(OrderStatus.values());
        cbStatus.addActionListener(e -> onChangeStatus());
        lblTotal = new JLabel("Total: 0.00");
        taOrderDetails = new JTextArea(8, 1);
        taOrderDetails.setEditable(false);
        taOrderDetails.setLineWrap(true);
        taOrderDetails.setWrapStyleWord(true);

        orderControls.add(btnCreateOrder);
        orderControls.add(lblTotal);
        orderControls.add(lblStatus);
        orderControls.add(cbStatus);
        orderControls.add(new JLabel("Order details:"));
        orderControls.add(new JScrollPane(taOrderDetails));
        right.add(orderControls, BorderLayout.CENTER);

        // bottom: sample actions + quit
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSampleCustomer = new JButton("Fill sample customer");
        btnSampleCustomer.addActionListener(e -> fillSampleCustomer());
        JButton btnQuit = new JButton("Quit");
        btnQuit.addActionListener(e -> System.exit(0));
        bottom.add(btnSampleCustomer);
        bottom.add(btnQuit);
        root.add(bottom, BorderLayout.SOUTH);
    }

    private void onAddToCart(ActionEvent e) {
        Product selected = productsList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Select a product first.");
            return;
        }
        // استخدم نسخة من المنتج في السلة (لتجنب مشاركة نفس المرجع إذا رغبت)
        cartModel.addElement(new Product(selected.getName(), selected.getPrice(), selected.getQuantity()));
        updateTotalLabel();
    }

    private void onRemoveFromCart(ActionEvent e) {
        Product selected = cartList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Select a product from cart to remove.");
            return;
        }
        cartModel.removeElement(selected);
        updateTotalLabel();
    }

    private void updateTotalLabel() {
        double total = 0;
        for (int i = 0; i < cartModel.size(); i++) {
            total += cartModel.get(i).getPrice();
        }
        lblTotal.setText(String.format("Total: %.2f", total));
    }

    private void onCreateOrder(ActionEvent e) {
        if (cartModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty.");
            return;
        }
        if (tfUsername.getText().isBlank() || tfPassword.getText().isBlank() || tfName.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Please fill at least username, password and name.");
            return;
        }

        Customer cust = new Customer(tfUsername.getText(), tfPassword.getText(),
                tfName.getText(), tfAddress.getText(), tfEmail.getText(), tfPhone.getText());

        ArrayList<Product> prods = new ArrayList<>();
        for (int i = 0; i < cartModel.size(); i++)
            prods.add(cartModel.get(i));

        currentOrder = new Order(cust, prods);
        double total = currentOrder.calculateTotalPrice();
        currentOrder.setStatus(OrderStatus.NEW);
        cbStatus.setSelectedItem(currentOrder.getStatus());
        lblTotal.setText(String.format("Total: %.2f", total));
        taOrderDetails.setText(buildOrderDetails(currentOrder));

        JOptionPane.showMessageDialog(this, "Order created successfully.");
    }

    private void onChangeStatus() {
        if (currentOrder == null)
            return;
        OrderStatus s = (OrderStatus) cbStatus.getSelectedItem();
        currentOrder.setStatus(s);
        taOrderDetails.setText(buildOrderDetails(currentOrder));
    }

    private String buildOrderDetails(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(order.getCustomer().getName()).append("\n");
        sb.append("Username: ").append(order.getCustomer().getUsername()).append("\n");
        sb.append("Email: ").append(order.getCustomer().getEmail()).append("\n");
        sb.append("Address: ").append(order.getCustomer().getAddress()).append("\n\n");
        sb.append("Products:\n");
        for (Product p : order.getProducts()) {
            sb.append("- ").append(p.getName()).append(" | price: ").append(p.getPrice()).append("\n");
        }
        sb.append("\nTotal: ").append(order.getTotalPrice()).append("\n");
        sb.append("Status: ").append(order.getStatus()).append("\n");
        return sb.toString();
    }

    private void fillSampleCustomer() {
        tfUsername.setText("user1");
        tfPassword.setText("pass123");
        tfName.setText("Ishak Ismail");
        tfAddress.setText("Algiers, Algeria");
        tfEmail.setText("ishak@example.com");
        tfPhone.setText("+213661234567");
    }

    // Renderer to show product nicely in JList
    private static class ProductCellRenderer extends JLabel implements ListCellRenderer<Product> {
        public ProductCellRenderer() {
            setOpaque(true);
            setBorder(new EmptyBorder(4, 4, 4, 4));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Product> list, Product value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setText(value.getName() + " — " + String.format("%.2f", value.getPrice()));
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TesterGUI gui = new TesterGUI();
            gui.setVisible(true);
        });
    }
}
