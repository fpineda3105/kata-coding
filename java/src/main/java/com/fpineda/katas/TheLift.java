package com.fpineda.katas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class TheLift {

    static enum Direction {
        UPWARD, DOWNWARD
    }

    static class FloorQueue {
        private Queue<Integer> people;

        FloorQueue() {
            people = new ArrayDeque<>();
        }

        public void addPeople(int destinationFloor) {
            people.add(destinationFloor);
        }

        public boolean hasPeopleWaiting() {
            return people != null && !people.isEmpty();
        }

        public Queue<Integer> getPeopleWaiting() {
            return people;
        }

    }

    static class QueueManager {

        private SortedMap<Integer, FloorQueue> upwardStops;
        private SortedMap<Integer, FloorQueue> downwardStops;

        QueueManager() {
            this.upwardStops = new TreeMap<Integer, FloorQueue>();
            this.downwardStops = new TreeMap<Integer, FloorQueue>(Collections.reverseOrder());

        }

        public void initialize(final int[][] queues) {
            for (int i = 0; i < queues.length; i++) {
                for (int j = 0; j < queues[i].length; j++) {
                    if (queues[i][j] > i) {
                        addPeopleGoingUpward(i, queues[i][j]);
                    } else {
                        addPeopleGoingDownward(i, queues[i][j]);
                    }
                }
            }
        }

        public void addPeopleGoingUpward(int sourceFloor, int personDestination) {
            upwardStops.computeIfAbsent(sourceFloor, k -> new FloorQueue());
            upwardStops.get(sourceFloor).addPeople(personDestination);
        }

        public void addPeopleGoingDownward(int sourceFloor, int destinationFloor) {
            downwardStops.computeIfAbsent(sourceFloor, k -> new FloorQueue());
            downwardStops.get(sourceFloor).addPeople(destinationFloor);
        }

        public boolean hasUpwardStops() {
            return !upwardStops.isEmpty();
        }

        public boolean hasDownwardStops() {
            return !downwardStops.isEmpty();
        }

        public int mostHigherDownStop() {
            return downwardStops.firstKey();
        }

        public boolean hasMoreStopsGoingDownFrom(int floorId) {
            return !downwardStops.tailMap(floorId).isEmpty()
                    || !upwardStops.headMap(floorId).isEmpty();
        }

        public boolean hasMoreStopsGoingUpFrom(int currentFloor) {
            return !upwardStops.tailMap(currentFloor).isEmpty()
                    || !downwardStops.headMap(currentFloor).isEmpty();
        }

        public Queue<Integer> peopleGoingUpFrom(int floorId) {
            return upwardStops.containsKey(floorId) ? upwardStops.get(floorId).getPeopleWaiting()
                    : null;
        }

        public Queue<Integer> peopleGoingDownFrom(int floorId) {
            return downwardStops.containsKey(floorId)
                    ? downwardStops.get(floorId).getPeopleWaiting()
                    : null;
        }

        public void updateQueueIn(int floorId) {
            if (upwardStops.containsKey(floorId) && !upwardStops.get(floorId).hasPeopleWaiting()) {
                upwardStops.remove(floorId);
            }
            if (downwardStops.containsKey(floorId)
                    && !downwardStops.get(floorId).hasPeopleWaiting()) {
                downwardStops.remove(floorId);
            }
        }

        public int nextUpwardStopFromOrDefault(final int floorId, final Direction direction,
                final int defaultStop) {
            if (Direction.UPWARD == direction) {
                var upwardRemaingStops = upwardStops.tailMap(floorId);
                if (!upwardRemaingStops.isEmpty()) {
                    return upwardRemaingStops.firstKey();
                }
            } else {
                var upwardRemaingStops = upwardStops.headMap(floorId);
                if (!upwardRemaingStops.isEmpty()) {
                    return upwardRemaingStops.firstKey();
                }
            }
            return defaultStop;
        }

        public int nextDownwardStopFromOrDefault(final int floorId, final Direction direction,
                final int defaultStop) {
            if (direction == Direction.UPWARD) {
                var downwardRemaingStops = downwardStops.headMap(floorId);
                if (!downwardRemaingStops.isEmpty()) {
                    return downwardRemaingStops.firstKey();
                }
            } else {
                var downwardRemaingStops = downwardStops.tailMap(floorId);
                if (!downwardRemaingStops.isEmpty()) {
                    return downwardRemaingStops.firstKey();
                }
            }
            return defaultStop;
        }

        public boolean hasMoreQueues() {
            return hasUpwardStops() || hasDownwardStops();
        }

    }

    static class Lift {
        private int capacity;
        private int currentFloor;
        private int lastFloor;
        private List<Integer> floorsVisited;
        private QueueManager queueManager;

        Direction direction;
        int countPassengers;

        int[] passengers;

        Lift(int capacity) {
            this.queueManager = new QueueManager();
            this.capacity = capacity;
            this.currentFloor = 0;
            this.countPassengers = 0;
            this.direction = Direction.UPWARD;
            this.floorsVisited = new ArrayList<>();
        }

        public void initialize(final int[][] queues) {
            lastFloor = queues.length - 1;
            this.passengers = new int[queues.length];

            queueManager.initialize(queues);
            if (!queueManager.hasUpwardStops()) {
                floorsVisited.add(currentFloor);
                updateToHigherStopFloor();
            }
        }

        private void updateToHigherStopFloor() {
            if (!queueManager.hasUpwardStops() && queueManager.hasDownwardStops()) {
                currentFloor = queueManager.mostHigherDownStop();
                direction = Direction.DOWNWARD;
            }
        }

        private boolean hasMoreTravels() {
            return hasPassengersOnBoard() || queueManager.hasMoreQueues();
        }

        private void addCurrentFloorVisited() {
            floorsVisited.add(currentFloor);
        }

        public void run() {
            while (hasMoreTravels()) {
                addCurrentFloorVisited();
                landPassengers();
                updateDirection();
                mountPassengers();
                updateCurrentStop();
                updateCurrentFloor();
            }
            if (floorsVisited.get(floorsVisited.size() - 1) > 0) {
                this.floorsVisited.add(0);
            }
        }

        private void landPassengers() {
            var landingPassengers = passengers[currentFloor];
            if (landingPassengers > 0) {
                countPassengers -= landingPassengers;
                passengers[currentFloor] = 0;
            }
        }

        private void mountPassengers() {
            Queue<Integer> persons;
            if (direction == Direction.UPWARD) {
                persons = queueManager.peopleGoingUpFrom(currentFloor);
            } else {
                persons = queueManager.peopleGoingDownFrom(currentFloor);
            }
            if (persons != null) {
                int rightQuantity = Math.min(capacity - countPassengers, persons.size());
                IntStream.range(0, rightQuantity).forEach(ignored -> {
                    addPassanger(persons.poll());
                });
            }
        }

        private void updateCurrentStop() {
            queueManager.updateQueueIn(currentFloor);
        }

        private void updateCurrentFloor() {
            if (!queueManager.hasUpwardStops() && !hasPassengersOnBoard()) {
                updateToHigherStopFloor();
                return;
            }
            if (direction == Direction.UPWARD) {
                currentFloor = nextFloorGoingUpward();
            } else {
                currentFloor = nextFloorGoingDownward();
            }
        }

        private int nextFloorGoingUpward() {
            if (hasPassengersOnBoard()) {
                int nextFloorDefault = nextUpwardPassengerStopFromCurrent();
                return Math.min(queueManager.nextUpwardStopFromOrDefault(currentFloor + 1,
                        direction, nextFloorDefault), nextFloorDefault);

            } else {
                int nextFloorDefault =
                        queueManager.nextDownwardStopFromOrDefault(currentFloor, direction, 0);
                return queueManager.nextUpwardStopFromOrDefault(currentFloor + 1, direction,
                        nextFloorDefault);
            }
        }

        private int nextFloorGoingDownward() {
            if (hasPassengersOnBoard()) {
                int defaultNextFloor = 0;
                return Math.max(queueManager.nextDownwardStopFromOrDefault(currentFloor - 1,
                        direction, defaultNextFloor), nextDownwardPassengerStop());

            } else {
                int defaultNextFloor =
                        queueManager.nextUpwardStopFromOrDefault(currentFloor, direction, 0);
                return queueManager.nextDownwardStopFromOrDefault(currentFloor - 1, direction,
                        defaultNextFloor);
            }
        }

        private boolean hasPassengersOnBoard() {
            return countPassengers > 0;
        }

        private int nextUpwardPassengerStopFromCurrent() {
            for (int i = currentFloor + 1; i < passengers.length; i++) {
                if (passengers[i] > 0) {
                    return i;
                }
            }
            return 0;
        }

        private int nextDownwardPassengerStop() {
            for (int i = currentFloor - 1; i >= 0; i--) {
                if (passengers[i] > 0) {
                    return i;
                }
            }
            return 0;
        }

        private void updateDirection() {

            if (hasPassengersOnBoard()) {
                return;
            }
            if (currentFloor == 0) {
                direction = Direction.UPWARD;
                return;
            }
            if (currentFloor == lastFloor) {
                direction = Direction.DOWNWARD;
                return;
            }
            if (Direction.DOWNWARD == direction
                    && !queueManager.hasMoreStopsGoingDownFrom(currentFloor)) {
                direction = Direction.UPWARD;
                return;
            }
            if (!queueManager.hasMoreStopsGoingUpFrom(currentFloor)) {
                direction = Direction.DOWNWARD;
            }
        }

        public void addPassanger(int passengerFloor) {
            passengers[passengerFloor] += 1;
            countPassengers++;
        }

        public List<Integer> getFloorsVisited() {
            return this.floorsVisited;
        }

    }

    public static int[] theLift(final int[][] queues, final int capacity) {
        var lift = new Lift(capacity);
        lift.initialize(queues);

        lift.run();

        return lift.getFloorsVisited().stream().mapToInt(i -> i).toArray();
    }

}
