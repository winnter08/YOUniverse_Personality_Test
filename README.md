<h1 align = "center">𐔌 .⋮  𝓨𝓞𝓤𝓝𝓘𝓥𝓔𝓡𝓢𝓔  .ᐟ ֹ ₊ ꒱</h1>
<h3 align = "center">༘⋆₊ ⊹★🔭๋࣭ ⭑⋆｡˚</h3>
<h3 align = "center">Your console-based personality exploration universe.</h3>
<p align = "center">
<b>IT 2111 </b> <br/>
De Ocampo, Summer Rain F. <br/>
Fegalan, Aliyah F. <br/>
Harina, Alwin C.
</p>

## ‧₊˚ ┊ Overview
YOUniverse is a console-based Java application allowing users to explore their inner universe through a guided personality test and reflective questions, all directly through the terminal.
<br/><br/>
It demonstrates the practical use of Object-Oriented Programming (OOP) concepts such as encapsulation, inheritance, polymorphism, and abstraction, alongside modular design, clean coding, and user interaction handling.
<br/>
### Users can:
🧩 Take a personalized personality test<br/>
📖 View detailed personality information<br/>
📊 View a summary of their test results<br/>
💌 Receive personalized advice or affirmations

### Note Entry Storage
💾 All results are stored in memory during runtime and summarized for reflection.

## ‧₊˚ ┊ Project Structure
```
📂 src/
├── ☕ YOUniverseApp.java
├── ☕ PersonalityAnalyzer.java
├── ☕ PersonalityType.java
├── ☕ INFJ.java … ENTJ.java
├── ☕ Question.java
└── ☕ InvalidAnswerException.java
```
- `YOUniverseApp.java` - This is the heart of the program. It acts as the core of YOUniverse, where the application starts, displays the menus, and handles all the choices. Basically, everything that appears in the console comes from here.
- `PersonalityAnalyzer.java` - This file handles the calculation of personality results based on the answers. It processes the responses and determines the most fitting personality type.
- `PersonalityType.java` - Serves as the template for all personality types. It maintains common properties such as strengths, weaknesses, and general traits, ensuring consistency across all personality classes.
- `INFJ.java … ENTJ` - Each represents a specific personality type. These classes inherit from **PersonalityType.java** and define unique traits, behaviors, and guidance relevant to students.
- `Question.java` - Represents each test question as an object. It stores the question text, available options, and validates input to make sure responses are correct.
- `InvalidAnswerException.java` - Handles unexpected or invalid input. This keeps the program running smoothly without crashes or interruptions
## 🚀 How to Run

You can run this program using **IntelliJ IDEA** (Recommended) or **VS Code**.

### 🔹 Option 1: Command Line (Terminal)
To run the program manually, follow these steps exactly:

1.  Open your terminal/command prompt in the **main project folder** (the folder that *contains* the `src` folder).
2.  Compile the code:
    ```bash
    javac src/*.java
    ```
3.  Run the program:
    ```bash
    java src.YOUniverseApp
    ```
### 🔹 Option 1: IntelliJ IDEA (Best Experience)
1.  Open IntelliJ IDEA.
2.  Go to **File > New > Project from Version Control**.
3.  Paste this URL:
    ```
    https://github.com/winnter08/YOUniverse_Personality_Test
    ```
4.  Click **Clone**.
5.  Once the project loads, navigate to the `src` folder.
6.  Right-click `YOUniverseApp.java` and select **Run 'YOUniverseApp.main()'**.

<br>

### 🔹 Option 3: Visual Studio Code
**Prerequisite:** You must have the **"Extension Pack for Java"** installed in VS Code.

1.  Open VS Code.
2.  Press `Ctrl + Shift + P` (or `Cmd + Shift + P` on Mac) and type **Git: Clone**.
3.  Paste this URL:
    ```
    https://github.com/winnter08/YOUniverse_Personality_Test
    ```
4.  Select a folder on your computer to save it.
5.  When prompted, click **Open**.
6.  Navigate to `src/YOUniverseApp.java`.
7.  Wait for the Java extension to load (you will see a thumbs-up icon or "Ready" at the bottom right).
8.  Click the **Run** button (Play icon) in the top right corner.

## ‧₊˚ ┊ Features
1. **Start Personality Test.** Begin the personality assessment. The program guides through reflective questions and collects answers to determine personality traits and tendencies.
2. **View Personality Information.** Access detailed descriptions of each personality type. Learn about strengths, weaknesses, motivations, and potential college or career advantages.
3. **View Last Result.** Quickly see the most recent personality assessment outcome. This includes the type, key traits, and a short summary of results.
4. **Get Advice / Affirmations.** Receive personalized advice and uplifting messages based on the assessed personality type. This helps in self-reflection and growth.
5. **Exit Program.** Safely close the program while keeping all previous data intact. Ensures that all progress is saved for the next session.

