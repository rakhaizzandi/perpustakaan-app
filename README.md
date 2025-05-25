# Sistem Informasi Perpustakaan

Sistem informasi perpustakaan sederhana yang dibangun menggunakan Java Swing dan MySQL. Aplikasi ini memungkinkan pengguna untuk mengelola data buku dan anggota perpustakaan.

## 🚀 Fitur

### 1. Manajemen Buku
- ✅ Tambah buku baru
- ✅ Lihat daftar buku
- ✅ Update data buku
- ✅ Hapus buku
- ✅ Cari buku berdasarkan judul, pengarang, atau penerbit
- ✅ Kategorisasi buku

### 2. Manajemen Anggota
- ✅ Tambah anggota baru
- ✅ Lihat daftar anggota
- ✅ Update data anggota
- ✅ Hapus anggota
- ✅ Cari anggota berdasarkan nama, email, atau nomor telepon
- ✅ Status keanggotaan (aktif/nonaktif)

## 🛠️ Teknologi yang Digunakan

- Java SE 8
- Java Swing untuk GUI
- MySQL Database
- JDBC untuk koneksi database
- Maven untuk manajemen dependencies

## 📋 Persyaratan Sistem

1. Java Development Kit (JDK) 8 atau lebih tinggi
2. MySQL Server (XAMPP)
3. MySQL Connector/J (JDBC Driver)
4. Maven (opsional)

## 🚀 Cara Instalasi

1. Clone repository ini
   ```bash
   git clone https://github.com/username/perpustakaan-app.git
   ```

2. Import database
   - Buka XAMPP Control Panel
   - Start Apache dan MySQL
   - Buka phpmyadmin (http://localhost/phpmyadmin)
   - Import file `perpustakaan.sql`

3. Konfigurasi database
   - Buka file `src/Koneksi.java`
   - Sesuaikan konfigurasi database jika diperlukan:
     ```java
     String url = "jdbc:mysql://localhost:3306/perpustakaan";
     String user = "root";
     String password = "";
     ```

4. Compile dan jalankan
   - Double click `compile.bat` untuk mengkompilasi
   - Double click `run.bat` untuk menjalankan program

## 📁 Struktur Database

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

## 💻 Penggunaan

1. Jalankan aplikasi dengan menjalankan `FormUtama.java`
2. Pilih menu yang diinginkan:
   - Manajemen Buku
   - Manajemen Anggota
3. Gunakan form yang muncul untuk melakukan operasi CRUD

## 🛠️ Pengembangan

### Menambahkan Fitur Baru
1. Fork repository ini
2. Buat branch baru (`git checkout -b fitur-baru`)
3. Commit perubahan Anda (`git commit -m 'Menambahkan fitur baru'`)
4. Push ke branch (`git push origin fitur-baru`)
5. Buat Pull Request

### Melaporkan Bug
Jika Anda menemukan bug, silakan buat issue di repository ini dengan format:
- Deskripsi bug
- Langkah-langkah untuk mereproduksi bug
- Screenshot (jika ada)
- Environment (OS, Java version, dll)

## 🎯 Prinsip Pemrograman Berorientasi Objek (PBO)

### 1. Encapsulation (Enkapsulasi)
- **Lokasi**: Class `Buku.java` dan `Anggota.java`
- **Penjelasan**: Implementasi enkapsulasi terlihat pada penggunaan private attributes dengan getter dan setter methods
- **Contoh**:
  ```java
  private int idBuku;
  private String judul;
  // Getter dan setter methods
  public int getIdBuku() { return idBuku; }
  public void setIdBuku(int idBuku) { this.idBuku = idBuku; }
  ```

### 2. Inheritance (Pewarisan)
- **Lokasi**: Class `Item.java` (abstract class) dan `Buku.java` (child class)
- **Penjelasan**: Implementasi inheritance dengan class `Item` sebagai parent class dan `Buku` sebagai child class
- **Contoh**:
  ```java
  public abstract class Item {
      protected int id;
      protected String nama;
  }
  
  public class Buku extends Item {
      // Child class implementation
  }
  ```

### 3. Polymorphism (Polimorfisme)
- **Lokasi**: Interface `CRUDOperations` dan implementasinya di `BukuDAO.java` dan `AnggotaDAO.java`
- **Penjelasan**: Implementasi polymorphism melalui interface dan method overriding
- **Contoh**:
  ```java
  public interface CRUDOperations {
      boolean create(Object obj);
      List<Object> read();
  }
  ```

### 4. Overloading (Overloading Method)
- **Lokasi**: Class `Buku.java` dan `Anggota.java`
- **Penjelasan**: Implementasi method overloading dengan multiple constructor dan methods dengan nama sama
- **Contoh**:
  ```java
  public Buku() {} // Default constructor
  public Buku(String judul, String pengarang) { // Overloaded constructor
      this.judul = judul;
      this.pengarang = pengarang;
  }
  ```

### 5. Abstraction (Abstraksi)
- **Lokasi**: Abstract class `BaseDAO.java` dan `Item.java`
- **Penjelasan**: Implementasi abstraction melalui abstract class dan interface
- **Contoh**:
  ```java
  public abstract class BaseDAO {
      protected Connection koneksi;
      public abstract boolean create(Object obj);
  }
  ```

## 🙏 Ucapan Terima Kasih

- Terima kasih kepada semua kontributor
- Terima kasih kepada komunitas open source
- Terima kasih kepada pengguna aplikasi ini 