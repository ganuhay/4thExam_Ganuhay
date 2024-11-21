/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialmediaapp;

import java.util.*;

class friends {
    int userId;
    friends prev;
    friends next;
    Set<friends> friends;

    public friends(int userId) {
        this.userId = userId;
        this.friends = new HashSet<>();
    }
}

class newNode {
    friends head;
    friends tail;

    public void addUser (int userId) {
        friends newNode = new friends(userId);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public friends findUser (int userId) {
        friends current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        friends user1 = findUser (userId1);
        friends user2 = findUser (userId2);
        if (user1 != null && user2 != null) {
            user1.friends.add(user2);
            user2.friends.add(user1);
        }
    }
}

class FriendRecommendation {
    private newNode userList;

    public FriendRecommendation() {
        userList = new newNode();
    }

    public void addUser (int userId) {
        userList.addUser (userId);
    }

    public void addFriendship(int userId1, int userId2) {
        userList.addFriend(userId1, userId2);
    }

    public List<Integer> recommendFriends(int userId) {
        friends user = userList.findUser (userId);
        Set<Integer> recommendations = new HashSet<>();

        if (user != null) {
            for (friends friend : user.friends) {
                for (friends friendOfFriend : friend.friends) {
                    if (friendOfFriend.userId != userId && !user.friends.contains(friendOfFriend)) {
                        recommendations.add(friendOfFriend.userId);
                    }
                }
            }
        }

        return new ArrayList<>(recommendations);
    }
}

