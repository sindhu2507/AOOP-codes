package LibraryManagementSystem;

public class BorrowingService implements Borrowable{
	@Override
    public void borrowBook(Book book, Member member) {
        System.out.println(member.getName() + " has borrowed the book: " + book.getTitle() + " by " + book.getAuthor());
    }
}
