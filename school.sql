-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Gru 2022, 22:54
-- Wersja serwera: 10.1.35-MariaDB
-- Wersja PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `school`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grade`
--

CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `description` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `studentID` int(11) NOT NULL,
  `subjectID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `grade`
--

INSERT INTO `grade` (`id`, `grade`, `description`, `studentID`, `subjectID`) VALUES
(1, 4, 'Sprawdzian', 2, 8),
(2, 5, 'Kartkówka', 5, 6),
(3, 2, 'Aktywność', 8, 7),
(4, 2, 'Sprawdzian', 9, 8),
(5, 1, 'Kartkówka', 2, 4),
(6, 2, 'Aktywność', 6, 8),
(7, 5, 'Sprawdzian', 2, 1),
(8, 5, 'Kartkówka', 9, 7),
(9, 4, 'Aktywność', 7, 10),
(10, 4, 'Sprawdzian', 3, 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `firstname` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `lastname` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `schoolClass` varchar(5) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `student`
--

INSERT INTO `student` (`id`, `firstname`, `lastname`, `schoolClass`) VALUES
(2, 'Anna', 'Nowak', '2A'),
(3, 'Piotr', 'Mazur', '1A'),
(4, 'Agata', 'Kowalczyk', '1A'),
(5, 'Karol', 'Pawlak', '1A'),
(6, 'Marta', 'Jankowski', '2A'),
(7, 'Maria', 'Wiśniewska', '2A'),
(8, 'Janusz', 'Woźniak', '2A'),
(9, 'Rafi22', 'Kosa', '5B'),
(10, 'Małgorzata', 'Zalewska', '3A'),
(12, 'Rafi22', 'Kosa', '5B');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `subject`
--

CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `subject`
--

INSERT INTO `subject` (`id`, `name`) VALUES
(1, 'Matma'),
(2, 'fizyka'),
(3, 'chemia'),
(4, 'biologia'),
(5, 'geografia'),
(6, 'historia'),
(7, 'język polski'),
(8, 'język angielski'),
(9, 'język niemiecki'),
(10, 'informatyka');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `grade`
--
ALTER TABLE `grade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT dla tabeli `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT dla tabeli `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
