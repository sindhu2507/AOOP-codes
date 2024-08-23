package LibraryManagementSystem;

public class Client {
	public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        library.addBook(book1);
        library.addBook(book2);

        // Adding members
        Member member1 = new Member("Alice", "M001");
        Member member2 = new Member("Bob", "M002");
        library.addMember(member1);
        library.addMember(member2);

        // Borrowing process
        BorrowingService borrowingService = new BorrowingService();
        borrowingService.borrowBook(book1, member1);
        borrowingService.borrowBook(book2, member2);
    }
}
