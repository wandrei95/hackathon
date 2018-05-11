package core;

import com.google.firebase.database.*;
import core.entities.Author;
import core.scholar.GoogleScholarNew;

import java.io.IOException;

public class DataFetcher {
    private final GoogleScholarNew googleScholarNew;

    public DataFetcher(GoogleScholarNew googleScholarNew) {
        this.googleScholarNew = googleScholarNew;
    }

    public Author getAuthorByName(String authorName) throws IOException {
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference("/authors")
                .child(authorName);

        final boolean[] shouldWait = {true};

        final Author[] author = {null};

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                shouldWait[0] = false;
                author[0] = dataSnapshot.getValue(Author.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                shouldWait[0] = false;
            }
        });

        while (shouldWait[0]) {
        }

        if (author[0] == null) {
            author[0] = googleScholarNew.getAuthor(authorName);
            ref.setValueAsync(author[0]);
        }

        return author[0];
    }
}
