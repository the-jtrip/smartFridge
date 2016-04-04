package smartFridge;

import java.util.logging.Logger;

import org.jjohnson.rainking.smartfridge.config.SmartFridgeConfig;
import org.jjohnson.rainking.smartfridge.domain.Item;
import org.jjohnson.rainking.smartfridge.servicesImpl.SmartFridgeManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SmartFridgeConfig.class })
public class SmartFridgeTest {

	static Logger log = Logger.getLogger(SmartFridgeTest.class.getName());

	@Autowired
	private SmartFridgeManagerImpl smartFridge;

	@Test
	public void getAverageFillFactor() {
		Double fillFactor = smartFridge.getFillFactor(2);
		log.info("here is the average fill factor for item 2: " + fillFactor);
	}

	@Test
	public void getItemsByFillFactor() {
		Object[] objArr = smartFridge.getItems(0.5);
		Item[] itemsByFillFactor = new Item[objArr.length];
		for (int i = 0; i < objArr.length; i++) {
			itemsByFillFactor[i] = (Item) objArr[i];
		}

		for (Item item : itemsByFillFactor) {
			log.info("here is the item name: " + item.getName() + " and here is the fill factor: "
					+ item.getFillFactor());

		}
	}

	@Test
	public void addItem() {
		smartFridge.handleItemAdded(3, "11", "iceCream", 0.1);
		smartFridge.listAllItems();
	}

	@Test
	public void deleteItem() {
		smartFridge.handleItemRemoved("5");
		smartFridge.listAllItems();
	}

	@Test
	public void forgetItem() {
		smartFridge.forgetItem(1);
		smartFridge.listAllItems();
	}

}
