package tqs.lab5.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;
 
public class Library {
	private final List<Book> store = new ArrayList<>();
 
	public void addBook(final Book book) {
		store.add(book);
	}

    public List<Book> findBookbyTitle(final String title) {
		return store.stream().filter(book -> {
			return book.getTitle().contains(title);
		}).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}
 
	public List<Book> findBookbyAuthor(final String author) {
		return store.stream().filter(book -> {
			return book.getAuthor().contains(author);
		}).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

    public List<Book> findBookbyDate(final LocalDate from, final LocalDate to) {

		return store.stream().filter(book -> {
			return book.getPublished().compareTo(from)>=0 && book.getPublished().compareTo(to)<=0;
		}).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
	}
}
