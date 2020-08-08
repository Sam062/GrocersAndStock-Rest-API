package base.model;

import java.util.List;

import lombok.Data;

@Data
public class GrocerModel {
	private String grocerName;
	private List<String> itemsForSale;
	private String location;
}
