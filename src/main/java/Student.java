public class Student {

    private final int id;
    private final String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        updateScore(score);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0~100사이여야 합니다.");
        }

        this.score = score;
    }

    public PassStatus getPassStatus() {
        if (score >= 60) {
            return  PassStatus.PASSED;
        }

        return PassStatus.FAILED;
    }

    @Override
    public String toString() {
        return "id=" + id + ", 이름=" + name + ", 점수=" + score + ", 상태=" + getPassStatus().getLabel();
    }
}
