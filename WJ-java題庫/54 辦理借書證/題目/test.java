import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UI {
    public static int showMenu(Scanner scanner) {
        /*
        System.out.println("--- 歡迎使用圖書館管理系統 ---");
        System.out.println("1. 辦理借書證");
        System.out.println("2. 借書");
        System.out.println("3. 借CD");
        System.out.println("4. 借研究小間");
        System.out.println("5. 歸還");
        System.out.println("6. 採購書籍");
        System.out.println("-1. 結束程式");
        System.out.print("請選擇操作：");
        */
        while (!scanner.hasNextInt()) {
            System.out.println("無效輸入，請輸入一個整數選項。");
            System.out.print("請選擇操作：");
            scanner.next(); // 消耗錯誤輸入
        }
        return scanner.nextInt();
    }
}

class LibCard {
    private String identity;
    private int bookLimit;
    private int loanPeriod;

    public LibCard(String identity) {
        this.identity = identity;
        switch (identity) {
            case "教師":
                this.bookLimit = 20;
                this.loanPeriod = 60;
                break;
            case "職員":
                this.bookLimit = 15;
                this.loanPeriod = 30;
                break;
            case "學生":
                this.bookLimit = 10;
                this.loanPeriod = 14;
                break;
        }
        System.out.println("已成功為您辦理借書證，您是" + this.identity + "。");
    }
}

class Book {
    private String title;
    private boolean isBorrowed;
    private boolean isReserved;

    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
        this.isReserved = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

class CD {
    private String title;
    private boolean isBorrowed;
    private boolean isReserved;

    public CD(String title) {
        this.title = title;
        this.isBorrowed = false;
        this.isReserved = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

class StudyRoom {
    private String name;
    private boolean isBorrowed;
    private boolean isReserved;

    public StudyRoom(String name) {
        this.name = name;
        this.isBorrowed = false;
        this.isReserved = false;
    }

    public String getName() {
        return name;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

class Library {
    private List<Book> books;
    private List<CD> cds;
    private List<StudyRoom> studyRooms;
    private LibCard currentCard;

    public Library() {
        this.books = new ArrayList<>();
        this.cds = new ArrayList<>();
        this.studyRooms = new ArrayList<>();
        // 初始化一些館藏
        books.add(new Book("book_A"));
        books.add(new Book("book_B"));
        cds.add(new CD("cd_A"));
        studyRooms.add(new StudyRoom("studyroom_A"));
    }

    public void createLibCard(Scanner scanner) {
        //System.out.print("請選擇您的身份 (1:教師, 2:職員, 3:學生): ");
        int choice = scanner.nextInt();
        String identity = "";
        switch (choice) {
            case 1:
                identity = "教師";
                break;
            case 2:
                identity = "職員";
                break;
            case 3:
                identity = "學生";
                break;
            default:
                System.out.println("無效的身份選擇。");
                return;
        }
        this.currentCard = new LibCard(identity);
    }

    public void borrowBook(Scanner scanner) {
        System.out.print("請輸入您要借的書籍名稱：");
        scanner.nextLine(); // 消耗換行符
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isBorrowed()) {
                book.setBorrowed(true);
                System.out.println("您已成功借閱 " + title + "。");
                return;
            }
        }
        System.out.println("書籍 " + title + " 不存在或已被借閱。");
    }

    public void borrowCD(Scanner scanner) {
        System.out.print("請輸入您要借的CD名稱：");
        scanner.nextLine();
        String title = scanner.nextLine();
        for (CD cd : cds) {
            if (cd.getTitle().equals(title) && !cd.isBorrowed()) {
                cd.setBorrowed(true);
                System.out.println("您已成功借閱 " + title + "。");
                return;
            }
        }
        System.out.println("CD " + title + " 不存在或已被借閱。");
    }

    public void borrowStudyRoom(Scanner scanner) {
        System.out.print("請輸入您要借用的研究小間名稱：");
        scanner.nextLine();
        String name = scanner.nextLine();
        for (StudyRoom room : studyRooms) {
            if (room.getName().equals(name) && !room.isBorrowed()) {
                room.setBorrowed(true);
                System.out.println("您已成功借用研究小間 " + name + "。");
                return;
            }
        }
        System.out.println("研究小間 " + name + " 不存在或已被借用。");
    }

    public void returnItem(Scanner scanner) {
        System.out.print("請輸入您要歸還的物品名稱：");
        scanner.nextLine();
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isBorrowed()) {
                book.setBorrowed(false);
                System.out.println("您已成功歸還 " + title + "。");
                return;
            }
        }
        for (CD cd : cds) {
            if (cd.getTitle().equals(title) && cd.isBorrowed()) {
                cd.setBorrowed(false);
                System.out.println("您已成功歸還 " + title + "。");
                return;
            }
        }
        for (StudyRoom room : studyRooms) {
            if (room.getName().equals(title) && room.isBorrowed()) {
                room.setBorrowed(false);
                System.out.println("您已成功歸還 " + title + "。");
                return;
            }
        }
        System.out.println("物品 " + title + " 狀態不符，無法歸還。");
    }

    public void purchaseBook(Scanner scanner) {
        System.out.print("請輸入要採購的書籍名稱：");
        scanner.nextLine();
        String title = scanner.nextLine();
        books.add(new Book(title));
        System.out.println(title + " 已成功採購。");
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            choice = UI.showMenu(scanner);
            // 處理數字輸入後的換行符，避免影響後續的字串讀取
            if (choice != -1) {
                switch (choice) {
                    case 1:
                        library.createLibCard(scanner);
                        break;
                    case 2:
                        library.borrowBook(scanner);
                        break;
                    case 3:
                        library.borrowCD(scanner);
                        break;
                    case 4:
                        library.borrowStudyRoom(scanner);
                        break;
                    case 5:
                        library.returnItem(scanner);
                        break;
                    case 6:
                        library.purchaseBook(scanner);
                        break;
                    default:
                        System.out.println("無效的選擇，請重新輸入。");
                        break;
                }
            }
        } while (choice != -1);
        
        scanner.close();
        System.out.println("程式結束。");
    }
}