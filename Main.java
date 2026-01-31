import java.util.*;
public class Main {

  static double totalExpenses(ArrayList<Pair>expenses){
    double totalSpending=0.0;
        for(int i=0;i<expenses.size();i++){
            Pair p = expenses.get(i);
            totalSpending+= p.amount;
        }
    System.out.println("total spending is: " + totalSpending);
    return totalSpending;
  }

  static void totalExpensesWithCategory(ArrayList<Pair>expenses){
     String cat1="Food";
     String cat2="Entertainment";
     String cat3="Travel";
     String cat4="Leisure";
     double amount1=0.0;
     double amount2=0.0;
     double amount3=0.0;
     double amount4=0.0;

     for(Pair p : expenses){
        if(p.category.equals(cat1)){
            amount1+=p.amount;
        }
        else if(p.category.equals(cat2)){
            amount2+=p.amount;
        }
        else if(p.category.equals(cat3)){
            amount3+=p.amount;
        }
        else{
            amount4+=p.amount;
        }
     }
     System.out.println("for category: "+ cat1 + " the amount spent is: "+ amount1);
     System.out.println("for category: "+ cat2 + " the amount spent is: "+ amount2);
     System.out.println("for category: "+ cat3 + " the amount spent is: "+ amount3);
     System.out.println("for category: "+ cat4 + " the amount spent is: "+ amount4);
  }

  static void categoryExpense(ArrayList<Pair>expenses, String cat){
    double amnt = 0.0;
        for(Pair p: expenses){
            if(p.category.equals(cat)){
                amnt+=p.amount;
            }
        }
    System.out.println("for category: "+ cat + "the amount spent is: "+ amnt); 
  }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    ArrayList<Pair> expenses= new ArrayList<Pair>();
    while(true){
        System.out.print("Enter the category: ");
        String category = myObj.nextLine();
        System.out.print("Enter the amount: ");
        double amount = myObj.nextDouble();
        myObj.nextLine();
        if(amount == -1 || category.isEmpty()){
            break;
        }
        expenses.add(new Pair(category,amount));
    }

    System.out.println("choose your option (1: to see total expense, 2: to see category wise spent, 3: Spent of a particular category: ");
    int choice = myObj.nextInt();
    myObj.nextLine();
    switch(choice){
        case 1:
            totalExpenses(expenses);
            break;
        case 2:
            totalExpensesWithCategory(expenses);
            break;
        case 3:
            System.out.print("Enter category: ");
            String chosenCategory = myObj.nextLine();
            categoryExpense(expenses,chosenCategory);
            break;
    }

    myObj.close();
  }
}

class Pair{
    String category;
    double amount;
    Pair(String category, double amount){
        this.category=category;
        this.amount=amount;
    }
}