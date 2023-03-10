package com.example.shopping_service.Module;

import com.example.shopping_service.DTO.ShopDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;
    private Float total;
    @Column(name = "date_shop")
    private Date dateShop;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserId(shopDTO.getUserId());
        shop.setTotal(shopDTO.getTotal());
        shop.setDateShop(shopDTO.getDateShop());
        shop.setItems(shopDTO
                .getItemDTOS()
                .stream()
                .map(Item::convert)
                .collect(Collectors.toList()));
        return shop;
    }
}
