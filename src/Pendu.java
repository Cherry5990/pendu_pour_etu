import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


/**
 * Vue du jeu du pendu
 */
public class Pendu extends Application {
    /**
     * modèle du jeu
     **/
    private MotMystere modelePendu;
    /**
     * Liste qui contient les images du jeu
     */
    private ArrayList<Image> lesImages;
    /**
     * Liste qui contient les noms des niveaux
     */    
    public List<String> niveaux;

    // les différents contrôles qui seront mis à jour ou consultés pour l'affichage
    /**
     * le dessin du pendu
     */
    private ImageView dessin;
    /**
     * le mot à trouver avec les lettres déjà trouvé
     */
    private Text motCrypte;
    /**
     * la barre de progression qui indique le nombre de tentatives
     */
    private ProgressBar pg;
    /**
     * le clavier qui sera géré par une classe à implémenter
     */
    private Clavier clavier;
    /**
     * le text qui indique le niveau de difficulté
     */
    private Text leNiveau;
    /**
     * le chronomètre qui sera géré par une clasee à implémenter
     */
    private Chronometre chrono;
    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;
    /**
     * le bouton Info / I
     */    
    private Button boutonInfo;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonMaison;
    /**
     * le bouton qui permet de (lancer ou relancer une partie
     */ 
    private Button bJouer;
    /**
     * la page d'accueil
     */
    private FenetreAccueil pageAccueil;
    /**
     * la page de jeu
     */
    private FenetreJeu pageJeu;
    /**
     * la scene
     */
    private Scene scene;
    /**
     * le clavier
     */
    private Clavier leClavier;
    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() {
        this.modelePendu = new MotMystere("/usr/share/dict/french", 3, 10, MotMystere.FACILE, 10);
        this.lesImages = new ArrayList<Image>();
        this.chargerImages("./img");
        this.leClavier = new Clavier("abcdefghijklmnopqrstuvwxyz", new ControleurLettres(this.modelePendu, this));


        ImageView imgHome = new ImageView("home.png");
        imgHome.setFitHeight(20);
        imgHome.setFitWidth(20);
        this.boutonMaison = new Button("", imgHome);

        ImageView imgInfo = new ImageView("info.png");
        imgInfo.setFitHeight(20);
        imgInfo.setFitWidth(20);
        this.boutonInfo = new Button("", imgInfo);
        
        ImageView imgSettings = new ImageView("parametres.png");
        imgSettings.setFitHeight(20);
        imgSettings.setFitWidth(20);
        this.boutonParametres = new Button("", imgSettings);

        this.fenetreAccueil();
        this.fenetreJeu();

        // A terminer d'implementer
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédentes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private Pane titre(){
        // A implementer          
        Pane banniere = new Pane();
        return banniere;
    }

    // /**
     // * @return le panel du chronomètre
     // */
    // private TitledPane leChrono(){
        // A implementer
        // TitledPane res = new TitledPane();
        // return res;
    // }

    /**
     * Crée la fenêtre de jeu avec le mot crypté, l'image, la barre
     *         de progression et le clavier
     */
    private void fenetreJeu(){
        this.pageJeu = new FenetreJeu(this.bJouer, this.boutonMaison, this.boutonParametres, this.boutonInfo, this.leClavier);
    }

    /**
     * Crée la fenêtre d'accueil sur laquelle on peut choisir les paramètres de jeu
     */
    private void fenetreAccueil(){   
        this.pageAccueil = new FenetreAccueil(this.bJouer, this.boutonMaison, this.boutonParametres, this.boutonInfo);
    }

    /**
     * charge les images à afficher en fonction des erreurs
     * @param repertoire répertoire où se trouvent les images
     */
    private void chargerImages(String repertoire){
        for (int i=0; i<this.modelePendu.getNbErreursMax()+1; i++){
            File file = new File(repertoire+"/pendu"+i+".png");
            System.out.println(file.toURI().toString());
            this.lesImages.add(new Image(file.toURI().toString()));
        }
    }

    public void modeAccueil(){
        this.scene.setRoot(this.pageAccueil);
    }
    
    public void modeJeu(){
        this.scene.setRoot(this.pageJeu);
    }
    
    public void modeParametres(){
        // A implémenter
    }

    /** lance une partie */
    public void lancePartie(){
        // A implementer
    }

    /**
     * raffraichit l'affichage selon les données du modèle
     */
    public void majAffichage(){
        // A implementer
    }

    /**
     * accesseur du chronomètre (pour les controleur du jeu)
     * @return le chronomètre du jeu
     */
    public Chronometre getChrono(){
        // A implémenter
        return null; // A enlever
    }

    public Alert popUpPartieEnCours(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
        
    public Alert popUpReglesDuJeu(){
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }
    
    public Alert popUpMessageGagne(){
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);        
        return alert;
    }
    
    public Alert popUpMessagePerdu(){
        // A implementer    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }

    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        this.scene = new Scene(this.pageAccueil, 800, 1600);
        stage.setTitle("IUTEAM'S - La plateforme de jeux de l'IUTO");
        stage.setScene(scene);
        this.modeJeu();
        stage.show();
    }

    public MotMystere getModele(){
        return this.modelePendu;
    }

    public void desacBoutons(Set<String> touches){
        this.leClavier.desactiveTouches(touches);
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
