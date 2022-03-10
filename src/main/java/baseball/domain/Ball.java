package baseball.domain;

import baseball.constant.GameRule;

import java.util.Objects;

public class Ball {

    private int no;
    private int position;

    public Ball(int no, int position) {
        setNo(no);
        setPosition(position);
    }

    private void setNo(int no) {
        validateNo(no);
        this.no = no;
    }

    private void validateNo(int no) {
        if (no < GameRule.MIN_BALL_NO || GameRule.MAX_BALL_NO < no) {
            throw new IllegalArgumentException(GameRule.MIN_BALL_NO + "이상 " + GameRule.MAX_BALL_NO + " 이하의 숫자를 입력해주세요.");
        }
    }

    private void setPosition(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < GameRule.MIN_BALL_POS || GameRule.MAX_BALL_POS < position) {
            throw new IllegalArgumentException(GameRule.MIN_BALL_POS + "이상 " + GameRule.MAX_BALL_POS + " 이하의 숫자를 입력해주세요.");
        }
    }

    public int getNo() {
        return no;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return getNo() == ball.getNo() && getPosition() == ball.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNo(), getPosition());
    }

}
