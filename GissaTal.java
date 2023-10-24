import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class GissaTal {

    private Random randomNumber = new Random();
    private Scanner scanner = new Scanner(System.in);
    
    private int userGuessedNumber;
    private int rightNumber;
    private int counter;
    private boolean gameRunner;

    public GissaTal(){
        
       runGame();
       
    }

    public void runGame(){

        gameRunner = true;
        
        rightNumber = randomNumber.nextInt(100) + 1;

        System.out.println("Gissa på ett tal mellan 1 och 100.");


        do{
            
            counter++;
            System.out.print("Gissning " + counter + ": ");

            try{

            userGuessedNumber = scanner.nextInt();

            if (userGuessedNumber > 100){
                counter --;
                System.out.println("Du måste ange ett tal mellan 1 och 100! Försök igen.");
            }

            else if (userGuessedNumber == rightNumber){
                System.out.print("Rätt! Talet är " + rightNumber + 
                " och du gissade rätt på " + counter + " försök.\n");
                restartGameOrNot();
                
            }

            else if (userGuessedNumber > rightNumber){
                System.out.println("Talet är mindre, gissa igen!");
            }

            else if (userGuessedNumber < rightNumber){
                System.out.println("Talet är större, gissa igen!");
            }

            }
             catch (InputMismatchException e){
                counter --;
                 System.out.println("Felaktig inmatning, du måste ange ett tal i siffror! Försök igen!");
                 scanner.next();
             }
        

        }while(gameRunner);

    }

    public void restartGameOrNot(){

        System.out.println("Vill du spela igen (Ja/Nej)?");
        String continueOrNot = scanner.next();

        if (continueOrNot.equalsIgnoreCase("Ja")){
            counter = 0;
            runGame();

              
        }
        else if (continueOrNot.equalsIgnoreCase("Nej")){
            
            System.out.println("Programmet avslutas, tack för den här gången!");
            gameRunner = false;
                   
        }
        else {
            System.out.println("Du måste ange Ja eller Nej!");
            restartGameOrNot();
        }

    }

            
}



    
    