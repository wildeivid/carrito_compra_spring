SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `carrito_compra` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `carrito_compra`;

CREATE TABLE IF NOT EXISTS `carts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjykljcwleunj1rmbji204j34` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `carts_lista_producto_carrito` (
  `carrito_id` bigint(20) NOT NULL,
  `lista_producto_carrito_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_77ibp89hmeb9bt20lj8rgysqr` (`lista_producto_carrito_id`),
  KEY `FK1sq18gwxbq36q9j0usjbum5xi` (`carrito_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `sku` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(1, 'Televisor', 'TV Samsung 24\"', '700999.99');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(2, 'Bicicleta eléctrica de alta revolución', 'BIKE ELECTRIC PLUS', '1999999.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(3, 'Monitor de Plasma HDMI, VGA y DVI', 'Monitor Plasma Lenovo 26\"', '650599.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(4, 'Notebook ASUS', 'Notebook ASUS', '3500999.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(5, 'Auriculares Inalámbricos', 'Auriculares Inalámbricos JBL', '85000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(6, 'Parlantes JBL', 'Parlantes JBL', '120000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(7, 'Case HDD Portatil', 'Case HDD Portatil', '20000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(8, 'Escritorio Oficina de Vidrio 15mm. 1.20x1.75', 'Office Desktop Glass', '380000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(9, 'Impresora HP Tinta Contínua', 'Impresora HP Tinta Contínua', '455000.00');
INSERT INTO `products` (`id`, `descripcion`, `nombre`, `sku`) VALUES(10, 'Impresora Samsung Láser', 'Impresora Samsung Láser', '799999.00');

CREATE TABLE IF NOT EXISTS `product_cars` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `carrito_id` bigint(20) DEFAULT NULL,
  `producto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgp88jltqi5upkgcwqw2d3b0ms` (`carrito_id`),
  KEY `FKnwpl0aaghs2xanht254la1wd4` (`producto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pimirdqbf828ejsgnxmc3kfix` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `usuario` (`id`, `apellido`, `email`, `fecha_nacimiento`, `nombre`, `user_name`) VALUES(1, 'CORDERO', 'wildeivid7@gmail.com', '1990-07-02', 'WILSON', 'wildeivid');
INSERT INTO `usuario` (`id`, `apellido`, `email`, `fecha_nacimiento`, `nombre`, `user_name`) VALUES(2, 'CHACÓN', 'danielavirginia7@gmail.com', '1993-06-29', 'DANIELA', 'UDANI');

CREATE TABLE IF NOT EXISTS `usuario_lista_carritos` (
  `usuario_id` bigint(20) NOT NULL,
  `lista_carritos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_lwpe7hlti8r0vsyuooucce96d` (`lista_carritos_id`),
  KEY `FKon0tls0nxukk807l9t0ltk5xy` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `carts`
  ADD CONSTRAINT `FKhjykljcwleunj1rmbji204j34` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

ALTER TABLE `carts_lista_producto_carrito`
  ADD CONSTRAINT `FK1sq18gwxbq36q9j0usjbum5xi` FOREIGN KEY (`carrito_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKr9q5v9sqk1c20ukhu7x721776` FOREIGN KEY (`lista_producto_carrito_id`) REFERENCES `product_cars` (`id`);

ALTER TABLE `product_cars`
  ADD CONSTRAINT `FKgp88jltqi5upkgcwqw2d3b0ms` FOREIGN KEY (`carrito_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKnwpl0aaghs2xanht254la1wd4` FOREIGN KEY (`producto_id`) REFERENCES `products` (`id`);

ALTER TABLE `usuario_lista_carritos`
  ADD CONSTRAINT `FKnnptxfs2x8535esdlq1kwr43w` FOREIGN KEY (`lista_carritos_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKon0tls0nxukk807l9t0ltk5xy` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
