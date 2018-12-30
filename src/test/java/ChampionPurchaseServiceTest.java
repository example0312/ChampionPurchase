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

        // then
        // TODO: Graren 구매가 성공함을 assert 문으로 작성해 보세요.

        // TODO: invalidUser 였다면 어떻게 해야 했을까?
    }
}
