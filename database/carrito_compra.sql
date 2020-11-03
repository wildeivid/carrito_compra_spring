-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 03-11-2020 a las 11:53:37
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carrito_compra`
--
CREATE DATABASE IF NOT EXISTS `carrito_compra` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `carrito_compra`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carts`
--

DROP TABLE IF EXISTS `carts`;
CREATE TABLE IF NOT EXISTS `carts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjykljcwleunj1rmbji204j34` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `carts`
--

INSERT INTO `carts` (`id`, `status`, `usuario_id`) VALUES(4, 'COMPLETED', 1);
INSERT INTO `carts` (`id`, `status`, `usuario_id`) VALUES(5, 'COMPLETED', 1);
INSERT INTO `carts` (`id`, `status`, `usuario_id`) VALUES(6, 'COMPLETED', 1);
INSERT INTO `carts` (`id`, `status`, `usuario_id`) VALUES(7, 'COMPLETED', 1);
INSERT INTO `carts` (`id`, `status`, `usuario_id`) VALUES(8, 'COMPLETED', 1);
INSERT INTO `carts` (`id`, `status`, `usuario_id`) VALUES(9, 'PENDING', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carts_lista_producto_carrito`
--

DROP TABLE IF EXISTS `carts_lista_producto_carrito`;
CREATE TABLE IF NOT EXISTS `carts_lista_producto_carrito` (
  `carrito_id` bigint(20) NOT NULL,
  `lista_producto_carrito_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_77ibp89hmeb9bt20lj8rgysqr` (`lista_producto_carrito_id`),
  KEY `FK1sq18gwxbq36q9j0usjbum5xi` (`carrito_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `sku` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(1, 'Televisor', 'TV Samsung 24\"', '700999.99');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(2, 'Bicicleta eléctrica de alta revolución', 'BIKE ELECTRIC PLUS', '1999999.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(3, 'Monitor de Plasma HDMI, VGA y DVI con sonido envolvente', 'Monitor Plasma Lenovo 26\"', '650599.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(4, 'Notebook ASUS', 'Notebook ASUS', '3500999.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(5, 'Auriculares Inalámbricos', 'Auriculares Inalámbricos JBL', '85000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(6, 'Parlantes JBL', 'Parlantes JBL', '120000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(7, 'Case HDD Portatil', 'Case HDD Portatil', '20000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(8, 'Escritorio Oficina de Vidrio 15mm. 1.20x1.75', 'Office Desktop Glass', '380000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(9, 'Impresora HP Tinta Contínua', 'Impresora HP Tinta Contínua', '455000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(10, 'Impresora Samsung Láser', 'Impresora Samsung Láser', '799999.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_cars`
--

DROP TABLE IF EXISTS `product_cars`;
CREATE TABLE IF NOT EXISTS `product_cars` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `carrito_id` bigint(20) DEFAULT NULL,
  `producto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgp88jltqi5upkgcwqw2d3b0ms` (`carrito_id`),
  KEY `FKnwpl0aaghs2xanht254la1wd4` (`producto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `product_cars`
--

INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(8, 2, 4, 9);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(9, 3, 4, 1);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(10, 1, 4, 4);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(11, 1, 4, 2);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(12, 2, 5, 1);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(14, 2, 5, 3);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(16, 2, 5, 2);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(17, 1, 5, 5);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(18, 1, 6, 1);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(22, 3, 7, 2);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(23, 3, 7, 1);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(25, 2, 8, 1);
INSERT INTO `product_cars` (`id`, `quantity`, `carrito_id`, `producto_id`) VALUES(26, 3, 8, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pimirdqbf828ejsgnxmc3kfix` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellido`, `email`, `fecha_nacimiento`, `nombre`, `user_name`) VALUES(1, 'CORDERO', 'wildeivid7@gmail.com', '1990-07-02', 'WILSON', 'wildeivid');
INSERT INTO `usuario` (`id`, `apellido`, `email`, `fecha_nacimiento`, `nombre`, `user_name`) VALUES(4, 'Chacón Bravo', 'danielavirginia7@gmail.com', '2020-11-01', 'Daniela Virginia', 'danilinda');
INSERT INTO `usuario` (`id`, `apellido`, `email`, `fecha_nacimiento`, `nombre`, `user_name`) VALUES(5, 'Mercado Pérez ', 'namerpe@gmail.com', '2020-03-05', 'Nallive Luz', 'namerpe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_lista_carritos`
--

DROP TABLE IF EXISTS `usuario_lista_carritos`;
CREATE TABLE IF NOT EXISTS `usuario_lista_carritos` (
  `usuario_id` bigint(20) NOT NULL,
  `lista_carritos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_lwpe7hlti8r0vsyuooucce96d` (`lista_carritos_id`),
  KEY `FKon0tls0nxukk807l9t0ltk5xy` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `FKhjykljcwleunj1rmbji204j34` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `carts_lista_producto_carrito`
--
ALTER TABLE `carts_lista_producto_carrito`
  ADD CONSTRAINT `FK1sq18gwxbq36q9j0usjbum5xi` FOREIGN KEY (`carrito_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKr9q5v9sqk1c20ukhu7x721776` FOREIGN KEY (`lista_producto_carrito_id`) REFERENCES `product_cars` (`id`);

--
-- Filtros para la tabla `product_cars`
--
ALTER TABLE `product_cars`
  ADD CONSTRAINT `FKgp88jltqi5upkgcwqw2d3b0ms` FOREIGN KEY (`carrito_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKnwpl0aaghs2xanht254la1wd4` FOREIGN KEY (`producto_id`) REFERENCES `products` (`id`);

--
-- Filtros para la tabla `usuario_lista_carritos`
--
ALTER TABLE `usuario_lista_carritos`
  ADD CONSTRAINT `FKnnptxfs2x8535esdlq1kwr43w` FOREIGN KEY (`lista_carritos_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKon0tls0nxukk807l9t0ltk5xy` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
