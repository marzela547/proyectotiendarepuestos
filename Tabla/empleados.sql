CREATE TABLE `empleados` (
  `Empcodigo` int NOT NULL AUTO_INCREMENT,
  `Empidentidad` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Empnombre` varchar(45) NOT NULL,
  `Emptelefono` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Empfechanacimiento` date NOT NULL,
  `Empdireccion` varchar(75) DEFAULT NULL,
  `Empfechaingreso` date NOT NULL,
  `Empfechasalida` date DEFAULT NULL,
  `Empcorreo` varchar(100) DEFAULT NULL,
  `Empestado` varchar(3) DEFAULT NULL,
  `Empusuario` varchar(45) DEFAULT NULL,
  `Empcontrasena` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Empcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
