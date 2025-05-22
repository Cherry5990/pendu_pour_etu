import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import java.util.Set;
import java.util.HashSet;

/**
 * Controleur du clavier
 */
public class ControleurLettres implements EventHandler<ActionEvent> {
    /**
     * modèle du jeu
     */
    private MotMystere modelePendu;
    /**
     * vue du jeu
     */
    private Pendu vuePendu;
    /**
     * boutons qui ont été désactivés
     */
    private Set<String> btnDesactives;
    /**
     * @param modelePendu modèle du jeu
     * @param vuePendu vue du jeu
     */
    ControleurLettres(MotMystere modelePendu, Pendu vuePendu){
        this.btnDesactives = new HashSet<>();
        this.modelePendu = modelePendu;
        this.vuePendu = vuePendu;
    }

    /**
     * Actions à effectuer lors du clic sur une touche du clavier
     * Il faut donc: Essayer la lettre, mettre à jour l'affichage et vérifier si la partie est finie
     * @param actionEvent l'événement
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btnAppuye = (Button) actionEvent.getSource();
        String lettreAppuyee = btnAppuye.getText();
        this.btnDesactives.add(lettreAppuyee);
        this.vuePendu.desacBoutons(btnDesactives);
    }
}
