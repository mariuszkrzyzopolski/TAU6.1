import com.google.common.collect.ArrayListMultimap;
import org.example.Note;
import org.example.NotesStorage;
import com.google.common.collect.Multimap;

import java.util.List;

public class MockedNotesStorage implements NotesStorage {
    Multimap<String,Note> notes = ArrayListMultimap.create();

    @Override
    public void add(Note note) {
        notes.put(note.getName(), note);
    }

    @Override
    public List<Note> getAllNotesOf(String name) {
        return (List<Note>) notes.get(name);
    }

    @Override
    public void clear() {
        notes.clear();
    }

    public int size(){
        return notes.size();
    }
}
