import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class StudyRoom {
    private int roomNumber;
    private int capacity;
    private boolean isAvailable;
    private Lock lock;

    public StudyRoom(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.isAvailable = true;
        this.lock = new ReentrantLock();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getAvailable(){
        return isAvailable? "Available" : "Unavailable";
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Lock getLock() {
        return lock;
    }
}

class StudyRoomReservationSystem {
    private List<StudyRoom> studyRooms;

    public StudyRoomReservationSystem() {
        studyRooms = new ArrayList<>();
    }

    public void addStudyRoom(StudyRoom studyRoom) {
        studyRooms.add(studyRoom);
    }

    public synchronized void reserveStudyRoom(int roomNumber) throws StudyRoomUnavailableException  {
        StudyRoom studyRoom = getStudyRoomByNumber(roomNumber);
        if (studyRoom == null) {
            throw new IllegalArgumentException("Invalid room number");
        }

        Lock lock = studyRoom.getLock();
        lock.lock();
        try {
            if (!studyRoom.isAvailable()) {
                throw new StudyRoomUnavailableException("Study room is already occupied");
            }

            studyRoom.setAvailable(false);
            // System.out.println("Study room " + roomNumber + " reserved successfully.");
        } finally {
            lock.unlock();
        }
    }

    public synchronized void releaseStudyRoom(int roomNumber) throws StudyRoomUnavailableException {
        StudyRoom studyRoom = getStudyRoomByNumber(roomNumber);
        if (studyRoom == null) {
            throw new IllegalArgumentException("Invalid room number");
        }

        Lock lock = studyRoom.getLock();
        lock.lock();
        try {
            if (studyRoom.isAvailable()) {
                throw new StudyRoomUnavailableException("Study room is already released");
            }

            studyRoom.setAvailable(true);
            // System.out.println("Study room " + roomNumber + " released successfully.");
        } finally {
            lock.unlock();
        }
    }

    public void displayStudyRoomStatus() {
        for (StudyRoom studyRoom : studyRooms) {
            System.out.println("Room Number: " + studyRoom.getRoomNumber() + ", Capacity: " + studyRoom.getCapacity() + ", Availability: " + studyRoom.getAvailable());
        }
    }

    private StudyRoom getStudyRoomByNumber(int roomNumber) {
        for (StudyRoom studyRoom : studyRooms) {
            if (studyRoom.getRoomNumber() == roomNumber) {
                return studyRoom;
            }
        }
        return null;
    }
}

class StudyRoomUnavailableException extends Exception {
    public StudyRoomUnavailableException(String message) {
        super(message);
    }
}

public class Main
{
    public static void main(String[] args) {
        // Create StudyRoom objects
        StudyRoom room1 = new StudyRoom(1, 4);
        StudyRoom room2 = new StudyRoom(2, 6);
        StudyRoom room3 = new StudyRoom(3, 8);

        // Create StudyRoomReservationSystem
        StudyRoomReservationSystem reservationSystem = new StudyRoomReservationSystem();

        // Add study rooms to the reservation system
        reservationSystem.addStudyRoom(room1);
        reservationSystem.addStudyRoom(room2);
        reservationSystem.addStudyRoom(room3);

        System.out.println("Study Room Status:");
        
        // Display initial study room status
        reservationSystem.displayStudyRoomStatus();

        // Test Case 1: Single student reserving an available study room
        try {
            reservationSystem.reserveStudyRoom(1);
        } catch (StudyRoomUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
}
}