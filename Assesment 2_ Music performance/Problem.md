# Formative Assignment 2: Musical Performances Simulation

## Problem Statement

### Task 1: Java Program for Musical Performances

You are required to develop a Java program to implement musical performances covering the following criteria:

- Each performance has the attributes main artist, performance name, year, venue, track list, backup singers, and backup dancers. The track list consists of a variable number of music tracks.
- The venue and year attributes can be viewed by anyone, but they cannot be changed.
- The performance name is both viewable and changeable.
- Anyone can make changes to the track list, but the currently existing track list should not be visible to outsiders.
- Each music track has a name and a duration.
- The number of backup singers and backup dancers varies for each performance.
- There are two types of performances: live performances and studio performances.
  - During live performances, the artist can interact with the audience.
  - Only studio performances have the function of audio processing.
  - Both live and studio performances can be recorded, but the recording methods are different for the two types.
- The main artist, backup singers, and backup dancers are all considered artists. All artists have a name.
- Both the main artist and backup singers are considered singers. All singers can sing.
- Backup dancers can dance.
- Both backup singers and backup dancers can back up the main artist during the performance, but the way they do it is different. Backup singers back up the artist by singing, while backup dancers back up the artist by dancing.
- (Hint: Use an interface called `IBackup`)

When a performance is initiated, the following things happen:
- A message “Welcome to the Performance [name of the performance] by [name of the main artist]!” is printed on the screen.
- The main artist sings. Backup singers and backup dancers back him/her up.

You do not need to include complex logic in method implementations. However, whenever a method is invoked, the message “This is the method [name of the method] in the class [name of the class].” should be printed on the screen. The method names, parameters, and access modifiers should be clear.

### Task 2: Create a Live Performance for the Eras Tour

Create a live performance for the Eras Tour by Taylor Swift and initiate the performance. The details of the performance are as follows:

- **Main artist**: Taylor Swift
- **Performance name**: Eras Tour
- **Year**: 2023
- **Venue**: Glendale
- **Tracklist**: Lavender Haze, All Too Well, The Lakes, The Man, Love Story
- **Backup singers**: Jeslyn, Melanie
- **Backup dancers**: Stephanie, Jake

### Submission Requirements

- Copy all your code into a single text file. Clearly indicate the separation of classes and include comments to clarify your work.
- Compile your code into an executable (.exe) file.
- Submit **BOTH** your `.txt` file and `.exe` file to Moodle.
