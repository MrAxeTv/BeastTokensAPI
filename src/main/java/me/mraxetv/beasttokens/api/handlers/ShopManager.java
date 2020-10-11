package me.mraxetv.beasttokens.api.handlers;

import me.mraxetv.beasttokens.api.wrappers.shop.ShopData;

import java.util.ArrayList;

public interface ShopManager {
    boolean isShopExists(String shop);

    ArrayList<String> getShopsList();

    ShopData getShop(String shop);

}
