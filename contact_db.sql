-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 03 Novembre 2016 à 19:48
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `contact_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `adress`
--

CREATE TABLE IF NOT EXISTS `adress` (
  `id` int(20) NOT NULL,
  `street` varchar(200) COLLATE utf8_bin NOT NULL,
  `city` varchar(50) COLLATE utf8_bin NOT NULL,
  `zip` varchar(20) COLLATE utf8_bin NOT NULL,
  `country` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `adress`
--

INSERT INTO `adress` (`id`, `street`, `city`, `zip`, `country`) VALUES
(47, 'champs', 'paris', '75001', 'france'),
(48, 'palm beach', 'LA', '99999', 'USA'),
(49, 'toto', 'rouen', '89000', 'france');

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `mail` varchar(90) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=51 ;

--
-- Contenu de la table `contact`
--

INSERT INTO `contact` (`id`, `nom`, `prenom`, `mail`) VALUES
(47, 'mamadou', 'mamadou', 'mamadou@mamadou.fr'),
(48, 'toto', 'gates', 'bg@bg.com'),
(49, 'toto', 'roro', 'toto@toto.fr');

-- --------------------------------------------------------

--
-- Structure de la table `contact_group`
--

CREATE TABLE IF NOT EXISTS `contact_group` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=10 ;

--
-- Contenu de la table `contact_group`
--

INSERT INTO `contact_group` (`id`, `name`) VALUES
(7, 'Univ'),
(8, 'miage'),
(9, 'toto');

-- --------------------------------------------------------

--
-- Structure de la table `list_group_contact`
--

CREATE TABLE IF NOT EXISTS `list_group_contact` (
  `id_contact` int(20) NOT NULL,
  `id_groupContact` int(20) NOT NULL,
  `nameGroup` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id_contact`,`id_groupContact`),
  KEY `fk_group` (`id_groupContact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `list_group_contact`
--

INSERT INTO `list_group_contact` (`id_contact`, `id_groupContact`, `nameGroup`) VALUES
(47, 7, 'Univ'),
(48, 9, 'toto'),
(49, 9, 'toto');

-- --------------------------------------------------------

--
-- Structure de la table `phonenumber`
--

CREATE TABLE IF NOT EXISTS `phonenumber` (
  `id` int(20) NOT NULL COMMENT 'Pointe sur le numéro du contact',
  `phoneKind` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `phoneNumber` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `phonenumber`
--

INSERT INTO `phonenumber` (`id`, `phoneKind`, `phoneNumber`) VALUES
(47, NULL, '0202020202'),
(48, NULL, '0404040404'),
(49, NULL, '0202020202');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `adress`
--
ALTER TABLE `adress`
  ADD CONSTRAINT `adress_fk_id` FOREIGN KEY (`id`) REFERENCES `contact` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `list_group_contact`
--
ALTER TABLE `list_group_contact`
  ADD CONSTRAINT `fk_constraint_contact` FOREIGN KEY (`id_contact`) REFERENCES `contact` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_group` FOREIGN KEY (`id_groupContact`) REFERENCES `contact_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `phonenumber`
--
ALTER TABLE `phonenumber`
  ADD CONSTRAINT `fk_contact_id` FOREIGN KEY (`id`) REFERENCES `contact` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
