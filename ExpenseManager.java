import java.util.*;
import java.io.* ;

class ExpenseManager {

    public static void saveExpenses(ArrayList<Expense>expenses){
         try (BufferedWriter writer =
             new BufferedWriter(new FileWriter("expenses.txt"))){
            for(Expense e: expenses){
                writer.write(e.category + "," + e.amount);
                writer.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Error saving expenses.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Expense> loadExpenses(){
        ArrayList<Expense> expenses = new ArrayList<>();
        try (BufferedReader reader =
             new BufferedReader(new FileReader("expenses.txt"))){
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(",");
                String category = parts[0];
                double amount = Double.parseDouble(parts[1]);
                expenses.add(new Expense(category,amount));
            }
        }
        catch (IOException e) {
        System.out.println("No existing expense file found.");
        }
        return expenses;
    }

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
    System.out.println("for category: "+ cat + " the amount spent is: "+ amnt); 
  }

}