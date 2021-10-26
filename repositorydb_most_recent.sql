-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 26 oct. 2021 à 05:58
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `repositorydb`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat_emballage`
--

CREATE TABLE `achat_emballage` (
  `id_achar_emballage` bigint(20) NOT NULL,
  `date_achat` date NOT NULL,
  `is_payed` bit(1) DEFAULT NULL,
  `is_stocked` bit(1) DEFAULT NULL,
  `montant_achat` float NOT NULL,
  `qte_en_casier` float NOT NULL,
  `source` varchar(50) DEFAULT NULL,
  `my_interface_caisse` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) NOT NULL,
  `nbgui` float NOT NULL,
  `nbsabc` float NOT NULL,
  `nbucb` float NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `achat_emballage`
--

INSERT INTO `achat_emballage` (`id_achar_emballage`, `date_achat`, `is_payed`, `is_stocked`, `montant_achat`, `qte_en_casier`, `source`, `my_interface_caisse`, `responsable`, `nbgui`, `nbsabc`, `nbucb`, `is_valide`) VALUES
(328, '2020-04-15', b'1', b'1', 396000, 300, 'Ferailleurs', 329, 87, 20, 250, 30, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `argent_mvt`
--

CREATE TABLE `argent_mvt` (
  `id_argent_mvt` bigint(20) NOT NULL,
  `date_op_argent` date NOT NULL,
  `heure_op_argent` time NOT NULL,
  `libelle_argent` varchar(50) DEFAULT NULL,
  `montant` float NOT NULL,
  `nature_mvt` bit(1) NOT NULL,
  `my_depenses` bigint(20) DEFAULT NULL,
  `my_gestion_facture` bigint(20) DEFAULT NULL,
  `my_gestion_livraison` bigint(20) DEFAULT NULL,
  `my_gestion_retour_chargment` bigint(20) DEFAULT NULL,
  `my_total_ristourne_payement` bigint(20) DEFAULT NULL,
  `my_caisse_journaliere` bigint(20) DEFAULT NULL,
  `my_interface_caisse` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL,
  `my_cass` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `argent_mvt`
--

INSERT INTO `argent_mvt` (`id_argent_mvt`, `date_op_argent`, `heure_op_argent`, `libelle_argent`, `montant`, `nature_mvt`, `my_depenses`, `my_gestion_facture`, `my_gestion_livraison`, `my_gestion_retour_chargment`, `my_total_ristourne_payement`, `my_caisse_journaliere`, `my_interface_caisse`, `responsable`, `is_valide`, `my_cass`) VALUES
(188, '2020-03-28', '18:57:51', 'Avance concernant la livraison de SUNDAY', 364700, b'1', NULL, NULL, 187, NULL, NULL, NULL, NULL, NULL, b'1', NULL),
(219, '2020-03-29', '19:37:04', 'Avance concernant la livraison de MONDAY', 200000, b'1', NULL, NULL, 218, NULL, NULL, NULL, NULL, NULL, b'1', NULL),
(221, '2020-03-29', '19:48:17', 'Avance concernant la livraison de MONDAY', 15000, b'1', NULL, NULL, 220, NULL, NULL, NULL, NULL, NULL, b'1', NULL),
(231, '2020-03-30', '20:05:58', 'Avance concernant la livraison de MONDAY', 26000, b'1', NULL, NULL, 230, NULL, NULL, NULL, NULL, NULL, b'1', NULL),
(236, '2020-03-31', '20:16:53', 'Avance concernant la livraison de MONDAY', 82000, b'1', NULL, NULL, 235, NULL, NULL, NULL, NULL, NULL, b'1', NULL),
(296, '2020-04-01', '10:28:04', 'Avance de Facture', 148600, b'1', NULL, 297, NULL, NULL, NULL, NULL, NULL, NULL, b'1', NULL),
(303, '2020-04-01', '10:54:57', 'Avance de Facture', 100000, b'1', NULL, 304, NULL, NULL, NULL, NULL, NULL, NULL, b'1', NULL),
(330, '2020-04-15', '08:09:31', 'Achat de Bouteilles', 396000, b'0', NULL, NULL, NULL, NULL, NULL, NULL, 329, 87, b'1', NULL),
(374, '2020-04-15', '11:32:39', 'DECAISSEMENT LivraisonSABC', 1332000, b'0', NULL, NULL, 372, NULL, NULL, NULL, 373, 87, b'1', NULL),
(382, '2020-04-15', '13:10:31', 'DECAISSEMENT LivraisonUCB', 153400, b'0', NULL, NULL, 377, NULL, NULL, NULL, 381, 87, b'1', NULL),
(384, '2020-04-15', '13:10:31', 'DECAISSEMENT LivraisonGUINNESS S.A.', 220000, b'0', NULL, NULL, 378, NULL, NULL, NULL, 383, 87, b'1', NULL),
(426, '2020-04-17', '10:05:14', 'Avance de Facture', 532600, b'1', NULL, 427, NULL, NULL, NULL, NULL, NULL, 87, b'1', NULL),
(452, '2020-04-22', '05:27:06', NULL, 230000, b'1', NULL, NULL, NULL, 451, NULL, 453, NULL, 87, b'1', NULL),
(519, '2020-04-26', '06:08:16', 'DEPENSE', 2000, b'0', 517, NULL, NULL, NULL, NULL, NULL, 518, 87, b'1', NULL),
(524, '2020-04-26', '06:17:05', 'DEPENSE', 3000, b'0', 522, NULL, NULL, NULL, NULL, NULL, 523, 87, b'1', NULL),
(528, '2020-04-26', '11:08:47', 'DEPENSE', 10000, b'0', 525, NULL, NULL, NULL, NULL, 431, NULL, 87, b'1', NULL),
(529, '2020-04-26', '11:16:38', 'DEPENSE', 10000, b'0', 525, NULL, NULL, NULL, NULL, 431, NULL, 87, b'1', NULL),
(531, '2020-04-26', '11:23:12', 'DEPENSE', 1000, b'0', 530, NULL, NULL, NULL, NULL, 431, NULL, 87, b'1', NULL),
(539, '2020-04-26', '12:48:30', 'Avance de Facture', 69000, b'1', NULL, 540, NULL, NULL, NULL, 557, NULL, 87, b'1', NULL),
(543, '2020-04-26', '12:48:30', 'Avance de Facture', 100300, b'1', NULL, 544, NULL, NULL, NULL, 558, NULL, 87, b'1', NULL),
(545, '2020-04-26', '12:48:30', 'Avance de Facture', 192500, b'1', NULL, 546, NULL, NULL, NULL, 559, NULL, 87, b'1', NULL),
(547, '2020-04-26', '12:48:30', 'Avance de Facture', 103500, b'1', NULL, 548, NULL, NULL, NULL, 560, NULL, 87, b'1', NULL),
(566, '2020-04-26', '13:21:40', 'Avance de Facture', 40000, b'1', NULL, 567, NULL, NULL, NULL, 570, NULL, 87, b'1', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `caisse`
--

CREATE TABLE `caisse` (
  `id_caisse` bigint(20) NOT NULL,
  `montant_caisse` float NOT NULL,
  `capital` float NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `caisse`
--

INSERT INTO `caisse` (`id_caisse`, `montant_caisse`, `capital`, `is_valide`) VALUES
(307, 393600, 2500000, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `caisse_journaliere`
--

CREATE TABLE `caisse_journaliere` (
  `id_caisse_journaliere` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `is_taked` bit(1) NOT NULL,
  `montant_depenses` float NOT NULL,
  `montant_encaisse` float NOT NULL,
  `montant_final` float NOT NULL,
  `montant_used` float DEFAULT NULL,
  `used_type` int(11) NOT NULL,
  `decaissementcj` bigint(20) DEFAULT NULL,
  `my_interface_caisse` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `caisse_journaliere`
--

INSERT INTO `caisse_journaliere` (`id_caisse_journaliere`, `date`, `is_taked`, `montant_depenses`, `montant_encaisse`, `montant_final`, `montant_used`, `used_type`, `decaissementcj`, `my_interface_caisse`, `is_valide`) VALUES
(431, '2020-04-13', b'0', 11000, 532600, 521600, 11000, 2, 531, NULL, b'1'),
(453, '2020-04-21', b'0', 0, 230000, 230000, 0, 1, NULL, NULL, b'1'),
(557, '2020-04-26', b'0', 0, 69000, 69000, 0, 1, NULL, NULL, b'1'),
(558, '2020-04-26', b'0', 0, 100300, 100300, 0, 1, NULL, NULL, b'1'),
(559, '2020-04-26', b'0', 0, 192500, 192500, 0, 1, NULL, NULL, b'1'),
(560, '2020-04-26', b'0', 0, 103500, 103500, 0, 1, NULL, NULL, b'1'),
(570, '2020-04-26', b'0', 0, 40000, 40000, 0, 1, NULL, NULL, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `cass`
--

CREATE TABLE `cass` (
  `id_gestion_facture` bigint(20) NOT NULL,
  `date_cass` date NOT NULL,
  `heure_cass` time NOT NULL,
  `montant_dommage` float NOT NULL,
  `nature` bit(1) NOT NULL,
  `nb_bout` float NOT NULL,
  `raison` varchar(50) DEFAULT NULL,
  `auteur_cass` bigint(20) NOT NULL,
  `produit_cass` bigint(20) DEFAULT NULL,
  `id_cass` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL,
  `is_acquited` bit(1) DEFAULT NULL,
  `is_managed` bit(1) DEFAULT NULL,
  `mag_emb` bigint(20) DEFAULT NULL,
  `mag_prod` bigint(20) DEFAULT NULL,
  `my_argent_mvt` bigint(20) DEFAULT NULL,
  `my_emballage_mvt` bigint(20) DEFAULT NULL,
  `my_produit_mvt` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `chargement`
--

CREATE TABLE `chargement` (
  `id_chargement` bigint(20) NOT NULL,
  `date_chargement` date NOT NULL,
  `heure_chargement` time NOT NULL,
  `nb_colis_char` float NOT NULL,
  `nb_emb_char` float NOT NULL,
  `secteur_char` varchar(30) DEFAULT NULL,
  `solde_char` float NOT NULL,
  `livreur_char` bigint(20) DEFAULT NULL,
  `magasinier_char` bigint(20) DEFAULT NULL,
  `my_personnel` bigint(20) DEFAULT NULL,
  `my_retour_chargment` bigint(20) DEFAULT NULL,
  `secretaire_char` bigint(20) DEFAULT NULL,
  `is_livred` bit(1) DEFAULT NULL,
  `is_embok` bit(1) DEFAULT NULL,
  `is_solded` bit(1) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `chargement`
--

INSERT INTO `chargement` (`id_chargement`, `date_chargement`, `heure_chargement`, `nb_colis_char`, `nb_emb_char`, `secteur_char`, `solde_char`, `livreur_char`, `magasinier_char`, `my_personnel`, `my_retour_chargment`, `secretaire_char`, `is_livred`, `is_embok`, `is_solded`, `is_valide`) VALUES
(432, '2020-04-18', '06:57:30', 40, 40, 'Tchitchap', 262500, 59, 87, NULL, 433, 87, b'1', b'0', b'0', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `chargement_patrimoine`
--

CREATE TABLE `chargement_patrimoine` (
  `id_charg_pat` bigint(20) NOT NULL,
  `my_chargement` bigint(20) DEFAULT NULL,
  `my_patrimoine` bigint(20) DEFAULT NULL,
  `is_occuped` bit(1) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` bigint(20) NOT NULL,
  `adresse_client` varchar(30) DEFAULT NULL,
  `date_cni_client` date DEFAULT NULL,
  `date_enregistrement` date NOT NULL,
  `date_naissance_client` date DEFAULT NULL,
  `libelle_argent` bit(1) NOT NULL,
  `nom_client` varchar(30) NOT NULL,
  `numero_cni_client` varchar(10) DEFAULT NULL,
  `prenom_client` varchar(30) DEFAULT NULL,
  `secteur` varchar(30) DEFAULT NULL,
  `sexe_client` bit(1) DEFAULT NULL,
  `type_client` varchar(30) NOT NULL,
  `tel_client` varchar(30) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `adresse_client`, `date_cni_client`, `date_enregistrement`, `date_naissance_client`, `libelle_argent`, `nom_client`, `numero_cni_client`, `prenom_client`, `secteur`, `sexe_client`, `type_client`, `tel_client`, `is_valide`) VALUES
