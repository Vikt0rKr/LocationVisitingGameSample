package com.victorkrivonos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "You are sitting in front of a computer drinking coffee"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small medieval-styled mansion"));
        locations.put(2, new Location(2, "You are at the top of the mountain"));
        locations.put(3, new Location(3, "You are inside a mansion, it looks like the one from the classic Resident Evil series"));
        locations.put(4, new Location(4, "You are in a valley near the waterfall"));
        locations.put(5, new Location(5, "You are in the dark forest.Is Ash Williams home? :)"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");



        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + " , ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
//            String checkedDirection = transformCommand(direction);
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }

        }



    }

//    public static String transformCommand(String command) {
//        if(command.equals("N") || command.equals("W") || command.equals("E") || command.equals("S")) {
//            return command;
//        } else {
//            String[] splittedCommand = command.split(" ");
//            for (String com : splittedCommand) {
//                if (com.toUpperCase().equals("WEST")) {
//                    command = "W";
//                } else if (com.equals("EAST")) {
//                    command = "E";
//                } else if (com.equals("SOUTH")) {
//                    command = "S";
//                } else if (com.equals("NORTH")) {
//                    command = "N";
//                } else {
//                    command = null;
//                }
//            }
//            return command;
//        }
//    }
}
