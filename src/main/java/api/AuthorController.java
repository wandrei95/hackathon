package api;

import core.Author;
import core.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public Author getAuthorDetails(@RequestParam("authorName") String authorName) {
        List<Publication> publications = new ArrayList<>();
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));
        publications.add(new Publication(3, 2000, "authors", "title"));

        return new Author(authorName, 65, "h index", publications.size(), publications);
    }
}
