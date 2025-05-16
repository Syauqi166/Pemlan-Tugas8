package praktikum.tugas8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDataMahasiswa {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Daftar Ulang Mahasiswa Baru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 370);
        frame.setLocationRelativeTo(null);

        // Judul form
        JLabel titleLabel = new JLabel("Form Daftar Ulang Mahasiswa Baru", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        // Panel untuk form input
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 8, 8));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Silakan isi data berikut"),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        
        JLabel namaLabel = new JLabel("Nama Lengkap");
        JTextField namaField = new JTextField();

        JLabel tglLahirLabel = new JLabel("Tanggal Lahir");
        JTextField tglLahirField = new JTextField();

        JLabel noPendaftaranLabel = new JLabel("Nomor Pendaftaran");
        JTextField noPendaftaranField = new JTextField();

        JLabel noTelpLabel = new JLabel("No. Telp");
        JTextField noTelpField = new JTextField();

        JLabel alamatLabel = new JLabel("Alamat");
        JTextField alamatField = new JTextField();

        JLabel emailLabel = new JLabel("E-mail");
        JTextField emailField = new JTextField();

        formPanel.add(namaLabel); formPanel.add(namaField);
        formPanel.add(tglLahirLabel); formPanel.add(tglLahirField);
        formPanel.add(noPendaftaranLabel); formPanel.add(noPendaftaranField);
        formPanel.add(noTelpLabel); formPanel.add(noTelpField);
        formPanel.add(alamatLabel); formPanel.add(alamatField);
        formPanel.add(emailLabel); formPanel.add(emailField);

        // Panel tombol
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(0, 153, 76));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        buttonPanel.add(submitButton);

        // Action listener tombol submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validasi semua kolom harus terisi
                if (namaField.getText().trim().isEmpty() ||
                    tglLahirField.getText().trim().isEmpty() ||
                    noPendaftaranField.getText().trim().isEmpty() ||
                    noTelpField.getText().trim().isEmpty() ||
                    alamatField.getText().trim().isEmpty() ||
                    emailField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Semua kolom harus diisi!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Panel konfirmasi
                int result = JOptionPane.showConfirmDialog(frame,
                        "Apakah anda yakin data yang Anda isi sudah benar?",
                        "Konfirmasi Data",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    // Tampilkan data di window baru
                    JFrame dataFrame = new JFrame("Data Mahasiswa (Hasil Input)");
                    dataFrame.setSize(370, 270);
                    dataFrame.setLocationRelativeTo(frame);

                    JPanel dataPanel = new JPanel(new GridLayout(6, 2, 8, 8));
                    dataPanel.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createTitledBorder("Data Mahasiswa"),
                            BorderFactory.createEmptyBorder(10, 15, 10, 15)
                    ));

                    dataPanel.add(new JLabel("Nama Lengkap:"));
                    dataPanel.add(new JLabel(namaField.getText()));
                    dataPanel.add(new JLabel("Tanggal Lahir:"));
                    dataPanel.add(new JLabel(tglLahirField.getText()));
                    dataPanel.add(new JLabel("Nomor Pendaftaran:"));
                    dataPanel.add(new JLabel(noPendaftaranField.getText()));
                    dataPanel.add(new JLabel("No. Telp:"));
                    dataPanel.add(new JLabel(noTelpField.getText()));
                    dataPanel.add(new JLabel("Alamat:"));
                    dataPanel.add(new JLabel(alamatField.getText()));
                    dataPanel.add(new JLabel("E-mail:"));
                    dataPanel.add(new JLabel(emailField.getText()));

                    dataFrame.add(dataPanel);
                    dataFrame.setVisible(true);
                }
                // Jika Cancel, tidak melakukan apa-apa, tetap di form
            }
        });

        // Layout utama
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}