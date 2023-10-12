import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class GissaTal {

    Random randomNumber = new Random();
    int userGuessedNumber;
    int rightNumber;
    Scanner scanner;
    int counter;
    boolean gameRunner;

    public GissaTal(){
        
       runGame();
       
        
    }


    public void runGame(){

        gameRunner = true;
        scanner = new Scanner(System.in);
        rightNumber = randomNumber.nextInt(100) + 1;

        System.out.println("Gissa på ett tal mellan 1 och 100.");


        do{
            

             counter++;
            System.out.print("Gissning " + counter + ": ");
             try{
            userGuessedNumber = scanner.nextInt();
            //checkInput(userGuessedNumber);

            if (userGuessedNumber == rightNumber){
                System.out.print("Talet är " + rightNumber + 
                " och du gissade rätt, på " + counter + " försök\n");
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
                 System.out.println("Felaktig inmatning, du måste ange tal i siffror! Försök igen!");
                 scanner.next();
             }
        

        }while(gameRunner);

    }

    public void restartGameOrNot(){

        System.out.println("Vill du spela igen (J/N)?");
        String continueOrNot = scanner.next();

        if (continueOrNot.equalsIgnoreCase("J")){
            counter = 0;
            runGame();

              
        }
        else if (continueOrNot.equalsIgnoreCase("N")){
            
            System.out.println("Programmet avslutas, tack för den här gången");
            gameRunner = false;
            
                
        }
        else {
            System.out.println("Du måste ange eller J/N!");
            restartGameOrNot();
        }

        
    }

/*     public void checkInput(int userGuessedNumber){

    try{
        
            System.out.print("Gissning " + counter + ": ");
            // try{
            userGuessedNumber = scanner.nextInt();

    }
    catch (InputMismatchException e){
    System.out.println("Felaktig inmatning!");
    scanner.next();
    }
    } */

            
}



    
    