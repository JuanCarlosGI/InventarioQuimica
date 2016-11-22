-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2016 at 06:20 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventarioquimica`
--

-- --------------------------------------------------------

--
-- Table structure for table `consumible`
--

CREATE TABLE `consumible` (
  `clave` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `presentacion` varchar(100) NOT NULL,
  `contenido` varchar(100) NOT NULL,
  `localizacion` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consumible`
--

INSERT INTO `consumible` (`clave`, `nombre`, `marca`, `presentacion`, `contenido`, `localizacion`, `descripcion`, `cantidad`) VALUES
('c1', 'consumible1', 'marca1', 'p', 'ocho', 'si', 'descr', 98),
('c2', 'consumible1', 'marca2', 'p', 'ocho', 'no', 'descr2', 100);

-- --------------------------------------------------------

--
-- Table structure for table `detalleconsumible`
--

CREATE TABLE `detalleconsumible` (
  `cantidad` int(11) NOT NULL,
  `observaciones` varchar(1000) NOT NULL,
  `pedidoId` int(11) NOT NULL,
  `consumibleId` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detalleconsumible`
--

INSERT INTO `detalleconsumible` (`cantidad`, `observaciones`, `pedidoId`, `consumibleId`) VALUES
(1, 'JAALA', 16, 'c1'),
(1, 'Obs', 20, 'c1');

-- --------------------------------------------------------

--
-- Table structure for table `detalleequipo`
--

CREATE TABLE `detalleequipo` (
  `cantidad` int(11) NOT NULL,
  `observaciones` varchar(1000) NOT NULL,
  `cantidadRegresada` int(11) NOT NULL,
  `pedidoId` int(11) NOT NULL,
  `equipoId` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detalleequipo`
--

INSERT INTO `detalleequipo` (`cantidad`, `observaciones`, `cantidadRegresada`, `pedidoId`, `equipoId`) VALUES
(1, 'SIPLIS', 0, 15, 'e1'),
(3, 'Si', 0, 20, 'e1');

-- --------------------------------------------------------

--
-- Table structure for table `detallematerial`
--

CREATE TABLE `detallematerial` (
  `cantidad` int(11) NOT NULL,
  `observaciones` varchar(1000) NOT NULL,
  `cantidadRegresada` int(11) NOT NULL,
  `pedidoId` int(11) NOT NULL,
  `materialId` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detallematerial`
--

INSERT INTO `detallematerial` (`cantidad`, `observaciones`, `cantidadRegresada`, `pedidoId`, `materialId`) VALUES
(1, '1', 0, 8, 'mat1'),
(1, 'COMENTARIOS', 0, 9, 'mat1'),
(1, 'COMENTARIOS', 0, 10, 'mat1'),
(4, 'Yo', 0, 10, 'mat2'),
(1, 'COMENTARIOS', 0, 11, 'mat1'),
(4, 'Yo', 0, 11, 'mat2'),
(3, 'Mis observaciones', 0, 20, 'mat1'),
(5, 'bla', 0, 20, 'mat2'),
(1, 'Test', 0, 21, 'mat1'),
(8, 'SP', 0, 22, 'mat1');

-- --------------------------------------------------------

--
-- Table structure for table `detallereactivo`
--

CREATE TABLE `detallereactivo` (
  `cantidad` int(11) NOT NULL,
  `observaciones` varchar(1000) NOT NULL,
  `pedidoId` int(11) NOT NULL,
  `reactivoId` varchar(100) NOT NULL,
  `cantidadRegresada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detallereactivo`
--

INSERT INTO `detallereactivo` (`cantidad`, `observaciones`, `pedidoId`, `reactivoId`, `cantidadRegresada`) VALUES
(1, 'TAMBIEN JALA', 18, 'r1', 0),
(1, 'Tambie jala', 19, 'r1', 0),
(1, 'ob', 20, 'r1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `equipo`
--

CREATE TABLE `equipo` (
  `clave` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `localizacion` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipo`
--

INSERT INTO `equipo` (`clave`, `nombre`, `marca`, `cantidad`, `localizacion`, `descripcion`) VALUES
('e1', 'equi1', 'hola', 95, 'hola', 'ahol'),
('e2', 'equi2', 'hola', 100, 'hola', 'hola');

-- --------------------------------------------------------

--
-- Table structure for table `laboratorio`
--

CREATE TABLE `laboratorio` (
  `clave` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `laboratorio`
--

INSERT INTO `laboratorio` (`clave`, `nombre`) VALUES
('lab', 'Laboratorio'),
('lab2', 'Laboratorio 2'),
('lab3', 'Mi nuevo laboratorio'),
('labQui', 'Quimica');

-- --------------------------------------------------------

--
-- Table structure for table `maestrolaboratorio`
--

CREATE TABLE `maestrolaboratorio` (
  `maestroId` varchar(10) NOT NULL,
  `laboratorioId` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maestrolaboratorio`
--

INSERT INTO `maestrolaboratorio` (`maestroId`, `laboratorioId`) VALUES
('Profesor', 'lab'),
('Profesor', 'labQui');

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `clave` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `capacidad` varchar(100) NOT NULL,
  `localizacion` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `material`
--

INSERT INTO `material` (`clave`, `nombre`, `marca`, `capacidad`, `localizacion`, `cantidad`, `descripcion`) VALUES
('mat1', 'Material1', 'hola', 'hola', 'hola', 81, 'hola'),
('mat2', 'Material2', 'hla', 'hla', 'hla', 87, 'hla');

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `fechaEmision` date NOT NULL,
  `profesorId` varchar(100) NOT NULL,
  `usuarioId` varchar(10) NOT NULL,
  `laboratorioId` varchar(100) NOT NULL,
  `fechaEntrega` date NOT NULL,
  `fechaDevolucion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`id`, `status`, `fechaEmision`, `profesorId`, `usuarioId`, `laboratorioId`, `fechaEntrega`, `fechaDevolucion`) VALUES
(1, 2, '2016-11-20', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(2, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(3, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(4, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(5, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(6, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(7, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(8, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(9, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(10, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(11, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(12, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(13, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(14, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(15, 0, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(16, 0, '2016-11-21', 'Profesor', 'Profesor', 'null', '2016-11-21', '2016-11-21'),
(17, 0, '2016-11-21', 'Profesor', 'Profesor', 'null', '2016-11-21', '2016-11-21'),
(18, 0, '2016-11-21', 'Profesor', 'Profesor', 'null', '2016-11-21', '2016-11-21'),
(19, 0, '2016-11-21', 'Profesor', 'Profesor', 'null', '2016-11-21', '2016-11-21'),
(20, 0, '2016-11-21', 'Profesor', 'Profesor', 'null', '2016-11-21', '2016-11-21'),
(21, 2, '2016-11-21', 'Profesor', 'Alumno', 'lab', '2016-11-21', '2016-11-21'),
(22, 2, '2016-11-21', 'admin', 'admin', 'null', '2016-11-21', '2016-11-21');

-- --------------------------------------------------------

--
-- Table structure for table `reactivo`
--

CREATE TABLE `reactivo` (
  `clave` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `presentacion` varchar(100) NOT NULL,
  `contenido` varchar(100) NOT NULL,
  `localizacion` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reactivo`
--

INSERT INTO `reactivo` (`clave`, `nombre`, `marca`, `presentacion`, `contenido`, `localizacion`, `descripcion`, `cantidad`) VALUES
('r1', 'react', 'marc', 'per', 'con', 'loc', 'des', 96);

-- --------------------------------------------------------

--
-- Table structure for table `registrolaboratorio`
--

CREATE TABLE `registrolaboratorio` (
  `maestroId` varchar(10) NOT NULL,
  `alumnoId` varchar(10) NOT NULL,
  `laboratorioId` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registrolaboratorio`
--

INSERT INTO `registrolaboratorio` (`maestroId`, `alumnoId`, `laboratorioId`) VALUES
('Profesor', 'Alumno', 'lab'),
('Profesor', 'alumno1', 'lab');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `matricula` varchar(10) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rol` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `creadorId` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`matricula`, `password`, `rol`, `nombre`, `creadorId`, `correo`) VALUES
('admin', 'admin', 'Administrador', 'Mi admin', 'A01196064', 'cesar@gmail.com'),
('Alumno', 'Alumno', 'Alumno', 'Juan Carlos G', 'Profesor', 'micorreo@gmail.com'),
('alumno1', 'alumno1', 'Alumno', 'alumno', '', ''),
('Profesor', 'Profesor', 'Profesor', 'Mi profesor', 'admin', 'armando@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consumible`
--
ALTER TABLE `consumible`
  ADD PRIMARY KEY (`clave`);

--
-- Indexes for table `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`clave`);

--
-- Indexes for table `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`clave`);

--
-- Indexes for table `maestrolaboratorio`
--
ALTER TABLE `maestrolaboratorio`
  ADD PRIMARY KEY (`maestroId`,`laboratorioId`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`clave`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reactivo`
--
ALTER TABLE `reactivo`
  ADD PRIMARY KEY (`clave`);

--
-- Indexes for table `registrolaboratorio`
--
ALTER TABLE `registrolaboratorio`
  ADD PRIMARY KEY (`maestroId`,`alumnoId`,`laboratorioId`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`matricula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
