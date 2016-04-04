package org.jjohnson.rainking.smartfridge.domain;

public class Item {

	long itemType;
	String itemUUID;
	String name;
	Double fillFactor;

	public Item(long itemType, String itemUUID, String name, Double fillFactor) {
		this.itemType = itemType;
		this.itemUUID = itemUUID;
		this.name = name;
		this.fillFactor = fillFactor;
	}

	public long getItemType() {
		return itemType;
	}

	public void setItemType(long itemType) {
		this.itemType = itemType;
	}

	public String getItemUUID() {
		return itemUUID;
	}

	public void setItemUUID(String itemUUID) {
		this.itemUUID = itemUUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFillFactor() {
		return fillFactor;
	}

	public void setFillFactor(Double fillFactor) {
		this.fillFactor = fillFactor;
	}

}
