package baseball.domain;

public enum Status {
    PLAY(1), STOP(2);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
