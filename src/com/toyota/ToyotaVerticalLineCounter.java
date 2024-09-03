package com.toyota;

public class ToyotaVerticalLineCounter{
    public static void main(String[] args){
        VerticalLineCountValidate verticalLineCountValidate = new VerticalLineCountValidate();
        if(verticalLineCountValidate.validateArguments(args)){
            int lineCount = verticalLineCountValidate.readLineCount(args[0]);// Use the provided argument
            if(lineCount >= 0){
                 // Output the result to the console
                System.out.println("Number of vertical lines: " + lineCount);    
            }           
        } else {
            System.out.println("Invalid number of arguments. Please provide exactly one argument.");
        }
    }
}