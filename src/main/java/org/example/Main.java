package org.example;


import java.util.*;

public class Main {
    private static final List<Customer> customers = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Map<Integer, Runnable> menuMap = new HashMap<>();
            menuMap.put(1, Main::addCustomer);
            menuMap.put(2, Main::openAccount);
            menuMap.put(3, Main::depositMoney);
            menuMap.put(4, Main::withdrawMoney);
            menuMap.put(5, Main::showBalance);
            menuMap.put(6, Main::listAccount);
            menuMap.put(7, Main::applyInterest);


        while(true){
            System.out.println("--Online Bankacılık Uygulaması--");
            System.out.println("1. Müşteri Ekle");
            System.out.println("2. Hesap Aç");
            System.out.println("3. Para Yatır");
            System.out.println("4. Para Çek");
            System.out.println("5. Bakiye Görüntüle");
            System.out.println("6. Müşteri Hesaplarını Listele");
            System.out.println("7. Vadeli hesaba Faiz İşle");
            System.out.println("8. Çıkış");
            System.out.println("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 8){
                System.out.println("Programdan çıkılıyor..");
                break;
            }
            Runnable action = menuMap.get(choice);
                if (action != null){
                    action.run();
                } else {
                    System.out.println("Geçersiz seçim!");
                }


        }
    }
    private static void addCustomer(){
        System.out.print("Müşteri Ad Soyad: ");
        String name = scanner.nextLine();
        int id =  (customers.size() + 1);
        Customer customer = new Customer(id, name);
        customers.add(customer);
        System.out.println("Müşteri eklendi. ID: " + id);
    }
    private static void openAccount(){
        Customer customer = findCustomerById();
        if (customer == null) return;
        System.out.print("Hesap Türü (1-Vadesiz, 2-Vadeli): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        if (type == 1){
            Account acc = new CheckingAccount(0);
            customer.addAccount(acc);
            System.out.println("Hesap başarıyla açıldı. Hesap numarası: " + acc.getAccountNumber());

        } else if(type == 2){
            Account acc = new DepositAccount(0);
            customer.addAccount(acc);
            System.out.println("Hesap başarıyla açıldı. Hesap numarası: " + acc.getAccountNumber());
            System.out.println("Faiz oranı: 0.3 ");
        }
        else {
            System.out.println("Geçersiz hesap türü!");
        }

    }

    private static Customer findCustomerById() {
        System.out.print("Müşteri ID: ");
        String id = scanner.nextLine();
        for (Customer customer : customers) {
             if (id.equals(String.valueOf(customer.getCustomerID()))
)
                return customer;
        }
        System.out.println("Müşteri bulunamadı!");
        return null;
    }

    private static void depositMoney(){
        Account acc = findAccountByCustomer();
        if (acc == null) return;
        System.out.print("Yatırılacak miktar: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        acc.deposit(amount);

    }
    private static void withdrawMoney(){
        Account acc = findAccountByCustomer();
        if (acc == null) return;
        System.out.print("Çekilecek miktar: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        try {
            acc.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
    private static void showBalance(){
        Account acc = findAccountByCustomer();
        if (acc == null) return;
        acc.showBalance();
    }
    private static void listAccount(){
        Customer customer = findCustomerById();
        if (customer == null) return;
        customer.listAccount();

    }
    private static void applyInterest(){
        Account acc = findAccountByCustomer();
        if (acc == null) return;
        if (acc instanceof DepositAccount) {
            ((DepositAccount) acc).applyInterest();
        } else {
            System.out.println("Bu işlem sadece vadeli hesaplar için geçerlidir!");
        }
    }

    private static Account findAccountByCustomer() {
        Customer customer = findCustomerById();
        if (customer == null) return null;
        System.out.print("Hesap No: ");
        String accNo = scanner.nextLine();
        Account acc = customer.findAccountByNumber(accNo);
        if (acc == null) System.out.println("Hesap bulunamadı!");
        return acc;
    }





}