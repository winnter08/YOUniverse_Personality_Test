package src;// PersonalityAnalyzer.java
import java.util.List;

public class PersonalityAnalyzer {
    private List<Question> questions;

    public PersonalityAnalyzer(List<Question> questions) {
        this.questions = questions;
    }

    public PersonalityType analyze(List<String> answers) throws IllegalArgumentException {
        if (answers == null || answers.size() != questions.size()) {
            throw new IllegalArgumentException("Answers list size must match questions size.");
        }

        int countI=0, totalI=0;
        int countN=0, totalN=0;
        int countF=0, totalF=0;
        int countJ=0, totalJ=0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            String ans = answers.get(i).trim().toUpperCase();
            boolean chooseA = ans.equals("A");

            String dim = q.getDimension();
            if(dim.equals("IE")) { totalI++; if(chooseA) countI++; }
            else if(dim.equals("NS")) { totalN++; if(chooseA) countN++; }
            else if(dim.equals("FT")) { totalF++; if(chooseA) countF++; }
            else if(dim.equals("JP")) { totalJ++; if(chooseA) countJ++; }
        }

        int pctI = (int)(((double)countI/totalI)*100);
        int pctN = (int)(((double)countN/totalN)*100);
        int pctF = (int)(((double)countF/totalF)*100);
        int pctP = (int)(((double)(totalJ - countJ)/totalJ)*100);

        char l1 = (pctI >= 50) ? 'I' : 'E';
        char l2 = (pctN >= 50) ? 'N' : 'S';
        char l3 = (pctF >= 50) ? 'F' : 'T';
        char l4 = (pctP >= 50) ? 'P' : 'J';

        String code = "" + l1 + l2 + l3 + l4;

        PersonalityType result = instantiateByCode(code);
        result.setPercentages(new int[]{ pctI, pctN, pctF, pctP });

        return result;
    }

    public PersonalityType instantiateByCode(String code) {
        switch (code) {
            case "ISTJ": return new ISTJ();
            case "ISFJ": return new ISFJ();
            case "INFJ": return new INFJ();
            case "INTJ": return new INTJ();
            case "ISTP": return new ISTP();
            case "ISFP": return new ISFP();
            case "INFP": return new INFP();
            case "INTP": return new INTP();
            case "ESTP": return new ESTP();
            case "ESFP": return new ESFP();
            case "ENFP": return new ENFP();
            case "ENTP": return new ENTP();
            case "ESTJ": return new ESTJ();
            case "ESFJ": return new ESFJ();
            case "ENFJ": return new ENFJ();
            case "ENTJ": return new ENTJ();
            default: return new INFJ();
        }
    }
}