package me.mraxetv.beasttokens.api.wrappers.shop;

public interface BTShopView<I extends BTItemData> {
  I getClickedItem();
  
  void setClickedItem(I item);
  
  boolean isTransactionMenuOpen();

  
  int getShopPage();
  
  void setShopPage(int paramInt);

  void setDiscount(Discount discount);

  Discount getDiscount();
}
