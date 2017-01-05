# MartyChartProject

For our second project I created an app using Java for Android Development.

Goals:

- practice OO and UI design with what we learned in the Java/Android weeks

Project Specificiations:

- Android app that allows user to track the food they eat
- Users should be able to enter what they eat and when (date/time) and for what meal
- App can show the user a record of what they have eaten

I reframed the idea for a medicine tracker - a MAR (Medical Administration Record) Chart is used by health organizations like the NHS to keep track of what medications a patient takes, the quantity and the time.

![image](https://cloud.githubusercontent.com/assets/22007490/21688572/4763dde2-d365-11e6-9ab1-cd6f8d856df6.png)

MSCW (Must, Should, Could and Woulds)

![image](https://cloud.githubusercontent.com/assets/22007490/21688612/719a3aac-d365-11e6-9ec0-27015eaeeca8.png)

User Case Story of a potential user of this app

![image](https://cloud.githubusercontent.com/assets/22007490/21688664/a08aed20-d365-11e6-9584-573ebfdf3f62.png)

App icon as a red pill as apparently Dementia patients see red colors best. 

<img src="https://cloud.githubusercontent.com/assets/22007490/21688893/7665305e-d366-11e6-93fa-d9795bf3e024.png" width="250">

<img src="https://cloud.githubusercontent.com/assets/22007490/21688697/c29f3222-d365-11e6-9607-2d516b7eb36a.png" width ="250">

<img src="https://cloud.githubusercontent.com/assets/22007490/21688717/d174c10e-d365-11e6-9179-c3762533eadf.png" width="250">

Learned and experimented with:

- SQLite databases
- ListViews
- Recycler View
- Data Binding
- Radio Buttons
- Image Buttons

Struggles:

- mapping objects/classes with results from the SQL database
- as in, creating a new object from the string from the database
- tried everything - hash maps, arrays of strings, interfaces
- eventually culd show list view of the object... but not the actual information
- had to override the toString method in the Medication class with some help

App Features and Future Development:

- Be able to show user what medications have been taken during period of time
- Radio buttons using images for selecting medication instead of having to type it in
- Date and time picker
- Menu activities to show patient medical details ex. GP contact information
