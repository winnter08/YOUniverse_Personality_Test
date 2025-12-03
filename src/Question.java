package src;

// Question.java
public class Question {
    private String text;
    private String optionA; // corresponds to first letter of dimension (e.g., "I")
    private String optionB; // second letter
    private String dimension; // "IE", "SN", "TF", "JP"

    public Question(String text, String optionA, String optionB, String dimension) {
        this.text = text;
        this.optionA = optionA;
        this.optionB = optionB;
        this.dimension = dimension;
    }

    public String getText() { return text; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getDimension() { return dimension; }
}
