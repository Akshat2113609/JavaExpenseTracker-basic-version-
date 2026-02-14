import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    ArrayList<Expense> expenses= new ArrayList<Expense>();
    while(true){
        System.out.print("Enter the category: ");
        String category = myObj.nextLine();
        System.out.print("Enter the amount: ");
        double amount = myObj.nextDouble();
        myObj.nextLine();
        if(amount == -1 || category.isEmpty()){
            break;
        }
        expenses.add(new Expense(category,amount));
    }

    System.out.println("choose your option (1: to see total expense, 2: to see category wise spent, 3: Spent of a particular category: ");
    int choice = myObj.nextInt();
    myObj.nextLine();
    ExpenseManager manager = new ExpenseManager();
    switch(choice){
        case 1:
            manager.totalExpenses(expenses);
            break;
        case 2:
            manager.totalExpensesWithCategory(expenses);
            break;
        case 3:
            System.out.print("Enter category: ");
            String chosenCategory = myObj.nextLine();
            manager.categoryExpense(expenses,chosenCategory);
            break;
    }

    myObj.close();
  }
}

