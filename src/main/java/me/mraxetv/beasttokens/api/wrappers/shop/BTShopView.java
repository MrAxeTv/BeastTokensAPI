package me.mraxetv.beasttokens.api.wrappers.shop;

public interface BTShopView<T extends BTItemData> {
  T getClickedItem();
  
  void setClickedItem(T item);
  
  boolean hasOpenConfirmMenu();
  
  boolean setOpenConfirmMenu(boolean paramBoolean);
  
  int getShopPage();
  
  void setShopPage(int paramInt);

  void setDiscount(Discount discount);

  Discount getDiscount();
}
