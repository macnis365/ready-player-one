package com.auto.app.com.auto.app;

import com.auto.app.com.auto.app.characters.Context;
import com.auto.app.com.auto.app.characters.HumanPlayer;
import com.auto.app.com.auto.app.characters.Office;
import com.auto.app.com.auto.app.characters.Table;
import com.auto.app.com.auto.app.places.Location;
import com.auto.app.com.auto.app.places.Room;
import com.auto.app.com.auto.app.tools.Item;
import com.auto.app.com.auto.app.tools.Utensil;

import java.util.Scanner;

public class Game {

    public static final String NEWLINE = "\n";

    private static final String SYSTEM_RESPONSE_DIALOGUE = "I have this options to explore";

    public static void main(String[] args) {
        boolean flag = true;
        Context context = new Office();
        Scanner inputResource = new Scanner(System.in);
        int input;
        System.out.println("Start");

        System.out.println("Welcome to Ready Player One......");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your character name: ");
        HumanPlayer player = new HumanPlayer(scanner.next());

        createGame(player);

//        System.out.println(player.checkout());
        System.out.println(SYSTEM_RESPONSE_DIALOGUE);

        System.out.println("1. examine skull");
        System.out.println("2. go north");

//        int optionChosen = scanner.nextInt();

        while (flag) {
            context.describe();
            context.options();
            input = inputResource.nextInt();
            if (context instanceof Office) {
                if (input == 1) {
//                    list item,
                } else if (input == 2) {
//                    go back*
                } else if (input == 3) {
//                    go forword
                } else {
//                    change context
                }
            } else if (context instanceof Table) {
                if (input == 1) {
//                    select an item, change context
                } else if (input == 2) {
//                    go back change context
                }
            }
//            else individual item, 1. collect each options selected , 2. go back, change context
        }
    }

    public static void createGame(HumanPlayer player) {
        Room room1 = new Room("Room1", "You Head off to Dungeon" + NEWLINE + "The dungeon door slams shut behind you. You are in a maze of twisty little passage all alike" + NEWLINE + "You see a dark doorway to the north" + NEWLINE + "A human skull lies in the corner");
        Item skull = new Utensil("Skull", "The skull appears blackened and chared. It smell of sulfur.", 10);
        room1.getArtifacts().add(skull);
        player.setCurrentLocation(room1);

        Room room2 = new Room("Room2", "You are in a vast, dark hall.", "There is a door to the south back to dungeon entrance." + NEWLINE + "A glowing orb floats in mid air," + NEWLINE + "In the center of the room on a raised platform there is a blackend, magic scarred altar.");
//        System.out.println("You head off to the north");
        Item altar = new Utensil("Altar", "There is a drawing of a skull scratched into the soot on the surface of the altar.", 20);
        room2.getArtifacts().add(altar);
        room2.setPreviousRoom(room1);
        room1.setNextRoom(room2);

        Room room3 = new Room("room3", "Suddenly, there is a deep rumbling sound. Dust fills the air." + NEWLINE + "There is a door to the south back to the starting room." + NEWLINE + "A secret passage has opened to the west." + NEWLINE + "A glowing orb floats in mid air." + NEWLINE + "In the center of the room on a raised platform there is a blackened, magic scarred altar.");
        room2.setNextRoom(room3);
        room3.setPreviousRoom(room2);
    }
}
