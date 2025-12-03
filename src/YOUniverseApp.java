// YOUniverseApp.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YOUniverseApp {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Question> questions = new ArrayList<>();
    private static PersonalityType lastResult = null;
    private static String userName = "Traveler";

    public static void main(String[] args) {
        loadQuestions();
        clearScreen();
        showBigLogo();

        // The Countdown Effect
        System.out.print("\n   Initializing YOUniverse in ");
        try {
            for(int i = 5; i > 0; i--) {
                System.out.print(i + "... ");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
        System.out.println("\n");

        clearScreen();
        showIntro();

        // Name Input with Box Style
        System.out.println(" ______________________________________________________");
        System.out.println("|                                                      |");
        System.out.println("|  Before we begin, what should we call you?           |");
        System.out.println("|______________________________________________________|");
        System.out.print("\n   Enter your name: ");
        String inputName = scanner.nextLine().trim();
        if (!inputName.isEmpty()) userName = inputName;

        System.out.println("\n   Hello, " + userName + "! Welcome to your YOUniverse.");
        System.out.println("   Press ENTER to enter the Main Menu...");
        scanner.nextLine();

        boolean exit = false;
        while (!exit) {
            clearScreen();
            showMainMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    takeTest();
                    break;
                case "2":
                    viewPersonalityInfo();
                    break;
                case "3":
                    viewSummary();
                    break;
                case "4":
                    viewAffirmations();
                    break;
                case "5":
                    exit = true;
                    showExitBox("Disconnecting...");
                    break;
                default:
                    // Loop back
            }
        }
        scanner.close();
    }

    private static void clearScreen() {
        for(int i = 0; i < 50; i++) System.out.println();
    }

    private static void showBigLogo() {
        System.out.println(" __   __  _______  __   __  __    _  ___   __   __  _______  ______    _______  _______ ");
        System.out.println("|  | |  ||       ||  | |  ||  |  | ||   | |  | |  ||       ||    _ |  |       ||       |");
        System.out.println("|  |_|  ||   _   ||  | |  ||   |_| ||   | |  |_|  ||    ___||   | ||  |  _____||    ___|");
        System.out.println("|       ||  | |  ||  |_|  ||       ||   | |       ||   |___ |   |_||_ | |_____ |   |___ ");
        System.out.println("|_     _||  |_|  ||       ||  _    ||   | |       ||    ___||    __  ||_____  ||    ___|");
        System.out.println("  |   |  |       ||       || | |   ||   |  |     | |   |___ |   |  | | _____| ||   |___ ");
        System.out.println("  |___|  |_______||_______||_|  |__||___|   |___|  |_______||___|  |_||_______||_______|");
    }

    private static void showIntro() {
        System.out.println(" __________________________________________________________________________");
        System.out.println("|                                                                          |");
        System.out.println("|              ✨ 🌌  WELCOME TO YOUR YOUNIVERSE  🌌 ✨                    |");
        System.out.println("|--------------------------------------------------------------------------|");
        System.out.println("|  Every person carries an entire universe within them.                    |");
        System.out.println("|                                                                          |");
        System.out.println("|  Here, we help you explore that inner world through reflective           |");
        System.out.println("|  questions designed to reveal your strengths and motivations.            |");
        System.out.println("|                                                                          |");
        System.out.println("|  This is not your usual personality test.                                |");
        System.out.println("|  This is YOUR journey. YOUR rhythm. YOUR universe.                       |");
        System.out.println("|__________________________________________________________________________|");
        System.out.println("\nAre you ready to begin? (Press ENTER)");
        scanner.nextLine();
    }

    // --- MAIN MENU WITH EMOJI HEADER ---
    private static void showMainMenu() {
        System.out.println(" _________________________________");
        System.out.println("|         🌌 MAIN MENU 🌌       |");
        System.out.println("|-------------------------------|");
        System.out.println("| 1. Take the Personality Test  |");
        System.out.println("| 2. View My Personality Type   |");
        System.out.println("| 3. Last Result Summary        |");
        System.out.println("| 4. Advice & Affirmation       |");
        System.out.println("| 5. Exit                       |");
        System.out.println("|_______________________________|");
        System.out.print("\nChoose an option (1-5): ");
    }

    private static void takeTest() {
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            boolean valid = false;
            while (!valid) {
                clearScreen();
                System.out.println(" ______________________________________________________");
                System.out.printf("| QUESTION %-41d |\n", (i + 1));
                System.out.println("|                                                    |");

                String qText = q.getText();
                if (qText.length() > 50) qText = qText.substring(0, 47) + "...";

                System.out.printf("| %-50s |\n", qText);
                System.out.println("|                                                    |");
                System.out.println("|----------------------------------------------------|");

                String opA = q.getOptionA();
                if (opA.length() > 47) opA = opA.substring(0, 44) + "...";

                String opB = q.getOptionB();
                if (opB.length() > 47) opB = opB.substring(0, 44) + "...";

                System.out.printf("| A) %-47s |\n", opA);
                System.out.printf("| B) %-47s |\n", opB);
                System.out.println("|                                                    |");
                System.out.println("| [Type 'M' to return to Menu]                       |");
                System.out.println("|____________________________________________________|");
                System.out.print("\nYour Answer (A/B): ");

                String input = scanner.nextLine().trim().toUpperCase();

                if (input.equals("M")) return;

                if (input.equals("A") || input.equals("B")) {
                    answers.add(input);
                    valid = true;
                } else {
                    System.out.println("Invalid input. Press ENTER to try again.");
                    scanner.nextLine();
                }
            }
        }

        System.out.println("\n   Thank you, " + userName + "!");
        System.out.println("   Analyzing your answers...");
        System.out.println("   Press ENTER to view your results.");
        scanner.nextLine();

        PersonalityAnalyzer analyzer = new PersonalityAnalyzer(questions);
        try {
            lastResult = analyzer.analyze(answers);
            clearScreen();

            // Show the detailed visual profile
            lastResult.showDetailedProfile(userName);

            // Satisfaction Check
            System.out.println("\nAre you satisfied with your result?");
            System.out.println("[1] Yes, it fits me");
            System.out.println("[2] Somewhat");
            System.out.println("[3] Not really");
            System.out.print("Enter choice: ");
            scanner.nextLine();

            System.out.println("\nWe're glad the result resonated with you, " + userName + ".");
            System.out.println("Press ENTER to return to the Main Menu.");
            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewPersonalityInfo() {
        clearScreen();
        System.out.println(" _________________________________");
        System.out.println("|   VIEW PERSONALITY INFORMATION  |");
        System.out.println("|_________________________________|");
        System.out.print("\nEnter personality type (e.g., INFJ): ");
        String code = scanner.nextLine().trim().toUpperCase();

        PersonalityAnalyzer analyzer = new PersonalityAnalyzer(questions);
        PersonalityType type = analyzer.instantiateByCode(code);
        clearScreen();
        type.showInfo();

        System.out.println("\nPress ENTER to return to main menu.");
        scanner.nextLine();
    }

    private static void viewSummary() {
        clearScreen();
        if (lastResult == null) {
            System.out.println("You haven't taken the test yet!");
        } else {
            lastResult.showSummaryResult(userName);
        }
        System.out.println("\nPress ENTER to return to main menu.");
        scanner.nextLine();
    }

    private static void viewAffirmations() {
        clearScreen();
        if (lastResult == null) {
            System.out.println("Please take the test (Option 1) first to get personalized advice.");
        } else {
            lastResult.showDetailedAdvice();
        }
        System.out.println("\nPress ENTER to return.");
        scanner.nextLine();
    }

    private static void showExitBox(String message) {
        System.out.println(" ______________________________________________________");
        System.out.println("|                                                      |");
        System.out.printf("|  %-52s|\n", message);
        System.out.println("|  Thank you for visiting YOUniverse!                  |");
        System.out.println("|______________________________________________________|");
    }

    private static void loadQuestions() {
        questions.clear();
        questions.add(new Question("When you walk into a new environment...",
                "Quietly observe the vibe first", "Engage and blend in immediately", "IE"));
        questions.add(new Question("When you're overwhelmed, you recharge by...",
                "Being alone in a calm space", "Being around people you trust", "IE"));
        questions.add(new Question("Which describes how your mind works?",
                "You look at patterns and deeper meanings", "You focus on what’s real and practical", "NS"));
        questions.add(new Question("When someone shares a problem, you...",
                "Listen deeply to how they feel", "Give straightforward solutions", "FT"));
        questions.add(new Question("Deadlines make you feel...",
                "Motivated to plan and organize early", "Pressured, but work better spontaneously", "JP"));
        questions.add(new Question("You express your emotions by...",
                "Writing or reflecting privately", "Talking them out with people", "IE"));
        questions.add(new Question("When making decisions, you rely on...",
                "Personal values and impact on others", "Logic, fairness, and consistency", "FT"));
        questions.add(new Question("You prefer days that are...",
                "Planned and structured", "Free and flexible", "JP"));
        questions.add(new Question("What frustrates you more?",
                "Insensitivity to feelings", "Illogical choices", "FT"));
        questions.add(new Question("Your creativity comes from..",
                "Imagination and inner reflection", "Real-world hands-on experience", "NS"));
        questions.add(new Question("You are more motivated by…",
                "Meaning and purpose", "Achievement and competence", "NS"));
        questions.add(new Question("In group work, you tend to…",
                "Facilitate harmony and understanding", "Provide structure and direction", "FT"));
        questions.add(new Question("People describe you as…",
                "Empathetic and introspective", "Confident and straightforward", "IE"));
        questions.add(new Question("You feel stressed when…",
                "There’s conflict or tension", "There’s pressure or inefficiency", "FT"));
        questions.add(new Question("You connect more with…",
                "Conversations about feelings and meaning", "Conversations about plans and facts", "NS"));
        questions.add(new Question("You tend to…",
                "Think about the future", "Focus on the present moment", "NS"));
        questions.add(new Question("When facing problems, you…",
                "Reflect deeply first", "Act quickly", "IE"));
        questions.add(new Question("You appreciate people who…",
                "Understand your emotions", "Respect your ideas", "FT"));
        questions.add(new Question("You prefer friendships that are…",
                "Deep, loyal, and meaningful", "Fun, energetic, and spontaneous", "NS"));
        questions.add(new Question("You feel fulfilled when…",
                "You help or understand someone", "You achieve something difficult", "FT"));
    }
}