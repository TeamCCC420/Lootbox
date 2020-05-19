package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.Main;
import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.boite.Compteur;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.vues.centre.VueCompteur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EcouteurRenseignements implements EventHandler<ActionEvent> {

    private Monde monde;

    public EcouteurRenseignements(Monde monde){
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TabPane tabPane = new TabPane();
        Tab page1 = new Tab("Page 1 - Comprehension");
        page1.setStyle("-fx-background-color: #ffffCC; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab page2 = new Tab("Page 2 - Proposition");
        page2.setStyle("-fx-background-color: #ffddcc; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab page3 = new Tab("Page 3 - Verification");
        page3.setStyle("-fx-background-color: #ffbbcc; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab page4 = new Tab("Page 4 - Economiser");
        page4.setStyle("-fx-background-color: #ffaaee; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab page5 = new Tab("Page 5 - Autre option ");
        page5.setStyle("-fx-background-color: #ccaaff; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        tabPane.getTabs().addAll(page1,page2,page3, page4, page5);
        VBox vboxPrincipal = new VBox();
        vboxPrincipal.setStyle("-fx-background-color: #ffffCC; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vbox = new VBox();
        Monde boites = new Monde();
        for (int i = 0; i < 10000; i++) {
            boites.getBox().get(0).gift();
            boites.getBox().get(1).gift();
            boites.getBox().get(2).gift();
        }
        vbox.setAlignment(Pos.CENTER);
        VueCompteur vueC;
        VBox temp;
        Label type = new Label();
        HBox hbox = new HBox();
        hbox.setSpacing(60);
        hbox.setAlignment(Pos.CENTER);
        for(int i=0; i<boites.getBox().size(); i++) {
            temp = new VBox();
            vueC = new VueCompteur(boites,boites.getBox().get(i));
            switch (i){
                case 0:
                    type = new Label("Bois");
                    break;
                case 1:
                    type = new Label("Metal");
                    break;
                case 2:
                    type = new Label("Diamant");
                    break;
            }
            temp.getChildren().addAll(type,vueC);
            hbox.getChildren().add(temp);
        }

        Monde monde = new Monde();
        Boite boite = new Boite();
        HBox hBox = new HBox();
        Label text1 = new Label("Cas 1 : On ouvre seulement \nla boite en bois jusqu'a \nson sold out : ");
        boite.setCompt(new Compteur(25,25,34,25,0));
        VueCompteur vueC1 = new VueCompteur(monde,boite);
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(text1,vueC1);
        Label text2 = new Label("Cas 2 : On ouvre seulement \nla boite en metal jusqu'a \nson sold out : ");
        boite.setCompt(new Compteur(25,25,34,25,25));
        VueCompteur vueC2 = new VueCompteur(monde,boite);
        VBox vb2 = new VBox();
        vb2.getChildren().addAll(text2,vueC2);
        Label text3 = new Label("Cas 3 : On ouvre seulement \nla boite en diamant jusqu'a \nson sold out : ");
        boite.setCompt(new Compteur(0,25,34,25,25));
        VueCompteur vueC3 = new VueCompteur(monde,boite);
        VBox vb3 = new VBox();
        vb3.getChildren().addAll(text3,vueC3);
        hBox.getChildren().addAll(vb1,vb2,vb3);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        VBox vboxP = new VBox();
        vboxP.getChildren().addAll(new Label(texte4()),hBox,new Label(texte5()));
        vboxP.setAlignment(Pos.CENTER);
        vboxP.setSpacing(20);
        VBox vbox3 = new VBox();
        vbox3.getChildren().addAll(new Label(texte6()));
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setSpacing(20);
        vboxP.setStyle("-fx-background-color: #ffbbcc; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        vbox3.setStyle("-fx-background-color: #ffaaee; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        page3.setContent(vboxP);
        page4.setContent(vbox3);
        VBox pa5 = new VBox();
        pa5.setAlignment(Pos.CENTER);
        pa5.setSpacing(20);
        pa5.getChildren().add(texte7());
        page5.setContent(pa5);
        pa5.setStyle("-fx-background-color: #ccaaff; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");

        VBox v5 = new VBox();
        v5.setStyle("-fx-background-color: #ccaaff; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");

        vbox.getChildren().addAll(hbox);
        vbox.setSpacing(20);
        vboxPrincipal.getChildren().addAll(new Label(texte1()),vbox,new Label(texte2()));
        vboxPrincipal.setAlignment(Pos.CENTER);
        vboxPrincipal.setSpacing(20);
        VBox vbox2 = new VBox();
        vbox2.setStyle("-fx-background-color: #ffddcc; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        vbox2.getChildren().addAll(new Label(texte3()));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(20);
        page1.setContent(vboxPrincipal);
        page2.setContent(vbox2);
        dialogStage.setScene(new Scene(tabPane, TailleComposants.getInstance().getLargeurEcran()/1.1, TailleComposants.getInstance().gethauteurEcran()/1.1));
        dialogStage.setTitle("Compte - Rendu : par PETIT Brian et DUCHESNE Leila");
        dialogStage.show();
        dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
    }

    public String texte1(){
        StringBuilder s = new StringBuilder();
        s.append("Vous venez d'essayer les boites classiques, si vous ne l'avez toujours pas fait, essayez, c'est fun !\n");
        s.append("Maintentant, nous allons essayer de comprendre les probabilités de ce jeu :\n");
        s.append("Les boites après 10000 lancés :");
        return s.toString();
    }

    private String texte2() {
        StringBuilder s = new StringBuilder();
        s.append("Tentons de comprendre : Nous savons qu'il est impossible d'obtenir des objets légendaires\n");
        s.append("dans une boite en bois, ni d'obtenir un commun dans une boite en diamant.\n");
        s.append("Les tirages sont avec remise, il est tout a fait possible que les '30000' objets achetés ne\n");
        s.append("couvrent pas tous les gains possibles, on peut conclure que ce système n'est pas juste, et\n");
        s.append("peut entrainer une dépendance, tout comme les jeux d'argents au casino, qui reprennent le même principe\n");
        s.append("de hasard controlé : la présence de remise, les intervalles hétérogènes de gains controlés et l'aléatoire total\n");
        s.append("sont de parfaites ficelles pour les dépenses excessives.\n");
        s.append("\n");
        s.append("Au vue des résultats, on peut conclure les probabilités suivantes : \n");
        s.append("Bois : Commun --> 80% ; Moyen --> 16% ; Rare --> 3% ; Epic --> 1%>.>0% ; Legendaire --> 0%\n");
        s.append("Metal : Commun --> 50% ; Moyen --> 25% ; Rare --> 12%>.>11% ; Epic --> 10% ; Legendaire --> 3%\n");
        s.append("Diamant : Commun --> 0% ; Moyen --> 40% ; Rare --> 28% ; Epic --> 22% ; Legendaire --> 10%\n");
        s.append("\n");
        s.append("On peut remarquer que la probabilté d'avoir un légendaire est de faible, en plus de ça, avec remise\n");
        s.append("il est possible que malgré toutes les tentatives, vous n'ayez jamais tous les légendaires, voir même aucun !\n");
        s.append("Ce système est donc injuste pour ses probabilités trop faibles et secrètes, et pour sa remise qui pousse\n");
        s.append("l'intervalle de gain vers l'infini !\n");
        s.append("\n");
        s.append("Améliorons ce système tout d'abord, en modifiant le système pour qu'il y ait de la remise\n");
        s.append("Si vous êtes prêt, lisez la page suivante !\n");
        return s.toString();
    }

    private String texte3() {
        StringBuilder s = new StringBuilder();
        s.append("Si vous en êtes là, c'est que vous avez compris le fonctionnement classique d'une lootbox !\n");
        s.append("Maintentant, nous préparons l'étape 2 : le tirage SANS REMISE; Pour cela, au sein du programme\n");
        s.append("nous devons changer certaines fonctions, rajouter des pramaètres, complexifier le programme en somme\n");
        s.append("En évocant cela, on peut se demander si l'injustice de ce programme est-il vraiment dû à un choix marqueting\n");
        s.append("ou a une simple 'flemme' démocratisée...\n");
        s.append("\n");
        s.append("Si vous êtes vraiment pret, lisez la page suivante !\n");
        return s.toString();
    }

    public String texte4(){
        StringBuilder s = new StringBuilder();
        s.append("Vous venez d'essayer les boites sans remise, si vous ne l'avez toujours pas fait, essayez !\n");
        s.append("Avez vous remarqué la fréquence d'apparition plus élevée des icones plus rares ?\n");
        s.append("Maintentant, nous allons essayer de comprendre les probabilités de cette solution :\n");
        s.append("Pour éviter toutes fausses probabilités, et pouvoir obtenir les résultats les plus réalistes dans un intervale controlée\n");
        s.append("nous allons faire les calculs sur 3 cas différents :\n");
        return s.toString();
    }

    private String texte5() {
        StringBuilder s = new StringBuilder();
        s.append("Tentons de comprendre : Nous savons dorénavant le nombre totale de gains dans chaque catégorie, le nombre excessif de lancés sur une base de données\n");
        s.append("faible entraine bien évidemment la complétion de l'inventaire, tous les gains sont ainsi obtenues, ce qui nous permet\n");
        s.append("de compter le nombre d'éléments et d'obtenir la véritable intervale de chaque evenement !\n");
        s.append("Les probabilités sont simples quand ce n'est qu'addition et pourcentage !\n");
        s.append("\n");
        s.append("Ce système est déjà plus juste que l'ancien (avec remise) car l'intervale de gains ne va plus entre [Gain 1;infini[\n");
        s.append("mais plutôt [Gain 1;nombre_élément_total[, avec une somme d'argent précise, on est capable d'obtenir tous les gains !\n");
        s.append("Voyons à la page suivante comment suivre un certaine logique pour gagner le maximun de gains avec peu de dépenses !\n");
        s.append("Pour cela, lisez la page suivante !\n");
        s.append("\n");
        return s.toString();
    }

    private String texte6() {
        StringBuilder s = new StringBuilder();
        s.append("Comment exploiter le système de façon logique et efficasse ? Comment obtenir tous les gains en dépensant peu ?\n");
        s.append("Il suffit d'un peu de logique : La boite en Bois couvre TOUS les gains des types Commun, Moyen, Rare, et Epic; ainsi, il suffit\n");
        s.append("de profiter de son faible cout pour tout obtenir et ensuite passer à la Lootbox en Metal pour économiser un maximun !\n");
        s.append("\n");
        s.append("Avec cette méthode, le cout en coins s'élève donc a :\n");
        s.append("100 * (25 + 25 + 34 + 25) + 600 * (25) = 10900 + 15000 = 25900 coins\n");
        s.append("25900 coins < 9000 * 3 = 150 $ --> c'est la façon la plus économique de tous obtenir en prenant en compte le prix avantageux de \n");
        s.append("certaines conversions.\n");
        s.append("\n");
        s.append("Resituons, nous avons déduis qu'il était plus judicieux de récupérer tous les communs, moyens, rares et epics avec la \n");
        s.append("boite en bois, et ainsi, de pouvoir accéder à tous les légendaires avec la boite en métal, nous garantissant ainsi une dépense minimale\n");
        s.append("Mais ce sytème a ses limites, ce petit tour de passe-passe logique fonctionne que dans un système de lootbox à faible base de données\n");
        s.append("et dont les possibles gains de chaque lootbox sont repartis comme sur notre exemple\n");
        s.append("\n");
        s.append("Prenez le cas où la base de gains est IMMENSE, cela ne vaut pas le coup de dépenser une quantité astronomique d'argent pour pouvoir ensuite\n");
        s.append("vous assurer les gains légendaires à bas prix. Les joueurs visent avant tous des objets précis, annoncé dans les publicités, dans des petites banières\n");
        s.append("que le jeu, ou le site, a soigneusement placée pour alimenter notre faim de gains.\n");
        s.append("\n");
        s.append("Les instances de jeux ont finit par améliorer leur système en octroyant des gains uniques et temporaires à certaines lootboxs, insitant les\n");
        s.append("joueurs a se ruer sur une caisse precise pour espérer obenir un objet que peu auront.\n");
        s.append("Ses évenements destabilisent les probabilités, les rendant plus flou, moins sensé.\n");
        s.append("\n");
        s.append("Conclusion : cette technique de 'partage de gains' dans un système de lootbox sans remise augmente les chances d'otenir un légendaire\n");
        s.append("car les intervalles de gains ne tendent plus vers l'infini, mais plutot vers les limites du nombre d'éléments obtenables pour chaque lootbox\n");
        s.append("Cependant, même si un peu de logique peut nous aider, dans un système classique avec une base de données énorme, elle reste tres peu efficasse\n");
        s.append("\n");
        s.append("On pourrait se demander si cette idée de lootbox sans remise est vraiment utile, ou juste de la poudre aux yeux\n");
        s.append("'Overwatch', un jeu populaire, a passé ses lootbox en mode 'sans remise', mais vu le nombre immense de gains possibles,\n");
        s.append("n'est-ce pas une tentative d'insiter les joueurs à tenter leur chance en leur promettant de meilleurs fausses probabilités ?\n");
        s.append("\n");
        s.append("Dans la page suivante, nous allons tenter de trouver d'autres solutions pour rendre le tout réellement plus juste\n");
        s.append("Si vous êtes vraiment pret, lisez la page suivante !\n");
        return s.toString();
    }

    public VBox texte7(){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        StringBuilder s = new StringBuilder();
        s.append("Commençons tout d'abord avec une idée : Dans la page précédente, nous avons compris que dans un petit univers, le 'sans remise' permet d'obtenir des gains\n");
        s.append("plus rares, tout ce qu'on aime ! Mais les fortes bases de données posaient problème, alors tentons de rectifier cela.\n");
        s.append("Pourquoi ne pas augmenter les probabilités des evenements plus rares au fur et à mesure des ouvertures ?\n");
        s.append("Par exemple, reprenons les probabilités de la boite en métal :\n");
        s.append("Metal : Commun --> 50% ; Moyen --> 25% ; Rare --> 12%>.>11% ; Epic --> 10% ; Legendaire --> 3%\n");
        vBox.getChildren().add(new Label(s.toString()));
        Monde monde = new Monde();
        Boite boite = new Boite();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        boite.setCompt(new Compteur(1500,800,400,300,100));
        VueCompteur vueC1 = new VueCompteur(monde,boite);
        hBox.getChildren().addAll(new Label("Immaginons le compteur suivant\n"),vueC1) ;
        vBox.getChildren().add(hBox);
        StringBuilder s1 = new StringBuilder();
        s1.append("A partir de là, on pourrait augmenter légèrement les probabilités des evenements rare, épic et légendaire ainsi par exemple !\n");
        s1.append("Metal : Commun --> 45% ; Moyen --> 23% ; Rare --> 14% ; Epic --> 12% ; Legendaire --> 7%\n");
        vBox.getChildren().add(new Label(s1.toString()));
        Monde monde1 = new Monde();
        Boite boite1 = new Boite();
        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(20);
        boite1.setCompt(new Compteur(2400,1400,900,750,450));
        VueCompteur vueC2 = new VueCompteur(monde1,boite1);
        hBox1.getChildren().addAll(new Label("Voici un exemple de compteur \nque l'on obtiendrait\n"),vueC2);
        vBox.getChildren().add(hBox1);
        StringBuilder s2 = new StringBuilder();
        s2.append("Les probabilités modifiées au fir et à mesure des gains, ajoutés au tirage sans remise, rendent le tout plus juste\n");
        s2.append("en récompensant de plus en plus les acheteurs. Mais le plus juste ne serait pas tout simplement de pouvoir gagner ses objets sans argent,\n");
        s1.append("et sans avoir besoin de passer 123 ans sur un jeu à faible gain de coins ?\n");
        vBox.getChildren().add(new Label(s2.toString()));
        return vBox;
    }

}
