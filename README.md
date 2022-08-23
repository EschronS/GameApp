## GameApp
This is an English Grammar learning android application runs on the Pepper humanoid robot 

# Notes and Ideas:
goal is to have the robot speak out every question instead of just having it on the screen.
    maybe try giving ever question its own activity?
when calling question() go with the Focus to Another Activity and Read the question in there. And then give back the Focus.

# DialogFlow
in this fork i want  to integrate the DialogFlow Chatbot from Google into the "GameApp"

#Troubleshooting (problems I encountered and their solution)
If this message appears in AS: "Compilation is not supported for following modules: GameApp.   
Unfortunately you can't have non-Gradle Java modules and Android-Gradle modules in one project."   
delete the .idea folder and all .iml files while AS is closed
solution found here: https://stackoverflow.com/questions/28668252/android-studio-error-unsupported-modules-detected-compilation-is-not-supported