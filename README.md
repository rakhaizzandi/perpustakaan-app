# Sistem Informasi Perpustakaan

Sistem informasi perpustakaan sederhana yang dibangun menggunakan Java Swing dan MySQL. Aplikasi ini memungkinkan pengguna untuk mengelola data buku dan anggota perpustakaan.

## Fitur

1. Manajemen Buku
   - Tambah buku baru
   - Lihat daftar buku
   - Update data buku
   - Hapus buku
   - Cari buku berdasarkan judul, pengarang, atau penerbit
   - Kategorisasi buku

2. Manajemen Anggota
   - Tambah anggota baru
   - Lihat daftar anggota
   - Update data anggota
   - Hapus anggota
   - Cari anggota berdasarkan nama, email, atau nomor telepon
   - Manajemen status anggota (aktif/nonaktif)

## Teknologi yang Digunakan

- Java SE 8
- Java Swing untuk GUI
- MySQL Database
- JDBC untuk koneksi database
- Maven untuk manajemen dependencies

## Persyaratan Sistem

1. Java Development Kit (JDK) 8 atau lebih tinggi
2. MySQL Server (XAMPP/MAMP)
3. Maven (untuk build project)

## Instalasi

1. Clone repository ini
   ```bash
   git clone https://github.com/rakhizzandi/perpustakaan-app.git
   cd perpustakaan-app
   ```

2. Setup Database
   - Buka XAMPP Control Panel
   - Start Apache dan MySQL
   - Buka phpMyAdmin (http://localhost/phpmyadmin)
   - Import file `perpustakaan.sql` untuk membuat struktur database
   - Import file `sample_data.sql` untuk mengisi data contoh

3. Build Project
   ```bash
   mvn clean install
   ```

4. Jalankan Aplikasi
   - Double click `run.bat` atau
   - Jalankan dari command line:
     ```bash
     java -jar target/perpustakaan-app-1.0-SNAPSHOT-jar-with-dependencies.jar
     ```

## Struktur Database

### Tabel Kategori
- id_kategori (INT, Primary Key)
- nama_kategori (VARCHAR)

### Tabel Buku
- id_buku (INT, Primary Key)
- judul (VARCHAR)
- pengarang (VARCHAR)
- penerbit (VARCHAR)
- tahun_terbit (INT)
- isbn (VARCHAR)
- stok (INT)
- id_kategori (INT, Foreign Key)

### Tabel Anggota
- id_anggota (INT, Primary Key)
- nama (VARCHAR)
- alamat (TEXT)
- no_telp (VARCHAR)
- email (VARCHAR)
- status (ENUM)

## Penggunaan

1. Jalankan aplikasi dengan menjalankan `FormUtama.java`
2. Pilih menu yang diinginkan:
   - Manajemen Buku: untuk mengelola data buku
   - Manajemen Anggota: untuk mengelola data anggota

3. Fitur dalam setiap menu:
   - Tambah: untuk menambah data baru
   - Update: untuk mengubah data yang dipilih
   - Hapus: untuk menghapus data yang dipilih
   - Clear: untuk membersihkan form input

## Data Contoh

Aplikasi dilengkapi dengan data contoh yang mencakup:
- 6 kategori buku
- 12 buku dari berbagai kategori
- 10 data anggota

## Troubleshooting

1. Error "com.mysql cannot be resolved"
   - Pastikan MySQL Connector sudah terinstall
   - Jalankan `mvn dependency:copy-dependencies`

2. Error koneksi database
   - Pastikan XAMPP sudah running
   - Periksa konfigurasi di `Koneksi.java`
   - Pastikan database sudah dibuat

3. Error saat menjalankan aplikasi
   - Pastikan JDK sudah terinstall
   - Pastikan semua dependencies sudah terdownload
   - Periksa path ke MySQL Connector
