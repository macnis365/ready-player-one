package com.auto.app;

import com.auto.app.com.auto.app.characters.HumanPlayer;
import com.auto.app.com.auto.app.places.Room;
import com.auto.app.com.auto.app.tools.Item;
import com.auto.app.com.auto.app.tools.Utensil;

import java.util.Scanner;

/**
 *
 */
public class App {

    public static final String NEWLINE = "\n";

    private static final String SYSTEM_RESPONSE_DIALOGUE = "I have this options to explore";

    public static void main(String[] args) {
        System.out.println("Welcome to Ready Player One......");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your character name: ");

        Room room1 = new Room("Room1", "You Head off to Dungeon" + NEWLINE + "The dungeon door slams shut behind you. You are in a maze of twisty little passage all alike" + NEWLINE + "You see a dark doorway to the north" + NEWLINE + "A human skull lies in the corner");
        Item skull = new Utensil("Skull", "The skull appears blackened and chared. It smell of sulfur.", 10);
        room1.getArtifacts().add(skull);
        HumanPlayer player = new HumanPlayer(scanner.next());
        player.setCurrentLocation(room1);
        System.out.println(player.checkout());

        System.out.println(SYSTEM_RESPONSE_DIALOGUE);
        System.out.println("1. examine skull");
        System.out.println("2. go north");

        int optionChosen = scanner.nextInt();
        if (1 == optionChosen) {
            System.out.println("You took the skull.");
            System.out.println(player.examine(room1.getArtifacts().get(0)));
            System.out.println("Do you want to take it with you?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            optionChosen = scanner.nextInt();
            if (1 == optionChosen) {
                System.out.println("You add skull to your backpack");
            }
        }

        System.out.println("1. go north");
        System.out.println("2. examine the room.");

        optionChosen = scanner.nextInt();
        if (1 == optionChosen) {

            Room room2 = new Room("Room2", "You are in a vast, dark hall.", "There is a door to the south back to dungeon entrance." + NEWLINE + "A glowing orb floats in mid air," + NEWLINE + "In the center of the room on a raised platform there is a blackend, magic scarred altar.");
            System.out.println("You head off to the north");

            player.setCurrentLocation(room2);
            System.out.println(player.checkout());
            System.out.println("1. examine altar");
            System.out.println("2. go back to earlier visited room");
            optionChosen = scanner.nextInt();
            if (1 == optionChosen) {
                System.out.println("There is a drawing of a skull scratched into the soot on the surface of the altar.");
                System.out.println("1. use the altar");
                System.out.println("2. dont know what to do?");
                optionChosen = scanner.nextInt();
                if (1 == optionChosen) {
                    System.out.println("Suddenly, there is a deep rumbling sound. Dust fills the air.");
                    System.out.println("There is a door to the south back to the starting room.");
                    System.out.println("A secret passage has opened to the west.");
                    System.out.println("A glowing orb floats in mid air.");
                    System.out.println("In the center of the room on a raised platform there is a blackened, magic scarred altar.");

                    System.out.println("1. go steps");
                    optionChosen = scanner.nextInt();
                    if (1 == optionChosen) {
                        if (player.getBackpack().contains(new Utensil("Skull", "The skull appears blackened and chared. It smell of sulfur.", 10))) {
                            System.out.println("You walk up the steps and open the door. You are blinded by the sun in you face. You have escaped the dungeon! You are free!");
                            System.exit(0);
                        }
                        System.out.println("door is locked, i need to find keys.");
                    }
                }
            }

        }

    }

}