## ‧₊˚ ┊ Object-oriented Principles
### 💊 Encapsulation
Encapsulation is applied throughout YOUniverse by keeping important data and logic safely tucked inside their respective classes.

For example, `PersonalityAnalyzer` keeps its scoring logic and calculations privately handled within the class. All computations are done through its own methods, so other parts of the program only interact with it through controlled, specific functions.

This design keeps the inner workings protected, avoids accidental changes, and ensures each component manages its own responsibilities cleanly.

### 💡 Abstraction
Abstraction shows up clearly in how tasks are separated into dedicated classes.

`PersonalityType` serves as a simplified blueprint that hides the complexity behind what makes up a personality profile, like traits, strengths, weaknesses, and descriptions. Meanwhile, the subclasses (like `INFJ.java`, `ESTP.java`, etc.) simply provide their unique details without needing to rewrite shared logic.

This keeps the entire program easier to understand, easier to maintain, and easier to extend, because the detailed work is handled quietly in the background.

### 🧬 Inheritance
Inheritance is used through the personality classes, where each of the 16 types extends the `PersonalityType` base class.

This allows every personality to inherit shared structures, such as method formats, required fields, and common behaviors—while still defining their own unique traits.

Because of this setup, adding a new personality type or adjusting an existing one can be done without rewriting the entire system. The project stays organized, consistent, and scalable.

### 🎭 Polymorphism
Polymorphism appears when the program deals with personality objects through their shared base class.

Even though each personality (e.g., `INTJ`, `ENFP`, `ISFJ`) is different, they can all be treated as `PersonalityType` when needed. When a method is called, such as retrieving strengths or generating descriptions, the program automatically uses the correct version based on the actual personality object created.

This flexible behavior allows YOUniverse to display the right traits and information without needing complicated conditions or repeated code.

## ‧₊˚ ┊ Example Output
₊ ⊹˚ **Starting Screen** 
```
|--------------------------------------------------------------------------|
|                     WELCOME TO YOUR YOUNIVERSE                           |
|--------------------------------------------------------------------------|
|  Every person carries an entire universe within them.                    |
|                                                                          |
|  Here, we help you explore that inner world through reflective           |
|  questions designed to reveal your strengths and motivations.            |
|                                                                          |
|  This is not your usual personality test.                                |
|  This is YOUR journey. YOUR rhythm. YOUR universe.                       |
|__________________________________________________________________________|

Are you ready to begin? (Press ENTER)

 ______________________________________________________
|                                                      |
|      Before we begin, what should we call you?       |
|______________________________________________________|

Enter your name: Queuetie #1

Hello, Queuetie #1! Welcome to your YOUniverse.
Press ENTER to enter the Main Menu...
```
₊ ⊹˚ **Dashboard**
```
|-------------------------------|
|            MAIN MENU          |
|-------------------------------|
| 1. Take the Personality Test  |
| 2. View My Personality Type   |
| 3. Last Result Summary        |
| 4. Advice & Affirmation       |
| 5. Exit                       |
|-------------------------------|

Choose an option (1–5): ...
```

##  ‧₊˚ ┊ Contributors
<table>
<tr>
    <th> &nbsp; </th>
    <th> Name </th>
    <th> Role </th>
</tr>
<tr>
    <td><img src="static/summerraind.jpg" width="100" height="100"> </td>
    <td><strong>Summer Rain F. De Ocampo, Sam</strong> <br/>
    <a href="https://github.com/rainatelier" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=yellow" alt="rainatelier's GitHub">
        </a>
    </td>
    <td>Project Designer/Visual-Interface Lead</td>
</tr>
<tr>
    <td><img src="static/aliyahf.jpg" width="100" height="100"> </td>
    <td><strong>Aliyah F. Fegalan, Ali</strong> <br/>
    <a href="https://github.com/jeisquaredd" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=pink" alt="jeisquaredd's GitHub">
        </a>
    </td>
    <td>File Handling & Integration Specialist</td>
</tr>
<tr>
    <td><img src="static/alwinh.jpg" width="100" height="100"> </td>
    <td><strong>Alwin C. Harina, Win</strong> <br/>
    <a href="https://github.com/winnter08" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=blue" alt="winnter08's GitHub">
        </a>
    </td>
    <td>Lead Programmer & Feature Developer</td>
</tr>
</table>

##  ‧₊˚ ┊ Acknowledgment
We sincerely thank our instructor for recognizing the potential of this project and for believing that we could bring it to life. Her approval and encouragement gave us the confidence to explore our ideas and make this a reality.

We are also grateful to our classmates for their support and guidance throughout the process. Their encouragement helped us stay motivated and focused. To our friends in the room, thank you for easing the pressure, cheering us on, and making the long hours enjoyable.

Most importantly, we thank each other for staying committed, being patient, and putting in our best efforts to make this project possible. Together, we turned ideas into a living, breathing experience that is YOUniverse.

<div align="center">
<br>
<i>"The stars shine brighter when you do."</i> 🌟
</div>
