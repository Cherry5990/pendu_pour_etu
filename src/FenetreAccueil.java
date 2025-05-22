import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FenetreAccueil extends BorderPane {
    public FenetreAccueil(Button btn){
        this.setHaut();

        this.setCentre();
    }

    private void setHaut(){
        BorderPane haut = new BorderPane();
        
        Text texte = new Text("Jeu du Pendu");

        HBox boiteBtn = new HBox();
        ImageView imgHome = new ImageView("home.png");
        ImageView imgSettings = new ImageView("parametres.png");
        ImageView imgInfo = new ImageView("info.png");
        imgSettings.setFitHeight(20);
        imgHome.setFitHeight(20);
        imgInfo.setFitHeight(20);
        imgSettings.setFitWidth(20);
        imgHome.setFitWidth(20);
        imgInfo.setFitWidth(20);
        Button btnAccueil = new Button("", imgHome);
        Button btnSettings = new Button("", imgSettings);
        Button btnInfo = new Button("", imgInfo);
        boiteBtn.getChildren().addAll(btnAccueil, btnSettings, btnInfo);

        haut.setLeft(texte);
        haut.setRight(boiteBtn);
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
