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
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));
        publications.add(new Publication(System.currentTimeMillis(), 53.2734, -7.778320310000026));

        return new Author("Author name", "h index", publications);
    }
}
