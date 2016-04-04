package org.jjohnson.rainking.smartfridge.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.jjohnson.rainking.smartfridge.config.MemoryDB;
import org.jjohnson.rainking.smartfridge.domain.Item;
import org.jjohnson.rainking.smartfridge.services.SmartFridgeManager;

public class SmartFridgeManagerImpl implements SmartFridgeManager {

	static Logger log = Logger.getLogger(SmartFridgeManagerImpl.class.getName());
	private Map<String, Item> fridgeItems = MemoryDB.getRefridgeratorItems();

	public SmartFridgeManagerImpl() {
		Item condiment1 = new Item(1, "1", "ketchup", 0.7);
		Item condiment2 = new Item(1, "2", "mustard", 0.4);
		Item condiment3 = new Item(1, "3", "mayo", 0.1);
		Item deli1 = new Item(2, "4", "ham", 1.0);
		Item deli2 = new Item(2, "5", "turkey", 0.6);
		Item deli3 = new Item(2, "6", "salami", 0.7);
		Item dessert = new Item(3, "7", "pie", 0.75);
		Item beverage1 = new Item(4, "8", "milk", 0.9);
		Item beverage2 = new Item(4, "9", "soda", 0.5);

		fridgeItems.put(condiment1.getItemUUID(), condiment1);
		fridgeItems.put(condiment2.getItemUUID(), condiment2);
		fridgeItems.put(condiment3.getItemUUID(), condiment3);
		fridgeItems.put(deli1.getItemUUID(), deli1);
		fridgeItems.put(deli2.getItemUUID(), deli2);
		fridgeItems.put(deli3.getItemUUID(), deli3);
		fridgeItems.put(dessert.getItemUUID(), dessert);
		fridgeItems.put(beverage1.getItemUUID(), beverage1);
		fridgeItems.put(beverage2.getItemUUID(), beverage2);

	}

	@Override
	public void handleItemRemoved(String itemUUID) {
		fridgeItems.remove(itemUUID);

	}

	@Override
	public void handleItemAdded(long itemType, String itemUUID, String name, Double fillFactor) {
		Item newItem = new Item(itemType, itemUUID, name, fillFactor);
		fridgeItems.put(newItem.getItemUUID(), newItem);

	}

	@Override
	public Object[] getItems(Double fillFactor) {
		List<Item> itemsByFillFactor = new ArrayList<>();
		for (Item item : fridgeItems.values()) {
			if (item.getFillFactor() <= fillFactor) {
				itemsByFillFactor.add(item);
			}
		}
		return itemsByFillFactor.toArray();
	}

	@Override
	public Double getFillFactor(long itemType) {
		int count = 0;
		Double averageFill = 0.0;
		for (Item item : fridgeItems.values()) {
			if (item.getItemType() == itemType && item.getFillFactor() > 0.0) {
				averageFill += item.getFillFactor();
				count++;
			}
		}
		if (count > 0) {
			averageFill = averageFill / count;
		}
		return averageFill;
	}

	@Override
	public void forgetItem(long itemType) {
		Map<String, Item> fridgeItemsCopy = new HashMap<String, Item>(fridgeItems);
		for (Item item : fridgeItemsCopy.values()) {
			if (item.getItemType() == itemType) {
				fridgeItems.remove(item.getItemUUID());
			}
		}

	}

	public void listAllItems() {
		for (Item item : fridgeItems.values()) {
			log.info("here is the item name: " + item.getName() + " here is the item uuid: " + item.getItemUUID());
		}
	}

}
