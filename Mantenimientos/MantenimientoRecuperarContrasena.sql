CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoRecuperarContrasena`(
IN _Empusuario VARCHAR(20),
IN _Empcontrasena VARCHAR(100),
OUT _Estado VARCHAR(10))
BEGIN
	SET _Estado = "OK";
    SET SQL_SAFE_UPDATES = 0;
		IF _Estado = "OK" THEN
			UPDATE empleados SET
				Empcontrasena = _Empcontrasena
			WHERE Empusuario = _Empusuario;
		END IF; 
END