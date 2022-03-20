package assignment_2;

 class Book {
	private String bookTitle;
	private String author;
	private String isbn;
	private int numOfCopies;

	public String getBookTitle() {
		return bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	public Book(String bookTitle, String author, String isbn, int numOfCopies) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.isbn = isbn;
		this.numOfCopies = numOfCopies;
	}

	public void display() {
		System.out.println("---book details------");
		System.out.println("bookTitle: " + bookTitle);
		System.out.println("author: " + author);
		System.out.println("isbn: " + isbn);
		System.out.println("numOfCopies: " + numOfCopies);
		System.out.println("---------------------");

	}
}
 
 
 class BookStore {
		private final int SIZE;
		private String bookStoreName;
		private Book[] books;
		
		public BookStore(String bookStoreName, int size) {
			SIZE=size;
			this.bookStoreName = bookStoreName;
			this.books = new Book[SIZE];
			init();
		}
		//populate some books
		private void init() {
				books[0]=new Book("rich dad poor dad", "RK", "54545A12", 10);
				books[1]=new Book("basic physics", "abc", "54595A12", 20);
				books[2]=new Book("pointer in c", "YK", "94545A12", 8);
				books[3]=new Book("head first core java", "foo", "50545A12", 20);
				books[4]=new Book("spring in action", "bar", "14545A12", 10);
		}



		public void sell(String bookTitle, int noOfCopies) {
			boolean found=false;
			for(int i=0;i<SIZE; i++) {
				if(	books[i].getBookTitle().equals(bookTitle)) {
					
					books[i].setNumOfCopies(books[i].getNumOfCopies()-noOfCopies);
					found=true;
				}
			}
			
			if(found)
				System.out.println("book sell is successful");
			else
				System.out.println("book is not found in store");
		}

		public void order(String bookTitle, int noOfCopies) {
			boolean found=false;
			for(int i=0;i<SIZE; i++) {
				if(	books[i].getBookTitle().equals(bookTitle)) {
					books[i].setNumOfCopies(books[i].getNumOfCopies()+noOfCopies);
					found=true;
				}
			}
			if(found)
				System.out.println("book order is successful");
			else
				System.out.println("book order is not successful");
		}

		public void display() {
			System.out.println("**********Book store *****************");
			System.out.println(bookStoreName);
			System.out.println("^^^^^^^^^^^^^^^Books details^^^^^^^^^^^^^^^^^^^^^^^^^");
			for(Book book: books) {
				book.display();
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			
		}
	} 

public class Q2 {

	public static void main(String[] args) {
		BookStore bookStore=new BookStore("harman", 5);
		bookStore.sell("spring in action", 2);
		bookStore.display();
	}

}
