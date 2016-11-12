-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Lug 18, 2016 alle 12:48
-- Versione del server: 10.1.14-MariaDB
-- Versione PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `centralina`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `SensoreDb`
--

CREATE TABLE `SensoreDb` (
  `ID` int(11) NOT NULL,
  `tipo` varchar(30) COLLATE utf8_bin NOT NULL,
  `soglia` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `SensoreDb`
--

INSERT INTO `SensoreDb` (`ID`, `tipo`, `soglia`) VALUES
(1, 'apertura porta', 5),
(2, 'fumo', 5),
(3, 'acqua', 5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
