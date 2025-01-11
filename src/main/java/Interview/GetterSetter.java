package Interview;

public class GetterSetter {
    private String teamMemberName;
    private String teamMemberEmail;

    public String getTeamMemberEmail() {
        return teamMemberEmail;
    }


    public String getTeamMemberName() {
        return teamMemberName;
    }


    public void setTeamMemberDetails(String name, String email) {
        this.teamMemberName = name;
        this.teamMemberEmail = email;
    }
}
