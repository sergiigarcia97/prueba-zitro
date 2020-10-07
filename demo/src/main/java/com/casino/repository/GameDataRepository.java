import com.casino.entity.GameData;
import com.casino.entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDataRepository extends JpaRepository<GameData, GameSession> {

    List<GameData> findByGameSessionGame(String gameId);

    List<GameData> findByGameSessionPlayer(String playerId);
}
