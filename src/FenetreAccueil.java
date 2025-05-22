import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FenetreAccueil extends BorderPane {
    public FenetreAccueil(Button btnJouer, Button btnAccueil, Button btnSettings, Button btnInfo){
        this.setHaut(btnAccueil, btnSettings, btnInfo);

        this.setCentre();
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

        Button btnJouer = new Button("Lancer une partie");

        VBox niveaux = new VBox();
        ToggleGroup groupeBtnNiveau = new ToggleGroup();
        RadioButton facile = new RadioButton("Facile");
        RadioButton moyen = new RadioButton("Moyen");
        RadioButton difficile = new RadioButton("Difficile");
        RadioButton expert = new RadioButton("Expert");

        facile.setToggleGroup(groupeBtnNiveau);
        moyen.setToggleGroup(groupeBtnNiveau);
        difficile.setToggleGroup(groupeBtnNiveau);
        expert.setToggleGroup(groupeBtnNiveau);
        niveaux.getChildren().addAll(facile, moyen, difficile, expert);

        TitledPane niveau = new TitledPane("Niveau de difficulté", niveaux);

        centre.getChildren().addAll(btnJouer, niveau);
        this.setCenter(centre);
    }
}
