package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.config.BookConfig;

public class BookExam {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);

        Book book = context.getBean("b",Book.class);

        book.setTitle("annotation injection");
        book.setPrice(20000);

        System.out.println(book);
    }
}