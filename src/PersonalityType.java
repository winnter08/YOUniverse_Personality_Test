package src;

// PersonalityType.java
public abstract class PersonalityType {
    private String code;
    private String title;
    private String description;
    private String[] strengths;
    private String[] weaknesses;
    private String[] collegeAdvantages;
    private String coreTraits;
    private String motivation;
    private String careers;
    private String compatibility;
    private String opposite;
    private String affirmation;
    // Advice Fields
    private String adviceChallenge;
    private String adviceAction;
    private String adviceMantra;
    private String emoji;

    private int[] percentages = new int[]{50, 50, 50, 50};

    // Total visual line length (including border pipes)
    private static final int CONTENT_WIDTH = 74;

    public PersonalityType(String code, String title, String description,
                           String[] strengths, String[] weaknesses, String[] collegeAdvantages,
                           String coreTraits, String motivation, String careers,
                           String compatibility, String opposite, String affirmation,
                           String adviceChallenge, String adviceAction, String adviceMantra,
                           String emoji) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
        this.collegeAdvantages = collegeAdvantages;
        this.coreTraits = coreTraits;
        this.motivation = motivation;
        this.careers = careers;
        this.compatibility = compatibility;
        this.opposite = opposite;
        this.affirmation = affirmation;
        this.adviceChallenge = adviceChallenge;
        this.adviceAction = adviceAction;
        this.adviceMantra = adviceMantra;
        this.emoji = emoji;
    }

    public String getCode() { return code; }
    public String getAffirmation() { return affirmation; }

    public void setPercentages(int[] percentages) {
        this.percentages = percentages;
    }

    // --- HELPER: DRAW DECORATIVE HEADER ---
    private void drawPageHeader(String pageTitle) {
        System.out.println(" __________________________________________________________________________");
        System.out.println("|                                                                          |");

        // Center the title with decorative stars
        String content = "✨ " + emoji + " " + pageTitle + " " + emoji + " ✨";

        // Truncate if somehow too long (unlikely)
        if (content.length() > CONTENT_WIDTH) content = content.substring(0, CONTENT_WIDTH);

        int paddingLeft = (CONTENT_WIDTH - content.length()) / 2;
        int paddingRight = CONTENT_WIDTH - paddingLeft - content.length();

        StringBuilder line = new StringBuilder("|");
        for (int i = 0; i < paddingLeft; i++) line.append(" ");
        line.append(content);
        for (int i = 0; i < paddingRight; i++) line.append(" ");
        line.append("|");

        System.out.println(line);
        System.out.println("|__________________________________________________________________________|");
    }

    private void drawDivider() {
        System.out.println("|--------------------------------------------------------------------------|");
    }

    private void drawEmptyLine() {
        System.out.println("|                                                                          |");
    }

    // --- MENU 2: INFO VIEW ---
    public void showInfo() {
        drawPageHeader("PROFILE: " + code + " - " + title.toUpperCase());
        drawEmptyLine();
        printFixedLine("🧩  CORE TRAITS: " + coreTraits);
        printFixedLine("🔥  MOTIVATION:  " + motivation);
        printFixedLine("💼  CAREERS:     " + careers);
        printFixedLine("💞  COMPATIBLE:  " + compatibility);
        printFixedLine("⚡  OPPOSITE:    " + opposite);
        System.out.println("|__________________________________________________________________________|");
    }

    // --- MENU 3: SUMMARY VIEW ---
    public void showSummaryResult(String name) {
        drawPageHeader("SUMMARY FOR " + name.toUpperCase());
        drawEmptyLine();
        printFixedLine("🆔  TYPE: " + code + " (" + title + ")");

        String energy = percentages[0] > 50 ? "Introverted" : "Extraverted";
        String info = percentages[1] > 50 ? "Intuitive" : "Observant";
        String decision = percentages[2] > 50 ? "Feeling" : "Thinking";
        String lifestyle = percentages[3] > 50 ? "Prospecting" : "Judging";

        printFixedLine("🔋  MIND:  " + energy);
        printFixedLine("👁️  INFO:  " + info);
        printFixedLine("❤️  HEART: " + decision);
        printFixedLine("📅  HABIT: " + lifestyle);

        drawDivider();
        printFixedLine("📜  Short Summary:");
        printFixedLine("    You are " + coreTraits.toLowerCase() + ".");
        System.out.println("|__________________________________________________________________________|");
    }

    // --- MENU 4: DETAILED ADVICE VIEW ---
    public void showDetailedAdvice() {
        drawPageHeader("GROWTH & ADVICE FOR " + code);
        drawEmptyLine();

        printFixedLine("⚔️  THE CHALLENGE");
        printWrappedLine("    \"" + adviceChallenge + "\"");

        drawDivider();

        printFixedLine("🚀  ACTIONABLE STEPS");
        printWrappedLine("    " + adviceAction);

        drawDivider();

        printFixedLine("🧘  YOUR MANTRA");
        printWrappedLine("    \"" + adviceMantra + "\"");

        System.out.println("|__________________________________________________________________________|");
    }

    // --- MENU 1: FULL PROFILE VIEW ---
    public void showDetailedProfile(String name) {
        drawPageHeader("YOUR RESULT: " + code + " - " + title.toUpperCase());

        drawEmptyLine();
        printWrappedLine("👋 Hello, " + name + ". " + description);

        drawDivider();
        printFixedLine("📊  YOUR TRAITS MAP");
        printFixedLine("    (Bars grow from the center | outwards)");
        drawEmptyLine();

        // Pass icons to the bar chart drawer for extra flair
        drawSplitBar("⚡ EXTRAVERTED", "INTROVERTED 🔋", percentages[0]);
        drawSplitBar("👁️ OBSERVANT",   "INTUITIVE 🔮",   percentages[1]);
        drawSplitBar("🧠 THINKING",    "FEELING ❤️",     percentages[2]);
        drawSplitBar("📝 JUDGING",     "PROSPECTING 🎲", percentages[3]);

        drawDivider();
        printFixedLine("✅  YOUR STRENGTHS");
        for (String s : strengths) printWrappedLine("    • " + s);

        drawDivider();
        printFixedLine("⚠️  AREAS FOR GROWTH");
        for (String w : weaknesses) printWrappedLine("    • " + w);

        drawDivider();
        printFixedLine("🎓  COLLEGE SUPERPOWERS");
        for (String c : collegeAdvantages) printWrappedLine("    • " + c);

        System.out.println("|__________________________________________________________________________|");
    }

    // --- HELPER: ALIGNED PRINTING ---
    private void printFixedLine(String text) {
        // Safe printing that cuts off if too long to prevent breaking the box
        if (text.length() > 74) text = text.substring(0, 71) + "...";

        StringBuilder line = new StringBuilder("|  ");
        line.append(text);
        while (line.length() < 75) line.append(" ");
        line.append("|");
        System.out.println(line);
    }

    // --- HELPER: TEXT WRAPPING ---
    private void printWrappedLine(String text) {
        int limit = 70; // Width for text inside margins
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder("|  ");

        for (String word : words) {
            if (line.length() + word.length() + 1 > limit + 3) {
                while (line.length() < 75) line.append(" ");
                line.append("|");
                System.out.println(line);
                line = new StringBuilder("|    ");
            }
            line.append(word).append(" ");
        }
        while (line.length() < 75) line.append(" ");
        line.append("|");
        System.out.println(line);
    }

    // --- VISUAL BAR CHART ---
    private void drawSplitBar(String leftLabel, String rightLabel, int rightPercent) {
        int leftPercent = 100 - rightPercent;
        boolean rightDominant = rightPercent > 50;
        int dominantPercent = rightDominant ? rightPercent : leftPercent;

        int barSize = 10;
        int fillCount = (int)(((dominantPercent - 50) / 50.0) * barSize);
        if (fillCount < 0) fillCount = 0;

        StringBuilder leftBar = new StringBuilder();
        StringBuilder rightBar = new StringBuilder();

        for(int i=0; i<barSize; i++) {
            if (!rightDominant && i >= (barSize - fillCount)) leftBar.append("=");
            else leftBar.append(" "); // Space for empty bar
        }

        for(int i=0; i<barSize; i++) {
            if (rightDominant && i < fillCount) rightBar.append("=");
            else rightBar.append(" ");
        }

        String center = "|";

        String leftText = rightDominant ? leftLabel : leftLabel + " (" + dominantPercent + "%)";
        String rightText = rightDominant ? "(" + dominantPercent + "%) " + rightLabel : rightLabel;

        // Strict formatting to match 76 char width
        // | + 2 space + 24 label + 1 space + 10 bar + 1 center + 10 bar + 1 space + 24 label + 1 space + |
        // Note: Emojis can sometimes be tricky with width, but standard spacing usually works.
        // If labels are too long (due to emojis), we truncate.

        if (leftText.length() > 24) leftText = leftText.substring(0, 24);
        if (rightText.length() > 24) rightText = rightText.substring(0, 24);

        System.out.printf("|  %-24s %s%s%s %-24s |\n",
                leftText, leftBar, center, rightBar, rightText);
    }
}