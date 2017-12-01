/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
/**
 *
 * @author Markb
 */
public class Score implements Serializable{
   
    transient Timer timer; //Timer object
    transient TimerTask task; //TimerTask object
    private int score; //Score
    private int hintCost; //cost of every hint which increments per hint used
    private int secondsPassed; //The actual passed game time in seconds
    
    //Constructor to instantiate variables and objects.
    Score() {
        
        this.score = 0; //Set initial game score to 0
        this.hintCost = 0; //Set initial hintCost to 0
        this.secondsPassed = 0;
        this.timer = new Timer(); //Instantiate timer as new Timer object
        //Declares a timerTask object which we can reference to from our timer object. 
        this.task = new TimerTask() {
            public void run() {
                secondsPassed ++;
                //System.out.println("Seconds passed: " + secondsPassed);
            }
        };
    }

    Score(int seconds, int points, int hintCost) {
        this.score = points; //Set initial game score to 0
        this.hintCost = hintCost; //Set initial hintCost to 0
        this.secondsPassed = seconds;
        this.timer = new Timer(); //Instantiate timer as new Timer object
        //Declares a timerTask object which we can reference to from our timer object. 
        this.task = new TimerTask() {
            public void run() {
                secondsPassed ++;
            }
        };
    }
    
    void beginTimer() {
       //Begin the timerTask object on the timer object with a delay of 1000 miliseconds and run the task every 1000 miliseconds
       this.timer.scheduleAtFixedRate(this.task, 1000, 1000);
      
    }  
    void pauseTimer() {
            //Pause the timer object
        timer.cancel();
        }
    
    void resumeTimer() {
        //resume timer object
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(this.task, 1000, 1000);
    }
    
    int getElapsedTime() {
        
        //Return the amount of time elapsed since gameStart in seconds
 
        return this.secondsPassed;  
    }
    
    int getScore(){
        return score;
    }
    
    int getHintCost(){
        return hintCost;
    }
    
    //Whenever we wish to increment our the users score. Upon completing quest and so forth. 
    void incrementScore(int i) {
        
        this.score += i;
     
    }
    
    //Whenever we wish to decrement the users score. Maybe when failing to answer a simple question...
    void decrementScore(int i) {
        
        this.score -= i;
    }
    
    //Return the current cost of using a hint.
    String hintCost() {
        
        String returnString = "";
        
        if(this.hintCost == 0) {
            returnString = "Du får dit første hint gratis, herefter stiger prisen med 5 point for hver hint";
            System.out.println("Du får dit første hint gratis, herefter stiger prisen med 5 point for hvert hint");
        } else {
            returnString = "Dit næste hint koster" + this.hintCost + " Point";
            System.out.println("Dit næste hint koster" + this.hintCost + " Point");
        }
        
        return returnString;
    }
    
    //Substract the cost of the hint from the current game score and increase the cost of the next hint
    void useHint() {
        
        this.decrementScore(this.hintCost);
        this.hintCost += 5;
       
    }
    
    //When asked return the total gamescore as of this moment. Best be used when game is over, remember to start
    double totalScore() {
        
        double totalScore = 0;
        
        System.out.println("Your total accumulated score: " + (this.score + this.hintCost));
        System.out.println("Hint penalty reduces your score to: " + this.score);
        double seconds = this.secondsPassed;
        System.out.println(seconds);
        double timeScore = 1000.0 / (seconds / 10);
        
        if(timeScore > 1000){
            timeScore = 1000;
        }
        
        System.out.println((seconds)/10);
        System.out.println("Additional time score: " + timeScore);
        totalScore = this.score + timeScore;
        System.out.println("Your total score is: " +totalScore);
        
        return totalScore;   
    }
    
    public double getTotalScore(){
        return totalScore();
    }
}