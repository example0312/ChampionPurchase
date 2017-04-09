package com.riotgames.kr;

import java.util.HashMap;

public class ChampionPurchaseService {
    RiotService riotService = new RiotService();

    /**
     * 챔피언을 구매한다
     * @param userInfo 사용자 정보
     * @param championName 구매하는 챔피언 이름
     * @return 구매 성공시 true, 실패시 false
     */
    public boolean buyChampion (UserInfo userInfo, String championName) {

        // 유저를 인증한다.
        boolean result = riotService.isAuthenticatedUser(userInfo);

        if(result) {
            HashMap<String, Champion> ownedChampions = userInfo.getOwnedChampions();
            // 구매를 원하는 챔피언이 현재 보유 중인지 확인한다.
            if (ownedChampions.containsKey(championName) == false) {
                // 해당 champion 을 구매하기 위한 RP 가 충분한지 확인한다.
                Champion champion = riotService.getChampion(championName);
                int championPrice = champion.getPrice();
                if (championPrice <= userInfo.getRp()) {
                    return true;
                }
            }
        }
        return false;
    }
}
