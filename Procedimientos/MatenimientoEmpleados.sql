CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoEmpleados`(
IN _Accion VARCHAR(20),
IN _Empcodigo INT,
IN _Empidentidad VARCHAR(40),
IN _Empnombre VARCHAR(40),
IN _Emptelefono VARCHAR(15),
IN _Empfechanacimiento  VARCHAR(10),
IN _Empdireccion VARCHAR(100),
IN _Empfechaingreso VARCHAR(10),
IN _Empfechasalida VARCHAR(10),
IN _Empcorreo VARCHAR(25),
IN _Empestado VARCHAR(3),
IN _Empusuario VARCHAR(20),
IN _Empcontrasena VARCHAR(100),
OUT _Estado VARCHAR(10)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Empidentidad) FROM empleados WHERE UPPER(Empidentidad) = UPPER(_Empidentidad)) !=0 THEN
			SET _Estado = "errIdentidad"; 
		END IF;
		IF (SELECT COUNT(Empnombre) FROM empleados WHERE UPPER(Empnombre) = UPPER(_Empnombre)) !=0 THEN
			SET _Estado = "errNombre"; 
		END IF;
		IF (SELECT COUNT(Emptelefono) FROM empleados WHERE UPPER(Emptelefono) = UPPER(_Emptelefono)) !=0 THEN
			SET _Estado = "errTelefono"; 
		END IF;   
		IF (SELECT COUNT(Empusuario) FROM empleados WHERE UPPER(Empusuario) = UPPER(_Empusuario)) !=0 THEN
			SET _Estado = "errUsuario"; 
		END IF;  
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestosgrupo.empleados 
            VALUES (
            _Empcodigo,
            _Empidentidad,
            _Empnombre,
            _Emptelefono,
            _Empfechanacimiento,
            _Empdireccion,
            _Empfechaingreso,
			"0000-00-00",
			_Empcorreo,
			"ACT",
            _Empusuario,
            _Empcontrasena);
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE empleados SET 
            Empidentidad = _Empidentidad,
			Empnombre = _Empnombre, 
			Emptelefono = _Emptelefono, 
			Empfechanacimiento = _Empfechanacimiento, 
			Empdireccion = _Empdireccion,
			Empfechaingreso = _Empfechaingreso, 
			Empfechasalida = _Empfechasalida, 
			Empcorreo = _Empcorreo,
            Empestado = _Empestado,
            Empusuario =_Empusuario
			WHERE Empcodigo = _Empcodigo;
		END IF; 
	END IF;
    
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE empleados SET
            Empfechasalida = CURDATE(),
            Empestado = "INA"
			WHERE Empcodigo = _Empcodigo;
		END IF; 
	END IF;
END