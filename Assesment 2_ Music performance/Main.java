import java.util.ArrayList;


interface IBackup { //This interface is for backup
    void backup();
}

interface IRecording { //This interface is for record the perfomance
    void record();
}


abstract class Artist { //This is a abstract class for all artist
    String name;
    public Artist(String name) {
        this.name = name;
    }
}

class Singer extends Artist {
    public Singer(String name) { 
        super(name);
    }
    public void sing() { //This is a method for singer
        System.out.println(name + " is singing.");
        System.out.println("This is the method sing() in the class Singer.");
    }
}

class BackupSinger extends Singer implements IBackup {
    public BackupSinger(String name) {
        super(name);
    }
    public void backup() { //This is a method for backup singer
        System.out.println(name + " is backing up the main artist by singing.");
        System.out.println("This is the method backup() in the class BackupSinger.");
    } 
}

class BackupDancer extends Artist implements IBackup {
    public BackupDancer(String name) {
        super(name);
    }
    public void backup() {//This is a method for backup dancer
        System.out.println(name + " is backing up the main artist by dancing.");
        System.out.println("This is the method backup() in the class BackupDancer.");
    }
    public void dance() { //This is a method for dancer
        System.out.println(name + " is dancing.");
        System.out.println("This is the method dance() in the class BackupDancer.");
    }
}

class MusicTrack { //Private class for music track that will be sung in performance time
    private String name;
    private double duration;

    public MusicTrack(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }
}

abstract class Performance {
    Singer mainArtist;
    String performanceName;
    final int year;
    String venue;
    ArrayList<MusicTrack> trackList;
    ArrayList<BackupSinger> backupSingers;
    ArrayList<BackupDancer> backupDancers;

    public Performance(Singer mainArtist, String performanceName, int year, String venue) {
        this.mainArtist = mainArtist;
        this.performanceName = performanceName;
        this.year = year;
        this.venue = venue;
        this.trackList = new ArrayList<>();
        this.backupSingers = new ArrayList<>();
        this.backupDancers = new ArrayList<>();
    }

    
    public void setPerformanceName(String performanceName) { //set the name for perfomance
        System.out.println("This is the method setPerformanceName() in the class Performance.");
        this.performanceName = performanceName;
        System.out.println("Performance name changed to " + performanceName);
    }

    public void addMusicTrack(MusicTrack musicTrack) { //add music track to the performance
        System.out.println("This is the method addMusicTrack() in the class Performance.");
        trackList.add(musicTrack);
        System.out.println("Added track " + musicTrack.getName());
    }

    public void addBackupSinger(BackupSinger singer) { //add backup singer to the performance
        System.out.println("This is the method addBackupSinger() in the class Performance.");
        backupSingers.add(singer);
    }

    public void addBackupDancer(BackupDancer dancer) { //add backup dancer to the performance
        System.out.println("This is the method addBackupDancer() in the class Performance.");
        backupDancers.add(dancer);
    }

    public abstract void startPerformance();

    public void printWelcomeMessage() { //Welcome message for perfomance
        System.out.println("This is the method printWelcomeMessage() in the class Performance.");
        System.out.println("Welcome to the Performance " + performanceName + " by " + mainArtist.name + "!");

    }
}

class LivePerformance extends Performance { //class for live performance
    public LivePerformance(Singer mainArtist, String performanceName, int year, String venue) {
        super(mainArtist, performanceName, year, venue);
    }

    public void startPerformance() {
        System.out.println("This is the startPerformance() in the LivePerformance.");
        printWelcomeMessage();
        mainArtist.sing();
        for (BackupSinger singer : backupSingers) {
            singer.backup();
        }
        for (BackupDancer dancer : backupDancers) {
            dancer.backup();
        }
        System.out.println(" The artist interact with the audience.");
    }

    public void record() { //record the show
        System.out.println("This is the method record() in the LivePerformance.");
        System.out.println("Recording live performance...");
    }
}

class StudioPerformance extends Performance { //class for studio performance
    public StudioPerformance(Singer mainArtist, String performanceName, int year, String venue) {
        super(mainArtist, performanceName, year,venue);
    }

    public void startPerformance() {
        System.out.println("This is the startPerformance() in the StudioPerformance.");
        printWelcomeMessage();
        mainArtist.sing();
        for (BackupSinger singer : backupSingers) {
         singer.backup();
        }
        for (BackupDancer dancer : backupDancers) {
         dancer.backup();
        }
        System.out.println("Function of audio processing.");
    }

    public void record() { //record the show
        System.out.println("This is the method record() in StudioPerformance.");
        System.out.println("Recording studio performance...");
    }

}



public class Main {
   public static void main(String[] args) {
      Singer mainArtist = new Singer("Taylor Swift"); //add main singer
      LivePerformance Eras_Tour = new LivePerformance(mainArtist, "Eras Tour", 2023, "Glendale"); //start live performance 
      ArrayList<MusicTrack> trackList = new ArrayList<>();
      trackList.add(new MusicTrack("Lavender Haze", 3.45)); //add track to the  show
      trackList.add(new MusicTrack("All Too Well", 5.29)); //add track to the  show
      trackList.add(new MusicTrack("the lakes", 3.32)); //add track to the  show
      trackList.add(new MusicTrack("The Man", 2.55)); //add track to the  show
      trackList.add(new MusicTrack("Love Story", 4.02)); //add track to the  show
      BackupSinger backupSinger1 = new BackupSinger("Jeslyn"); //register backup singer to the  show
      BackupSinger backupSinger2 = new BackupSinger("Melanie"); //register backup singer to the  show
      Eras_Tour.addBackupSinger(backupSinger1); //add backup singer to the  show
      Eras_Tour.addBackupSinger(backupSinger2); //add backup singer to the  show
      BackupDancer backupDancer1 = new BackupDancer("Stephanie"); //register backup dancer to the  show
      BackupDancer backupDancer2 = new BackupDancer("Jake"); //register backup dancer to the  show
      Eras_Tour.addBackupDancer(backupDancer1); //add backup dancer to the  show
      Eras_Tour.addBackupDancer(backupDancer2); //add backup dancer to the  show
      Eras_Tour.startPerformance(); //start the show
      Eras_Tour.record(); 
      System.out.println();
   }
}