package org.example.entity;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String taskOwner) {
        switch (taskOwner) {
            case "ann":
                return getAnnsTasks();
            case "bob":
                return getBobsTasks();
            case "carol":
                return getCarolsTasks();
            case "all":
                return getUnion(getAnnsTasks(), getBobsTasks(), getCarolsTasks());
        }
        return new HashSet<>();
    }


    public Set<Task> getUnion(Set<Task>... taskSets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : taskSets) {
            union.addAll(set);
        }
        return union;
    }
    public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2) {
        Set<Task> intersection = new HashSet<>(task1);
        intersection.retainAll(task2);
        return intersection;
    }
    public Set<Task> getDifferences(Set<Task> task1, Set<Task> task2) {
        Set<Task> difference = new HashSet<>(task1);
        difference.removeAll(task2);
        return difference;
    }
}
