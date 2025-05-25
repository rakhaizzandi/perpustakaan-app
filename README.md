# Sistem Informasi Perpustakaan

Aplikasi desktop sederhana untuk mengelola data perpustakaan menggunakan Java Swing dan MySQL. Aplikasi ini memungkinkan pengguna untuk mengelola data buku dan anggota perpustakaan.

## Fitur Aplikasi

1. **Manajemen Buku**
   - ✅ Tambah buku baru
   - ✅ Lihat daftar buku
   - ✅ Update data buku
   - ✅ Hapus buku
   - ✅ Cari buku berdasarkan judul, pengarang, atau penerbit
   - ✅ Kategorisasi buku

2. **Manajemen Anggota**
   - ✅ Tambah anggota baru
   - ✅ Lihat daftar anggota
   - ✅ Update data anggota
   - ✅ Hapus anggota
   - ✅ Cari anggota berdasarkan nama, email, atau nomor telepon
   - ✅ Status keanggotaan (aktif/nonaktif)

## Cara Menjalankan Aplikasi

### Persyaratan
- Java JDK 8 atau lebih baru
- MySQL Server
- MySQL Connector/J (sudah ada di folder `lib`)

### Langkah-langkah Menjalankan

1. **Persiapkan Database**
   - Buka MySQL Server
   - Buat database baru dengan nama `perpustakaan`
   - Import file `database.sql` ke database tersebut

2. **Compile Program**
   - Double click file `compile.bat`
   - Tunggu sampai muncul pesan "Compilation complete!"
   - File hasil kompilasi akan disimpan di folder `bin`

3. **Jalankan Aplikasi**
   - Double click file `run.bat`
   - Aplikasi akan terbuka dengan tampilan menu utama

## Struktur Folder

```
perpustakaan/
├── bin/              # Folder untuk file hasil kompilasi
├── lib/              # Folder untuk library yang dibutuhkan
├── src/              # Folder untuk file source code
├── compile.bat       # Script untuk mengkompilasi program
├── run.bat          # Script untuk menjalankan program
└── database.sql     # File SQL untuk membuat database
```

## Penjelasan File Penting

1. **FormUtama.java**
   - Tampilan menu utama
   - Berisi tombol untuk membuka form buku dan anggota

2. **FormBuku.java**
   - Tampilan manajemen buku
   - Fitur CRUD untuk data buku

3. **FormAnggota.java**
   - Tampilan manajemen anggota
   - Fitur CRUD untuk data anggota

4. **Koneksi.java**
   - Mengatur koneksi ke database MySQL
   - Konfigurasi database ada di sini

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

## Prinsip Pemrograman Berorientasi Objek (PBO)

### 1. Encapsulation (Enkapsulasi)
- **Lokasi**: Class `Buku.java` dan `Anggota.java`
- **Penjelasan**: Implementasi enkapsulasi terlihat pada penggunaan private attributes dengan getter dan setter methods
- **Contoh di Buku.java**:
  ```java
  private String judul;
  private String pengarang;
  public String getJudul() { return judul; }
  public void setJudul(String judul) { this.judul = judul; }
  ```

### 2. Inheritance (Pewarisan)
- **Lokasi**: 
  - `BaseModel.java` (abstract class) sebagai parent class
  - `Buku.java` dan `Anggota.java` sebagai child class
- **Penjelasan**: Implementasi inheritance dengan class `BaseModel` sebagai parent class
- **Contoh**:
  ```java
  public abstract class BaseModel {
      protected int id;
      protected String nama;
  }
  
  public class Buku extends BaseModel {
      // Implementasi spesifik untuk Buku
  }
  ```

### 3. Polymorphism (Polimorfisme)
- **Lokasi**: 
  - Interface `CRUDOperations<T>`
  - Implementasi di `BukuDAO.java` dan `AnggotaDAO.java`
- **Penjelasan**: Implementasi polymorphism melalui interface dan method overriding
- **Contoh**:
  ```java
  public interface CRUDOperations<T> {
      boolean create(T obj);
      List<T> read();
  }
  ```

### 4. Overloading (Overloading Method)
- **Lokasi**: Class `Buku.java` dan `Anggota.java`
- **Penjelasan**: Implementasi method overloading dengan multiple constructor
- **Contoh di Buku.java**:
  ```java
  public Buku() { super(); }
  public Buku(String judul, String pengarang) { /* ... */ }
  public void updateStok(int stok) { /* ... */ }
  public void updateStok(int stok, String keterangan) { /* ... */ }
  ```

### 5. Abstraction (Abstraksi)
- **Lokasi**: 
  - Abstract class `BaseModel.java` dan `BaseDAO.java`
  - Interface `CRUDOperations.java`
- **Penjelasan**: Implementasi abstraction melalui abstract class dan interface
- **Contoh**:
  ```java
  public abstract class BaseDAO {
      protected Connection koneksi;
      protected abstract String getTableName();
  }
  ```

## Penjelasan DAO (Data Access Object)

DAO adalah design pattern yang memisahkan logika akses data dari logika bisnis.

### Struktur DAO
1. **Interface CRUDOperations**
   - Mendefinisikan operasi dasar database (Create, Read, Update, Delete)
   - Menggunakan generic type `<T>` untuk fleksibilitas

2. **Abstract Class BaseDAO**
   - Menyediakan koneksi database
   - Mendefinisikan method abstrak untuk nama tabel dan primary key

3. **Implementasi DAO**
   - `BukuDAO`: Menangani operasi database untuk entitas Buku
   - `AnggotaDAO`: Menangani operasi database untuk entitas Anggota

### Keuntungan Menggunakan DAO
1. **Pemisahan Layer**
   - Memisahkan logika database dari logika bisnis
   - Memudahkan maintenance dan testing

2. **Reusability**
   - Kode dapat digunakan kembali untuk entitas lain
   - Mengurangi duplikasi kode

3. **Fleksibilitas**
   - Mudah mengganti implementasi database
   - Mendukung multiple database

4. **Type Safety**
   - Menggunakan generic type untuk type checking
   - Mengurangi error runtime

## Troubleshooting

1. **Error "Cannot find symbol"**
   - Pastikan sudah menjalankan `compile.bat`
   - Pastikan semua file `.java` ada di folder `src`

2. **Error Koneksi Database**
   - Pastikan MySQL Server sudah berjalan
   - Pastikan database `perpustakaan` sudah dibuat
   - Cek konfigurasi di `Koneksi.java`

3. **Aplikasi Tidak Mau Buka**
   - Pastikan Java sudah terinstall
   - Pastikan sudah menjalankan `compile.bat` sebelum `run.bat`

