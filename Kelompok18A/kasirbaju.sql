-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Des 2020 pada 15.14
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasirbaju`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE `akun` (
  `NIK` int(11) NOT NULL,
  `Jabatan` varchar(255) NOT NULL,
  `Nama` varchar(255) NOT NULL,
  `KataSandi` varchar(11) NOT NULL,
  `TanggalLahir` date NOT NULL,
  `Gaji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`NIK`, `Jabatan`, `Nama`, `KataSandi`, `TanggalLahir`, `Gaji`) VALUES
(234, 'Karyawan', 'Udin', 'udin1', '1999-08-31', 5000),
(1234567, 'Karyawan', 'aa', '12345', '1999-08-27', 120000),
(1402017101, 'Admin', 'Dafi', 'qwerty', '1999-08-31', 3000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenisjabatan`
--

CREATE TABLE `jenisjabatan` (
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenisjabatan`
--

INSERT INTO `jenisjabatan` (`nama`) VALUES
('Admin'),
('Karyawan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenisproduk`
--

CREATE TABLE `jenisproduk` (
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenisproduk`
--

INSERT INTO `jenisproduk` (`nama`) VALUES
('Sweater_Jumper'),
('Romper'),
('Kemeja'),
('Rok'),
('Kaos'),
('Topi'),
('Kacamata'),
('Sepatu'),
('Sandal');

-- --------------------------------------------------------

--
-- Struktur dari tabel `stock`
--

CREATE TABLE `stock` (
  `Id` int(11) NOT NULL,
  `JenisProduk` varchar(255) NOT NULL,
  `NamaProduk` varchar(255) NOT NULL,
  `Jenis` varchar(255) NOT NULL,
  `Satuan` varchar(255) NOT NULL,
  `Persediaan` int(11) NOT NULL,
  `Harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `stock`
--

INSERT INTO `stock` (`Id`, `JenisProduk`, `NamaProduk`, `Jenis`, `Satuan`, `Persediaan`, `Harga`) VALUES
(1, 'Sandal', 'Sandal Jepit', 'Guchi edition', 'pcs', 500, 500000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tipepencarian`
--

CREATE TABLE `tipepencarian` (
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tipepencarian`
--

INSERT INTO `tipepencarian` (`nama`) VALUES
('Id'),
('JenisProduk'),
('NamaProduk'),
('Jenis'),
('Satuan'),
('Persediaan'),
('Harga');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tipepencarianadmin`
--

CREATE TABLE `tipepencarianadmin` (
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tipepencarianadmin`
--

INSERT INTO `tipepencarianadmin` (`nama`) VALUES
('NIK'),
('Jabatan'),
('Nama'),
('KataSandi'),
('TanggalLahir'),
('Gaji');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tipesatuan`
--

CREATE TABLE `tipesatuan` (
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tipesatuan`
--

INSERT INTO `tipesatuan` (`nama`) VALUES
('pcs');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`NIK`),
  ADD UNIQUE KEY `NIK` (`NIK`);

--
-- Indeks untuk tabel `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `stock`
--
ALTER TABLE `stock`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
