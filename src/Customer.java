import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Customer {

    public static void main(String args[]) throws IOException {

        final String FILE = "F:\b.csv";

            customerInfo inputNewCustomer = inputCustomer(); 
            saveCustomer(inputNewCustomer, FILE);
       
    }

    public static customerInfo inputCustomer() {
        Scanner input = new Scanner(System.in);
        customerInfo inputNewCustomer = new customerInfo();
        System.out.println("Input name of Customer:");
        inputNewCustomer.setName(input.nextLine());
        System.out.println("Input Phone number:");
        inputNewCustomer.setPhoneNumber(input.nextInt());
        System.out.println("Input number of people:");
        inputNewCustomer.setNumberOfPeople(input.nextInt());
        System.out.println("Note:");
        inputNewCustomer.setNote(input.nextLine());

        return inputNewCustomer;
    }

    public static void saveCustomer(customerInfo customer, String filePath) throws IOException {

        File data = new File(filePath);
        FileOutputStream fos = new FileOutputStream(data, false);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            StringBuilder str = new StringBuilder();
            str.append(customer.getName()).append(",")
                    .append(customer.getPhoneNumber()).append(",")
                    .append(customer.getNumberOfPeople()).append(",")
                    .append(customer.getNote());
            bw.write(String.valueOf(str));
            bw.newLine();
        
        bw.close();
    }
}
