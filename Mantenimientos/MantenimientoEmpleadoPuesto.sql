CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoEmpleadoPuesto`(
IN _Accion VARCHAR(15),
IN _Pueempcodigo INT,
IN _Empcodigo INT,
IN _Puecodigo INT,
OUT _Estado VARCHAR(15)
)
BEGIN
	SET SQL_SAFE_UPDATES = 0;
	SET _Estado = "OK";
	IF _Accion LIKE '%eliminar%' THEN
    
		IF _Estado = "OK" THEN
			DELETE FROM `bdrepuestosgrupo`.`puesto-empleado` 
            WHERE Empcodigo = _Empcodigo;
		END IF; 
	END IF;   
	IF _Accion LIKE '%insertar%' THEN
		INSERT INTO `puesto-empleado`
        VALUES
        (
			0,
			_Empcodigo,
            _Puecodigo
        );
        
	END IF;
END