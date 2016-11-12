-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Lug 18, 2016 alle 12:49
-- Versione del server: 10.1.14-MariaDB
-- Versione PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `server`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `AbitazioneDb`
--

CREATE TABLE `AbitazioneDb` (
  `ID` int(11) NOT NULL,
  `nome` varchar(15) COLLATE utf8_bin NOT NULL,
  `telefono` varchar(11) COLLATE utf8_bin NOT NULL,
  `indirizzo` varchar(30) COLLATE utf8_bin NOT NULL,
  `id_sensore` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `AbitazioneDb`
--

INSERT INTO `AbitazioneDb` (`ID`, `nome`, `telefono`, `indirizzo`, `id_sensore`) VALUES
(2, 'Riccio', '1234', 'via strada', 1),
(1, 'Paudice', '4321', 'via stradone', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `GestoreDb`
--

CREATE TABLE `GestoreDb` (
  `ID` int(11) NOT NULL,
  `tipo` varchar(30) COLLATE utf8_bin NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `GestoreDb`
--

INSERT INTO `GestoreDb` (`ID`, `tipo`, `numero`) VALUES
(1, 'polizia', 112),
(2, 'vigili del fuoco', 115);

-- --------------------------------------------------------

--
-- Struttura della tabella `InterventoDb`
--

CREATE TABLE `InterventoDb` (
  `ID` int(11) NOT NULL,
  `tipo` varchar(30) COLLATE utf8_bin NOT NULL,
  `data` datetime NOT NULL,
  `esito` int(11) NOT NULL,
  `id_segnalazione` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `InterventoDb`
--

INSERT INTO `InterventoDb` (`ID`, `tipo`, `data`, `esito`, `id_segnalazione`) VALUES
(86, 'fumo', '2016-07-15 12:40:08', 0, 40),
(39, 'fumo', '2016-07-15 12:40:26', 0, 39),
(131, 'apertura porta', '2016-07-15 12:40:46', 0, 99),
(2, 'fumo', '2016-07-15 12:59:36', 0, 2),
(127, 'fumo', '2016-07-15 14:12:34', 0, 68),
(160, 'fumo', '2016-07-18 14:48:09', 0, 94),
(121, 'fumo', '2016-07-18 14:48:27', 0, 22);

-- --------------------------------------------------------

--
-- Struttura della tabella `SegnalazioneDb`
--

CREATE TABLE `SegnalazioneDb` (
  `ID` int(11) NOT NULL,
  `stato` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `id_abitazione` int(11) NOT NULL,
  `id_sensore` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `SegnalazioneDb`
--

INSERT INTO `SegnalazioneDb` (`ID`, `stato`, `data`, `id_abitazione`, `id_sensore`) VALUES
(40, 0, '2016-07-15 12:40:06', 1, 2),
(39, 0, '2016-07-15 12:40:26', 1, 2),
(99, 0, '2016-07-15 12:40:46', 2, 1),
(2, 0, '2016-07-15 12:59:35', 1, 2),
(68, 0, '2016-07-15 14:12:33', 1, 2),
(94, 0, '2016-07-18 14:48:08', 1, 2),
(22, 0, '2016-07-18 14:48:27', 1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `SensoreDb`
--

CREATE TABLE `SensoreDb` (
  `ID` int(11) NOT NULL,
  `tipo` varchar(30) COLLATE utf8_bin NOT NULL,
  `soglia` int(11) NOT NULL,
  `id_gestore` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dump dei dati per la tabella `SensoreDb`
--

INSERT INTO `SensoreDb` (`ID`, `tipo`, `soglia`, `id_gestore`) VALUES
(1, 'apertura porta', 5, 1),
(2, 'fumo', 5, 2),
(3, 'acqua', 5, 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `AbitazioneDb`
--
ALTER TABLE `AbitazioneDb`
  ADD KEY `FK_kxpmiuuyjvvmjr2pp1r77vg4k` (`id_sensore`);

--
-- Indici per le tabelle `InterventoDb`
--
ALTER TABLE `InterventoDb`
  ADD KEY `FK_ec7k49d63tx07xt3llrmof3jk` (`id_segnalazione`);

--
-- Indici per le tabelle `SegnalazioneDb`
--
ALTER TABLE `SegnalazioneDb`
  ADD KEY `FK_w1jkxnph1jkp8etnoq5ry49u` (`id_sensore`),
  ADD KEY `FK_9vuaa6omusye6m7op3pfkduds` (`id_abitazione`);

--
-- Indici per le tabelle `SensoreDb`
--
ALTER TABLE `SensoreDb`
  ADD KEY `FK_h5cm9lrl2syjfr2alaroa81g4` (`id_gestore`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
