import java.util.ArrayList;

// creating swimmer class
class Swimmer {
    private String name;
    private int idNumber;

    public Swimmer(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public void swim() {
        System.out.println(this.name + " is swimming.");
    }
}

// creating spectator class
class Spectator {
    private String name;
    private int idNumber;

    public Spectator(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public void checkScoreboard(Scoreboard scoreboard) {
        System.out.println(this.name + " is checking the scoreboard. Current score: " + scoreboard.getCurrentScore());
    }
}

// creating judge class
class Judge {
    private String name;
    private int idNumber;

    public Judge(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public void blowWhistle() {
        System.out.println(this.name + " is blowing the whistle.");
    }
}

// creating supportive staff class
class SupportingStaff {
    private String name;
    private int idNumber;

    public SupportingStaff(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public void checkScoreboard(Scoreboard scoreboard) {
        System.out.println(this.name + " is checking the scoreboard. Current score: " + scoreboard.getCurrentScore());
    }
}

//creating scoreboard to determine the winner 
class Scoreboard {
    private int currentScore;

    public Scoreboard() {
        this.currentScore = 0;
    }

    public int getCurrentScore() {
        return this.currentScore;
    }

    public void updateScore(int score) {
        this.currentScore += score;
    }
}

//start competition
public class SwimmingCompetition {
    public static void main(String[] args) {
        int numSwimmers = Integer.parseInt(args[0]);
        int numSpectators = Integer.parseInt(args[1]);
        int numJudges = Integer.parseInt(args[2]);
        int numStaff = Integer.parseInt(args[3]);

        ArrayList<Swimmer> swimmers = new ArrayList<>();
        ArrayList<Spectator> spectators = new ArrayList<>();
        ArrayList<Judge> judges = new ArrayList<>();
        ArrayList<SupportingStaff> staff = new ArrayList<>();
        
        //add new swimmers
        for (int i = 0; i < numSwimmers; i++) {
            Swimmer swimmer = new Swimmer("Swimmer " + i, i);
            swimmers.add(swimmer);
        }
        
        //add new spectators
        for (int i = 0; i < numSpectators; i++) {
            Spectator spectator = new Spectator("Spectator " + i, i);
            spectators.add(spectator);
        }
        
        //add new judge
        for (int i = 0; i < numJudges; i++) {
            Judge judge = new Judge("Judge " + i, i);
            judges.add(judge);
        }
        
        //add new staff
        for (int i = 0; i < numStaff; i++) {
            SupportingStaff staffMember = new SupportingStaff("Staff " + i, i);
            staff.add(staffMember);
        }
        
        //creating scoreboard
        Scoreboard scoreboard = new Scoreboard();
        
        // check the scoreboard 
        for (Swimmer swimmer : swimmers) {
            swimmer.swim();
        }

        for (Spectator spectator : spectators) {
            spectator.checkScoreboard(scoreboard);
        }
      
        for (SupportingStaff staffMember : staff) {
            staffMember.checkScoreboard(scoreboard);
        }
        
        //blow whistle
        for (Judge judge : judges) {
        Judge headJudge = judges.get(0);
        headJudge.blowWhistle();
        }
    
        // scoreboard update
        scoreboard.updateScore(10);
    
        //check the scoreboard again.
        for (Swimmer swimmer : swimmers) {
            swimmer.swim();
        }
        
        for (Spectator spectator : spectators) {
            spectator.checkScoreboard(scoreboard);
        }
    
        for (SupportingStaff staffMember : staff) {
            staffMember.checkScoreboard(scoreboard);
        }
    }
}
    