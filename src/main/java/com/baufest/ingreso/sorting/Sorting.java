package com.baufest.ingreso.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

	/**
	 * Se debe ordenar primero por puntuación de manera descendente, luego por
	 * nombre de manera ascendente.
	 * 
	 * @param jugadores la lista de jugadores a ordenar
	 * @return la lista ordenada de jugadores
	 */
	public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {

		// ordeno primero por puntuación
		jugadores = sortByScoreDesc(jugadores, false);
		jugadores = sortByName(jugadores);
		return jugadores;

	}

	/**
	 * Se debe ordenar primero por puntuación de manera descendente. Cuando 2
	 * jugadores tienen igual cantidad de puntos, el que tiene menos perdidas se lo
	 * considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el
	 * nombre de manera ascendente.
	 * 
	 * @param jugadores la lista de jugadores a ordenar
	 * @return la lista ordenada de jugadores
	 */
	public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores) {

		jugadores = sortByScoreDesc(jugadores, true);
		jugadores = sortByNameLost(jugadores);
		return jugadores;
	}

	/**
	 * realiza sort por puntaje descendientemente
	 * @param1 lista de jugadores
	 * @param2 booleano para saber si tambien se debe realizar sort por perdidas.
	 * @return lista ordenada
	 */
	public static List<Jugador> sortByScoreDesc(List<Jugador> j, Boolean shouldSortLostScore) {
		
		Collections.sort(j, Comparator.comparingInt(ju -> ((Jugador) ju).getPuntuacion()).reversed());
		if (shouldSortLostScore && j.size() > 1) {

			j = sortByLostScore(j);
		}
		return j;
	}
	/**
	 * realizar sort por nombre, si es que existen items con el mismo puntaje
	 * @param lista de jugadores
	 * @return lista ordenada
	 */
	public static List<Jugador> sortByName(List<Jugador> jugadores) {

		int aux = 1;
		for (int i = 0; i < jugadores.size(); i++) {

			if (aux == jugadores.size()) {
				// fin
				break;

			} else {

				if (jugadores.get(i).getPuntuacion() == jugadores.get(aux).getPuntuacion()) {

					int compare = jugadores.get(i).getNombre().compareToIgnoreCase(jugadores.get(aux).getNombre());
					// compare<0 si get(i) es "menor" que get(aux),
					// compare>0 si get(i) es "mayor" que get(aux),
					// compare=0 son iguales

					if (compare < 0) {
						// ok
					} else if (compare > 0) {
						Collections.swap(jugadores, i, aux);
					} else {
						// son iguales en nombre
					}
				}

			}
			aux++;
		}

		return jugadores;
	}

	/**
	 * realizar sort por nombre, si es que existen items con el mismo puntaje de perdidas
	 * @param lista de jugadores
	 * @return lista ordenada
	 */
	public static List<Jugador> sortByNameLost(List<Jugador> jugadores) {

		int aux = 1;
		for (int i = 0; i < jugadores.size(); i++) {

			if (aux == jugadores.size()) {
				// fin
				break;

			} else {

				if (jugadores.get(i).getPerdidas() == jugadores.get(aux).getPerdidas()) {

					int compare = jugadores.get(i).getNombre().compareToIgnoreCase(jugadores.get(aux).getNombre());
					// compare<0 si get(i) es "menor" que get(aux),
					// compare>0 si get(i) es "mayor" que get(aux),
					// compare=0 son iguales

					if (compare < 0) {
						// ok
					} else if (compare > 0) {
						Collections.swap(jugadores, i, aux);
					} else {
						// son iguales en nombre
					}
				}

			}
			aux++;
		}

		return jugadores;
	}

	/**
	 * realizar sort por puntaje perdidas
	 * @param lista de jugadores
	 * @return lista ordenada
	 */
	public static List<Jugador> sortByLostScore(List<Jugador> jugadores) {

		int aux = 1;

		for (int i = 0; i < jugadores.size(); i++) {

			if (jugadores.get(i).getPerdidas() == jugadores.get(aux).getPerdidas()) {
				if (jugadores.get(i).getPerdidas() > jugadores.get(aux).getPerdidas()) {
					Collections.swap(jugadores, i, aux);
				}
			}
		}

		return jugadores;
	}

}
