package com.example.shopping_service.DTO;

import com.example.shopping_service.Module.Shop;
import java.util.Date;
import java.util.List;

public class ShopDTO {

    private String userId;
    private Float total;
    private Date dateShop;
    private List<ItemDTO> itemDTOS;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDateShop() {
        return dateShop;
    }

    public void setDateShop(Date dateShop) {
        this.dateShop = dateShop;
    }

    public List<ItemDTO> getItemDTOS() {
        return itemDTOS;
    }

    public void setItemDTOS(List<ItemDTO> itemDTOS) {
        this.itemDTOS = itemDTOS;
    }

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserId(shop.getUserId());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }
}

