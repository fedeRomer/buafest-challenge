package com.baufest.ingreso.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatedCharacters {

	/**
	 * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple
	 * con alguna de las siguientes propiedades: 1- Todos los caracteres aparecen la
	 * misma cantidad de veces. Ejemplos: "aabbcc", "abcdef", "aaaaaa" 2- Todos los
	 * caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece
	 * un vez mas o una vez menos. Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
	 * 
	 * @param cadena la cadena a evaluar
	 * @return booleano indicando si la cadena cumple con las propiedades
	 */
	public Boolean isValid(String cadena) {

		// mapa donde asigno un valor (cantidad) a cada caracter del string
		Map<Character, Integer> map = new HashMap<>();
		cadena = cadena.replaceAll("\\s+", "");// remover espacio blanco para no contaminar la prueba
		// paso string a array de char
		char[] caracter = cadena.toCharArray();

		// itero el array de char y lo pongo en el mapa
		for (char c : caracter) {
			if (map.containsKey(c)) {
				int i = map.get(c);
				map.put(c, ++i);
			} else {
				map.put(c, 1);
			}
		}

		// bucle finalizado, mapa contiene k,v -> char,cantidad
		// de esta manera paso a evaluar si todas las key tienen el mismo valor
		return checkCharCount(map);

		// throw new UnsupportedOperationException();
	}

	public Boolean checkCharCount(Map<Character, Integer> map) {
		// basicamente lo que hago es pasar el set de valores y evaluar su tamano

		// si es igual a 1, significa que todos los caracteres tienen la misma cantidad
		// de repeticiones.

		// si el valor es 2, significa que todos los caracteres tienen la misma cantidad
		// de repeticiones menos 1.

		Set<Integer> values = new HashSet<Integer>(map.values());
		Boolean flag = values.size() == 1;
		Boolean flag2 = values.size() == 2;
		if (flag) {
			return true;
		} else if (flag2) {
			return true;
		} else {
			return false;
		}

	}

}
