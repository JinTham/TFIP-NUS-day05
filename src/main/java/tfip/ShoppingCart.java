package tfip;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) throws IOException{
        String dirPath = "./shoppingcart";
        String fileName = "";
        File newDirectory = new File(dirPath);

        if (newDirectory.exists()){
            System.out.println("Directory already exists");
        } else {
            newDirectory.mkdir();
        }
        System.out.println("Welcome to your Shopping Cart");

        List<String> cartItems = new ArrayList<>();

        Console con = System.console();
        String input = "";
        while (!input.equals("quit")){
            input = con.readLine("What do you want to perform? (Type 'quit' to exit program)\n");
            //single input
            switch (input){
                case "help":
                    displayMsg("'list' to show a list of items in shopping cart");
                    displayMsg("'login <name>' to access your shopping cart");
                    displayMsg("'add <item>' to add items into your shopping cart");
                    displayMsg("'delete <item#>' to remove an item from your shopping cart");
                    displayMsg("'quit' to exit this program");
                    break;
                case "list":
                    listCart(cartItems);
                    break;
                case "users":
                    listUsers(dirPath);
                    break;
                default:
            }
            //add items
            if (input.startsWith("add")){
                cartItems = addCartItem(cartItems, input);
            }
            //delete items
            if (input.startsWith("delete")){
                cartItems = deleteCartItem(cartItems, input);
            }
            //login
            if (input.startsWith("login")){
                login(input,dirPath,fileName);
            }
        }
    }
    //Functions
    public static void displayMsg(String msg){
        System.out.println(msg);
    }
    public static void listCart(List<String> cartItems){
        if (cartItems.size()>0){
            for (int i=0;i<cartItems.size();i++){
                displayMsg(String.format("%d. %s",i+1,cartItems.get(i)));
            }
        } else {
            displayMsg("Your cart is empty");
        }
    }
    public static List<String> deleteCartItem(List<String> cartItems, String input){
        input = input.replace(","," ");
        Scanner scanner = new Scanner(input.substring(6));
        while (scanner.hasNext()){
            int listItemIndex = Integer.parseInt(scanner.next());
            if (listItemIndex<cartItems.size()){
                cartItems.remove(listItemIndex-1);
            } else {
                displayMsg("Incorrect item index");
            }
        }
        return cartItems;
    }
    public static List<String> addCartItem(List<String> cartItems, String input){
        input = input.replace(","," ");
        Scanner scanner = new Scanner(input.substring(4));
        while (scanner.hasNext()){
            String strValue = scanner.next();
            cartItems.add(strValue);
        }
        return cartItems;
    }
    public static void login(String input, String dirPath, String fileName) throws IOException{
        input = input.replace(","," ");
        Scanner scanner = new Scanner(input.substring(6));
        while (scanner.hasNext()){
            fileName = scanner.next();
        }
        //Define filepath and filename
        File loginFile = new File(dirPath + File.separator + fileName);
        Boolean isCreated = loginFile.createNewFile();
        if (isCreated){
            displayMsg("New file created successfully: "+loginFile.getCanonicalFile());
        } else {
            displayMsg("File already created");
        }
    }
    public static void listUsers(String dirPath){
        File directoryPath = new File(dirPath);
        String contents[] = directoryPath.list();
        for (String file : contents){
            displayMsg(file);
        }
    }
}
