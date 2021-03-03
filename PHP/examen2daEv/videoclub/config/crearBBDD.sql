SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

drop database if exists videoclub;
create database videoclub;
use videoclub;

CREATE TABLE `clientes` (
  `dni` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `calle` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `numero` int(11) NOT NULL,
  `cp` int(11) NOT NULL,
  `provincia` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

ALTER TABLE `clientes`
  ADD PRIMARY KEY (`dni`);
COMMIT;


INSERT INTO `clientes` (`dni`, `nombre`, `apellidos`, `edad`, `calle`, `numero`, `cp`, `provincia`) VALUES
('01612901A', 'Julio', 'Garcí­a Santos', 23, 'C/ Los Olivos', 3, 38493, 'Santa Cruz de Tenerife'),
('02374624N', 'Julio', 'Brito Santos', 30, 'C/ Los Pinos', 25, 38403, 'Las Palmas'),
('11498125B', 'MarÃ­a', 'Méndez Camacho', 45, 'C/ Los Franceses', 23, 38505, 'Las Palmas'),
('19541465K', 'Ana', 'Méndez Núñez', 22, 'C/ Los Pinos', 25, 38403, 'Santa Cruz de Tenerife'),
('82230227Y', 'Alanis Carolina', 'Simoes Villalonga', 21, 'C/ Obispo Bení­tez', 26, 38300, 'Santa Cruz de Tenerife');
