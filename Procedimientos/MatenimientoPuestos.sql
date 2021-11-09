CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoPuestos`(
IN _Accion VARCHAR(15),
IN _Puecodigo INT,
IN _Puedescripcion VARCHAR(40),
IN _Pueestado VARCHAR(3),
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Puedescripcion) FROM puestos WHERE UPPER(Puedescripcion) = UPPER(_Puedescripcion)) !=0 THEN
			SET _Estado = "errDescripcion"; 
		END IF; 
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestosgrupo.puestos 
            VALUES (
            0,
            _Puedescripcion,
			"ACT"
            );
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE puestos SET 
            Puedescripcion = _Puedescripcion,
			Pueestado = _Pueestado
			WHERE Puecodigo = _Puecodigo;
		END IF; 
	END IF;
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE puestos SET
            Pueestado = "INA"
			WHERE Puecodigo = _Puecodigo;
		END IF; 
	END IF;
END