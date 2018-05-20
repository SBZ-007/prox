-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 09 Avril 2018 à 12:46
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bdd`
--
CREATE DATABASE IF NOT EXISTS `bdd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdd`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `idConseiller` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `age`, `idConseiller`) VALUES
(1, 'KIM', 'wil', 56, 1),
(4, 'Antheane', 'Philippe', 35, 3),
(5, 'Blabla', 'Bliblou', 70, 3),
(8, 'Monsieur', 'Test', 56, 2),
(9, 'Monsieur', 'Test', 32, 1),
(22, 'SERSOUB', 'nabil', 27, 2),
(24, 'VERON', 'latin', 50, 1),
(25, 'ooo', 'ooo', 2, 1),
(26, 'hhh', 'hhh', 2, 2),
(27, 'bob', 'pip', 10, 3),
(28, 'ggg', 'ggg', 22, 2),
(29, 'nnn', 'nnn', 12, 1),
(30, 'ggg', 'ggg', 22, 1),
(31, 'fff', 'fff', 20, 2),
(32, 'pop', 'pp', 55, 2);

-- --------------------------------------------------------

--
-- Structure de la table `clientclub`
--

CREATE TABLE `clientclub` (
  `idClient` int(11) NOT NULL,
  `idClub` int(11) NOT NULL,
  `dateInscription` date DEFAULT NULL,
  `tarif` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `clientclub`
--

INSERT INTO `clientclub` (`idClient`, `idClub`, `dateInscription`, `tarif`) VALUES
(1, 1, '1999-09-10', '90.68');

-- --------------------------------------------------------

--
-- Structure de la table `club`
--

CREATE TABLE `club` (
  `idClub` int(11) NOT NULL,
  `nomClub` varchar(100) DEFAULT NULL,
  `performance` varchar(255) DEFAULT NULL,
  `niveau` int(11) DEFAULT NULL,
  `discriminateur` varchar(255) DEFAULT 'sportif'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `club`
--

INSERT INTO `club` (`idClub`, `nomClub`, `performance`, `niveau`, `discriminateur`) VALUES
(1, 'Basket', 'trop bon', NULL, 'sportif'),
(2, 'Boxe', 'débutant', NULL, 'sportif'),
(3, 'Saxohone', NULL, 1, 'musique'),
(4, 'Anglais', NULL, 5, 'langue'),
(5, 'Espagnol', NULL, 3, 'langue');

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `idConseiller` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`idConseiller`, `nom`, `prenom`) VALUES
(1, 'Blondel', 'Benoit'),
(2, 'Toto', 'Tata'),
(3, 'Mouah', 'aha'),
(4, 'Sans', 'Client');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `idLogin` int(11) NOT NULL,
  `login` varchar(100) DEFAULT NULL,
  `mdp` varchar(100) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `login`
--

INSERT INTO `login` (`idLogin`, `login`, `mdp`, `idClient`) VALUES
(5, 'bb', 'ibou', 5);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD KEY `fk_conseiller` (`idConseiller`);

--
-- Index pour la table `clientclub`
--
ALTER TABLE `clientclub`
  ADD PRIMARY KEY (`idClient`,`idClub`),
  ADD KEY `fk_clientclub_club` (`idClub`),
  ADD KEY `fk_clientclub_client` (`idClient`);

--
-- Index pour la table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`idClub`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`idConseiller`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idLogin`),
  ADD UNIQUE KEY `login` (`login`),
  ADD KEY `fk_client` (`idClient`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `club`
--
ALTER TABLE `club`
  MODIFY `idClub` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `conseiller`
--
ALTER TABLE `conseiller`
  MODIFY `idConseiller` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `idLogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `fk_conseiller` FOREIGN KEY (`idConseiller`) REFERENCES `conseiller` (`idConseiller`);

--
-- Contraintes pour la table `clientclub`
--
ALTER TABLE `clientclub`
  ADD CONSTRAINT `fk_clientclub_client` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `fk_clientclub_club` FOREIGN KEY (`idClub`) REFERENCES `club` (`idClub`);

--
-- Contraintes pour la table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_client` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
