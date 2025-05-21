import javax.swing.*;
import java.awt.*;

public class FormUtama extends JFrame {
    private JButton btnBuku, btnAnggota;

    public FormUtama() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistem Informasi Perpustakaan");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new GridLayout(2, 1, 10, 10));
        panelTombol.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnBuku = new JButton("Manajemen Buku");
        btnAnggota = new JButton("Manajemen Anggota");

        panelTombol.add(btnBuku);
        panelTombol.add(btnAnggota);

        // Event Handlers
        btnBuku.addActionListener(e -> {
            new FormBuku().setVisible(true);
        });

        btnAnggota.addActionListener(e -> {
            new FormAnggota().setVisible(true);
        });

        // Layout
        setLayout(new BorderLayout());
        add(panelTombol, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new FormUtama().setVisible(true);
        });
    }
} 