package me.mraxetv.beasttokens.api.wrappers.shop;

import java.util.List;

public interface ItemData {
     String getPermission();

     void setPermission(String permission);

     boolean hasPermission();

    void setPrice(double price);

     void setCmd(List<String> cmd);

     void setRcmd(List<String> rcmd);

     void setPcmd(List<String> pcmd);

     int getSlot();

     String getName();
     //

     List<String> getCmd();

     List<String> getRcmd();

     List<String> getPcmd();

     boolean hasCmd();

     boolean hasRcmd();

     boolean hasPcmd();

     boolean hasOpenShop();

     String getOpenShop();

     void setOpenShop(String openShop);

     boolean hasPlayerLimit();

     int getPlayerLimit();

     void setPlayerLimit(int limit);

     boolean hasServerLimit();

     int getServerLimit();

     void setServerLimit(int limit);

     double getPrice();

     boolean isCloseShop();

     void setCloseShop(boolean b);
}
