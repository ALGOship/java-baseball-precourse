package baseball.domain;

public enum Score {
    STRIKE(3), BALL(2), NOTHING(1);

    public int priority;

    Score(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public Score compare(Score score) {
        if (this.priority < score.getPriority()) {
            return score;
        }
        return this;
    }
}
