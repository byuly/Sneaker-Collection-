# Sneaker Collection

## Application
The application will help organize sneakers for people that like sneakers. There will be information on sneakers
that the user owns/wants to own. Mainly for sneaker lovers. 

User Stories:
- As a user, I want to be able to add a sneaker to my sneaker list. 
- As a user, I want to be able to view the list of sneakers in my sneaker list.
- As a user, I want to be able to have separate lists for WANT and OWNED. 
- As a user, I want to be able to remove a sneaker from my sneaker list.
- As a user, I want to be able to edit sneakers in the list. 
- As a user, I want to be able to save my sneaker collection to file (if I so choose)
- As a user, I want to be able to be able to load my sneaker collection from file (if I so choose)
- As a user, I want to be able to see information on price, size, date, brand, style, colorway, and owned status.

Instructions For Grader:
- You can generate the first required action related to adding X to Y by pressing the add sneaker button, putting
in information for the sneaker, then confirming adding the sneaker by pressing the add sneaker button again,
- You can generate the second required action related to adding X to Y by typing in the name of sneaker already in
list in the search bar, then pressing search. When one sneaker pops up, it will prompt you checking if you want to 
edit the sneaker or not. You can press yes then edit the sneaker from the list. 
- You can generate a third action related to adding X to Y by pressing view owned sneaker list or view wanted sneaker 
list. These lists are sorted as sublists of the all sneaker list, separated by if you own the sneaker or not. 
- You can locate my visual component via SplashScreen when started, and
by pressing the ":)" button in the main menu.
- You can save the state of my application by clicking the save button in main menu.
- You can load the previous saved data in my application by pressing the load button in main menu. 

PHASE 4: Task 2
-Tue Aug 08 22:18:45 PDT 2023
added sneaker with name: Adidas
-Tue Aug 08 22:18:45 PDT 2023
added sneaker with name: Nike Jordan 1's
-Tue Aug 08 22:18:45 PDT 2023
added sneaker with name: Hey
-Tue Aug 08 22:18:45 PDT 2023
added sneaker with name: Nike
-Tue Aug 08 22:18:45 PDT 2023
added sneaker with name: New Balance 550
-Tue Aug 08 22:18:45 PDT 2023
added sneaker with name: testsneakerlog
-Tue Aug 08 22:18:47 PDT 2023
viewed sneaker collection.
-Tue Aug 08 22:18:55 PDT 2023
edited a sneaker
-Tue Aug 08 22:18:57 PDT 2023
removed sneaker with name: testsneakerlog
-Tue Aug 08 22:19:18 PDT 2023
added sneaker with name: testsneakerlog
-Tue Aug 08 22:19:21 PDT 2023
loaded sneaker collection
-Tue Aug 08 22:19:21 PDT 2023
saved sneaker collection
-Tue Aug 08 22:19:23 PDT 2023
viewed sneaker collection.
-Tue Aug 08 22:19:29 PDT 2023
cleared collection

PHASE 4: TASK 3

There were a lot of repetition in my code that could've been improved if I made an abstract class with the methods
and extended them. I would also research more and see if I can have my "search" more like a real search, going over each
character. Currently, it can only search words and see if it contains the word. If I had more time, I would definitely 
make my GUI look nicer, and more user friendly. While I was testing the gui and my application, it felt really 
inflexible and strict about what I can do to it. I would add exceptions as a way to combat this problem, (for example,
in the name section, if I put something other than a string, it would just parse it as a string) so that something
can be done when the input is not the expected type. I would definitely thoroughly add exceptions, making my app more
robust. 