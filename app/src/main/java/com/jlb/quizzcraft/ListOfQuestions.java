package com.jlb.quizzcraft;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfQuestions {

    // Liste des Questions/Réponses
    private static ArrayList<QA> list = new ArrayList<QA>();

    // Profondeur de la liste des questions déjà posées
    private static final int LAST_QA_DEEP = 10;

    // Liste avec les dernières questions posées
    private static List mLastQa = new LinkedList();

    public ListOfQuestions(int pLevel) {
        // Template :   list.add(new QA("<question>", "<réponse_1>", "<réponse_2>", "<réponse_3>", "<réponse_4>",  numéro_bonne_réponse, "image"))
        // list.add(new QA("", "", "", "", "", , "" ));
        list.clear();
        list.add(new QA("Combien de blocs peut pousser un piston (sans slime) ?", "4", "8", "10", "12", 4, "piston", 1));
        list.add(new QA("Combien de blocs font de la lumière ?", "6", "7", "9", "11", 1, "bloc_lumineux", 2));
        list.add(new QA("Quel est le vrai nom du développeur de Minecraft ?", "Bill Gates", "Steve Jobs", "Jens Bergensten", "Donald Trump", 3, "createur_minecraft",1));
        list.add(new QA("Minecraft est un jeu...", "américain", "suèdois", "français", "autrichien", 2, "drapeaux",0));
        list.add(new QA("Minecraft a été créé en quelle année ?", "1998", "2007", "2009", "2012", 3, "calendrier",1));
        list.add(new QA("Combien de blocs peuvent activer un levier sans répéteur ?", "15", "16", "19", "20", 1, "levier",0));
        list.add(new QA("Combien coûte une enclume en lingots de fer ?", "27", "30", "31", "41", 3, "enclume",0));
        list.add(new QA("En quelle année est né Notch ?", "1969", "1972", "1975", "1989", 2, "notch",2));
        list.add(new QA("Quelle est la date de création de Minecraft ?", "8 mai 2009", "9 mai 2009", "10 mai 2009", "11 mai 2009", 3, "gateau_minecraft",2));
        list.add(new QA("Combien le petit cube de magma fait-il de dégats ?", "1", "2", "3", "4", 3, "bloc_magma",1));
        list.add(new QA("Combien de points de vie a une sorcière ?", "10", "16", "20", "26", 4, "sorciere",1));
        list.add(new QA("Quel est le nom de la musique de Minecraft ?", "X234", "D786", "C418", "P516", 3, "musique",2));
        list.add(new QA("Qui a fait découvrir Minecraft avec son tutoriel ?", "Thefantasio974", "BobLennon", "FuriousJumper", "Biloulette", 1, "youtuber",0));
        list.add(new QA("Quel est le bloc le plus utile dans minecraft ?", " Le bois (Bouleau, Pin, Sapin,chêne,acacia)", "Diamant", "Emeraude", "Eponge", 1, "inventaire",0));
        list.add(new QA("Combien y a-t-il de dimensions dans Minecraft ?", "1", "2", "3", "4", 3, "end",0));
        list.add(new QA("Combien de blocs peuvent faire glisser les mobs ?", "1", "2", "3", "4", 2, "glace",1));
        list.add(new QA("Comment s'appelle le bloc qui permet de faire bouger les blocs et les entités ?", "T.N.T", "Piston", "Glace", "Redstone", 2, "blocs",0));
        list.add(new QA("Quel est le bloc invincible du jeu ?", "Le bois (bûche)", "L'obsidienne", "La fenêtre", "La bedrock", 4, "blocks",1));
        list.add(new QA("Combien y a-t-il de mob dans le nether de Minecraft 1.9 ?", "6", "8", "5", "4", 1, "nether",1));
        list.add(new QA("Quel est le portail ci-dessous ?", "enfer", "paradis", "nether", "aether", 3, "netherportal",0));
        list.add(new QA("Quel est le nom de cette entité ?", "Herobrine", "Notch", "jeb", "Jeb_", 1, "herobrine",2));
        list.add(new QA("Quel est l'item que les villageois adorent", "Diamand", "Or", "LapisLazuli", "Emeraud", 4, "pnj",1));
        list.add(new QA("Quel est le nombre d'armures ?", "6", "4", "5", "2", 3, "armure",0));
        list.add(new QA("Est-ce que dans Minecraft il y a <b>des</b> arcs ", "oui", "je sais pas", "peut-être", "non", 4, "arc",1));
        list.add(new QA("Est-ce que dans Minecraft il y a des armes a feux ?", "euh", "je sais pas", "bien-sûr", "non", 4, "arm",1));
        list.add(new QA("Quel est le texture pack et quel youtubeur y figure ?", "fufu et BDcraft", "Fi0nita et faithful", "fufu et truc", "fanta et boisson", 1, "gun",2));
        list.add(new QA("Combien y a-t-il de zombies", "1", "2", "3", "4", 3, "zombie",1));
        list.add(new QA("Combien y a-t-il de pigs (cochons) ?", "1", "2", "3", "4", 2, "pig",0));
        list.add(new QA("Par qui a été créé 'minecraft-news' ?", "Furious jumper", "Fi0nita", "Oxilac", "Mario", 1, "news",1));
        list.add(new QA("Quel est le MOB qui a le plus de coeurs ?", "l'enderman", "l'araignée", "golem de fer", "le wither", 3, "mc",2));
        list.add(new QA("Quel est le mob/boss qui n'existe pas dans Minecraft ?", "le wither", "l'endergirl", "la mooshroom", "killer bunny", 2, "mod",1));
        list.add(new QA("Qui a créé la musique de Minecraft ?", "notch", "jeb", "jeb_", "rosenfeld", 4, "disc",2));
        list.add(new QA("Combien y a-t-il de modes de jeu ?", "2", "7", "5", "4",3 , "mode",0));
        list.add(new QA("Début juin 2016, Notch dit sur Twitter que Minecraft est à ... de vente .", "10 millions ", "100 millions", "1 million", "75 millions", 2, "twitter",2));
        list.add(new QA("Combien de lignes de texte peut-on écrire sur une pancarte ?", "2", "4", "3", "1",2 , "sign",1 ));
        list.add(new QA("Est-ce qu'une éponge peut absorber de la lave ?", "peut-être", "non", "parfois", "sûrement",2 , "bobsponge",0 ));
        list.add(new QA("Le Creeper était à la base :", "quelque chose", "un cochon", "un homme-cochon", "un pig-men", 2, "creeper",2 ));
        list.add(new QA("Comment s'appelle l'ennemi ci-dessous ?", "ghast", "ghost", "ghist", "ghaist",1 , "ghast",0 ));
        list.add(new QA("Quel est le personnage de base ?", "steve", "alex", "axel", "stevi",1 , "steve",0 ));
        list.add(new QA("Comment s'appelle le mob ci-dessous ?", "shulker", "sulcer", "seulkeur", "shulkeur", 1, "shulker",1 ));
        list.add(new QA("Comment s'appelle le boss de fin ?", "Wither", "Dragon", "EnderDragon", "EnderMan", 3, "ender",1 ));
        list.add(new QA("Est-ce que ce bloc existe sans mod ?", "je sais pas", "non", "sûrement", "oui", 4, "structureblock",2 ));
        list.add(new QA("Comment s'appelait Minecraft à l'origine ?", "Minecraft", "Cavegame", "Creativers", "Trove", 2, "mc2",2 ));
        list.add(new QA("Quels animaux fournissent du cuir ?", "cheval et vache", "cheval et cochon", "vache et mouton", "creeper", 1, "cuir",0 ));
        list.add(new QA("Combien a-t-on de place dans l'inventaire (inventaire, armure et main gauche) ?", "2", "4", "36", "41",4 , "chest",1 ));
        list.add(new QA("L'enderman peut se tp a maximum combien de blocks ?", "6", "12", "18", "24", 4, "enderman",2 ));
        list.add(new QA("Combien y a-t-il d'arbres dans Minecraft ?", "5", "6", "7", "8",1 , "arbre",0 ));
        list.add(new QA("Comment s'appellle le cochon dans Minecraft Story Mode ?", "Ted", "Fluffy", "Jesse", "Reuben",4 , "cochon",1 ));
        list.add(new QA("Si un cochon se fait foudroyer que devient-il ?", "Donald-Trump", "Je sais pas", "ce qu'il veux", "pig-men", 4, "pigpig",0 ));
        list.add(new QA("D'où vient le lapin tueur ?", "D'une planète inconue", "de minecraft", "de Cearbannog", "de sicile",3 , "lapin",2 ));
        list.add(new QA("Quelle est le nom de la première version où l'ender-dragon était apparue ?", "le 9/5/2009", "1.9pre5", "1.9pre6", "1.9pre4", 4, "enderdragon",1 ));
        list.add(new QA("Combien le dragon donne en xp une fois mort ?", "10 000", "12 000", "14 000", "8000", 2, "enderdragon",2 ));
        list.add(new QA("Combien de xp donne le dragon une fois  réinvoqué après sa mort ?", "300", "400", "500", "600",2 , "drag", 1));
        list.add(new QA("Peut-on faire des ronds (balle) dans Minecraft ?", "non", "peut-être", "oui", "sûrement pas", 3, "balle",2 ));
        list.add(new QA("Une citrouille lumineuse éclaire jusqu'à combien de blocs ?", "25", "27", "29", "31", 3, "jacko",1 ));
        list.add(new QA("Une torche éclaire jusqu'à combien de blocs ?", "25", "27", "29", "31", 2, "torche",1 ));
        //list.add(new QA("", "", "", "", "", , "", ))
        //list.add(new QA("", "", "", "", "", , "", ))
        //list.add(new QA("", "", "", "", "", , "", ))

        // Filtre suivant le niveau
        for (int i = 0; i < list.size(); i++) {
            while (list.get(i).getLevel() > pLevel) {
                    list.remove(i);
                    if (i >= list.size()) break;
                }
        }

        // Debug
        Log.d("LOG", "ListOfQuestions : Nombre de questions disponibles: " + list.size());
        Log.d("LOG", "ListOfQuestions : Profondeur des dernières questions posées: " + mLastQa.size());
    }

    public static QA askQuestion() {
        int mRnd = 0;
        boolean mAlreadyChosen = false;

        do {
            mRnd = (int) (Math.random() * list.size());
            mAlreadyChosen = false;
            for (int i = 0; i < mLastQa.size(); i++) {
                if (mRnd == (int) mLastQa.get(i)) {
                    mAlreadyChosen = true;
                    break;
                }
            }

        } while (mAlreadyChosen == true);

        if (mLastQa.size() >= LAST_QA_DEEP) {
            mLastQa.remove(0);
        }

        mLastQa.add(mRnd);

        // Debug
        Log.d("LOG", "askQuestion : Question n°" + mRnd + "/" + list.size() + "; Solution : " + list.get(mRnd).getResult() + "; Niveau : " + list.get(mRnd).getLevel());

        return list.get(mRnd);
    }

    public static int getNbOfQuestions() { return list.size(); }
}

