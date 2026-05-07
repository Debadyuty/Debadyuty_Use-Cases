package April_Day3;

public class Voter {
	
    private String name;
    private int age;
    private String voterId;
    private boolean hasVoted;

    
    public Voter(String name, int age, String voterId) {
        this.name = name;
        this.age = age;
        this.voterId = voterId;
        this.hasVoted = false; 
    }

    
    public String getVoterId() {
        return voterId;
    }

   
    public void vote() {
        if (age < 18) {
            System.out.println(name + " is not eligible to vote.");
        } else if (hasVoted) {
            System.out.println(name + " has already voted.");
        } else {
            hasVoted = true;
            System.out.println(name + " has successfully voted!");
        }
    }
}

public class VotingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter voter ID: ");
        String voterId = sc.nextLine();

        Voter voter = new Voter(name, age, voterId);

        
        voter.vote();

        
        voter.vote();

        sc.close();
    }
}
}
