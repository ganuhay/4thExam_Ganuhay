/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socialmediaapp;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jezze
 */
public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        FriendRecommendation friendRecommendation = new FriendRecommendation();

        // Input number of users
        System.out.print("Enter the number of users: ");
        int numberOfUsers = scn.nextInt();

        // Adding users
        System.out.println("Enter user IDs:");
        for (int i = 0; i < numberOfUsers; i++) {
            int userId = scn.nextInt();
            friendRecommendation.addUser (userId);
        }

        // Input number of friendships
        System.out.print("Enter the number of friendships: ");
        int numberOfFriendships = scn.nextInt();

        // Adding friendships
        System.out.println("Enter friendships (userId1 userId2):");
        for (int i = 0; i < numberOfFriendships; i++) {
            int userId1 = scn.nextInt();
            int userId2 = scn.nextInt();
            friendRecommendation.addFriendship(userId1, userId2);
        }

        // Input user ID for recommendations
        System.out.print("Enter user ID for friend recommendations: ");
        int userId = scn.nextInt();

        // Get recommendations
        List<Integer> recommendedFriends = friendRecommendation.recommendFriends(userId);
        System.out.println("Recommended friends for user " + userId + ": " + recommendedFriends);

        
        scn.close();
    }
}