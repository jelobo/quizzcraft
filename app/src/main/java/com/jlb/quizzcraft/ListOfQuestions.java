package com.jlb.quizzcraft;

import java.util.ArrayList;

/**
 * Created by bobo_ on 24-10-17.
 */

public class ListOfQuestions {

    private ArrayList<QA> list = new ArrayList<QA>();

    public ListOfQuestions() {
        // Template :   list.add(new QA("<question>", "<réponse_1>", "<réponse_2>", "<réponse_3>", "<réponse_4>",  numéro_bonne_réponse), "image")
        //              list.add(new QA("", "", "", "",  "", ""));
        list.add(new QA("Combien de blocs peut pousser un piston (sans slime) ?", "4", "8", "10", "12", 4, "piston"));
        list.add(new QA("Combien de blocs font de la lumière ?", "6", "7", "9", "11", 1, "bloc_lumineux"));
        list.add(new QA("Quel est le vrai nom du développeur de Minecraft ?", "Bill Gates", "Steve Jobs", "Jens Bergensten", "Donald Trump", 3, "createur_minecraft"));
        list.add(new QA("Minecraft est un jeu...", "américain", "suèdois", "français", "autrichien", 2, "drapeaux"));
        list.add(new QA("Minecraft a été créé en quelle année ?", "1998", "2007", "2009", "2012",  2, "calendrier"));
        list.add(new QA("Combien de blocs peut activer un levier sans répéteur ?", "15", "16", "19", "20",  1, "levier"));
        list.add(new QA("Combien coûte une enclume en lingots de fer ?", "27", "30", "31", "41",  3, "enclume"));
        list.add(new QA("En quelle année est né Notch ?", "1969", "1972", "1975", "1989", 2, "notch" ));
        list.add(new QA("Quelle est la date de création de Minecraft ?", "8 mai 2009", "9 mai 2009", "10 mai 2009",  "11 mai 2009", 3, "gateau_minecraft"));
        list.add(new QA("Combien le petit cube de magma fait de dégat ?", "1", "2", "3",  "4", 3, "bloc_magma"));
        list.add(new QA("Combien de points de vie a une sorcière ?", "10", "16", "20",  "26", 4, "sorciere"));
    }

    public QA askQuestion() {
        int mRnd = (int) (Math.random() * list.size());

        return list.get(mRnd);
    }
}

