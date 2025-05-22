import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FenetreJeu extends BorderPane {
    private Text texteMot;

    private ImageView imagePendu;

    private ProgressBar barreProgression;

    private Clavier leClavier;

    public FenetreJeu(Button btnJouer, Button btnAccueil, Button btnSettings, Button btnInfo, Clavier leClavier){
        this.leClavier = leClavier;
        this.setHaut(btnAccueil, btnSettings, btnInfo);

        this.setCentre();

        this.setDroite();
    }

    private void setHaut(Button btnAccueil, Button btnSettings, Button btnInfo){
        BorderPane haut = new BorderPane();
        
        Text texte = new Text("Jeu du Pendu");

        HBox boiteBtn = new HBox();
        boiteBtn.getChildren().addAll(btnAccueil, btnSettings, btnInfo);

        haut.setLeft(texte);
        haut.setRight(boiteBtn);
        boiteBtn.setAlignment(Pos.CENTER_RIGHT);
        this.setTop(haut);
    }

    private void setCentre(){
        VBox centre = new VBox();

        this.texteMot = new Text("[Mot à trouver]");

        this.imagePendu = new ImageView("pendu0.png");

        this.barreProgression = new ProgressBar();

        centre.getChildren().addAll(this.texteMot, this.imagePendu, this.barreProgression, this.leClavier);
        this.setCenter(centre);
    }

    private void setDroite(){

    }
}
