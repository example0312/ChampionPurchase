package com.riotgames.kr;

import java.util.HashMap;
import java.util.Map;

public class LolUser {
    private String accountId;
    private int ownedRp;

    // 아래 map은 사실 User DB 에서 긁어와야 하는 정보이다. 그러나 지금은 테스트를 공부하기 위해 임시로 만든 것이니,
    // 모든 유저들이 챔피언을 구매한 적이 한번도 없다고 가정하자.
    private Map<String, Champion> ownedChampions = new HashMap<>();

    public Map<String, Champion> getOwnedChampions() {
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
