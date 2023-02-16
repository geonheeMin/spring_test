package com.admin.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {
    private int products = 0;
    private int transaction = 0;
    private int money = 0;
    public Item(int products, int transaction, int money) {
        this.products = products;
        this.transaction = transaction;
        this.money = money;
    }
}
