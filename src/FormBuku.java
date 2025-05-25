package src;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import src.BukuDAO;
import src.Buku;

public class FormBuku extends JFrame {
    private JTextField txtJudul, txtPengarang, txtPenerbit, txtTahun, txtIsbn, txtStok;
    private JComboBox<String> cmbKategori;
    private JTable tblBuku;
    private DefaultTableModel modelTabel;
    private JButton btnTambah, btnUpdate, btnHapus, btnClear, btnKembali;
    private BukuDAO bukuDAO;
    private int selectedId = -1;

    public FormBuku() {
        bukuDAO = new BukuDAO();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setTitle("Manajemen Buku");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(7, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Judul:"));
        txtJudul = new JTextField();
        panelInput.add(txtJudul);

        panelInput.add(new JLabel("Pengarang:"));
        txtPengarang = new JTextField();
        panelInput.add(txtPengarang);

        panelInput.add(new JLabel("Penerbit:"));
        txtPenerbit = new JTextField();
        panelInput.add(txtPenerbit);

        panelInput.add(new JLabel("Tahun Terbit:"));
        txtTahun = new JTextField();
        panelInput.add(txtTahun);

        panelInput.add(new JLabel("ISBN:"));
        txtIsbn = new JTextField();
        panelInput.add(txtIsbn);

        panelInput.add(new JLabel("Stok:"));
        txtStok = new JTextField();
        panelInput.add(txtStok);

        panelInput.add(new JLabel("Kategori:"));
        cmbKategori = new JComboBox<>(new String[]{"Fiksi", "Non-Fiksi", "Pendidikan", "Teknologi", "Sejarah", "Biografi"});
        panelInput.add(cmbKategori);

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

        panelTombol.add(btnTambah);
        panelTombol.add(btnUpdate);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        panelTombol.add(btnKembali);

        // Tabel
        String[] kolom = {"ID", "Judul", "Pengarang", "Penerbit", "Tahun", "ISBN", "Stok", "Kategori"};
        modelTabel = new DefaultTableModel(kolom, 0);
        tblBuku = new JTable(modelTabel);
        JScrollPane scrollPane = new JScrollPane(tblBuku);

        // Layout
        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.NORTH);
        add(panelTombol, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Event Handlers
        btnTambah.addActionListener(e -> tambahBuku());
        btnUpdate.addActionListener(e -> updateBuku());
        btnHapus.addActionListener(e -> hapusBuku());
        btnClear.addActionListener(e -> clearForm());
        btnKembali.addActionListener(e -> {
            dispose();
            new FormUtama().setVisible(true);
        });

        tblBuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblBuku.getSelectedRow();
                if (row != -1) {
                    selectedId = Integer.parseInt(modelTabel.getValueAt(row, 0).toString());
                    txtJudul.setText(modelTabel.getValueAt(row, 1).toString());
                    txtPengarang.setText(modelTabel.getValueAt(row, 2).toString());
                    txtPenerbit.setText(modelTabel.getValueAt(row, 3).toString());
                    txtTahun.setText(modelTabel.getValueAt(row, 4).toString());
                    txtIsbn.setText(modelTabel.getValueAt(row, 5).toString());
                    txtStok.setText(modelTabel.getValueAt(row, 6).toString());
                    cmbKategori.setSelectedItem(modelTabel.getValueAt(row, 7).toString());
                }
            }
        });
    }

    private void loadData() {
        modelTabel.setRowCount(0);
        List<Buku> daftarBuku = bukuDAO.read();
        for (Buku buku : daftarBuku) {
            Object[] row = {
                buku.getId(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
                buku.getTahunTerbit(),
                buku.getIsbn(),
                buku.getStok(),
                buku.getNamaKategori()
            };
            modelTabel.addRow(row);
        }
    }

    private void tambahBuku() {
        try {
            Buku buku = new Buku();
            buku.setJudul(txtJudul.getText());
            buku.setPengarang(txtPengarang.getText());
            buku.setPenerbit(txtPenerbit.getText());
            buku.setTahunTerbit(Integer.parseInt(txtTahun.getText()));
            buku.setIsbn(txtIsbn.getText());
            buku.setStok(Integer.parseInt(txtStok.getText()));
            buku.setIdKategori(cmbKategori.getSelectedIndex() + 1);

            if (bukuDAO.create(buku)) {
                JOptionPane.showMessageDialog(this, "Buku berhasil ditambahkan!");
                clearForm();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan buku!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tahun dan stok harus berupa angka!");
        }
    }

    private void updateBuku() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih buku yang akan diupdate!");
            return;
        }

        try {
            Buku buku = new Buku();
            buku.setId(selectedId);
            buku.setJudul(txtJudul.getText());
            buku.setPengarang(txtPengarang.getText());
            buku.setPenerbit(txtPenerbit.getText());
            buku.setTahunTerbit(Integer.parseInt(txtTahun.getText()));
            buku.setIsbn(txtIsbn.getText());
            buku.setStok(Integer.parseInt(txtStok.getText()));
            buku.setIdKategori(cmbKategori.getSelectedIndex() + 1);

            if (bukuDAO.update(buku)) {
                JOptionPane.showMessageDialog(this, "Buku berhasil diupdate!");
                clearForm();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate buku!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tahun dan stok harus berupa angka!");
        }
    }

    private void hapusBuku() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih buku yang akan dihapus!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus buku ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (bukuDAO.delete(selectedId)) {
                JOptionPane.showMessageDialog(this, "Buku berhasil dihapus!");
                clearForm();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus buku!");
            }
        }
    }

    private void clearForm() {
        selectedId = -1;
        txtJudul.setText("");
        txtPengarang.setText("");
        txtPenerbit.setText("");
        txtTahun.setText("");
        txtIsbn.setText("");
        txtStok.setText("");
        cmbKategori.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormBuku().setVisible(true);
        });
    }
} 