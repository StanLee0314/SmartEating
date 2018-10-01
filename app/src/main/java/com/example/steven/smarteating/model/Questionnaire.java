package com.example.steven.smarteating.model;

/**
 * Created by steven on 10/1/2018.
 */

public class Questionnaire {
    public String questions[] = {
            "Eat at least 5 serves of vegetables every day. A serve is % cup cooked vegetables (hot chips don't count!) or 1 cup of salad.",
            "Eat at least 2 serves of fruit every day. A serve is 1 medium piece of 2 small pieces of fresh fruit, or one cup of chopped or canned fruit (no added sugar).",
            "Have at least 2 serves of reduced fat milk, yoghurt, cheese or alternatives every day (for example, 1 slice of reduced fat cheese, a small tub of reduced fat yoghurt (preferably no added sugar), 1 cup of milk or 1 cup of soy milk with added calcium).",
            "Eat mostly wholegrain cereals (such as high fibre breakfast cereal and wholemeal bread).",
            "Eat at least a small serve of lean meat of chicken (fat and/or skin cut off) or fish, or eggs or some nuts or legumes (for example, lentils, chickpeas, beans such as kidney beans or baked beans) every day.",
            "Drink plenty of water every day and limit drinks with added sugars, such as soft drinks, cordial, energy drinks and sports drinks.",
            "Limit takeaway foods such as pizzas, commercial burgers, hot chips or other deep fried foods to once a week or less.",
            "Limit store-bought cakes, muffins, pastries, pies and biscuits to once a week or less.",
            "Limit salty foods like processed meats (for example, salami and bacon), crisps and salty snacks to once a week or less, and avoic adding salt during cooking or at the table.",
            "Drink no more than 2 standard drinks containing alcohol on any one day."
    };

    public String choices[][] = {
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"}
    };

    public String correctAnswer[] = {
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes"
    };

    public String getQuestion(int a) {
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a) {
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a) {
        String choice = choices[a][1];
        return choice;
    }


    public String getCorrectAnswer(int a) {
        String answer = correctAnswer[a];
        return answer;
    }
}
