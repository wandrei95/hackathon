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

    public void getAuthorByName(String authorName, DataFetcherListener listener) throws IOException {
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference("/authors")
                .child(authorName);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Author author = dataSnapshot.getValue(Author.class);
                if (author == null) {
                    try {
                        author = googleScholarNew.getAuthor(authorName);
                        ref.setValueAsync(author);
                        listener.onDataFetched(author);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    listener.onDataFetched(author);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                try {
                    Author author = googleScholarNew.getAuthor(authorName);
                    ref.setValueAsync(author);
                    listener.onDataFetched(author);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public interface DataFetcherListener {
        void onDataFetched(Author author);
    }
}
