import com.riotgames.kr.Champion;
import com.riotgames.kr.ChampionPurchaseService;
import com.riotgames.kr.LolUser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChampionPurchaseServiceTest {
    private ChampionPurchaseService championPurchaseService;

    @Before
    public void setUpRiotService() {
        championPurchaseService = new ChampionPurchaseService();
    }

    @Test
    public void testBuyChampion() {
        // given
        LolUser lolUser = new LolUser();
        lolUser.setAccountId("ksc1004");
        lolUser.setRp(12000);
        lolUser.addChampion("Ahri", new Champion("Ahri", 1000));

        // when
        boolean result;
        result = championPurchaseService.buyChampion(lolUser, "Garen");
        assertTrue("유저인증실패 또는 챔피언을 이미 보유중이거나 RP가 부족합니다.", result);

        result = championPurchaseService.buyChampion(lolUser, "Ahri");
        assertFalse("유저인증에도 성공, 챔피언 미보유, 보유 RP 가 충분한 것으로 판단되었습니다.", result);

        lolUser.setRp(100);
        result = championPurchaseService.buyChampion(lolUser, "Galio");
        assertFalse("유저인증에도 성공, 챔피언 미보유, 보유 RP 가 충분한 것으로 판단되었습니다.", result);

        // then

        // TODO: RP 가 충분할 때, 갈리오 구매가 성공함을 assert 문으로 작성해 보세요.

        // TODO: invalidUser 일 때, "MissFortune" 구매가 실패함을 assert 문으로 작성해 보세요.
    }
}
