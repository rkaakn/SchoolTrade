package com.rka.data;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service("item")
public class Item {
	private int itemId;
	private String name;
	private String description;
	private String pic;
	private String uploadDate;
	private String checkDate;
	private String OwnerName;
	private String BuyerName;
	private float price;
	public Item() {
		// TODO 自动生成的构造函数存根
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItemId() {
		return itemId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		this.OwnerName = ownerName;
	}
	public String getBuyerName() {
		return BuyerName;
	}
	public void setBuyerName(String buyerName) {
		this.BuyerName = buyerName;
	}
	
	

}
