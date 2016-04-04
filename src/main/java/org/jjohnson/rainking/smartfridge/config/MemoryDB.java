package org.jjohnson.rainking.smartfridge.config;

import java.util.HashMap;
import java.util.Map;

import org.jjohnson.rainking.smartfridge.domain.Item;

public class MemoryDB {

	private static Map<String, Item> refridgeratorItems = new HashMap<>();

	public static Map<String, Item> getRefridgeratorItems() {
		return refridgeratorItems;
	}
}
