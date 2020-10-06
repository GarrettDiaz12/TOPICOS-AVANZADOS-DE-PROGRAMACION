# TOPICOS-AVANZADOS-DE-PROGRAMACION/PROGRAMA DE CIFRADO Y DECIFRADO DE UNA CADENA DE TEXTO POR ASCII
Tareas/Actividades/DIAZ CERVERA BRIAN NOE / ITL / TAP / 2020 / PROFESOR LEVY
Desarrollar un programa que implemente una aplicación con GUI para el cifrado de archivos de texto con el algoritmo de cifrado Vigenère.

Se va a crear un programa de cifrado simple. El proceso es muy sencillo. Se divide en dos partes.
 En primer lugar, cada letra mayúscula o minúscula debe desplazarse tres posiciones
hacia la derecha, de acuerdo con la tabla ASCII: la letra ’a’ debe convertirse en la letra
’d’, la letra ’y’ debe convertirse en el carácter ’—’, etc. En segundo lugar, cada línea debe
invertirse. Después de invertir, todos los caracteres de la mitad en adelante (truncado) deben
moverse una posición a la izquierda en ASCII. En este caso, ’b’ se convierte en ’a’ y ’a’ se
convierte en ’‘’.
Por ejemplo, si como entrada tenemos la cadena abcABC1 si la palabra resultante de la
primera parte es ”defDEF1”, las letras ”DEF1”deben moverse una posición a la izquierda.
Sin embargo, si la palabra resultante de la primera parte es ”tesA”, las letras ”sA”serán
desplazadas. El resultado cifrado de la cadena es 1FECedc.
