-- Mengisi data kategori (sudah ada di perpustakaan.sql)
INSERT INTO kategori (nama_kategori) VALUES 
('Fiksi'),
('Non-Fiksi'),
('Pendidikan'),
('Teknologi'),
('Sejarah'),
('Biografi');

-- Mengisi data buku
INSERT INTO buku (judul, pengarang, penerbit, tahun_terbit, isbn, stok, id_kategori) VALUES
('Laskar Pelangi', 'Andrea Hirata', 'Bentang Pustaka', 2005, '978-979-1227-79-9', 10, 1),
('Bumi Manusia', 'Pramoedya Ananta Toer', 'Hasta Mitra', 1980, '978-979-97312-8-1', 5, 1),
('Filosofi Teras', 'Henry Manampiring', 'Kompas', 2018, '978-602-412-518-9', 8, 2),
('Atomic Habits', 'James Clear', 'Gramedia Pustaka Utama', 2018, '978-602-06-3517-2', 15, 2),
('Pemrograman Java', 'Budi Raharjo', 'Informatika', 2019, '978-602-6232-14-5', 12, 3),
('Database Design', 'Fathansyah', 'Informatika', 2017, '978-602-6232-15-2', 7, 3),
('Clean Code', 'Robert C. Martin', 'Prentice Hall', 2008, '978-013-235088-4', 6, 4),
('The Pragmatic Programmer', 'Andrew Hunt', 'Addison-Wesley', 1999, '978-020-161622-4', 4, 4),
('Sejarah Indonesia Modern', 'M.C. Ricklefs', 'Serambi', 2005, '978-979-024-294-2', 9, 5),
('Sejarah Dunia', 'Yuval Noah Harari', 'Kepustakaan Populer Gramedia', 2014, '978-602-424-416-5', 11, 5),
('Steve Jobs', 'Walter Isaacson', 'Gramedia Pustaka Utama', 2011, '978-602-03-2876-5', 8, 6),
('Elon Musk', 'Walter Isaacson', 'Gramedia Pustaka Utama', 2023, '978-602-06-6942-8', 13, 6);

-- Mengisi data anggota
INSERT INTO anggota (nama, alamat, no_telp, email, status) VALUES
('Budi Santoso', 'Jl. Merdeka No. 123, Jakarta', '081234567890', 'budi@email.com', 'aktif'),
('Ani Wijaya', 'Jl. Sudirman No. 45, Bandung', '082345678901', 'ani@email.com', 'aktif'),
('Dewi Putri', 'Jl. Gatot Subroto No. 67, Surabaya', '083456789012', 'dewi@email.com', 'aktif'),
('Rudi Hartono', 'Jl. Asia Afrika No. 89, Bandung', '084567890123', 'rudi@email.com', 'nonaktif'),
('Siti Aminah', 'Jl. Diponegoro No. 12, Yogyakarta', '085678901234', 'siti@email.com', 'aktif'),
('Ahmad Hidayat', 'Jl. Veteran No. 34, Jakarta', '086789012345', 'ahmad@email.com', 'aktif'),
('Maya Sari', 'Jl. Pahlawan No. 56, Surabaya', '087890123456', 'maya@email.com', 'nonaktif'),
('Rina Melati', 'Jl. Veteran No. 78, Bandung', '088901234567', 'rina@email.com', 'aktif'),
('Doni Pratama', 'Jl. Merdeka No. 90, Jakarta', '089012345678', 'doni@email.com', 'aktif'),
('Lina Wijaya', 'Jl. Sudirman No. 23, Yogyakarta', '090123456789', 'lina@email.com', 'aktif'); 