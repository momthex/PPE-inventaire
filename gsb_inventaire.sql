-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  jeu. 19 mars 2020 à 19:37
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gsb_inventaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

DROP TABLE IF EXISTS `historique`;
CREATE TABLE IF NOT EXISTS `historique` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `id_personnel` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `historique`
--

INSERT INTO `historique` (`id`, `date`, `id_personnel`, `id_produit`, `quantite`) VALUES
(1, '2020-03-04 06:15:24', 1, 1, 2),
(2, '2020-03-04 08:14:18', 1, 2, 5),
(7, '2020-03-07 15:37:00', 1, 17, 2);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `passWord` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`id`, `nom`, `prenom`, `login`, `passWord`, `isAdmin`) VALUES
(1, 'Reynaud', 'Pierre', 'preynaud', '65a011904b54779dd766db806fdc3b97cdd6c628713aaa1ea700f4913dc465b7', 1),
(2, 'Dupont', 'Jean', 'jdupont', 'dc4c0433b0815370e0a14a747172417e7865c07db1fc91d568035846dd3cc4bd', 0),
(3, 'Durand', 'Francois', 'fdurand', '4db857f065f7687df5650c39168b854e9e84ea208c96331d0b8670e0d468f6e1', 0);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `quantite` int(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `quantite`, `description`) VALUES
(1, 'Doliprane 1000mg', 38, 'Ce médicament est un antalgique et un antipyrétique qui contient du paracétamol.'),
(2, 'Dafalgan 1000mg', 59, 'Ce médicament est un antalgique et un antipyrétique qui contient du paracétamol.'),
(5, 'Imodium 2mg', 7, 'Traitement symptomatique des diarrhées aiguës et chroniques.'),
(6, 'Kardegic 500mg', 13, 'Syndromes coronariens aigus (angor instable, infarctus sans onde Q) et à la phase aiguë de l\'infarctus du myocarde, notamment lorsque la voie orale ne peut être utilisée.'),
(7, 'Spasfon, comprimé enrobé', 67, 'Traitement symptomatique des douleurs liées aux troubles fonctionnels du tube digestif et des voies biliaires. \r\nTraitement symptomatique des manifestations spasmodiques douloureuses en gynécologie.'),
(8, 'Isimig 2,5mg', 91, 'Traitement de la phase céphalalgique de la crise de migraine avec ou sans aura. \r\nISIMIG est indiqué chez les adultes.'),
(9, 'Daflon', 34, 'Traitement des symptômes en rapport avec l\'insuffisance veinolymphatique (jambes lourdes, douleurs, impatiences du primo-décubitus). \r\nTraitement des signes fonctionnels liés à la crise hémorroïdaire.'),
(10, 'Derinox 15ml', 45, 'Traitement symptomatique local de courte durée des états congestifs et inflammatoires au cours des rhinites aiguës de l\'adulte et des adolescents de plus de 15 ans.'),
(11, 'Tanakan 40mg', 49, 'Médicament à base de plantes utilisé dans le traitement symptomatique des troubles cognitifs du sujet âgé, à l\'exception des patients atteints de démence confirmée, de maladie de Parkinson, de trouble'),
(12, 'Morpal 10mg', 52, 'Traitement des ulcères duodénaux. \r\nPrévention des récidives d\'ulcères duodénaux. \r\nTraitement des ulcères gastriques.'),
(13, 'Lysanxia 10mg', 73, 'Traitement symptomatique des manifestations anxieuses sévères et/ou invalidantes. \r\nPrévention et traitement du delirium tremens et des autres manifestations du sevrage alcoolique.'),
(14, 'Rhinofluimucil 10ml', 66, 'Traitement local symptomatique de courte durée des affections rhinopharyngées avec sécrétion excessive de la muqueuse de l\'adulte et des adolescents de plus de 15 ans.'),
(15, 'Plavix 75mg', 42, 'Prévention secondaire des événements athérothrombotiques.'),
(16, 'Coaprovel 300mg', 89, 'Traitement de l\'hypertension artérielle essentielle.'),
(17, 'Soluped 5mg', 18, 'Poussées évolutives de maladies systémiques, notamment : lupus érythémateux disséminé, vascularite, polymyosite, sarcoïdose viscérale. ');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
