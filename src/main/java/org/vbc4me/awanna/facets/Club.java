package org.vbc4me.awanna.facets;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  Contains the club names that students can belong to with in the Awana association.
 */
public enum Club {
	PUGGLES("Puggles"),
	CUBBIES("Cubbies"),
	SPARKS("Sparks"),
	TANDT("T&T"),
	TREK("Trek"),
	JOURNEY("Journey");
	
	private String name;
	private static final Map<String, Club> CLUB_MAP;
	
	/**
	 * Constructor which takes a string representation.
	 */
	Club(String name) {
		this.name = name;
	}
	
	/**
	 *  Convenience method for retrieving the name of the club.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Constructor for populating the internal unmodifiable map to allow returning 
	 * the {@link Club} enum by name.
	 */
	static {
		Map<String, Club> map = new ConcurrentHashMap<>();
		for(Club club : Club.values()) {
			map.put(club.getName(), club);
		}
		CLUB_MAP = Collections.unmodifiableMap(map);
	}
	
	/**
	 * Returns the Enum associated with the string name passed in.
	 * This will throw an {@link IllegalArgumentException} if the name passed 
	 * in is not found in the internal mapping.
	 */
	public static Club get(String name) {
		if(!CLUB_MAP.containsKey(name))
			throw new IllegalArgumentException("The club name: " + name + " does not exist.");
		return CLUB_MAP.get(name);
	}
}
