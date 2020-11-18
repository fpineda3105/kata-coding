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

    static class State {
        private int capacity;
        private int currentFloor;
        private int lastFloor;
        private List<Integer> floorsVisited;

        Direction direction;
        int countPassengers;

        int[] passengers;

        State(int capacity, int lastFloor) {
            this.capacity = capacity;
            this.currentFloor = 0;
            this.countPassengers = 0;
            this.direction = Direction.UPWARD;
            this.floorsVisited = new ArrayList<>();
            this.passengers = new int[lastFloor + 1];
        }

        public void recordHistory() {
            floorsVisited.add(currentFloor);
        }        

        public void landPassengers() {
            var landingPassengers = passengers[currentFloor];
            if (landingPassengers > 0) {
                countPassengers -= landingPassengers;
                passengers[currentFloor] = 0;
            }
        }

        private int nextUpwardPassengerStopFromCurrent() {
            for (int i = currentFloor + 1; i < passengers.length; i++) {
                if (passengers[i] > 0) {
                    return i;
                }
            }
            return 0;
        }

        public void addPassanger(int passengerFloor) {
            passengers[passengerFloor] += 1;
            countPassengers++;
        }

        private int nextDownwardPassengerStop() {
            for (int i = currentFloor - 1; i >= 0; i--) {
                if (passengers[i] > 0) {
                    return i;
                }
            }
            return 0;
        }

        public boolean isFirstFloor() {
            return currentFloor == 0;
        }

        public boolean isLastFloor() {
            return currentFloor == lastFloor;
        }

        public boolean hasPassengersOnBoard() {
            return countPassengers > 0;
        }

        public boolean isGoingUpward() {
            return Direction.UPWARD == direction;
        }

        public boolean isGoingDownward() {
            return Direction.DOWNWARD == direction;
        }

        public List<Integer> getHistory() {
            return this.floorsVisited;
        }

        public int getCurrentFloor() {
            return currentFloor;
        }

        public void setCurrentFloor(int currentFloor) {
            this.currentFloor = currentFloor;
        }

        public Direction getDirection() {
            return this.direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getPassengersOnBoard() {
            return countPassengers;
        }

        public int availableSpace() {
            return capacity - countPassengers;
        }

    }

    static class Lift {

        private QueueManager queueManager;
        private State state;

        Lift(final int[][] queues, int capacity) {
            initialize(queues, capacity);
        }

        private void initialize(final int[][] queues, int capacity) {
            this.queueManager = new QueueManager();
            this.state = new State(capacity, queues.length - 1);
            queueManager.initialize(queues);

            if (!queueManager.hasUpwardStops()) {
                state.recordHistory();
                updateToHigherStopFloor();
            }
        }

        private void updateToHigherStopFloor() {
            if (!queueManager.hasUpwardStops() && queueManager.hasDownwardStops()) {
                state.setCurrentFloor(queueManager.mostHigherDownStop());
                state.setDirection(Direction.DOWNWARD);
            }
        }

        private boolean hasMoreTravels() {
            return state.hasPassengersOnBoard() || queueManager.hasMoreQueues();
        }

        public void run() {
            while (hasMoreTravels()) {  
                recordCurrentFloor();              
                landPassengers();
                updateDirection();
                mountPassengers();
                updateCurrentStop();
                updateCurrentFloor();
            }
            if (state.getHistory().get(state.getHistory().size() - 1) > 0) {
                state.setCurrentFloor(0);
                state.recordHistory();
            }
        }

        private void landPassengers() {
            state.landPassengers();
        }

        private void recordCurrentFloor() {
            state.recordHistory();
        }

        private void mountPassengers() {
            Queue<Integer> persons;
            if (state.isGoingUpward()) {
                persons = queueManager.peopleGoingUpFrom(state.getCurrentFloor());
            } else {
                persons = queueManager.peopleGoingDownFrom(state.getCurrentFloor());
            }
            if (persons != null) {
                int rightQuantity = Math.min(state.availableSpace(), persons.size());
                IntStream.range(0, rightQuantity).forEach(ignored -> {
                    state.addPassanger(persons.poll());
                });
            }
        }

        private void updateCurrentStop() {
            queueManager.updateQueueIn(state.getCurrentFloor());
        }

        private void updateCurrentFloor() {
            if (!queueManager.hasUpwardStops() && !state.hasPassengersOnBoard()) {
                updateToHigherStopFloor();
                return;
            }
            if (state.isGoingUpward()) {
                state.setCurrentFloor(nextFloorGoingUpward());
            } else {
                state.setCurrentFloor(nextFloorGoingDownward());
            }
        }

        private int nextFloorGoingUpward() {
            if (state.hasPassengersOnBoard()) {
                int nextFloorDefault = state.nextUpwardPassengerStopFromCurrent();
                return Math
                        .min(queueManager.nextUpwardStopFromOrDefault(state.getCurrentFloor() + 1,
                                state.getDirection(), nextFloorDefault), nextFloorDefault);

            } else {
                int nextFloorDefault = queueManager.nextDownwardStopFromOrDefault(
                        state.getCurrentFloor(), state.getDirection(), 0);
                return queueManager.nextUpwardStopFromOrDefault(state.getCurrentFloor() + 1,
                        state.getDirection(), nextFloorDefault);
            }
        }

        private int nextFloorGoingDownward() {
            if (state.hasPassengersOnBoard()) {
                int defaultNextFloor = 0;
                return Math.max(
                        queueManager.nextDownwardStopFromOrDefault(state.getCurrentFloor() - 1,
                                state.getDirection(), defaultNextFloor),
                        state.nextDownwardPassengerStop());

            } else {
                int defaultNextFloor = queueManager.nextUpwardStopFromOrDefault(
                        state.getCurrentFloor(), state.getDirection(), 0);
                return queueManager.nextDownwardStopFromOrDefault(state.getCurrentFloor() - 1,
                        state.getDirection(), defaultNextFloor);
            }
        }

        private void updateDirection() {

            if (state.hasPassengersOnBoard()) {
                return;
            }
            if (state.isFirstFloor()) {
                state.setDirection(Direction.UPWARD);
                return;
            }
            if (state.isLastFloor()) {
                state.setDirection(Direction.DOWNWARD);
                return;
            }
            if (state.isGoingDownward()
                    && !queueManager.hasMoreStopsGoingDownFrom(state.getCurrentFloor())) {
                state.setDirection(Direction.UPWARD);
                return;
            }
            if (!queueManager.hasMoreStopsGoingUpFrom(state.getCurrentFloor())) {
                state.setDirection(Direction.DOWNWARD);
            }
        }

        

        public List<Integer> getHistory() {
            return state.getHistory();
        }

    }

    public static int[] theLift(final int[][] queues, final int capacity) {
        var lift = new Lift(queues,capacity);        

        lift.run();

        return lift.getHistory().stream().mapToInt(i -> i).toArray();
    }

}
