package TP2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TesterGUI {

    public static void main(String[] args) {

        // ========== الإطار الرئيسي ==========
        JFrame window = new JFrame("Management Library");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 450);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout(15, 15));

        // خلفية عامة فاتحة
        window.getContentPane().setBackground(new Color(245, 245, 245));

        // ========== اللوحة اليسرى (الأزرار) ==========
        JPanel leftPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        leftPanel.setBackground(new Color(245, 245, 245));
        leftPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // أزرار مسطحة (Flat)
        JButton addBtn = createFlatButton("Add");
        JButton deleteBtn = createFlatButton("Delete");
        JButton showBtn = createFlatButton("Show");
        JButton exitBtn = createFlatButton("Exit");

        // إضافة الأزرار
        leftPanel.add(addBtn);
        leftPanel.add(deleteBtn);
        leftPanel.add(showBtn);
        leftPanel.add(exitBtn);

        // ========== اللوحة اليمنى (العرض) ==========
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Cairo", Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setBackground(new Color(250, 250, 250));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        window.add(leftPanel, BorderLayout.WEST);
        window.add(rightPanel, BorderLayout.CENTER);

        window.setVisible(true);
    }

    // ====== دالة إنشاء زر Flat ======
    private static JButton createFlatButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(230, 230, 230));
        button.setForeground(Color.DARK_GRAY);
        button.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 35));

        // تأثير hover بسيط
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(210, 210, 210));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(230, 230, 230));
            }
        });

        return button;
    }
}
