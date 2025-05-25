package src;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import src.AnggotaDAO;
import src.Anggota;

public class FormAnggota extends JFrame {
    private JTextField txtNama, txtAlamat, txtNoTelp, txtEmail;
    private JComboBox<String> cmbStatus;
    private JTable tblAnggota;
    private DefaultTableModel modelTabel;
    private JButton btnTambah, btnUpdate, btnHapus, btnClear, btnKembali;
    private AnggotaDAO anggotaDAO;
    private int selectedId = -1;

    public FormAnggota() {
        anggotaDAO = new AnggotaDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setTitle("Manajemen Anggota");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(5, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Alamat:"));
        txtAlamat = new JTextField();
        panelInput.add(txtAlamat);

        panelInput.add(new JLabel("No. Telepon:"));
        txtNoTelp = new JTextField();
        panelInput.add(txtNoTelp);

        panelInput.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panelInput.add(txtEmail);

        panelInput.add(new JLabel("Status:"));
        cmbStatus = new JComboBox<>(new String[]{"aktif", "nonaktif"});
        panelInput.add(cmbStatus);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        // Style untuk button
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        Dimension buttonSize = new Dimension(200, 35);

        btnTambah = new JButton("Tambah");
        btnTambah.setFont(buttonFont);
        btnTambah.setPreferredSize(buttonSize);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(buttonFont);
        btnUpdate.setPreferredSize(buttonSize);

        btnHapus = new JButton("Hapus");
        btnHapus.setFont(buttonFont);
        btnHapus.setPreferredSize(buttonSize);

        btnClear = new JButton("Clear");
        btnClear.setFont(buttonFont);
        btnClear.setPreferredSize(buttonSize);

        btnKembali = new JButton("Kembali");
        btnKembali.setFont(buttonFont);
        btnKembali.setPreferredSize(buttonSize);
        btnKembali.setBackground(new Color(255, 200, 200));

        // Tambahkan tombol ke panel
        panelTombol.add(btnTambah);
        panelTombol.add(btnUpdate);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        panelTombol.add(Box.createHorizontalStrut(20)); // Spasi
        panelTombol.add(btnKembali);

        // Tabel
        String[] kolom = {"ID", "Nama", "Alamat", "No. Telepon", "Email", "Status"};
        modelTabel = new DefaultTableModel(kolom, 0);
        tblAnggota = new JTable(modelTabel);
        JScrollPane scrollPane = new JScrollPane(tblAnggota);

        // Layout
        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.NORTH);
        add(panelTombol, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Event Handlers
        btnTambah.addActionListener(e -> tambahAnggota());
        btnUpdate.addActionListener(e -> updateAnggota());
        btnHapus.addActionListener(e -> hapusAnggota());
        btnClear.addActionListener(e -> clearForm());
        btnKembali.addActionListener(e -> {
            dispose();
            new FormUtama().setVisible(true);
        });

        tblAnggota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblAnggota.getSelectedRow();
                if (row != -1) {
                    selectedId = Integer.parseInt(modelTabel.getValueAt(row, 0).toString());
                    txtNama.setText(modelTabel.getValueAt(row, 1).toString());
                    txtAlamat.setText(modelTabel.getValueAt(row, 2).toString());
                    txtNoTelp.setText(modelTabel.getValueAt(row, 3).toString());
                    txtEmail.setText(modelTabel.getValueAt(row, 4).toString());
                    cmbStatus.setSelectedItem(modelTabel.getValueAt(row, 5).toString());
                }
            }
        });
    }

    private void loadData() {
        modelTabel.setRowCount(0);
        List<Anggota> daftarAnggota = anggotaDAO.read();
        for (Anggota anggota : daftarAnggota) {
            Object[] row = {
                anggota.getId(),
                anggota.getNama(),
                anggota.getAlamat(),
                anggota.getNoTelp(),
                anggota.getEmail(),
                anggota.getStatus()
            };
            modelTabel.addRow(row);
        }
    }

    private void tambahAnggota() {
        Anggota anggota = new Anggota();
        anggota.setNama(txtNama.getText());
        anggota.setAlamat(txtAlamat.getText());
        anggota.setNoTelp(txtNoTelp.getText());
        anggota.setEmail(txtEmail.getText());
        anggota.setStatus(cmbStatus.getSelectedItem().toString());

        if (anggotaDAO.create(anggota)) {
            JOptionPane.showMessageDialog(this, "Anggota berhasil ditambahkan!");
            clearForm();
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan anggota!");
        }
    }

    private void updateAnggota() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih anggota yang akan diupdate!");
            return;
        }

        Anggota anggota = new Anggota();
        anggota.setId(selectedId);
        anggota.setNama(txtNama.getText());
        anggota.setAlamat(txtAlamat.getText());
        anggota.setNoTelp(txtNoTelp.getText());
        anggota.setEmail(txtEmail.getText());
        anggota.setStatus(cmbStatus.getSelectedItem().toString());

        if (anggotaDAO.update(anggota)) {
            JOptionPane.showMessageDialog(this, "Anggota berhasil diupdate!");
            clearForm();
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate anggota!");
        }
    }

    private void hapusAnggota() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih anggota yang akan dihapus!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus anggota ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (anggotaDAO.delete(selectedId)) {
                JOptionPane.showMessageDialog(this, "Anggota berhasil dihapus!");
                clearForm();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus anggota!");
            }
        }
    }

    private void clearForm() {
        selectedId = -1;
        txtNama.setText("");
        txtAlamat.setText("");
        txtNoTelp.setText("");
        txtEmail.setText("");
        cmbStatus.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormAnggota().setVisible(true);
        });
    }
} 