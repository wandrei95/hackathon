package api;

import core.DataFetcher;
import core.entities.Author;
import core.scholar.GoogleScholarNew;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthorController {

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public Author getAuthorDetails(@RequestParam("authorName") String authorName) throws IOException {
        GoogleScholarNew googleScholarNew = new GoogleScholarNew();
        DataFetcher dataFetcher = new DataFetcher(googleScholarNew);
        return dataFetcher.getAuthorByName(authorName);
    }
}