(240, '', '2010-05-03', '2020-03-31', '2010-05-03', b'1', 'Confiance', '123465789', '', 'Molo Molo', b'0', 'Regulier', '698959625', b'1'),
(241, '', '2010-05-03', '2020-03-31', '2010-05-03', b'1', 'Passant', '123465789', '', ' ', b'0', 'Regulier', '698959625', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur_ext`
--

CREATE TABLE `collaborateur_ext` (
  `id_collaborateur_ext` bigint(20) NOT NULL,
  `contactce1` varchar(30) NOT NULL,
  `contactce2` varchar(30) DEFAULT NULL,
  `nomce` varchar(30) NOT NULL,
  `postece` varchar(30) DEFAULT NULL,
  `prenomce` varchar(30) DEFAULT NULL,
  `my_fournisseur` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `collaborateur_ext`
--

INSERT INTO `collaborateur_ext` (`id_collaborateur_ext`, `contactce1`, `contactce2`, `nomce`, `postece`, `prenomce`, `my_fournisseur`, `is_valide`) VALUES
(1, '+237693910091', '+237671314631', 'Mussen', 'LivreurCamion', 'Fabien', 2, b'1'),
(11, '+237650001456', NULL, 'Kapssen', 'LivreurCamion', 'Jean', 3, b'1'),
(12, '+237650001456', NULL, 'Kapssen', 'LivreurCamion', 'Jean', 3, b'1'),
(13, '+237658965412', NULL, 'Etoga', 'LivreurCamion', 'Jeanette', 3, b'1'),
(14, '+237693910091', '+237699969825', 'Atoa', 'LivreurCamion', 'Laurent', 2, b'1'),
(25, '+237693910091', NULL, 'Mussen', 'LivreurCamion', 'Fabien', 26, b'1'),
(29, '+237650012536', '+237677880014', 'Kamga', 'LivreurCamion', 'Laurent', 27, b'1'),
(30, '+237650012536', '+237677880014', 'Kamga', 'LivreurCamion', 'Laurent', 27, b'1'),
(31, '+237650012536', '+237677880014', 'FATOU', 'LivreurCamion', 'Diome', 27, b'1'),
(34, '+237650012536', '+237677880014', 'TALLA', 'LivreurCamion', 'Dieudonne', 27, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_commande` bigint(20) NOT NULL,
  `date_commande` date NOT NULL,
  `heure_commande` time NOT NULL,
  `nb_casiers` float NOT NULL,
  `nb_emb_com` float NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `my_client` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `date_commande`, `heure_commande`, `nb_casiers`, `nb_emb_com`, `status`, `my_client`, `is_valide`) VALUES
