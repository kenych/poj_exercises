package exercises.concurrency;

public class PlayerHighScore implements Comparable {

    Integer score;
    Integer playerId;

    public PlayerHighScore(Integer score, Integer playerId) {
        this.score = score;
        this.playerId = playerId;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    @Override
    public int compareTo(Object o) {
        return score.compareTo(((PlayerHighScore) o).getScore());
    }

    @Override
    public String toString() {
        return "PlayerHighScore{" +
                "score=" + score +
                ", playerId=" + playerId +
                '}';
    }
}
