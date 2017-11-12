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

    public ListOfQuestions() {
        // Template :   list.add(new QA("<question>", "<réponse_1>", "<réponse_2>", "<réponse_3>", "<réponse_4>",  numéro_bonne_réponse, "image"))
        // list.add(new QA("", "", "", "", "", , "" ));
        list.clear();
        list.add(new QA("Combien de blocs peut pousser un piston (sans slime) ?", "4", "8", "10", "12", 4, "piston"));
        list.add(new QA("Combien de blocs font de la lumière ?", "6", "7", "9", "11", 1, "bloc_lumineux"));
        list.add(new QA("Quel est le vrai nom du développeur de Minecraft ?", "Bill Gates", "Steve Jobs", "Jens Bergensten", "Donald Trump", 3, "createur_minecraft"));
        list.add(new QA("Minecraft est un jeu...", "américain", "suèdois", "français", "autrichien", 2, "drapeaux"));
        list.add(new QA("Minecraft a été créé en quelle année ?", "1998", "2007", "2009", "2012", 3, "calendrier"));
        list.add(new QA("Combien de blocs peuvent activer un levier sans répéteur ?", "15", "16", "19", "20", 1, "levier"));
        list.add(new QA("Combien coûte une enclume en lingots de fer ?", "27", "30", "31", "41", 3, "enclume"));
        list.add(new QA("En quelle année est né Notch ?", "1969", "1972", "1975", "1989", 2, "notch"));
        list.add(new QA("Quelle est la date de création de Minecraft ?", "8 mai 2009", "9 mai 2009", "10 mai 2009", "11 mai 2009", 3, "gateau_minecraft"));
        list.add(new QA("Combien le petit cube de magma fait-il de dégats ?", "1", "2", "3", "4", 3, "bloc_magma"));
        list.add(new QA("Combien de points de vie a une sorcière ?", "10", "16", "20", "26", 4, "sorciere"));
        list.add(new QA("Quel est le nom de la musique de Minecraft ?", "X234", "D786", "C418", "P516", 3, "musique"));
        list.add(new QA("Qui a fait découvrir Minecraft avec son tutoriel ?", "Thefantasio974", "BobLennon", "FuriousJumper", "Biloulette", 1, "youtuber"));
        list.add(new QA("Quel est le bloc le plus utile dans minecraft ?", " Le bois (Bouleau, Pin, Sapin,chêne,acacia)", "Diamant", "Emeraude", "Eponge", 1, "inventaire"));
        list.add(new QA("Combien y a-t-il de dimensions dans Minecraft ?", "1", "2", "3", "4", 3, "end"));
        list.add(new QA("Combien de blocs peuvent faire glisser les mobs ?", "1", "2", "3", "4", 2, "glace"));
        list.add(new QA("Comment s'appelle le bloc qui permet de faire bouger les blocs et les entités ?", "T.N.T", "Piston", "Glace", "Redstone", 2, "blocs"));
        list.add(new QA("Quel est le bloc invincible du jeu ?", "Le bois (bûche)", "L'obsidienne", "La fenêtre", "La bedrock", 4, "blocks"));
        list.add(new QA("Combien y a-t-il de mob dans le nether de Minecraft 1.9 ?", "6", "8", "5", "4", 1, "nether"));
        list.add(new QA("Quel est le portail ci-dessous ?", "enfer", "paradis", "nether", "aether", 3, "netherportal"));
        list.add(new QA("Quel est le nom de cette entité ?", "Herobrine", "Notch", "jeb", "Jeb_", 1, "herobrine"));
        list.add(new QA("Quel est l'item que les villageois adorent", "Diamand", "Or", "LapisLazuli", "Emeraud", 4, "pnj"));
        list.add(new QA("Quel est le nombre d'armures ?", "6", "4", "5", "2", 3, "armure"));
        list.add(new QA("Est-ce que dans Minecraft il y a <b>des</b> arcs ", "oui", "je sais pas", "peut-être", "non", 4, "arc"));
        list.add(new QA("Est-ce que dans Minecraft il y a des armes a feux ?", "euh", "je sais pas", "bien-sûr", "non", 4, "arm"));
        list.add(new QA("Quel est le texture pack et quel youtubeur est dessus ?", "fufu et BDcraft", "Fi0nita et faithful", "fufu et truc", "fanta et boisson", 1, "gun"));
        list.add(new QA("Combien y a-t-il de zombies", "1", "2", "3", "4", 3, "zombie"));
        list.add(new QA("Combien y a-t-il de pigs (cochons) ?", "1", "2", "3", "4", 2, "pig"));
        list.add(new QA("Par qui a été créé 'minecraft-news' ?", "Furious jumper", "Fi0nita", "Oxilac", "Mario", 1, "news"));
        list.add(new QA("Quel est le MOB qui a le plus de coeurs ?", "l'enderman", "l'araignée", "golem de fer", "le wither", 3, "mc"));
        list.add(new QA("Quel est le mob/boss qui n'existe pas dans Minecraft ?", "le wither", "l'endergirl", "la mooshroom", "killer bunny", 2, "mod"));
        list.add(new QA("Qui a créé la musique de Minecraft ?", "notch", "jeb", "jeb_", "rosenfeld", 4, "disc"));
        list.add(new QA("Combien y a-t-il de modes de jeu ?", "2", "7", "5", "4",3 , "mode"));
        list.add(new QA("Début juin 2016, Notch dit sur Twitter que Minecraft est à ... de vente .", "10 millions ", "100 millions", "1 million", "75 millions", 2, "twitter"));
        list.add(new QA("Combien de lignes de texte peut-on écrire sur une pancarte ?", "2", "4", "3", "1",2 , "sign" ));
        list.add(new QA("Est-ce que une éponge peut absorber de la lave ?", "peut-être", "non", "parfois", "sûrement",2 , "bobsponge" ));
        list.add(new QA("Le Creeper était à la base :", "quelque chose", "un cochon", "un homme-cochon", "un pig-men", 2, "creeper" ));
        list.add(new QA("Comment s'appelle l'ennemi ci-dessous ?", "ghast", "ghost", "ghist", "ghaist",1 , "ghast" ));

        // Debug
        Log.d("ListOfQuestions", "Nombre de questions disponibles: " + list.size());
        Log.d("ListOfQuestions", "Profondeur des dernières questions posées: " + mLastQa.size());
    }

    public QA askQuestion() {
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
        Log.d("askQuestion", "Question n°" + mRnd + "; Solution : " + list.get(mRnd).getResult());

        return list.get(mRnd);
    }
}

