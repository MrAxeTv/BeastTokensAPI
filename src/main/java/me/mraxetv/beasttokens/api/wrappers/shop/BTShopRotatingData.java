package me.mraxetv.beasttokens.api.wrappers.shop;

import me.mraxetv.beasttokens.api.ShopTimerType;

import java.util.Collections;
import java.util.List;

public interface BTShopRotatingData {
  long getRotatingTime();

  default boolean isRotatingEnabled() {
    return false;
  }

  default boolean isMysqlStorage() {
    return false;
  }

  default String getShopId() {
    return "";
  }

  default ShopTimerType getTimerType() {
    return ShopTimerType.UNKNOWN;
  }

  default List<String> getCurrentRotatingItemIds() {
    return Collections.emptyList();
  }
}
