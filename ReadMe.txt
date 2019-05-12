Overview

Our project is a desktop app to help MCIT 591 students study for their final exam.
We created a text file ("ContentHash.txt") that has Topics (e.g., Basics), each of which has a variety of Lessons (e.g., Intro, Hello World, Comments). 
Within each Lesson, there are pages for content and questions (multiple choice and fill in the blanks). Each column is separated by "#".
For the user, the sequence of events is as follows:
1. Choose a Topic on the first page
2. Choose a Lesson within that Topic (or go back to the first page)
3. Go through the content and questions of that Lesson
4. After the last page within that Lesson, pick another Lesson for that Topic or go back to the list of Topics. 


Reader Class

Our Reader class reads each row of "ContentHash.txt" and separates it by #. 
2. It creates an ArrayList of Topics using the second column in the text file. 
3. We have a Topic class for which the constructor of a Topic object is an ArrayList of Lessons, so once we have the Topics ArrayList we can add an Lessons to an ArrayList for each Topic object. 
4. We also have a Lesson class for which the constructor of a Lesson object is a String of text. For each Lesson within the Topic, we can add text for either a content or question page.
5. If the page is for content, we have a Content class for which the constructor takes in a string of text and then uses “/n” to display multiple lines when needed. 
6. If the page is for a question, we have a Question class for which the constructor takes in 1)question type (MC or fill in the blank), 2) question text, 3)correct answer 4) three incorrect answers. 
7. We also have a method called recordLastPage which contains a FileWriter to print your last viewed lesson/topic to a text file “captainsLog.txt”, as well as another method called xp which contains another FileWriter to print 10 to a txt file “xp.txt” every time you answer a question correctly.


Creating Buttons, Labels, and Layouts

We have 2 classes for this purpose: CreateMainButtons and CreateMainLayout.
1. CreateMainButtons creates all of the buttons and labels that we need for our pages, including the next/previous buttons which use an image of an arrow as the button.
2. CreateMainLayouts has methods to create basic gridPanes, HBox and VBox layouts which are then passed to the borderPane method that is used for all pages.


Putting it all Together

Everything comes together in the Screens class. The methods include:
1. goToTopics: first page is created and buttons for each topic are added via for loop of javaTopics ArrayList mentioned above. We also added three labels to the top of the page which tells you the last lesson/topic that you viewed (using recordLastPage method from Reader class) and how many XP you have earned (using xp method from Reader class).
2. goToLessons: depending on what topic you choose, this method creates a second page where buttons are created dynamically for each lesson name.
3. getToTheNextScreen: takes in current topic, current lesson, and previous scene. It uses an ArrayList of contentAndQuestions to determine if there is a next page in the lesson. If there is, it sets the currentScene as the next page. If there is not, it takes you back to the Lesson page. This method also calls on the recordLastPage method in the readerClass to record the page as your last viewed page.
4. getToThePreviousScreen: takes you back one index in the lesson array.
5. contentPage: takes in page in lesson index, current topic and lesson, previous scene, and content text. This method creates a label for the content as well as next and previous buttons.
6. questionPage: takes in page in lesson index, current topic and lesson, previous scene, and question object. The question object is then used to get the question text, correct answer, and three wrong answers. We create 4 radio buttons for the possible answers. We assign the correct answer to the first radio button, but before placing the radio buttons on the page, we shuffle them around in an array list so the answers show up in a random order. We can then use an if statement to say if the user chose radio button #1, then record 10 points and display a pop-up message (via Alert class) to tell the user they are correct. The user cannot press submit until a radio button is selected, and also cannot press the next button until they answer correctly.
7. questionFIBPage: takes in same parameters as questionPage method. Rather than radio buttons, this method creates labels with prompt text “Write here” for each fill in the blank. 
For every page that you see, we use the CreateMainLayouts class to create individual layouts which are then used as parameters for the setBorderPane method.
