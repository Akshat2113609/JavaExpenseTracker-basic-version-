import java.util.*;
class ExpenseManager {
    public static HashMap<String,ArrayList<Double>> createMap(ArrayList<Expense>expenses){
        HashMap<String,ArrayList<Double>> expenseMap = new HashMap<>();
        for(Expense e: expenses){
            if(!expenseMap.containsKey(e.category)){
                expenseMap.put(e.category,new ArrayList<>());
            }
            expenseMap.get(e.category).add(e.amount);
        }
        return expenseMap;
    }

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
     HashMap<String,ArrayList<Double>> expenseMap = createMap(expenses);
     for(String cat: expenseMap.keySet()){
        double amnt = 0.0;
        for(double i: expenseMap.get(cat)){
            amnt+=i;
        }
        System.out.println("For category: " + cat + " the amount is: " + amnt);
     }
  }

  static void categoryExpense(ArrayList<Expense>expenses, String cat){
    HashMap<String,ArrayList<Double>> expenseMap = createMap(expenses);
    double amnt = 0.0;
        for(double i: expenseMap.get(cat)){
            amnt+=i;
        }
    System.out.println("for category: "+ cat + "the amount spent is: "+ amnt); 
  }

}