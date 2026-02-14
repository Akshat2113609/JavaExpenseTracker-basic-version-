import java.util.*;
class ExpenseManager {
    static double totalExpenses(ArrayList<Expense>expenses){
        double totalSpending=0.0;
        for(int i=0;i<expenses.size();i++){
            Expense p = expenses.get(i);
            totalSpending+= p.amount;
        }
        System.out.println("total spending is: " + totalSpending);
        return totalSpending;
  } 
  static void totalExpensesWithCategory(ArrayList<Expense>expenses){
     String cat1="Food";
     String cat2="Entertainment";
     String cat3="Travel";
     String cat4="Leisure";
     double amount1=0.0;
     double amount2=0.0;
     double amount3=0.0;
     double amount4=0.0;

     for(Expense p : expenses){
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

  static void categoryExpense(ArrayList<Expense>expenses, String cat){
    double amnt = 0.0;
        for(Expense p: expenses){
            if(p.category.equals(cat)){
                amnt+=p.amount;
            }
        }
    System.out.println("for category: "+ cat + "the amount spent is: "+ amnt); 
  }

}