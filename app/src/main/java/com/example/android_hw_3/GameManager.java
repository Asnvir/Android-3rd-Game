package com.example.android_hw_3;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Objects;

public class GameManager {
    private int score = 0;
    private int index = 0;
    private long startTime;
    private long endTime;

    private ArrayList<Item> items;

    public GameManager() {

        items = DataManager.getItems();
        setStartTime();
    }

    public int getScore() {
        return score;
    }

    private Item current() {
        return items.get(index);
    }

    public void checkAnswer(String answer) {
        if (Objects.equals(current().getName(), answer)) {
            score += current().getScore();
        }
        index++;
    }

    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    public void setEndTime() {
        endTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public boolean isEndGame() {
        return index == items.size();
    }

    public int getCurrentImg() {
        return current().getImageRes();
    }


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    public void setTextButtons(ArrayList<MaterialButton> game_BTN_answers) {

        int rightIndexBTN = getRandomNumber(0, game_BTN_answers.size());
        String textAnswer = items.get(index).getName();

        game_BTN_answers.get(rightIndexBTN).setText(textAnswer);

        ArrayList<Integer> usedItemIndexes = new ArrayList<>();
        usedItemIndexes.add(index);


        for (int indexCurrentBTN = 0; indexCurrentBTN < game_BTN_answers.size(); indexCurrentBTN++) {
            if (indexCurrentBTN == rightIndexBTN) continue;
            int randomIndexItem;
            do {
                randomIndexItem = getRandomNumber(0, items.size());
            } while (usedItemIndexes.contains(randomIndexItem));


            String currentBtnTEXT = items.get(randomIndexItem).getName();
            game_BTN_answers.get(indexCurrentBTN).setText(currentBtnTEXT);
        }
    }
}
