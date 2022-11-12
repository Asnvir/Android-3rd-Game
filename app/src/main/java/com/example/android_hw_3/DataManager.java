package com.example.android_hw_3;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item()
                .setName("Facebook")
                .setImageRes(R.drawable.img_facebook)
                .setScore(10));

        items.add(new Item()
                .setName("Firefox")
                .setImageRes(R.drawable.img_firefox)
                .setScore(10));

        items.add(new Item()
                .setName("Google Play")
                .setImageRes(R.drawable.img_google_play)
                .setScore(10));

        items.add(new Item()
                .setName("NPM")
                .setImageRes(R.drawable.img_npm)
                .setScore(10));

        items.add(new Item()
                .setName("Safari")
                .setImageRes(R.drawable.img_safari)
                .setScore(10));

        items.add(new Item()
                .setName("Steam")
                .setImageRes(R.drawable.img_steam)
                .setScore(10));

        items.add(new Item()
                .setName("Twitch")
                .setImageRes(R.drawable.img_twitch)
                .setScore(10));

        items.add(new Item()
                .setName("Viber")
                .setImageRes(R.drawable.img_viber)
                .setScore(10));

        items.add(new Item()
                .setName("Whatsapp")
                .setImageRes(R.drawable.img_whatsapp)
                .setScore(10));

        items.add(new Item()
                .setName("Youtube Music")
                .setImageRes(R.drawable.img_youtube_music)
                .setScore(10));


        return items;

    }
}


