package com.example.shopping_service.Module;

import com.example.shopping_service.DTO.ItemDTO;

import javax.persistence.*;

@Embeddable
public class Item {

    @Column(name = "product_id")
    private String productId;
    private Float price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductId(itemDTO.getProductId());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
