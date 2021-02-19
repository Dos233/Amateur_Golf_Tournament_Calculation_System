public class Customer {
    private String name;
    private String club;
    private String gender;
    private String handicap;
    private int[] hole_scores;
    private int total_result;

    public void setName(String name) {
        this.name = name;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public void setHole_scores(int[] hole_scores) {
        this.hole_scores = hole_scores;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public String getGender() {
        return gender;
    }

    public String getHandicap() {
        return handicap;
    }

    public int[] getHole_scores() {
        return hole_scores;
    }

    public int getTotal_result() {
        return total_result;
    }
}
