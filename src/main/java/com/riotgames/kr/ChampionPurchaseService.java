package com.riotgames.kr;

import java.util.Map;

public class ChampionPurchaseService {
    private RiotService riotService = new RiotService();

    /**
     * 챔피언을 구매한다
     * @param lolUser 사용자 정보
     * @param championName 구매하는 챔피언 이름
     * @return 구매 성공시 true, 실패시 false
     */
    public boolean buyChampion(LolUser lolUser, String championName) {
        // 유저를 인증한다.
        boolean validUser = riotService.isAuthenticatedUser(lolUser);

        if (validUser) {
            Map<String, Champion> ownedChampions = lolUser.getOwnedChampions();
            // 구매를 원하는 챔피언이 현재 보유 중인지 확인한다.
            if (ownedChampions.containsKey(championName) == false) {
                // 해당 champion 을 구매하기 위한 RP 가 충분한지 확인한다.
                Champion champion = riotService.getChampion(championName);
                int championPrice = champion.getPrice();
                if (championPrice <= lolUser.getRp()) {
                    // 여기서 실제로 구매를 위해 lolUser의 RP를 감소시키고, lolUser의 ownedChampions 맵에 챔피언을 추가해야 한다.
                    // 그러나 지금은 상기 작업들이 잘 되었다고 가정하고, true를 리턴한다.
                    return true;
                }
            }
        }

        throw new RuntimeException("Invalid user.");
    }
}
