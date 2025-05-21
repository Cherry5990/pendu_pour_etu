import java.util.Scanner;

public class ExecutablePendu {
    public static void main(String [] args){
        MotMystere partie = new MotMystere("/usr/share/dict/french", 6, 10, 1, 10);
        Scanner scanner = new Scanner(System.in);
        while(!partie.gagne() && !partie.perdu()){
            System.out.println(partie);
            System.out.println(partie.getMotATrouve());
            System.out.println(partie.getMotCrypte());
            System.out.println("Veuillez entrer la lettre que vous voulez choisir");
            String userInput = scanner.nextLine();
            char lettreTestee = userInput.toUpperCase().charAt(0);
            partie.essaiLettre(lettreTestee);
        }
        scanner.close();
        if(partie.gagne()){
            System.out.println("Vous avez gagné ! Félicitatiiions !!! 🎉");
        } else {
            System.out.println("Vous avez perdu ! Bouuuuh !!! 👎");
        }
    }
}
