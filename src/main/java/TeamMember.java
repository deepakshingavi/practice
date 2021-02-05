import java.util.LinkedList;
import java.util.Scanner;

public class TeamMember {

    private static LinkedList<TeamMember> teamMembers;

    public LinkedList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(LinkedList<TeamMember> teamMembers) {
        teamMembers = teamMembers;
    }


    private Scanner scan = new Scanner(System.in);

    public TeamMember(String name) {
        if(teamMembers==null) {
            teamMembers = new LinkedList<>();
        }
    }

}