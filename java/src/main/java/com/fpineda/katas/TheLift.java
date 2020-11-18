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

    static class Lift {
        private int capacity;
        private int currentFloor;
        private int lastFloor;
        private List<Integer> floorsVisited;
        private SortedMap<Integer, Queue<Integer>> upStops;
        private SortedMap<Integer, Queue<Integer>> downStops;

        enum Direction {
            UPWARD, DOWNWARD
        }

        Direction direction;
        int countPassengers;

        int[] passengers;

        Lift(int capacity) {
            this.capacity = capacity;
            this.currentFloor = 0;
            this.countPassengers = 0;
            this.direction = Direction.UPWARD;
            this.floorsVisited = new ArrayList<>();
            this.upStops = new TreeMap<Integer, Queue<Integer>>();
            this.downStops = new TreeMap<Integer, Queue<Integer>>(Collections.reverseOrder());
        }

        public void initialize(final int[][] queues) {
            lastFloor = queues.length - 1;
            this.passengers = new int[queues.length];
            for (int i = 0; i < queues.length; i++) {
                for (int j = 0; j < queues[i].length; j++) {
                    if (queues[i][j] > i) {
                        addUpStop(i, queues[i][j]);
                    } else {
                        addDownStop(i, queues[i][j]);
                    }
                }
            }
            if (!hasUpwardTravels()) {
                floorsVisited.add(currentFloor);
                updateUpwardsTravels();
            }
        }

        private boolean hasUpwardTravels() {
            return upStops.size() > 0;
        }

        private boolean hasDownwardTravels() {
            return downStops.size() > 0;
        }

        private void updateUpwardsTravels() {
            if (!hasUpwardTravels() && hasDownwardTravels()) {
                currentFloor = downStops.firstKey();
                direction = Direction.DOWNWARD;
            }
        }

        private boolean hasMoreTravels() {
            return upStops.size() > 0 || downStops.size() > 0 || hasPassengersOnBoard();
        }

        public void run() {
            while (hasMoreTravels()) {

                floorsVisited.add(currentFloor);

                landPassengers();
                updateDirection();
                if (Direction.UPWARD.equals(direction)) {
                    mountPassengers(upStops);
                    updateStopsIn(upStops, currentFloor);
                } else {
                    mountPassengers(downStops);
                    updateStopsIn(downStops, currentFloor);
                }
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

        private void mountPassengers(final SortedMap<Integer, Queue<Integer>> stops) {
            var persons = stops.get(currentFloor);
            if (persons != null) {
                var available = Math.min(capacity - countPassengers, persons.size());
                IntStream.range(0, available).forEach(val -> {
                    addPassanger(persons.poll());
                });
            }
        }

        private void updateStopsIn(final SortedMap<Integer, Queue<Integer>> stops, int floor) {
            if (stops.containsKey(floor) && stops.get(floor).size() == 0) {
                stops.remove(floor);
            }
        }

        private void updateCurrentFloor() {
            if (!hasUpwardTravels() && !hasPassengersOnBoard()) {
                updateUpwardsTravels();
                return;
            }
            if (direction == Direction.UPWARD) {
                if (hasPassengersOnBoard()) {
                    currentFloor =
                            Math.min(nextUpwardStopFromOrDefault(upStops.tailMap(currentFloor + 1),
                                    nextUpwardPassengerStop()), nextUpwardPassengerStop());
                } else {
                    currentFloor = nextUpwardStopFromOrDefault(upStops.tailMap(currentFloor + 1),
                            nextDownwardStopFromOrDefault(downStops.headMap(currentFloor), 0));
                }
            } else {
                if (hasPassengersOnBoard()) {
                    currentFloor = Math.max(
                            nextDownwardStopFromOrDefault(downStops.tailMap(currentFloor - 1), 0),
                            nextDownwardPassengerStop());
                } else {
                    currentFloor =
                            nextDownwardStopFromOrDefault(downStops.tailMap(currentFloor - 1),
                                    nextUpwardStopFromOrDefault(upStops.headMap(currentFloor), 0));
                }
            }
        }

        private boolean hasPassengersOnBoard() {
            return countPassengers > 0;
        }

        private int nextUpwardPassengerStop() {
            return hasPassengersOnBoard() ? nextLowerFloor() : lastFloor;
        }

        private int nextUpwardStopFromOrDefault(final SortedMap<Integer, Queue<Integer>> stops,
                int defaultFloor) {
            return stops.size() > 0 ? stops.firstKey() : defaultFloor;
        }

        private int nextDownwardStopFromOrDefault(final SortedMap<Integer, Queue<Integer>> stops,
                int defaultFloor) {
            return stops.size() > 0 ? stops.firstKey() : defaultFloor;
        }

        private int nextDownwardPassengerStop() {
            return hasPassengersOnBoard() ? nextHighFloor() : 0;
        }

        private int nextHighFloor() {
            for (int i = currentFloor - 1; i >= 0; i--) {
                if (passengers[i] > 0) {
                    return i;
                }
            }
            return 0;
        }

        private int nextLowerFloor() {
            for (int i = currentFloor + 1; i < passengers.length; i++) {
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
            if (Direction.DOWNWARD == direction) {
                if (currentFloor == 0 || !hasMoreStopsGoingDown()) {
                    direction = Direction.UPWARD;
                }
                return;
            }
            if (currentFloor == lastFloor || !hasMoreStopsGoingUp()) {
                direction = Direction.DOWNWARD;
            }
        }

        private boolean hasMoreStopsGoingDown() {
            return hasMoreStopsFromFloor(downStops.tailMap(currentFloor))
            || hasMoreStopsFromFloor(upStops.headMap(currentFloor));
        }

        private boolean hasMoreStopsGoingUp() {
            return hasMoreStopsFromFloor(upStops.tailMap(currentFloor))
                    || hasMoreStopsFromFloor(downStops.headMap(currentFloor));
        }

        private boolean hasMoreStopsFromFloor(final SortedMap<Integer, Queue<Integer>> stops) {
            return hasPassengersOnBoard() || stops.size() > 0;
        }

        public void addPassanger(int passengerFloor) {
            passengers[passengerFloor] += 1;
            countPassengers++;
        }

        public void addUpStop(int sourceFloor, int destinationFloor) {
            this.upStops.computeIfAbsent(sourceFloor, k -> new ArrayDeque<>());
            this.upStops.get(sourceFloor).add(destinationFloor);
        }

        public void addDownStop(int sourceFloor, int destinationFloor) {
            this.downStops.computeIfAbsent(sourceFloor, k -> new ArrayDeque<>());
            this.downStops.get(sourceFloor).add(destinationFloor);
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
