package taskone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Ques{
    final String text;
    public final List<String> options;
    public final int correctAnswerIndex;

    public Ques(String text,List<String> options,int correctAnswerIndex){
        this.text=text;
        this.options=options;
        this.correctAnswerIndex=correctAnswerIndex;
    }
    public boolean isCorrect(String answer){
        return options.get(correctAnswerIndex).equals(answer);
    }
}
public class Quiz {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int score=0;

        List<Ques> questions=new ArrayList<>();
        questions.add(new Ques("What is the Capital of Italy ?",Arrays.asList("Rome","Berlin","Madrai"),0));
        questions.add(new Ques("What is the largest ocean on Earth ?",Arrays.asList("Atantic","Pacific","Indian"),1));
        questions.add(new Ques("What is the closest Star to our Solar System ?",Arrays.asList("Alpha Centari A","Sirius","Betelgeuse","Proxima Centauri"),3));

        for(Ques question: questions){
            askQuestion(question,sc);
            score+=checkAnswer(question,sc);
        }

        System.out.println("Your Final Score is: "+score+"/"+questions.size());
    }

    private static void askQuestion(Ques question,Scanner sc){
        System.out.println(question.text);
        for(int i=0;i<question.options.size();i++){
            System.out.println((char)('a'+i)+")"+question.options.get(i));
        }
    }

    private static int checkAnswer(Ques question,Scanner sc){
        String ans=getValidInput(sc,"Enter Valid answer :");
       if(question.isCorrect(ans)){
        System.out.println("Correct !");
        return 1;
       } 
       else{
        System.out.println("Incorrect. The correct answer is: "+question.options.get(question.correctAnswerIndex));
        return 0;
       }
    }

    private static String getValidInput(Scanner sc,String prompt){
        while(true){
            System.out.println(prompt);
            String input=sc.nextLine();
            if(!input.isEmpty()){
                return input;
            }
            else{
                System.out.println("Please enter a valid answer.");
            }
        }
    }

}