(480, '2020-04-25', '11:42:04', 40, 40, '0', 240, b'1'),
(488, '2020-04-26', '04:50:00', 0, 0, '0', 240, b'1'),
(496, '2020-04-26', '05:45:10', 15, 15, '0', 240, b'1'),
(532, '2020-04-26', '11:54:50', 10, 10, '0', 240, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `commande_facture`
--

CREATE TABLE `commande_facture` (
  `id_com_fact` bigint(20) NOT NULL,
  `my_commande` bigint(20) NOT NULL,
  `my_facture` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `cumul_rist_clients`
--

CREATE TABLE `cumul_rist_clients` (
  `idcrc` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `is_payed` bit(1) NOT NULL,
  `montant` float NOT NULL,
  `client` bigint(20) NOT NULL,
  `facture` bigint(20) DEFAULT NULL,
  `my_factures_chargement` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cumul_rist_clients`
--

INSERT INTO `cumul_rist_clients` (`idcrc`, `date`, `is_payed`, `montant`, `client`, `facture`, `my_factures_chargement`, `is_valide`) VALUES
(423, '2020-04-17', b'0', 23300, 240, 396, NULL, b'1'),
(467, '2020-04-21', b'0', 4300, 240, NULL, 460, b'1'),
(477, '2020-04-25', b'0', 1200, 240, NULL, 473, b'1'),
(504, '2020-04-26', b'0', 192500, 240, 492, NULL, b'1'),
(515, '2020-04-26', b'0', 100300, 240, 506, NULL, b'1'),
(538, '2020-04-26', b'0', 3000, 240, 535, NULL, b'1'),
(542, '2020-04-26', b'0', 4500, 240, 486, NULL, b'1'),
(565, '2020-04-26', b'0', 3000, 240, 562, NULL, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `depenses`
--

CREATE TABLE `depenses` (
  `id_depense` bigint(20) NOT NULL,
  `date_depense` date NOT NULL,
  `dategf` time NOT NULL,
  `montant` float NOT NULL,
  `motif` varchar(50) NOT NULL,
  `my_argent_mvt` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) NOT NULL,
  `secretaire` bigint(20) NOT NULL,
  `is_payed` bit(1) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL,
  `heure_depense` time NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `depenses`
--

INSERT INTO `depenses` (`id_depense`, `date_depense`, `dategf`, `montant`, `motif`, `my_argent_mvt`, `responsable`, `secretaire`, `is_payed`, `is_valide`, `heure_depense`) VALUES
(517, '2020-04-26', '06:08:16', 2000, 'Carburant', 519, 87, 87, b'1', b'1', '00:00:00'),
(522, '2020-04-26', '06:17:05', 3000, 'Carburant', 524, 87, 87, b'1', b'1', '00:00:00'),
(525, '2020-04-24', '07:29:51', 10000, 'Pneu Voiture', 529, 87, 87, b'1', b'1', '00:00:00'),
(530, '2020-04-26', '11:23:12', 1000, 'Ration', 531, 87, 87, b'1', b'1', '00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `detailsfc`
--

CREATE TABLE `detailsfc` (
  `id_detailsfc` bigint(20) NOT NULL,
  `total_avance_emb` float NOT NULL,
  `total_avance_soldefc` float NOT NULL,
  `total_reste_soldefc` float NOT NULL,
  `totalreste_emb` float NOT NULL,
  `my_factures_chargement` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `detailsfc`
--

INSERT INTO `detailsfc` (`id_detailsfc`, `total_avance_emb`, `total_avance_soldefc`, `total_reste_soldefc`, `totalreste_emb`, `my_factures_chargement`, `is_valide`) VALUES
(461, 15, 103300, 0, 0, 460, b'1'),
(474, 5, 34200, 0, -2, 473, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `details_facture`
--

CREATE TABLE `details_facture` (
  `id_details_facture` bigint(20) NOT NULL,
  `total_avance_emb` float NOT NULL,
  `total_avance_solde` float NOT NULL,
  `total_reste_emb` float NOT NULL,
  `total_reste_solde` float NOT NULL,
  `my_facture` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `details_facture`
--

INSERT INTO `details_facture` (`id_details_facture`, `total_avance_emb`, `total_avance_solde`, `total_reste_emb`, `total_reste_solde`, `my_facture`, `is_valide`) VALUES
(269, 40, 248600, 0, 0, 270, b'1'),
(395, 77, 532600, 0, 0, 396, b'1'),
(485, 15, 103500, 0, 0, 486, b'1'),
(489, 0, 0, 0, 0, 490, b'1'),
(491, 30, 192500, 0, 0, 492, b'1'),
(505, 15, 100300, 0, 0, 506, b'1'),
(534, 10, 69000, 0, 0, 535, b'1'),
(561, 10, 40000, 0, 0, 562, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `details_livraison`
--

CREATE TABLE `details_livraison` (
  `id_details_livraison` bigint(20) NOT NULL,
  `avance_emb` float NOT NULL,
  `avance_solde` float NOT NULL,
  `reste_emb` float NOT NULL,
  `reste_solde` float NOT NULL,
  `deconsigne_value` float DEFAULT 0,
  `is_deconsigneddl` bit(1) NOT NULL,
  `mylivraison` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `details_livraison`
--

INSERT INTO `details_livraison` (`id_details_livraison`, `avance_emb`, `avance_solde`, `reste_emb`, `reste_solde`, `deconsigne_value`, `is_deconsigneddl`, `mylivraison`, `is_valide`) VALUES
(134, 90, 714700, 0, -200000, 0, b'0', NULL, b'1'),
(135, 0, 0, 20, 221000, 0, b'0', NULL, b'1'),
(1, 0, 0, 0, 0, 0, b'0', NULL, b'1'),
(137, 0, 0, 0, 0, 0, b'0', NULL, b'1'),
(152, 0, 0, 200, 1080000, 18000, b'1', NULL, b'1'),
(154, 0, 0, 0, 0, 0, b'0', NULL, b'1'),
(157, 0, 0, 0, 0, 0, b'0', NULL, b'1'),
(166, 150, 540000, -100, 0, 150000, b'1', NULL, b'1'),
(178, 55, 297000, 0, 0, 0, b'0', NULL, b'1'),
(191, 0, 0, 0, 0, 0, b'0', 192, b'1'),
(193, 0, 0, 0, 0, 0, b'0', 194, b'1'),
(195, 0, 0, 0, 0, 0, b'0', 196, b'1'),
(197, 0, 0, 0, 26000, 0, b'0', 198, b'1'),
(224, 0, 26000, 0, 0, 0, b'0', 225, b'1'),
(226, 0, 0, 0, 0, 0, b'0', 227, b'1'),
(232, 20, 82000, 0, 0, 0, b'0', 233, b'1'),
(311, 250, 1332000, 0, 0, 0, b'0', 312, b'1'),
(334, 30, 153400, 0, 0, 0, b'0', 335, b'1'),
(336, 20, 220000, 0, 0, 0, b'0', 337, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `emballages_mvt`
--

CREATE TABLE `emballages_mvt` (
  `id_emb` bigint(20) NOT NULL,
  `date_op` date NOT NULL,
  `heure_op` time NOT NULL,
  `libelle_mvt_emb` varchar(255) DEFAULT NULL,
  `nature_mvt_emb` bit(1) NOT NULL,
  `quantite_emb` float NOT NULL,
  `fournisseur_emb` bigint(20) DEFAULT NULL,
  `my_gestion_facture` bigint(20) DEFAULT NULL,
  `my_gestion_livraison` bigint(20) DEFAULT NULL,
  `my_gestion_retour_chargment` bigint(20) DEFAULT NULL,
  `magasinieremb` bigint(20) DEFAULT NULL,
  `my_achat_emballage` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL,
  `my_cass` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `emballages_mvt`
--

INSERT INTO `emballages_mvt` (`id_emb`, `date_op`, `heure_op`, `libelle_mvt_emb`, `nature_mvt_emb`, `quantite_emb`, `fournisseur_emb`, `my_gestion_facture`, `my_gestion_livraison`, `my_gestion_retour_chargment`, `magasinieremb`, `my_achat_emballage`, `is_valide`, `my_cass`) VALUES
(217, '2020-03-29', '19:35:49', 'Avance concernant la livraison de MONDAY', b'1', 30, 2, NULL, 216, NULL, NULL, NULL, b'1', NULL),
(223, '2020-03-29', '19:48:17', 'Avance concernant la livraison de MONDAY', b'1', 10, 2, NULL, 222, NULL, NULL, NULL, b'1', NULL),
(238, '2020-03-29', '20:16:53', 'Avance concernant la livraison de MONDAY', b'1', 20, 2, NULL, 237, NULL, NULL, NULL, b'1', NULL),
(300, '2020-03-31', '10:48:06', 'Avance de Facture', b'1', 25, 2, 299, NULL, NULL, NULL, NULL, b'1', NULL),
(306, '2020-03-31', '10:54:57', 'Avance de Facture', b'1', 15, 2, 305, NULL, NULL, NULL, NULL, b'1', NULL),
(331, '2020-04-15', '08:09:31', 'Stock Achat Emballage', b'1', 250, 2, NULL, NULL, NULL, 87, 328, b'1', NULL),
(332, '2020-04-15', '08:09:31', 'Stock Achat Emballage', b'1', 30, 3, NULL, NULL, NULL, 87, 328, b'1', NULL),
(333, '2020-04-15', '08:09:31', 'Stock Achat Emballage', b'1', 20, 26, NULL, NULL, NULL, 87, 328, b'1', NULL),
(376, '2020-04-15', '12:52:11', 'Sortie Emballages Livraison   SABC', b'0', 250, 2, NULL, 375, NULL, 87, NULL, b'1', NULL),
(385, '2020-04-15', '13:10:31', 'Sortie Emballages Livraison   UCB', b'0', 30, 3, NULL, 379, NULL, 87, NULL, b'1', NULL),
(386, '2020-04-15', '13:10:31', 'Sortie Emballages Livraison   GUINNESS S.A.', b'0', 20, 26, NULL, 380, NULL, 87, NULL, b'1', NULL),
(429, '2020-04-16', '07:30:37', 'Avance de Facture', b'1', 77, 2, 428, NULL, NULL, 87, NULL, b'1', NULL),
(450, '2020-04-21', '04:03:04', NULL, b'1', 31, 2, NULL, NULL, 449, 87, NULL, b'1', NULL),
(550, '2020-04-25', '12:27:00', 'Avance de Facture', b'1', 10, 2, 549, NULL, NULL, 87, NULL, b'1', NULL),
(552, '2020-04-25', '12:27:00', 'Avance de Facture', b'1', 15, 2, 551, NULL, NULL, 87, NULL, b'1', NULL),
(554, '2020-04-25', '12:27:00', 'Avance de Facture', b'1', 30, 2, 553, NULL, NULL, 87, NULL, b'1', NULL),
(556, '2020-04-25', '12:27:00', 'Avance de Facture', b'1', 15, 2, 555, NULL, NULL, 87, NULL, b'1', NULL),
(569, '2020-04-25', '13:21:41', 'Avance de Facture', b'1', 10, 2, 568, NULL, NULL, 87, NULL, b'1', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id_facture` bigint(20) NOT NULL,
  `date_fact` date NOT NULL,
  `heure` time NOT NULL,
  `is_emb_ok_facture` bit(1) NOT NULL,
  `is_solded_facture` bit(1) NOT NULL,
  `nb_colis_fact` float NOT NULL,
  `nb_emb_fact` float NOT NULL,
  `solde_fact` float NOT NULL,
  `total_rist_fact` float NOT NULL,
  `client` bigint(20) DEFAULT NULL,
  `livreur` bigint(20) DEFAULT NULL,
  `magasinier_fact` bigint(20) DEFAULT NULL,
  `my_details_facture` bigint(20) DEFAULT NULL,
  `secrectaire_fact` bigint(20) NOT NULL,
  `is_livred` bit(1) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id_facture`, `date_fact`, `heure`, `is_emb_ok_facture`, `is_solded_facture`, `nb_colis_fact`, `nb_emb_fact`, `solde_fact`, `total_rist_fact`, `client`, `livreur`, `magasinier_fact`, `my_details_facture`, `secrectaire_fact`, `is_livred`, `is_valide`) VALUES
(270, '2020-03-23', '09:57:19', b'1', b'1', 40, 40, 248600, 10700, 240, 87, 87, 269, 87, b'1', b'1'),
(396, '2020-04-01', '21:26:16', b'1', b'1', 82, 77, 532600, 23300, 240, 87, 87, 395, 87, b'1', b'1'),
(486, '2020-04-21', '11:42:05', b'1', b'1', 15, 15, 103500, 4500, 240, 87, 87, 485, 87, b'1', b'1'),
(490, '2020-04-26', '04:50:02', b'0', b'0', 0, 0, 0, 0, 240, NULL, NULL, 489, 87, b'0', b'1'),
(492, '2020-04-20', '05:09:12', b'1', b'1', 30, 30, 192500, 9000, 240, 87, 87, 491, 87, b'1', b'1'),
(506, '2020-04-19', '05:45:12', b'1', b'1', 15, 15, 100300, 4500, 240, 87, 87, 505, 87, b'1', b'1'),
(535, '2020-04-22', '11:54:52', b'1', b'1', 10, 10, 69000, 3000, 240, 87, 87, 534, 87, b'1', b'1'),
(562, '2020-04-22', '13:12:55', b'1', b'1', 10, 10, 40000, 3000, 240, 87, 87, 561, 87, b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `factures_chargement`
--

CREATE TABLE `factures_chargement` (
  `id_fact_charg` bigint(20) NOT NULL,
  `datefc` date NOT NULL,
  `heurefc` time NOT NULL,
  `is_emb_ok` bit(1) NOT NULL,
  `is_solded` bit(1) NOT NULL,
  `nb_colisfc` float NOT NULL,
  `nb_embfc` float NOT NULL,
  `soldefc` float NOT NULL,
  `total_ristfc` float NOT NULL,
  `my_chargement` bigint(20) NOT NULL,
  `my_client` bigint(20) NOT NULL,
  `my_detailsfc` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `factures_chargement`
--

INSERT INTO `factures_chargement` (`id_fact_charg`, `datefc`, `heurefc`, `is_emb_ok`, `is_solded`, `nb_colisfc`, `nb_embfc`, `soldefc`, `total_ristfc`, `my_chargement`, `my_client`, `my_detailsfc`, `is_valide`) VALUES
(460, '2020-04-19', '09:58:16', b'1', b'1', 15, 15, 103300, 4300, 432, 240, 461, b'1'),
(473, '2020-04-24', '11:28:48', b'1', b'1', 5, 5, 34200, 1200, 432, 240, 474, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `facture_patrimoine`
--

CREATE TABLE `facture_patrimoine` (
  `id_fact_pat` bigint(20) NOT NULL,
  `my_facture` bigint(20) NOT NULL,
  `my_patrimoine` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id_fournisseur` bigint(20) NOT NULL,
  `contact` varchar(40) NOT NULL,
  `jours_livraison` varchar(40) DEFAULT NULL,
  `nom` varchar(40) NOT NULL,
  `periode_rist` varchar(40) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id_fournisseur`, `contact`, `jours_livraison`, `nom`, `periode_rist`, `is_valide`) VALUES
(2, '+23765285412', 'Mercedi, samedi', 'SABC', '8 mois', b'1'),
(3, '+237655013215', 'Mardi, Jeudi', 'UCB', '6 mois', b'1'),
(26, '+23765285412', 'Mardi, Vendredi', 'GUINNESS S.A.', '6 mois', b'1'),
(27, '+237677944247', 'Mardi, Vendredi', 'Grand depot S.A.', '6 mois', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `gestionfc`
--

CREATE TABLE `gestionfc` (
  `id_gestionfc` bigint(20) NOT NULL,
  `avancefc` float NOT NULL,
  `dategfc` date NOT NULL,
  `heuregfc` time NOT NULL,
  `nature_opfc` bit(1) NOT NULL,
  `my_factures_chargement` bigint(20) NOT NULL,
  `is_managed` bit(1) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gestionfc`
--

INSERT INTO `gestionfc` (`id_gestionfc`, `avancefc`, `dategfc`, `heuregfc`, `nature_opfc`, `my_factures_chargement`, `is_managed`, `is_valide`) VALUES
(469, 100000, '2020-04-25', '10:58:46', b'1', 460, b'0', b'1'),
(470, 13, '2020-04-25', '10:58:46', b'0', 460, b'0', b'1'),
(471, 2, '2020-04-25', '11:04:14', b'0', 460, b'0', b'1'),
(472, 3300, '2020-04-25', '11:10:37', b'1', 460, b'0', b'1'),
(478, 34200, '2020-04-25', '11:33:14', b'1', 473, b'0', b'1'),
(479, 5, '2020-04-25', '11:33:14', b'0', 473, b'0', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `gestion_caisse`
--

CREATE TABLE `gestion_caisse` (
  `id_gestion_caisse` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `montant` float NOT NULL,
  `nature_op` bit(1) NOT NULL,
  `source_ou_destination` varchar(50) DEFAULT NULL,
  `my_interface_caisse` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gestion_caisse`
--

INSERT INTO `gestion_caisse` (`id_gestion_caisse`, `date`, `montant`, `nature_op`, `source_ou_destination`, `my_interface_caisse`, `is_valide`) VALUES
(309, '2020-04-14', 500000, b'1', 'Reunion Bakassa', 310, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `gestion_facture`
--

CREATE TABLE `gestion_facture` (
  `id_gestion_facture` bigint(20) NOT NULL,
  `avancegf` float NOT NULL,
  `dategf` date NOT NULL,
  `heuregf` time NOT NULL,
  `nature_opgf` bit(1) NOT NULL,
  `my_argent_mvt` bigint(20) DEFAULT NULL,
  `my_facture` bigint(20) NOT NULL,
  `personnel_intgf` bigint(20) NOT NULL,
  `is_managed` bit(1) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gestion_facture`
--

INSERT INTO `gestion_facture` (`id_gestion_facture`, `avancegf`, `dategf`, `heuregf`, `nature_opgf`, `my_argent_mvt`, `my_facture`, `personnel_intgf`, `is_managed`, `is_valide`) VALUES
(297, 148600, '2020-03-31', '10:28:04', b'1', 296, 270, 87, NULL, b'1'),
(299, 25, '2020-03-31', '10:48:06', b'0', NULL, 270, 87, NULL, b'1'),
(304, 100000, '2020-03-31', '10:54:57', b'1', 303, 270, 87, NULL, b'1'),
(305, 15, '2020-03-31', '10:54:57', b'0', NULL, 270, 87, NULL, b'1'),
(427, 532600, '2020-04-17', '07:30:37', b'1', 426, 396, 87, b'1', b'1'),
(428, 77, '2020-04-17', '07:30:37', b'0', NULL, 396, 87, b'1', b'1'),
(540, 69000, '2020-04-25', '12:02:09', b'1', 539, 535, 87, b'1', b'1'),
(544, 100300, '2020-04-25', '12:27:00', b'1', 543, 506, 87, b'1', b'1'),
(546, 192500, '2020-04-25', '12:27:00', b'1', 545, 492, 87, b'1', b'1'),
(548, 103500, '2020-04-25', '12:27:00', b'1', 547, 486, 87, b'1', b'1'),
(549, 10, '2020-04-25', '12:27:00', b'0', NULL, 535, 87, b'1', b'1'),
(551, 15, '2020-04-25', '12:27:00', b'0', NULL, 506, 87, b'1', b'1'),
(553, 30, '2020-04-25', '12:27:00', b'0', NULL, 492, 87, b'1', b'1'),
(555, 15, '2020-04-25', '12:27:00', b'0', NULL, 486, 87, b'1', b'1'),
(567, 40000, '2020-04-26', '13:21:41', b'1', 566, 562, 87, b'1', b'1'),
(568, 10, '2020-04-26', '13:21:41', b'0', NULL, 562, 87, b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `gestion_livraison`
--

CREATE TABLE `gestion_livraison` (
  `id_gestion_livraison` bigint(20) NOT NULL,
  `avancegl` float NOT NULL,
  `nature_operation` bit(1) NOT NULL,
  `preuve_juridique` varchar(60) DEFAULT NULL,
  `valideop` bit(1) NOT NULL,
  `my_livraison` bigint(20) NOT NULL,
  `my_personnel_int` bigint(20) NOT NULL,
  `my_personnel_ext` bigint(20) NOT NULL,
  `heure_operation` time NOT NULL,
  `date_operation` date NOT NULL,
  `is_deconsigned` bit(1) NOT NULL,
  `my_argent_mvt` bigint(20) DEFAULT NULL,
  `my_emballages_mvt` bigint(20) DEFAULT NULL,
  `is_managed` bit(1) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gestion_livraison`
--

INSERT INTO `gestion_livraison` (`id_gestion_livraison`, `avancegl`, `nature_operation`, `preuve_juridique`, `valideop`, `my_livraison`, `my_personnel_int`, `my_personnel_ext`, `heure_operation`, `date_operation`, `is_deconsigned`, `my_argent_mvt`, `my_emballages_mvt`, `is_managed`, `is_valide`) VALUES
(79, 10000, b'1', NULL, b'1', 64, 53, 1, '23:51:24', '2020-01-01', b'0', NULL, NULL, NULL, b'1'),
(80, 25000, b'1', NULL, b'1', 64, 59, 1, '23:31:26', '2020-02-02', b'0', NULL, NULL, NULL, b'1'),
(81, 15000, b'1', NULL, b'1', 64, 53, 1, '02:19:23', '2020-01-14', b'0', NULL, NULL, NULL, b'1'),
(82, 10, b'0', NULL, b'1', 64, 59, 1, '12:01:16', '2020-03-11', b'0', NULL, NULL, NULL, b'1'),
(100, 50000, b'1', NULL, b'1', 97, 87, 34, '09:19:54', '2020-03-06', b'0', NULL, NULL, NULL, b'1'),
(101, 5, b'0', NULL, b'1', 97, 87, 34, '09:22:12', '2020-03-06', b'0', NULL, NULL, NULL, b'1'),
(131, 150000, b'1', NULL, b'1', 108, 87, 14, '12:45:08', '2020-03-07', b'0', NULL, NULL, NULL, b'1'),
(132, 90, b'0', NULL, b'1', 108, 87, 14, '12:59:08', '2020-03-07', b'0', NULL, NULL, NULL, b'1'),
(148, 1500000, b'1', NULL, b'1', 136, 59, 1, '23:27:46', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(149, 150, b'0', NULL, b'1', 136, 59, 1, '23:35:16', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(150, 150, b'0', NULL, b'1', 136, 59, 1, '23:35:20', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(151, 10, b'0', NULL, b'1', 136, 59, 1, '23:43:20', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(161, 300000, b'1', NULL, b'1', 153, 59, 1, '00:35:18', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(162, 60, b'0', NULL, b'1', 153, 59, 1, '00:49:31', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(163, 10, b'0', NULL, b'1', 153, 59, 1, '01:03:04', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(164, 78000, b'1', NULL, b'1', 153, 59, 1, '01:03:04', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(165, 18000, b'1', NULL, b'1', 153, 59, 1, '19:18:16', '2020-03-18', b'1', NULL, NULL, NULL, b'1'),
(171, 540000, b'1', NULL, b'1', 167, 59, 1, '21:08:00', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(172, 150000, b'1', NULL, b'1', 167, 59, 1, '21:19:00', '2020-03-18', b'1', NULL, NULL, NULL, b'1'),
(173, 50, b'0', NULL, b'1', 167, 59, 1, '21:19:00', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(174, 150000, b'1', NULL, b'1', 167, 59, 1, '21:26:48', '2020-03-18', b'1', NULL, NULL, NULL, b'1'),
(175, 50, b'0', NULL, b'1', 167, 59, 1, '21:26:48', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(176, 150000, b'1', NULL, b'1', 167, 59, 1, '21:45:37', '2020-03-18', b'1', NULL, NULL, NULL, b'1'),
(177, 50, b'0', NULL, b'1', 167, 59, 1, '21:45:37', '2020-03-18', b'0', NULL, NULL, NULL, b'1'),
(181, 100000, b'1', NULL, b'1', 179, 59, 1, '07:18:05', '2020-03-21', b'0', NULL, NULL, NULL, b'1'),
(182, 97000, b'1', NULL, b'1', 179, 59, 1, '07:19:37', '2020-03-21', b'0', NULL, NULL, NULL, b'1'),
(183, 100000, b'1', NULL, b'1', 179, 59, 1, '07:20:22', '2020-03-21', b'0', NULL, NULL, NULL, b'1'),
(184, 10, b'0', NULL, b'1', 179, 59, 1, '07:22:34', '2020-03-21', b'0', NULL, NULL, NULL, b'1'),
(185, 15, b'0', NULL, b'1', 179, 59, 1, '07:23:44', '2020-03-21', b'0', NULL, NULL, NULL, b'1'),
(186, 30, b'0', NULL, b'1', 179, 59, 1, '07:24:39', '2020-03-21', b'0', NULL, NULL, NULL, b'1'),
(187, 364700, b'1', NULL, b'1', 108, 59, 1, '18:57:50', '2020-03-28', b'0', NULL, NULL, NULL, b'1'),
(214, 200000, b'1', NULL, b'1', 108, 59, 1, '19:35:49', '2020-03-29', b'0', 215, NULL, NULL, b'1'),
(216, 30, b'0', NULL, b'1', 198, 59, 1, '19:35:49', '2020-03-29', b'0', NULL, 217, NULL, b'1'),
(218, 200000, b'1', NULL, b'1', 198, 59, 1, '19:37:04', '2020-03-29', b'0', 219, NULL, NULL, b'1'),
(220, 15000, b'1', NULL, b'1', 198, 59, 1, '19:48:17', '2020-03-29', b'0', 221, NULL, NULL, b'1'),
(222, 10, b'0', NULL, b'1', 198, 59, 1, '19:48:17', '2020-03-29', b'0', NULL, 223, NULL, b'1'),
(230, 26000, b'1', NULL, b'1', 225, 59, 1, '20:05:58', '2020-03-29', b'0', 231, NULL, NULL, b'1'),
(235, 82000, b'1', NULL, b'1', 233, 59, 1, '20:16:53', '2020-03-29', b'0', 236, NULL, NULL, b'1'),
(237, 20, b'0', NULL, b'1', 233, 59, 1, '20:16:53', '2020-03-29', b'0', NULL, 238, NULL, b'1'),
(372, 1332000, b'1', NULL, b'1', 312, 87, 1, '11:32:41', '2020-04-15', b'0', 374, NULL, NULL, b'1'),
(375, 250, b'0', NULL, b'1', 312, 87, 1, '12:48:23', '2020-04-14', b'0', NULL, 376, NULL, b'1'),
(377, 153400, b'1', NULL, b'1', 335, 87, 13, '13:10:32', '2020-04-15', b'0', 382, NULL, NULL, b'1'),
(378, 220000, b'1', NULL, b'1', 337, 87, 25, '13:10:32', '2020-04-15', b'0', 384, NULL, NULL, b'1'),
(379, 30, b'0', NULL, b'1', 335, 87, 13, '13:10:32', '2020-04-15', b'0', NULL, 385, NULL, b'1'),
(380, 20, b'0', NULL, b'1', 337, 87, 25, '13:10:32', '2020-04-15', b'0', NULL, 386, NULL, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `gestion_retour_chargment`
--

CREATE TABLE `gestion_retour_chargment` (
  `idgrc` bigint(20) NOT NULL,
  `avancegrc` float NOT NULL,
  `dategrc` date NOT NULL,
  `heuregrc` time NOT NULL,
  `nature_opgrc` bit(1) NOT NULL,
  `restegrc` float NOT NULL,
  `my_retour_chargment` bigint(20) NOT NULL,
  `personnel_int` bigint(20) NOT NULL,
  `is_managed` bit(1) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gestion_retour_chargment`
--

INSERT INTO `gestion_retour_chargment` (`idgrc`, `avancegrc`, `dategrc`, `heuregrc`, `nature_opgrc`, `restegrc`, `my_retour_chargment`, `personnel_int`, `is_managed`, `is_valide`) VALUES
(449, 31, '2020-04-21', '04:03:02', b'0', 9, 433, 87, b'1', b'1'),
(451, 230000, '2020-04-21', '04:34:44', b'1', 32500, 433, 87, b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(573),
(573),
(573),
(573),
(573),
(573),
(573),
(573);

-- --------------------------------------------------------

--
-- Structure de la table `interface_caisse`
--

CREATE TABLE `interface_caisse` (
  `id_int_caisse` bigint(20) NOT NULL,
  `date_operation` date NOT NULL,
  `montant_operation` float NOT NULL,
  `nature_operation` bit(1) NOT NULL,
  `my_argent_mvt_pour_decaisser` bigint(20) DEFAULT NULL,
  `my_caisse_journaliere` bigint(20) DEFAULT NULL,
  `my_gestion_caisse` bigint(20) DEFAULT NULL,
  `my_achat_emballage` bigint(20) DEFAULT NULL,
  `responsable` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `interface_caisse`
--

INSERT INTO `interface_caisse` (`id_int_caisse`, `date_operation`, `montant_operation`, `nature_operation`, `my_argent_mvt_pour_decaisser`, `my_caisse_journaliere`, `my_gestion_caisse`, `my_achat_emballage`, `responsable`, `is_valide`) VALUES
(310, '2020-04-14', 500000, b'1', NULL, NULL, 309, NULL, NULL, b'1'),
(329, '2020-04-15', 396000, b'0', NULL, NULL, NULL, 328, NULL, b'1'),
(373, '2020-04-15', 1332000, b'0', 374, NULL, NULL, NULL, 87, b'1'),
(381, '2020-04-15', 153400, b'0', 382, NULL, NULL, NULL, 87, b'1'),
(383, '2020-04-15', 220000, b'0', 384, NULL, NULL, NULL, 87, b'1'),
(518, '2020-04-26', 2000, b'0', 519, NULL, NULL, NULL, 87, b'1'),
(523, '2020-04-26', 3000, b'0', 524, NULL, NULL, NULL, 87, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

CREATE TABLE `livraison` (
  `id_livraison` bigint(20) NOT NULL,
  `jour_livraison` varchar(30) NOT NULL,
  `nb_colis` float DEFAULT NULL,
  `nb_emb` float NOT NULL,
  `solde_livraison` float NOT NULL,
  `total_rist` float NOT NULL,
  `my_details_livraison` bigint(20) NOT NULL,
  `my_personnel` bigint(20) NOT NULL,
  `is_emb_ok` bit(1) NOT NULL,
  `is_solded` bit(1) NOT NULL,
  `heure_livraison` time DEFAULT NULL,
  `date_livraison` date DEFAULT NULL,
  `num_fact_livraision` varchar(30) DEFAULT NULL,
  `my_collaborateur_ext` bigint(20) NOT NULL,
  `is_sotcked` bit(1) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`id_livraison`, `jour_livraison`, `nb_colis`, `nb_emb`, `solde_livraison`, `total_rist`, `my_details_livraison`, `my_personnel`, `is_emb_ok`, `is_solded`, `heure_livraison`, `date_livraison`, `num_fact_livraision`, `my_collaborateur_ext`, `is_sotcked`, `is_valide`) VALUES
(64, 'Mercredi', 40, 25, 126300, 7500, 1, 53, b'0', b'0', NULL, NULL, NULL, 14, b'1', b'1'),
(97, 'Samedi', 25, 25, 105000, 7500, 1, 53, b'0', b'0', '22:32:54', '2020-03-05', NULL, 14, b'1', b'1'),
(108, 'SUNDAY', 100, 90, 514700, 29550, 134, 87, b'1', b'1', '09:00:11', '2020-03-01', '00005', 14, b'1', b'1'),
(136, 'WEDNESDAY', 330, 320, 1721000, 98500, 135, 59, b'1', b'0', '22:36:17', '2020-03-13', '00025', 1, b'1', b'1'),
(153, 'THURSDAY', 270, 270, 1458000, 81000, 152, 59, b'1', b'1', '23:49:36', '2020-03-12', '00058', 1, b'1', b'1'),
(167, 'THURSDAY', 100, 100, 540000, 30000, 166, 59, b'1', b'1', '20:54:23', '2020-03-14', '00060', 1, b'1', b'1'),
(179, 'SUNDAY', 55, 55, 297000, 16500, 178, 59, b'1', b'1', '07:05:24', '2020-03-18', '0000000', 1, b'1', b'1'),
(198, 'MONDAY', 60, 40, 241000, 18250, 197, 59, b'1', b'1', '18:27:02', '2020-03-24', '00099', 1, b'1', b'1'),
(225, 'MONDAY', 10, 0, 26000, 2500, 224, 59, b'1', b'1', '19:57:01', '2020-03-26', '00100', 1, b'1', b'1'),
(233, 'MONDAY', 20, 20, 82000, 8000, 232, 59, b'1', b'1', '20:11:16', '2020-03-25', '00101', 1, b'1', b'1'),
(312, 'WEDNESDAY', 260, 250, 1332000, 79250, 311, 87, b'1', b'1', '06:23:55', '2020-04-11', '111000050', 1, b'1', b'1'),
(335, 'THURSDAY', 32, 30, 153400, 10200, 334, 87, b'1', b'1', '08:49:29', '2020-04-13', '0000A25', 13, b'1', b'1'),
(337, 'THURSDAY', 20, 20, 220000, 9500, 336, 87, b'1', b'1', '08:49:29', '2020-04-13', '20005022', 25, b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `mag_emballage`
--

CREATE TABLE `mag_emballage` (
  `id_mag_emb` bigint(20) NOT NULL,
  `nb_bout` float DEFAULT NULL,
  `qte_mag` float NOT NULL,
  `fournisseur` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `mag_emballage`
--

INSERT INTO `mag_emballage` (`id_mag_emb`, `nb_bout`, `qte_mag`, `fournisseur`, `is_valide`) VALUES
(313, 0, 188, 2, b'1'),
(314, 0, 0, 3, b'1'),
(315, 0, 0, 26, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `manquantsrc`
--

CREATE TABLE `manquantsrc` (
  `id_manquantsrc` float NOT NULL,
  `is_emb` bit(1) DEFAULT NULL,
  `nb_bouteilles` float DEFAULT NULL,
  `nb_casier` float DEFAULT NULL,
  `valeurm` float DEFAULT NULL,
  `my_retour_chargment` bigint(20) NOT NULL,
  `produitmrc` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `patrimoine`
--

CREATE TABLE `patrimoine` (
  `id_patrimoine` bigint(20) NOT NULL,
  `immatriculation_pat` varchar(30) DEFAULT NULL,
  `nature_pat` varchar(30) DEFAULT NULL,
  `nom_pat` varchar(30) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `patrimoine_facture`
--

CREATE TABLE `patrimoine_facture` (
  `id_patrimoine_facture` bigint(20) NOT NULL,
  `facture` bigint(20) DEFAULT NULL,
  `patrimoine` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id_personnel` bigint(20) NOT NULL,
  `adresse_pers` varchar(45) DEFAULT NULL,
  `cni_pers` varchar(45) DEFAULT NULL,
  `contact_pers1` varchar(45) NOT NULL,
  `contact_pers2` varchar(45) DEFAULT NULL,
  `nom_pers` varchar(45) NOT NULL,
  `poste_pers` varchar(45) NOT NULL,
  `prenom_pers` varchar(45) NOT NULL,
  `sexe_pers` bit(1) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `date_cni_pers` date DEFAULT NULL,
  `date_naissance_pers` date DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL,
  `my_user` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`id_personnel`, `adresse_pers`, `cni_pers`, `contact_pers1`, `contact_pers2`, `nom_pers`, `poste_pers`, `prenom_pers`, `sexe_pers`, `status`, `date_cni_pers`, `date_naissance_pers`, `is_valide`, `my_user`) VALUES
(53, 'Toungang', '1234567', '690508814', '690508814', 'TCHOKOTHE', 'Boss', 'Blaise Pascal', b'1', NULL, NULL, NULL, b'1', NULL),
(55, 'Toungang', '1234567', '690508814', NULL, 'TCHOKOTHE', 'Boss', 'Blaise Pascal', b'1', NULL, NULL, NULL, b'1', NULL),
(59, 'Yaoundé', '1234567', '699986014', '671314631', 'YOUMBA', 'Vice Directeur', 'Arlegil Browndon', b'1', 'En Service', NULL, NULL, b'1', NULL),
(87, 'Extreme Nord', '13151419', '677825365', '691247856', 'MEGOUYEM', 'Secretaire', 'Megane', b'0', 'EN SERVICE', '2016-05-29', '1999-03-25', b'1', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `prix_produits`
--

CREATE TABLE `prix_produits` (
  `id_prix` bigint(20) NOT NULL,
  `prix_client` float NOT NULL,
  `rist_prod` float DEFAULT NULL,
  `produit` bigint(20) NOT NULL,
  `my_client` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `prix_produits`
--

INSERT INTO `prix_produits` (`id_prix`, `prix_client`, `rist_prod`, `produit`, `my_client`, `is_valide`) VALUES
(248, 6800, 200, 38, 240, b'1'),
(249, 4000, 300, 39, 240, b'1'),
(250, 2900, 300, 40, 240, b'1'),
(251, 5600, 200, 43, 240, b'1'),
(252, 5400, 200, 42, 240, b'1'),
(253, 6900, 300, 37, 240, b'1'),
(254, 6900, 300, 36, 240, b'1'),
(271, 6600, 0, 38, 241, b'1'),
(272, 4200, 0, 39, 241, b'1'),
(273, 2300, 0, 40, 241, b'1'),
(274, 5200, 0, 43, 241, b'1'),
(275, 5400, 0, 42, 241, b'1'),
(276, 6600, 0, 37, 241, b'1'),
(277, 6600, 0, 36, 241, b'1'),
(387, 13800, 300, 44, 240, b'1'),
(388, 10800, 300, 45, 240, b'1'),
(389, 7800, 300, 46, 240, b'1'),
(390, 6900, 300, 49, 240, b'1'),
(391, 4000, 200, 50, 240, b'1'),
(392, 5400, 200, 52, 240, b'1'),
(393, 9500, 200, 48, 240, b'1'),
(394, 6900, 300, 47, 240, b'1'),
(403, 2100, 300, 41, 240, b'1'),
(404, 6900, 300, 53, 240, b'1'),
(425, 6900, 300, 53, 240, b'1'),
(571, 5400, 0, 52, 241, b'1'),
(572, 13500, 0, 44, 241, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` bigint(20) NOT NULL,
  `degre_alcool` varchar(10) DEFAULT NULL,
  `format` int(11) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL,
  `nom_prod` varchar(30) NOT NULL,
  `prix_chargement` float NOT NULL,
  `pu_achat` float NOT NULL,
  `pu_vente` float NOT NULL,
  `quantite` float NOT NULL,
  `ristourne_livraison` float DEFAULT NULL,
  `type_prod` varchar(30) NOT NULL,
  `volume` varchar(10) DEFAULT NULL,
  `my_fournisseur` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `degre_alcool`, `format`, `is_valide`, `nom_prod`, `prix_chargement`, `pu_achat`, `pu_vente`, `quantite`, `ristourne_livraison`, `type_prod`, `volume`, `my_fournisseur`) VALUES
(36, '5.4%', 12, b'1', 'Castel Beer', 6600, 5400, 5400, 25, 300, 'casier', NULL, 2),
(37, '5.4%', 12, b'1', '33 Export Beer', 6600, 5400, 5400, 0, 300, 'casier', NULL, 2),
(38, '5.4%', 12, b'1', 'Booster', 6300, 5200, 5400, 2, 250, 'casier', NULL, 2),
(39, '5.4%', 12, b'1', 'Top', 3700, 4100, 4100, 4, 400, 'casier', NULL, 2),
(40, '5.4%', 12, b'1', 'Soda', 2300, 2600, 2600, 4, 300, 'casier', NULL, 2),
(41, '0%', 6, b'1', 'Tangui', 2300, 2600, 2600, 2, 250, 'pet', '1.5L', 2),
(42, '0%', 24, b'1', 'Fanta', 5200, 5200, 5400, 3, 250, 'pet', '0.33L', 2),
(43, '5.2%', 12, b'1', 'Magnan', 5200, 5400, 762, 4, 250, 'casier', '', 2),
(44, '7%', 24, b'1', 'Petite Guinness', 13500, 13500, 13500, 8, 500, 'casier', '0.33cl', 26),
(45, '7%', 12, b'1', 'Grande Guinness', 9500, 9500, 9500, 4, 500, 'casier', '0.66cl', 26),
(46, '7%', 15, b'1', 'Smooth', 7500, 7500, 7500, 3, 400, 'casier', '0.6cl', 26),
(47, '7%', 12, b'1', 'Origin', 6900, 6700, 6700, 0, 300, 'casier', '0.6cl', 26),
(48, '0%', 24, b'1', 'Malta G.', 9300, 9250, 9400, 0, 500, 'casier', '0.33cl', 26),
(49, '5.4%', 12, b'1', 'Kadji Beer', 6600, 5100, 5400, 25, 300, 'casier', '0.66cl', 3),
(50, '0%', 12, b'1', 'Special Pamplemousse', 3700, 3700, 4000, 5, 400, 'casier', '0.66cl', 3),
(51, '0%', 12, b'1', 'Special UCB', 3700, 3700, 4000, 0, 400, 'casier', '0.66cl', 3),
(52, '0%', 6, b'1', 'Special Pet 1.5L', 5400, 3700, 4000, 2, 350, 'pet', '1.5L', 3),
(53, '5.5%', 12, b'1', 'Mutzig', 6600, 5400, 5400, 19, 300, 'casier', '0.66cl', 2);

-- --------------------------------------------------------

--
-- Structure de la table `produitsfc`
--

CREATE TABLE `produitsfc` (
  `id_produitfc` bigint(20) NOT NULL,
  `prix_totalfc` float NOT NULL,
  `qtefc` float NOT NULL,
  `ristfc` float NOT NULL,
  `my_factures_chargement` bigint(20) NOT NULL,
  `produitfc` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produitsfc`
--

INSERT INTO `produitsfc` (`id_produitfc`, `prix_totalfc`, `qtefc`, `ristfc`, `my_factures_chargement`, `produitfc`, `is_valide`) VALUES
(463, 69000, 10, 3000, 460, 37, b'1'),
(464, 20700, 3, 900, 460, 36, b'1'),
(465, 13600, 2, 400, 460, 38, b'1'),
(475, 13800, 2, 600, 473, 36, b'1'),
(476, 20400, 3, 600, 473, 38, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `produitsrc`
--

CREATE TABLE `produitsrc` (
  `id_produitsrc` bigint(20) NOT NULL,
  `nb_bouteille_sup` float DEFAULT NULL,
  `quantiterc` float NOT NULL,
  `total_par_prod` float NOT NULL,
  `my_retour_chargment` bigint(20) NOT NULL,
  `produitrc` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produitsrc`
--

INSERT INTO `produitsrc` (`id_produitsrc`, `nb_bouteille_sup`, `quantiterc`, `total_par_prod`, `my_retour_chargment`, `produitrc`, `is_valide`) VALUES
(443, 5, 5, 35750, 433, 37, b'1'),
(444, 0, 2, 13200, 433, 36, b'1'),
(445, 0, 1, 6300, 433, 38, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `produits_chargment`
--

CREATE TABLE `produits_chargment` (
  `id_produits_chargment` bigint(20) NOT NULL,
  `prix_totalpc` float NOT NULL,
  `quantitepc` float NOT NULL,
  `my_chargement` bigint(20) NOT NULL,
  `produitpc` bigint(20) NOT NULL,
  `quantite_vendu` float NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produits_chargment`
--

INSERT INTO `produits_chargment` (`id_produits_chargment`, `prix_totalpc`, `quantitepc`, `my_chargement`, `produitpc`, `quantite_vendu`, `is_valide`) VALUES
(434, 198000, 30, 432, 37, 10, b'1'),
(435, 33000, 5, 432, 36, 5, b'1'),
(436, 31500, 5, 432, 38, 5, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `produits_commande`
--

CREATE TABLE `produits_commande` (
  `id_prod_com` bigint(20) NOT NULL,
  `nb_colis_prod_com` float NOT NULL,
  `nb_emb_prod_com` float NOT NULL,
  `qte_pord_com` float NOT NULL,
  `my_commande` bigint(20) NOT NULL,
  `produit_prod_com` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produits_commande`
--

INSERT INTO `produits_commande` (`id_prod_com`, `nb_colis_prod_com`, `nb_emb_prod_com`, `qte_pord_com`, `my_commande`, `produit_prod_com`, `is_valide`) VALUES
(481, 15, 15, 15, 480, 37, b'1'),
(482, 10, 10, 10, 480, 53, b'1'),
(483, 10, 10, 10, 480, 38, b'1'),
(484, 5, 5, 5, 480, 39, b'1'),
(497, 10, 10, 10, 496, 37, b'1'),
(498, 1, 1, 1, 496, 53, b'1'),
(499, 3, 3, 3, 496, 38, b'1'),
(500, 1, 1, 1, 496, 39, b'1'),
(533, 10, 10, 10, 532, 37, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `produits_facture`
--

CREATE TABLE `produits_facture` (
  `id_porduits_facture` bigint(20) NOT NULL,
  `prix_totalpf` float NOT NULL,
  `quantitepf` float NOT NULL,
  `ristpf` float NOT NULL,
  `my_facture` bigint(20) NOT NULL,
  `produitpf` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produits_facture`
--

INSERT INTO `produits_facture` (`id_porduits_facture`, `prix_totalpf`, `quantitepf`, `ristpf`, `my_facture`, `produitpf`, `is_valide`) VALUES
(278, 103500, 15, 4500, 270, 37, b'1'),
(279, 34500, 5, 1500, 270, 36, b'1'),
(280, 68000, 10, 2000, 270, 38, b'1'),
(281, 20000, 5, 1500, 270, 39, b'1'),
(282, 5800, 2, 600, 270, 40, b'1'),
(283, 16800, 3, 600, 270, 43, b'1'),
(397, 207000, 30, 9000, 396, 37, b'1'),
(398, 69000, 10, 3000, 396, 36, b'1'),
(399, 68000, 10, 2000, 396, 38, b'1'),
(400, 40000, 10, 3000, 396, 39, b'1'),
(401, 2900, 1, 300, 396, 40, b'1'),
(402, 5600, 1, 200, 396, 43, b'1'),
(405, 69000, 10, 3000, 396, 53, b'1'),
(406, 6300, 3, 900, 396, 41, b'1'),
(407, 10800, 2, 400, 396, 42, b'1'),
(408, 27600, 2, 600, 396, 44, b'1'),
(409, 15600, 2, 600, 396, 46, b'1'),
(410, 10800, 1, 300, 396, 45, b'1'),
(487, 103500, 15, 103500, 486, 37, b'1'),
(493, 103500, 15, 103500, 492, 37, b'1'),
(494, 69000, 10, 69000, 492, 53, b'1'),
(495, 20000, 5, 20000, 492, 39, b'1'),
(507, 69000, 10, 69000, 506, 37, b'1'),
(508, 6900, 1, 6900, 506, 53, b'1'),
(509, 20400, 3, 20400, 506, 38, b'1'),
(510, 4000, 1, 4000, 506, 39, b'1'),
(536, 69000, 10, 3000, 535, 37, b'1'),
(563, 40000, 10, 3000, 562, 39, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `produits_livraison`
--

CREATE TABLE `produits_livraison` (
  `id_produits_livraison` bigint(20) NOT NULL,
  `pt` float NOT NULL,
  `quantite` float NOT NULL,
  `ristpl` float NOT NULL,
  `mylivraison` bigint(20) NOT NULL,
  `my_produit` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produits_livraison`
--

INSERT INTO `produits_livraison` (`id_produits_livraison`, `pt`, `quantite`, `ristpl`, `mylivraison`, `my_produit`, `is_valide`) VALUES
(102, 25500, 5, 1500, 97, 36, b'1'),
(103, 51000, 10, 3000, 97, 37, b'1'),
(104, 15300, 3, 750, 97, 38, b'1'),
(105, 7400, 2, 800, 97, 39, b'1'),
(118, 297000, 55, 16500, 108, 37, b'1'),
(119, 54000, 10, 3000, 108, 36, b'1'),
(120, 26000, 5, 1250, 108, 38, b'1'),
(121, 20500, 5, 2000, 108, 39, b'1'),
(122, 2600, 1, 300, 108, 40, b'1'),
(123, 54000, 10, 3000, 108, 53, b'1'),
(124, 21600, 4, 1000, 108, 43, b'1'),
(125, 26000, 5, 1250, 108, 42, b'1'),
(126, 13000, 5, 1250, 108, 41, b'1'),
(139, 594000, 110, 33000, 136, 37, b'1'),
(140, 297000, 55, 16500, 136, 36, b'1'),
(141, 156000, 30, 7500, 136, 38, b'1'),
(142, 82000, 20, 8000, 136, 39, b'1'),
(143, 13000, 5, 1500, 136, 40, b'1'),
(144, 162000, 30, 9000, 136, 53, b'1'),
(145, 54000, 10, 2500, 136, 43, b'1'),
(146, 26000, 5, 1250, 136, 42, b'1'),
(147, 13000, 5, 1250, 136, 41, b'1'),
(159, 324000, 60, 18000, 153, 37, b'1'),
(160, 54000, 10, 3000, 153, 53, b'1'),
(168, 540000, 100, 30000, 153, 37, b'1'),
(169, 540000, 100, 30000, 153, 37, b'1'),
(170, 540000, 100, 30000, 167, 37, b'1'),
(180, 297000, 55, 16500, 179, 53, b'1'),
(199, 82000, 20, 8000, 198, 39, b'1'),
(200, 13000, 5, 1500, 198, 40, b'1'),
(201, 81000, 15, 3750, 198, 43, b'1'),
(202, 26000, 5, 1250, 198, 42, b'1'),
(203, 13000, 5, 1250, 198, 41, b'1'),
(228, 26000, 10, 2500, 198, 41, b'1'),
(229, 26000, 10, 2500, 225, 41, b'1'),
(234, 82000, 20, 8000, 233, 39, b'1'),
(338, 594000, 110, 33000, 312, 37, b'1'),
(339, 216000, 40, 12000, 312, 36, b'1'),
(340, 104000, 20, 5000, 312, 38, b'1'),
(341, 216000, 40, 12000, 312, 53, b'1'),
(342, 123000, 30, 12000, 312, 39, b'1'),
(343, 13000, 5, 1500, 312, 40, b'1'),
(344, 27000, 5, 1250, 312, 43, b'1'),
(345, 13000, 5, 1250, 312, 41, b'1'),
(346, 26000, 5, 1250, 312, 42, b'1'),
(347, 127500, 25, 7500, 335, 49, b'1'),
(348, 18500, 5, 2000, 335, 50, b'1'),
(349, 7400, 2, 700, 335, 52, b'1'),
(350, 135000, 10, 5000, 337, 44, b'1'),
(351, 47500, 5, 2500, 337, 45, b'1'),
(352, 37500, 5, 2000, 337, 46, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `produit_mvt`
--

CREATE TABLE `produit_mvt` (
  `id_mag_prod_mvt` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `libelle` varchar(30) DEFAULT NULL,
  `nature` bit(1) NOT NULL,
  `quantite` float NOT NULL,
  `my_chargement` bigint(20) DEFAULT NULL,
  `my_facture` bigint(20) DEFAULT NULL,
  `my_livraison` bigint(20) DEFAULT NULL,
  `my_retour_chargment` bigint(20) DEFAULT NULL,
  `produit` bigint(20) NOT NULL,
  `magasinierprod` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL,
  `my_cass` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit_mvt`
--

INSERT INTO `produit_mvt` (`id_mag_prod_mvt`, `date`, `heure`, `libelle`, `nature`, `quantite`, `my_chargement`, `my_facture`, `my_livraison`, `my_retour_chargment`, `produit`, `magasinierprod`, `is_valide`, `my_cass`) VALUES
(204, '2020-03-29', '19:25:19', NULL, b'1', 20, NULL, NULL, 198, NULL, 39, NULL, b'1', NULL),
(205, '2020-03-29', '19:25:19', NULL, b'1', 5, NULL, NULL, 198, NULL, 40, NULL, b'1', NULL),
(206, '2020-03-29', '19:25:19', NULL, b'1', 15, NULL, NULL, 198, NULL, 43, NULL, b'1', NULL),
(207, '2020-03-29', '19:25:19', NULL, b'1', 5, NULL, NULL, 198, NULL, 42, NULL, b'1', NULL),
(208, '2020-03-29', '19:25:19', NULL, b'1', 5, NULL, NULL, 198, NULL, 41, NULL, b'1', NULL),
(284, '2020-03-31', '10:14:01', 'Sortie de facture ', b'0', 15, NULL, 270, NULL, NULL, 37, NULL, b'1', NULL),
(285, '2020-03-31', '10:14:01', 'Sortie de facture ', b'0', 5, NULL, 270, NULL, NULL, 36, NULL, b'1', NULL),
(286, '2020-03-31', '10:14:01', 'Sortie de facture ', b'0', 10, NULL, 270, NULL, NULL, 38, NULL, b'1', NULL),
(287, '2020-03-31', '10:14:01', 'Sortie de facture ', b'0', 5, NULL, 270, NULL, NULL, 39, NULL, b'1', NULL),
(288, '2020-03-31', '10:14:01', 'Sortie de facture ', b'0', 2, NULL, 270, NULL, NULL, 40, NULL, b'1', NULL),
(289, '2020-03-31', '10:14:01', 'Sortie de facture ', b'0', 3, NULL, 270, NULL, NULL, 43, NULL, b'1', NULL),
(353, '2020-04-15', '08:57:40', NULL, b'1', 110, NULL, NULL, 312, NULL, 37, 87, b'1', NULL),
(354, '2020-04-15', '08:57:40', NULL, b'1', 40, NULL, NULL, 312, NULL, 36, 87, b'1', NULL),
(355, '2020-04-15', '08:57:40', NULL, b'1', 20, NULL, NULL, 312, NULL, 38, 87, b'1', NULL),
(356, '2020-04-15', '08:57:40', NULL, b'1', 40, NULL, NULL, 312, NULL, 53, 87, b'1', NULL),
(357, '2020-04-15', '08:57:40', NULL, b'1', 30, NULL, NULL, 312, NULL, 39, 87, b'1', NULL),
(358, '2020-04-15', '08:57:40', NULL, b'1', 5, NULL, NULL, 312, NULL, 40, 87, b'1', NULL),
(359, '2020-04-15', '08:57:40', NULL, b'1', 5, NULL, NULL, 312, NULL, 43, 87, b'1', NULL),
(360, '2020-04-15', '08:57:40', NULL, b'1', 5, NULL, NULL, 312, NULL, 41, 87, b'1', NULL),
(361, '2020-04-15', '08:57:40', NULL, b'1', 5, NULL, NULL, 312, NULL, 42, 87, b'1', NULL),
(362, '2020-04-15', '08:57:40', NULL, b'1', 25, NULL, NULL, 335, NULL, 49, 87, b'1', NULL),
(363, '2020-04-15', '08:57:40', NULL, b'1', 5, NULL, NULL, 335, NULL, 50, 87, b'1', NULL),
(364, '2020-04-15', '08:57:40', NULL, b'1', 2, NULL, NULL, 335, NULL, 52, 87, b'1', NULL),
(365, '2020-04-15', '08:57:40', NULL, b'1', 10, NULL, NULL, 337, NULL, 44, 87, b'1', NULL),
(366, '2020-04-15', '08:57:40', NULL, b'1', 5, NULL, NULL, 337, NULL, 45, 87, b'1', NULL),
(367, '2020-04-15', '08:57:40', NULL, b'1', 5, NULL, NULL, 337, NULL, 46, 87, b'1', NULL),
(411, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 30, NULL, 396, NULL, NULL, 37, 87, b'1', NULL),
(412, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 10, NULL, 396, NULL, NULL, 36, 87, b'1', NULL),
(413, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 10, NULL, 396, NULL, NULL, 38, 87, b'1', NULL),
(414, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 10, NULL, 396, NULL, NULL, 39, 87, b'1', NULL),
(415, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 1, NULL, 396, NULL, NULL, 40, 87, b'1', NULL),
(416, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 1, NULL, 396, NULL, NULL, 43, 87, b'1', NULL),
(417, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 10, NULL, 396, NULL, NULL, 53, 87, b'1', NULL),
(418, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 3, NULL, 396, NULL, NULL, 41, 87, b'1', NULL),
(419, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 2, NULL, 396, NULL, NULL, 42, 87, b'1', NULL),
(420, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 2, NULL, 396, NULL, NULL, 44, 87, b'1', NULL),
(421, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 2, NULL, 396, NULL, NULL, 46, 87, b'1', NULL),
(422, '2020-04-17', '06:51:47', 'Sortie de facture ', b'0', 1, NULL, 396, NULL, NULL, 45, 87, b'1', NULL),
(437, '2020-04-21', '19:27:20', NULL, b'0', 30, 432, NULL, NULL, NULL, 37, 87, b'1', NULL),
(438, '2020-04-21', '19:27:20', NULL, b'0', 5, 432, NULL, NULL, NULL, 36, 87, b'1', NULL),
(439, '2020-04-21', '19:27:20', NULL, b'0', 5, 432, NULL, NULL, NULL, 38, 87, b'1', NULL),
(446, '2020-04-22', '03:51:04', 'RETOUR CHARGEMENT PRODUIT', b'1', 5.41667, 432, NULL, NULL, 433, 37, 87, b'1', NULL),
(447, '2020-04-22', '03:51:04', 'RETOUR CHARGEMENT PRODUIT', b'1', 2, 432, NULL, NULL, 433, 36, 87, b'1', NULL),
(448, '2020-04-22', '03:51:04', 'RETOUR CHARGEMENT PRODUIT', b'1', 1, 432, NULL, NULL, 433, 38, 87, b'1', NULL),
(501, '2020-04-26', '05:45:12', 'Sortie de facture ', b'0', 15, NULL, 492, NULL, NULL, 37, 87, b'1', NULL),
(502, '2020-04-26', '05:45:12', 'Sortie de facture ', b'0', 10, NULL, 492, NULL, NULL, 53, 87, b'1', NULL),
(503, '2020-04-26', '05:45:12', 'Sortie de facture ', b'0', 5, NULL, 492, NULL, NULL, 39, 87, b'1', NULL),
(511, '2020-04-26', '05:45:13', 'Sortie de facture ', b'0', 10, NULL, 506, NULL, NULL, 37, 87, b'1', NULL),
(512, '2020-04-26', '05:45:13', 'Sortie de facture ', b'0', 1, NULL, 506, NULL, NULL, 53, 87, b'1', NULL),
(513, '2020-04-26', '05:45:13', 'Sortie de facture ', b'0', 3, NULL, 506, NULL, NULL, 38, 87, b'1', NULL),
(514, '2020-04-26', '05:45:13', 'Sortie de facture ', b'0', 1, NULL, 506, NULL, NULL, 39, 87, b'1', NULL),
(537, '2020-04-26', '11:54:52', 'Sortie de facture ', b'0', 10, NULL, 535, NULL, NULL, 37, 87, b'1', NULL),
(541, '2020-04-26', '12:27:00', 'Sortie de facture ', b'0', 15, NULL, 486, NULL, NULL, 37, 87, b'1', NULL),
(564, '2020-04-26', '13:12:55', 'Sortie de facture ', b'0', 10, NULL, 562, NULL, NULL, 39, 87, b'1', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `retour_chargment`
--

CREATE TABLE `retour_chargment` (
  `id_retour` bigint(20) NOT NULL,
  `date_retour` date NOT NULL,
  `heure_retour` time NOT NULL,
  `total_casier_retour` float NOT NULL,
  `total_colis_retour` float NOT NULL,
  `total_emb_retour` float NOT NULL,
  `total_manquant_emb` float NOT NULL,
  `total_manquant_prod` float NOT NULL,
  `total_produitrc` float NOT NULL,
  `total_versement` float NOT NULL,
  `is_stocked_emb` bit(1) DEFAULT NULL,
  `is_stocked_prod` bit(1) DEFAULT NULL,
  `total_casier_prod` float NOT NULL,
  `magazinieremb` bigint(20) DEFAULT NULL,
  `magazinierpd` bigint(20) DEFAULT NULL,
  `my_chargement` bigint(20) NOT NULL,
  `secretaire` bigint(20) DEFAULT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `retour_chargment`
--

INSERT INTO `retour_chargment` (`id_retour`, `date_retour`, `heure_retour`, `total_casier_retour`, `total_colis_retour`, `total_emb_retour`, `total_manquant_emb`, `total_manquant_prod`, `total_produitrc`, `total_versement`, `is_stocked_emb`, `is_stocked_prod`, `total_casier_prod`, `magazinieremb`, `magazinierpd`, `my_chargement`, `secretaire`, `is_valide`) VALUES
(433, '2020-04-17', '03:43:55', 39.4167, 39.4167, 31, 0.583302, -22750, 55250, 230000, b'0', b'1', 8.4167, NULL, 87, 432, 87, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `retour_produits`
--

CREATE TABLE `retour_produits` (
  `idrp` bigint(20) NOT NULL,
  `date_retour` date DEFAULT NULL,
  `magaziner` bigint(20) DEFAULT NULL,
  `my_produit_facture` bigint(20) DEFAULT NULL,
  `my_produitsrc` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `role` varchar(30) NOT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`role`, `description`) VALUES
('ADMIN', 'The director or owner of repository'),
('SECRETAIRE', 'La secretaire'),
('CAISSIER(E)', 'The responsible of money'),
('MAGAZINIER(E)_PROD', 'responsible of products'),
('MAGAZINIER(E)_EMB', 'responsible of emballages');

-- --------------------------------------------------------

--
-- Structure de la table `total_ristourne_payement`
--

CREATE TABLE `total_ristourne_payement` (
  `id_total_ristourne` bigint(20) NOT NULL,
  `date_payement` date NOT NULL,
  `heure_payement` time NOT NULL,
  `montant_total` float NOT NULL,
  `periode` varchar(30) NOT NULL,
  `client` bigint(20) NOT NULL,
  `my_argent_mvt` bigint(20) NOT NULL,
  `is_valide` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `actived` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `my_personnel` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`username`, `actived`, `password`, `my_personnel`) VALUES
('blaise', b'1', '1234', 53),
('youmba', b'1', '852', 59),
('lise', b'1', '1234', 87);

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_username` varchar(30) NOT NULL,
  `roles_role` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users_roles`
--

INSERT INTO `users_roles` (`user_username`, `roles_role`) VALUES
('blaise', 'ADMIN'),
('lise', 'CAISSIER(E)'),
('lise', 'SECRETAIRE'),
('youmba', 'MAGAZINIER(E)_PROD'),
('youmba', 'MAGAZINIER(E)_EMB');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `achat_emballage`
--
ALTER TABLE `achat_emballage`
  ADD PRIMARY KEY (`id_achar_emballage`),
  ADD KEY `FKmlqbbn52bt8jlw54xh1bo93xa` (`my_interface_caisse`),
  ADD KEY `FKsyod8tmta3p11qsy6sw0rqepd` (`responsable`);

--
-- Index pour la table `argent_mvt`
--
ALTER TABLE `argent_mvt`
  ADD PRIMARY KEY (`id_argent_mvt`),
  ADD KEY `FK73nk8n19ovbghlvig6j4ctr5g` (`my_caisse_journaliere`),
  ADD KEY `FKgfg54dg402di9pehmrov5ai0i` (`my_depenses`),
  ADD KEY `FKshem5p7pqtwbcr4wb1tl9mw4i` (`my_gestion_facture`),
  ADD KEY `FKr3pmok13qbbvrij83414l9s4n` (`my_gestion_livraison`),
  ADD KEY `FKbn3wqk4jk6jr3ueug470k1rq2` (`my_gestion_retour_chargment`),
  ADD KEY `FKbb5xtv8js07k373ny0yb50bud` (`my_interface_caisse`),
  ADD KEY `FKkx7rd2bwfekwa001kw4eolpuh` (`my_total_ristourne_payement`),
  ADD KEY `FKgwhrtphltegx7tuf203s96ml4` (`responsable`),
  ADD KEY `FKj6r39wbki5lc59mskeax3b4rc` (`my_cass`);

--
-- Index pour la table `caisse`
--
ALTER TABLE `caisse`
  ADD PRIMARY KEY (`id_caisse`);

--
-- Index pour la table `caisse_journaliere`
--
ALTER TABLE `caisse_journaliere`
  ADD PRIMARY KEY (`id_caisse_journaliere`),
  ADD KEY `FKl9ocdcgfohj4wrrp9e7rbb80` (`decaissementcj`),
  ADD KEY `FKkc1lxwir51pqib10vxtss8sqe` (`my_interface_caisse`);

--
-- Index pour la table `cass`
--
ALTER TABLE `cass`
  ADD PRIMARY KEY (`id_gestion_facture`),
  ADD KEY `FK9oib1e47g9xbxf1ou2f3vbu8j` (`auteur_cass`),
  ADD KEY `FKsvdwhnlxo8hkql1smwevwh236` (`produit_cass`),
  ADD KEY `FK2418e5bu55pfhducthx5krib6` (`mag_emb`),
  ADD KEY `FKf81qqvxcg85n1wi530e4pctqs` (`mag_prod`),
  ADD KEY `FKptkod4awtcju54dajl9c83bvb` (`my_argent_mvt`),
  ADD KEY `FKs2gx0obke2i505p9lhpm8hg7p` (`my_emballage_mvt`),
  ADD KEY `FK6rpls20w81ct0ek2cqcbw4nae` (`my_produit_mvt`);

--
-- Index pour la table `chargement`
--
ALTER TABLE `chargement`
  ADD PRIMARY KEY (`id_chargement`),
  ADD KEY `FKdob6vbpqookr7136mw23uibhr` (`livreur_char`),
  ADD KEY `FKevxc4aso29n0r0ilf2rfnmfp6` (`magasinier_char`),
  ADD KEY `FKliedt4arsqpq52wnklus645y2` (`my_personnel`),
  ADD KEY `FKqnk3s01cp2dwxalvymuv60u2` (`my_retour_chargment`),
  ADD KEY `FKpy1ya0mlowjugsgd2wy27ganj` (`secretaire_char`);

--
-- Index pour la table `chargement_patrimoine`
--
ALTER TABLE `chargement_patrimoine`
  ADD PRIMARY KEY (`id_charg_pat`),
  ADD KEY `FKha4x6rjr5arx457yxhy5u0920` (`my_chargement`),
  ADD KEY `FK86nj6urep8tf2n9789dndcwhn` (`my_patrimoine`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `collaborateur_ext`
--
ALTER TABLE `collaborateur_ext`
  ADD PRIMARY KEY (`id_collaborateur_ext`),
  ADD KEY `FK7q74v7bxmiehjcq236q7oris0` (`my_fournisseur`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `FK7v0sxk2lybkyh5qux29dw2fhx` (`my_client`);

--
-- Index pour la table `commande_facture`
--
ALTER TABLE `commande_facture`
  ADD PRIMARY KEY (`id_com_fact`),
  ADD KEY `FKh7x3bv8dsf6abigfkerk4xti2` (`my_commande`),
  ADD KEY `FKpetsw9caudva4h76ly3pmc56f` (`my_facture`);

--
-- Index pour la table `cumul_rist_clients`
--
ALTER TABLE `cumul_rist_clients`
  ADD PRIMARY KEY (`idcrc`),
  ADD KEY `FKpppqoxqdgp8alp60denjdjkhq` (`client`),
  ADD KEY `FKb691bffgq404duco8oa2pk6mn` (`facture`),
  ADD KEY `FKb89ln9gejp2333frbjilok4di` (`my_factures_chargement`);

--
-- Index pour la table `depenses`
--
ALTER TABLE `depenses`
  ADD PRIMARY KEY (`id_depense`),
  ADD KEY `FKfulv5xo94mli7i2ytddm43ddn` (`my_argent_mvt`),
  ADD KEY `FKdy4h04st0blnad5spxonnva8x` (`responsable`),
  ADD KEY `FKjsmx2jy58e4bu7ocoxtqk6qic` (`secretaire`);

--
-- Index pour la table `detailsfc`
--
ALTER TABLE `detailsfc`
  ADD PRIMARY KEY (`id_detailsfc`),
  ADD KEY `FKif8tnesawamcfdboftk0cfb5w` (`my_factures_chargement`);

--
-- Index pour la table `details_facture`
--
ALTER TABLE `details_facture`
  ADD PRIMARY KEY (`id_details_facture`),
  ADD KEY `FKukquolq1sehxwpdtt1axit63` (`my_facture`);

--
-- Index pour la table `details_livraison`
--
ALTER TABLE `details_livraison`
  ADD PRIMARY KEY (`id_details_livraison`),
  ADD KEY `FKlgg8048960jqcr8g473vh72qr` (`mylivraison`);

--
-- Index pour la table `emballages_mvt`
--
ALTER TABLE `emballages_mvt`
  ADD PRIMARY KEY (`id_emb`),
  ADD KEY `FKo6bssar1f2k5i2spf1hovjym6` (`fournisseur_emb`),
  ADD KEY `FKk72he1fbw7mia7rrd94s37h9n` (`magasinieremb`),
  ADD KEY `FK7ejlb5kwaiertry115is2t304` (`my_achat_emballage`),
  ADD KEY `FKspv5ikt2ovgpy554omvh4v4s7` (`my_gestion_facture`),
  ADD KEY `FKftpmj10r3anilsg7yiyegapkx` (`my_gestion_livraison`),
  ADD KEY `FKp13wons36rqy94rhs8pvbxeji` (`my_gestion_retour_chargment`),
  ADD KEY `FKhbey7p0et4vca77w31od1durg` (`my_cass`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id_facture`),
  ADD KEY `FKn8j0l6u5blg7tuao1x52as0i9` (`client`),
  ADD KEY `FKs5xxh3gvdvi2jnxi700anm0ih` (`livreur`),
  ADD KEY `FK9lo393axb14jy76am7m7ef7s3` (`magasinier_fact`),
  ADD KEY `FKf3hy9hnplgxb2udlr3m1e4e9s` (`my_details_facture`),
  ADD KEY `FK8sr4lto4kh8kf1ft3bo6k46m5` (`secrectaire_fact`);

--
-- Index pour la table `factures_chargement`
--
ALTER TABLE `factures_chargement`
  ADD PRIMARY KEY (`id_fact_charg`),
  ADD KEY `FKctwcdfsbinialmbwn00x8n4ig` (`my_chargement`),
  ADD KEY `FKg8ritjsb5her9uav3cr9doayu` (`my_client`),
  ADD KEY `FKtoiueotjqfy7pudpp40227uq0` (`my_detailsfc`);

--
-- Index pour la table `facture_patrimoine`
--
ALTER TABLE `facture_patrimoine`
  ADD PRIMARY KEY (`id_fact_pat`),
  ADD KEY `FKjkl9w0hqs9y8wdawycoxh0u6q` (`my_facture`),
  ADD KEY `FKgjb4utfbjy9shp96iscmst68f` (`my_patrimoine`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id_fournisseur`);

--
-- Index pour la table `gestionfc`
--
ALTER TABLE `gestionfc`
  ADD PRIMARY KEY (`id_gestionfc`),
  ADD KEY `FK55mhm33f8pjcylj1hbqdljyo6` (`my_factures_chargement`);

--
-- Index pour la table `gestion_caisse`
--
ALTER TABLE `gestion_caisse`
  ADD PRIMARY KEY (`id_gestion_caisse`),
  ADD KEY `FKh4le5uusmc60vyxe9dwt4tj34` (`my_interface_caisse`);

--
-- Index pour la table `gestion_facture`
--
ALTER TABLE `gestion_facture`
  ADD PRIMARY KEY (`id_gestion_facture`),
  ADD KEY `FK8tawo9kltm5xb1vphxm9axnv5` (`my_argent_mvt`),
  ADD KEY `FK4rmdgp47mp6lw9xx36liedk54` (`my_facture`),
  ADD KEY `FK2qnbov91v9t6mb8vl5k56ug51` (`personnel_intgf`);

--
-- Index pour la table `gestion_livraison`
--
ALTER TABLE `gestion_livraison`
  ADD PRIMARY KEY (`id_gestion_livraison`),
  ADD KEY `FK66vlkuv125fenh47pnvk267tq` (`my_argent_mvt`),
  ADD KEY `FKc2lpnf9y98qv2yukj9ffnmii3` (`my_emballages_mvt`),
  ADD KEY `FK1e4kuegut7kvvld7elarv3t26` (`my_livraison`),
  ADD KEY `FKt660kohdppnto97hoxy601jvu` (`my_personnel_int`),
  ADD KEY `FKf8l6amu4cdmld4d3w59uheffh` (`my_personnel_ext`);

--
-- Index pour la table `gestion_retour_chargment`
--
ALTER TABLE `gestion_retour_chargment`
  ADD PRIMARY KEY (`idgrc`),
  ADD KEY `FKpo1e18kdge3jdymc74g7c7ds6` (`my_retour_chargment`),
  ADD KEY `FKq68tyhnv4crmaakc2bc2kqcmc` (`personnel_int`);

--
-- Index pour la table `interface_caisse`
--
ALTER TABLE `interface_caisse`
  ADD PRIMARY KEY (`id_int_caisse`),
  ADD KEY `FKew9kciiytqh1babidjqqp350k` (`responsable`),
  ADD KEY `FKctgade943bqdsg59ru063exnd` (`my_achat_emballage`),
  ADD KEY `FKdq4470qkvaor9r3nts0o674u1` (`my_argent_mvt_pour_decaisser`),
  ADD KEY `FKiaujtk8vvab2nrfpwtsxgxvlm` (`my_caisse_journaliere`),
  ADD KEY `FKre10vf0u86u1p757sbqp27uvw` (`my_gestion_caisse`);

--
-- Index pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD PRIMARY KEY (`id_livraison`),
  ADD KEY `FK6apbqxsop1jqd2by9fm976p55` (`my_collaborateur_ext`),
  ADD KEY `FKr0v56q5hjq1mnwuq8bhji7i0n` (`my_details_livraison`),
  ADD KEY `FKala5ova3wgo9w9taljt0ppv12` (`my_personnel`);

--
-- Index pour la table `mag_emballage`
--
ALTER TABLE `mag_emballage`
  ADD PRIMARY KEY (`id_mag_emb`),
  ADD KEY `FKqowo8ukqn80nb46hbjr1v6s9` (`fournisseur`);

--
-- Index pour la table `manquantsrc`
--
ALTER TABLE `manquantsrc`
  ADD PRIMARY KEY (`id_manquantsrc`),
  ADD KEY `FKccrt04qh10wwx5ixfiu15yvnw` (`my_retour_chargment`),
  ADD KEY `FKi1nlxpti465pqw0tm3n6sp8ul` (`produitmrc`);

--
-- Index pour la table `patrimoine`
--
ALTER TABLE `patrimoine`
  ADD PRIMARY KEY (`id_patrimoine`);

--
-- Index pour la table `patrimoine_facture`
--
ALTER TABLE `patrimoine_facture`
  ADD PRIMARY KEY (`id_patrimoine_facture`),
  ADD KEY `FK8u883qvjsi5l4rb2gmll1969h` (`facture`),
  ADD KEY `FKk0vk9mm5e9pnnmm652j82di0k` (`patrimoine`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id_personnel`),
  ADD KEY `FKng3f74l302rie1eiy1pipxpvk` (`my_user`);

--
-- Index pour la table `prix_produits`
--
ALTER TABLE `prix_produits`
  ADD PRIMARY KEY (`id_prix`),
  ADD KEY `FKfueed31mb8xto58jaw6qdy9q2` (`my_client`),
  ADD KEY `FK7ie3rohfn4a1qh46f9r2wfqxt` (`produit`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `FK8j5dekuogh60yqi1g4fb4ae53` (`my_fournisseur`);

--
-- Index pour la table `produitsfc`
--
ALTER TABLE `produitsfc`
  ADD PRIMARY KEY (`id_produitfc`),
  ADD KEY `FKh7lqtw05vta8i86nke368lxmo` (`my_factures_chargement`),
  ADD KEY `FKltga3ig1yu4dsbfxm240m6efn` (`produitfc`);

--
-- Index pour la table `produitsrc`
--
ALTER TABLE `produitsrc`
  ADD PRIMARY KEY (`id_produitsrc`),
  ADD KEY `FKqv8ynde32ed3odmogl39fofya` (`my_retour_chargment`),
  ADD KEY `FK5fnynpts5d8kig8yq55cx5nft` (`produitrc`);

--
-- Index pour la table `produits_chargment`
--
ALTER TABLE `produits_chargment`
  ADD PRIMARY KEY (`id_produits_chargment`),
  ADD KEY `FKfh620d17aaigr4earsnrl09rv` (`my_chargement`),
  ADD KEY `FKhbud69cgt5qgrs3ys296tm3di` (`produitpc`);

--
-- Index pour la table `produits_commande`
--
ALTER TABLE `produits_commande`
  ADD PRIMARY KEY (`id_prod_com`),
  ADD KEY `FKmegu5gjd5ay9ruu6i4apcrjvu` (`my_commande`),
  ADD KEY `FKn5d5ts1nukfm40p4nrca3m5y3` (`produit_prod_com`);

--
-- Index pour la table `produits_facture`
--
ALTER TABLE `produits_facture`
  ADD PRIMARY KEY (`id_porduits_facture`),
  ADD KEY `FKelnvgnuckxab9126pc8wbe96m` (`my_facture`),
  ADD KEY `FK4epnv6o8ffbebvepc4ub6wl1` (`produitpf`);

--
-- Index pour la table `produits_livraison`
--
ALTER TABLE `produits_livraison`
  ADD PRIMARY KEY (`id_produits_livraison`),
  ADD KEY `FK676nrns89gjv59qa1qvmd8u1m` (`my_produit`),
  ADD KEY `FKrv878n3rylx3dyup3lxcgfjlb` (`mylivraison`);

--
-- Index pour la table `produit_mvt`
--
ALTER TABLE `produit_mvt`
  ADD PRIMARY KEY (`id_mag_prod_mvt`),
  ADD KEY `FKnpb10url0ol923k3sqyfbokdg` (`magasinierprod`),
  ADD KEY `FKdu46g7bse34tem7r782qar2st` (`my_chargement`),
  ADD KEY `FKq1q33q22hbej0xbkhqflxwcty` (`my_facture`),
  ADD KEY `FK1jtdb7n92jwl04yvaqac8gcom` (`my_livraison`),
  ADD KEY `FKl6skuw6q0p9jqsbhd93deg8q6` (`my_retour_chargment`),
  ADD KEY `FKq4ragn3jnkxhkhbnkr9y24yrn` (`produit`),
  ADD KEY `FK639hlesgnhe1hmksmd5pm2rj7` (`my_cass`);

--
-- Index pour la table `retour_chargment`
--
ALTER TABLE `retour_chargment`
  ADD PRIMARY KEY (`id_retour`),
  ADD KEY `FK71gfhhix7ne891ckcmghs6cs4` (`magazinieremb`),
  ADD KEY `FK9sfm0klvm0n5b226i814k3yhj` (`magazinierpd`),
  ADD KEY `FKlkpv7dqxpnptm1fudy8ckqbe` (`my_chargement`),
  ADD KEY `FK53hie1nneauedmvf91kevi10e` (`secretaire`);

--
-- Index pour la table `retour_produits`
--
ALTER TABLE `retour_produits`
  ADD PRIMARY KEY (`idrp`),
  ADD KEY `FKpq6gfhveubtuplq9pmv7ni8u2` (`magaziner`),
  ADD KEY `FKsbaxhl1kbavr1rr0e3ygiojbp` (`my_produit_facture`),
  ADD KEY `FK21wuvixf8b7xqwlvuaf72f8cg` (`my_produitsrc`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role`);

--
-- Index pour la table `total_ristourne_payement`
--
ALTER TABLE `total_ristourne_payement`
  ADD PRIMARY KEY (`id_total_ristourne`),
  ADD KEY `FK7wu73kxb4g1kdqc18rif7x5x3` (`client`),
  ADD KEY `FK7jwba6to4y31ww1xuf4xveqwf` (`my_argent_mvt`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD KEY `FKrrw4xmou4jh00uvxwhe1xb4ss` (`my_personnel`);

--
-- Index pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FK9bxfby7rpenikksf47nelxdbt` (`roles_role`),
  ADD KEY `FK1y8kc6nr793297gijoc5t5qmx` (`user_username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
