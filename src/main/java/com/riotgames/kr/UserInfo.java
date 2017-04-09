package com.riotgames.kr;

import java.util.HashMap;

public class UserInfo {
    String accountId;
    int ownedRp;
    HashMap<String, Champion> ownedChampions = new HashMap<>();

    public HashMap<String, Champion> getOwnedChampions() {
        return ownedChampions;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setRp(int rp) {
        this.ownedRp = rp;
    }

    public String getAccountId() {
        return accountId;
    }

    public int getRp() {
        return ownedRp;
    }

    public void addChampion(String champName, Champion champion){
        ownedChampions.put(champName, champion);
    }
}
