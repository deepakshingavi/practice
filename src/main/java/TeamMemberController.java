import java.util.LinkedList;
import java.util.Scanner;

public class TeamMemberController {
    private TeamMember teamMember;

    private Scanner scan = null;

    public TeamMemberController(Scanner scan) {
        String name = null;
        this.teamMember = new TeamMember(name);
        this.scan = scan;
    }



    public String addTeamMember() {
        System.out.println("To go back press 0");
        String name = null;

        boolean keepLooping = true;

        //get team member linked list
        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();


        //user enters name
        while (keepLooping) {
            System.out.println("Enter team member name");
            //project names MUST be UNIQUE
            name = scan.nextLine();
            if (name.equals("0")) {
                return "team member not added";
            }

            if (!this.checkIfTeamMemberNameExists(name)) {
                keepLooping = false;
            } else {
                System.out.println("Team Member already exists");
                System.out.println("");
            }
        }


        //add team member to collection
        teamMembers.add(new TeamMember(name));

        teamMember.setTeamMembers(teamMembers);

        //returns true when a team member has been successfully added
        return "Name: " + name + "\n--Added--";
    }

    public String findTeamMember() {

        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();

        //if the company has no team members no need to continue
        if (teamMembers.isEmpty()) {
            return "Sorry no team members";
        }

        //get here company must have team members
        System.out.println("Enter team member name");
        String name = scan.nextLine();


        for (TeamMember t : teamMembers) {
            if (t.getTeamMembers().equals(name)) {
                return "Name: " + t.getTeamMembers();
            }
        }
        return "Team member not found";
    }

    public String removeTeamMember() {

        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();
        System.out.println("Enter name of team member to remove");
        System.out.println("Enter 0 to exit");
        String projectToRemove = scan.nextLine();
        boolean removed = false;

        if (projectToRemove.equals("0")) {
            return "No project removed";
        }

        //check existing team member names against the user input one
        for (TeamMember t : teamMembers) {
            if (t.getTeamMembers().equals(removeTeamMember())) {
                teamMembers.remove(t);
                removed = true;
            }
        }
        if (removed) {
            teamMember.setTeamMembers(teamMembers);
        } else
            return "No team member found";

        return removeTeamMember() + " has successfully been removed";
    }

    public void displayAllTeamMembers() {

        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();
        if (teamMembers.isEmpty()) {
            System.out.println("Company has not added any team members");
            return;
        }


        System.out.format(" Name%n");

        for (TeamMember t : teamMembers) {


            System.out.println(t.getTeamMembers() + "         ");
        }

    }


    public int quit() {
        System.out.println("Are you sure you want to quit? y/n");
        String userResponse = scan.nextLine();
        boolean loop = true;

        while (loop) {

            if (userResponse.equalsIgnoreCase("y")) {
                System.out.println("Program ending");
                return 0;
            } else if (userResponse.equalsIgnoreCase("n"))
                return 5;
        }

        return 0;

    }


    public boolean checkIfTeamMemberNameExists(String name) {

        //get team member linked list
        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();

        //if a team member with the same name already exists return true
        if (!teamMembers.isEmpty()) {
            for (TeamMember t : teamMembers) {
                if (t.getTeamMembers().equals(name)) {
                    return true;
                }
            }
        }


        return false;
    }


}
