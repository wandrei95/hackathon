package api;

import core.DataFetcher;
import core.entities.Author;
import core.scholar.GoogleScholarNew;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class AuthorController {

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public Author getAuthorDetails(@RequestParam("authorName") String authorName) throws IOException {
        String lowerCaseAuthorName = authorName.toLowerCase();
        GoogleScholarNew googleScholarNew = new GoogleScholarNew();
        DataFetcher dataFetcher = new DataFetcher(googleScholarNew);
        AtomicReference<Author> author = new AtomicReference<>();

        dataFetcher.getAuthorByName(lowerCaseAuthorName, (a -> author.set(a)));

        while (author.get() == null) {
        }
        return author.get();
    }
}
