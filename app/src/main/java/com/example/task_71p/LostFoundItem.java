package com.example.task_71p;

/**
 * Represents a lost/found post
 */
public class LostFoundItem {
    private final String name;
    private final String phone;
    private final String description;
    private final String date;
    private final String location;

    public LostFoundItem(String name, String phone, String description, String date, String location) {
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
