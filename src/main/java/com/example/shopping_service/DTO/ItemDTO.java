package com.example.shopping_service.DTO;

import com.example.shopping_service.Module.Item;

public class ItemDTO {

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

    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductId(item.getProductId());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }
}
