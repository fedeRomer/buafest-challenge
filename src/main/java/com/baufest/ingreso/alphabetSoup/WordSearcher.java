package com.baufest.ingreso.alphabetSoup;

public class WordSearcher {

	private char soup[][];

	public WordSearcher(char soup[][]) {
		this.soup = soup;
	}

	/**
	 * El objetivo de este ejercicio es implementar una función que determine si una
	 * palabra está en una sopa de letras.
	 *
	 * ### Reglas - Las palabras pueden estar dispuestas direcciones horizontal o
	 * vertical, _no_ en diagonal. - Las palabras pueden estar orientadas en
	 * cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
	 * para abajo o viceversa. - El cambio de dirección puede estar a media palabra,
	 * de modo que, por ejemplo, parte de la palabra esté horizontal y de izquierda
	 * a derecha, parte esté vertical y de arriba hacia abajo, y otra parte
	 * horizontal de derecha a la izquierda.
	 *
	 * @param word Palabra a buscar en la sopa de letras.
	 *
	 * @return {@link Boolean} true si la palabra se encuentra en la sopa de letras.
	 */
	public boolean isPresent(String word) {
		// asumiendo que es una matriz cuadrada de igual columnas x filas
		if (searchY(word) || searchX(word)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * busca palabra en el eje Y de la matriz basicamente lo que hace es recorrer la
	 * matriz y pasar los chars a un string ya que no se pide en que ubicacion se
	 * encuentra la palabra, no guardo posiciones se realiza un reverse del string
	 * para ver si la palabra buscada se encuentra en orden inverso
	 * 
	 * @param palabra buscada
	 * @return true si existe en ejeY
	 */
	public Boolean searchY(String word) {
		// eje y
		String a = "";
		for (int fila = 0; fila < soup.length; fila++) {
			for (int columna = 0; columna < soup.length; columna++) {
				a = a.concat(String.valueOf(soup[columna][fila]));
			}
		}

		System.out.println(a + " \ny");
		String soupWordReversed = reverseUsingStringBuilder(a);
		if (a.contains(word) || soupWordReversed.contains(word)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * busca palabra en el eje x de la matriz basicamente lo que hace es recorrer la
	 * matriz y pasar los chars a un string ya que no se pide en que ubicacion se
	 * encuentra la palabra, no guardo posiciones se realiza un reverse del string
	 * para ver si la palabra buscada se encuentra en orden inverso
	 * 
	 * @param palabra buscada
	 * @return true si existe en ejeX
	 */
	public Boolean searchX(String word) {
		// eje X
		String a = "";
		for (int fila = 0; fila < soup.length; fila++) {
			for (int columna = 0; columna < soup.length; columna++) {
				a = a.concat(String.valueOf(soup[fila][columna]));
			}
		}

		System.out.println(a + " \nx");
		String soupWordReversed = reverseUsingStringBuilder(a);
		if (a.contains(word) || soupWordReversed.contains(word)) {
			return true;
		} else {
			return false;
		}
	}

	public String reverseUsingStringBuilder(String input) {
		if (input == null) {
			return null;
		}

		StringBuilder output = new StringBuilder(input).reverse();
		return output.toString();
	}

}
