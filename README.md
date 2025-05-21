# Sistem Informasi Perpustakaan

Sistem informasi perpustakaan sederhana yang dibangun menggunakan Java Swing dan MySQL.

## Fitur

1. Manajemen Buku
   - Tambah buku baru
   - Lihat daftar buku
   - Update data buku
   - Hapus buku
   - Cari buku

2. Manajemen Anggota
   - Tambah anggota baru
   - Lihat daftar anggota
   - Update data anggota
   - Hapus anggota
   - Cari anggota

## Persyaratan Sistem

1. Java Development Kit (JDK) 8 atau lebih tinggi
2. MySQL Server
3. MySQL Connector/J (JDBC Driver)

## Instalasi

1. Clone repository ini
2. Import file `perpustakaan.sql` ke MySQL Server
3. Pastikan MySQL Server berjalan
4. Sesuaikan konfigurasi database di file `Koneksi.java` jika diperlukan
5. Compile dan jalankan file `FormUtama.java`

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
2. Pilih menu yang diinginkan (Manajemen Buku atau Manajemen Anggota)
3. Gunakan form yang muncul untuk melakukan operasi CRUD

## Kontribusi

Silakan buat pull request untuk kontribusi. Untuk perubahan besar, harap buka issue terlebih dahulu untuk mendiskusikan perubahan yang diinginkan.

## Lisensi

[MIT](https://choosealicense.com/licenses/mit/) 